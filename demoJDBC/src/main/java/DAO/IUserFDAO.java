package DAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserFDAO {
    public void insertUser(User users) throws SQLException;
    public List<User> selectAllUser();
    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User users) throws SQLException;
}
