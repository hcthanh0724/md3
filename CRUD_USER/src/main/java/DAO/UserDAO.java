package DAO;

import Model.User;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/user?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO `user`.`users` ( `name`, `email`, `country`, `img`) VALUES (?,?,?,?);";
        System.out.println(sql);
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(1,user.getCountry());
            preparedStatement.setString(1,user.getImg());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            printSQLException(e);
        }

    }

    @Override
    public User selectUser(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String img = rs.getString("img");
                user = new User(id,name,email,country,img);
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        String sql = "SELECT * FROM user";
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("country");
                String country = rs.getString("country");
                String img = rs.getString("img");
                users.add(new User(id,name,email,country,img));
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id =?";
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE user set name = ?, email = ?, country = ?, img = ? WHERE id = ?";
        boolean rowUpdate;
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.setString(4,user.getImg());
            preparedStatement.setInt(5,user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
    public void printSQLException (SQLException ex){
        for (Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState:" +(((SQLException) e).getSQLState()));
                System.err.println("Error Code: " + (((SQLException) e).getErrorCode()));
                System.err.println("Message: " +e.getMessage());
                Throwable t = ex.getCause();
                while (t != null){
                    System.out.println("Cause: "+t);
                    t = t.getCause();
                }
            }
        }
    }
}
