package sevices;

import dao.IUserDao;
import dao.UserDao;
import dataAccess.DataAccess;
import models.*;

import java.sql.SQLException;

public class UserService {
    private IUserDao usersDao = new UserDao(new DataAccess());

    public UserService() throws SQLException, ClassNotFoundException {
        DataAccess.DataAccess();
    }

    public User GetUser(int id) throws SQLException {
        return usersDao.getUser(id);
    }

    public void DeleteUser(User user) throws SQLException {
        usersDao.delete(user);
    }

    public void AddUser(User user) throws SQLException {
        usersDao.addUser(user);
    }

    public User[] GetUsers() throws SQLException {
        return usersDao.users();
    }
}
