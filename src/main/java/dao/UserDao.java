package dao;

import dataAccess.DataAccess;
import models.User;
import java.sql.SQLException;

public class UserDao implements IUserDao {

    private DataAccess db;

    public UserDao(DataAccess db){
        this.db = db;
    }

    @Override
    public User getUser(int id) throws SQLException {
        return db.userDB.getUser(id);
    }



    @Override
    public void addUser(User user) throws SQLException {
        db.AddUser(user);
    }

    @Override
    public void delete(User user) throws SQLException {
        db.DeleteUser(user);
    }

    @Override
    public User[] users() throws SQLException {
        return db.GetUsers();
    }
}
