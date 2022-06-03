package sevices;

import dao.IUserDao;
import dao.UserDao;
import dataAccess.DataAccess;
import models.*;

import java.util.List;

public class UserService {
    private IUserDao usersDao = new UserDao(new DataAccess());

    public UserService() {    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }

}
