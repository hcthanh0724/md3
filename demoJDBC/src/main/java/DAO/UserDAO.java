package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserFDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUES(?,?,?):";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id = ?";
    private static final String SELECT_ALL_USERS ="select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country =? where id = ?";

    public UserDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            //tải lớp trình điều khiển mySQL Driver
            Class.forName("com.mysql.jdbc.Driver");
            // thiết lập kết nối đến cơ sở dữ liệu MySQL.
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    //chèn bản ghi mới
    public void insertUser(User users) throws SQLException {
        //tt
        System.out.println(INSERT_USERS_SQL);
        //kết nối tới csdl, thiết lập đối tượng preparestmt cho phép truyền các gt và câu lệnh sql
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //phương thức setString thiết lập các gt cho các tham số trong câu SQL
            preparedStatement.setString(1,users.getName());
            preparedStatement.setString(2,users.getEmail());
            preparedStatement.setString(3,users.getCountry());
            //tt
            System.out.println(preparedStatement);
            //thực thi câu lệnh sql và chèn bản ghi vào bảng user
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            printSQLException(e);
        }
    }

    //truy vấn và lấy thông tin bản ghi theo ID được chỉ định
    public User selectUser(int id){
        //đối tượng user được sử dụng để lưu trữ thông tin truy vấn từ csdl
        User users = null;

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
            //Thiết lập giá trị tham số cho câu sql
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            //duyệt tất cả bản ghi được trả về bời câu sql
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users = new User(id,name,email,country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<User> selectAllUser() {
        //khởi tạo list users để lưu thông tin truy xuất từ csdl
        List<User> users = new ArrayList<>();
        //đối tượng preparestmt dùng để truyền tham số cho câu lệnh sql
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)){
            System.out.println(preparedStatement);
            //thực thi câu lệnh sql được chuẩn bị bởi đối tượng preparestmt
            //trả về đối tượng rs chứ kết quả truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        //biến kiểm tra xem bản ghi đã được xóa thành công hay không
        boolean rowDeleted;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)){
            statement.setInt(1,id);
            //số bản ghi bị ảnh hưởng, nếu số bản ghi >0, biến rowDeleted là true
            rowDeleted = statement.executeUpdate() >0 ;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User users) throws SQLException {
        boolean rowUpdated;
        try(Connection connection=getConnection();PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)){
            preparedStatement.setString(1,users.getName());
            preparedStatement.setString(2,users.getEmail());
            preparedStatement.setString(3,users.getCountry());
            preparedStatement.setInt(4,users.getId());

            rowUpdated = preparedStatement.executeUpdate() >0;
        }
        return rowUpdated;
    }
}
