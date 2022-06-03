import models.User;
import sevices.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserService us = new UserService();
        User[] a = us.GetUsers();
        for (User user: a) {
            System.out.println(user);
        }
    }
}
