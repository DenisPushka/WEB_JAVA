package dao;

import models.Auto;
import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    User getUser(int id) throws SQLException;

    void addUser(User user) throws SQLException;

    void delete(User user)throws SQLException;

    User[] users() throws SQLException;
}
