import dataAccess.DataAccess;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DataAccess.DataAccess();
        DataAccess.CreateDB();
        DataAccess.WriteDB();
        DataAccess.ReadDB();
        DataAccess.CloseDB();
    }
}
