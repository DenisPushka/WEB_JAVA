import dataAccess.DataAccess;
import models.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DataAccess.DataAccess();
        DataAccess db = new DataAccess();
        db.getUser(2);
        db.DeleteUser(new User("Denis", 20));
    }
}
