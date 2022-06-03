package dataAccess.models;

import dataAccess.DataAccess;
import models.User;
import java.sql.SQLException;
import static java.lang.System.out;

public class UserRepository {
    private DataAccess db;

    public UserRepository(DataAccess db) {
        this.db = db;
    }

    public User getUser(int id) throws SQLException {
        db.resSet = db.statmt.executeQuery("SELECT * FROM users WHERE id = " + id);

        while (db.resSet.next()) {
            int idUs = db.resSet.getInt("id");
            if (idUs == id) {
                String name = db.resSet.getString("name");
                int age = db.resSet.getInt("age");
                out.println(name + "\t" + age);
                return new User(name, age);
            }
        }

        return new User();
    }
}
