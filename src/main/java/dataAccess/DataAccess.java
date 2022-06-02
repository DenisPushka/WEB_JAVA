package dataAccess;

import java.sql.*;

import static java.lang.System.out;

public class DataAccess {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/OrderAccountSystem";
    static final String USER = "postgres";
    static final String PASS = "ogr84Bqk3";
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void DataAccess() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        statmt = conn.createStatement();

        out.println("База Подключена!");
    }

    public static void CreateDB() throws SQLException {
        statmt = conn.createStatement();
        // statmt.execute("CREATE TABLE if not exists \"users\" ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'age' INT);");

        out.println("Таблица создана или уже существует.");
    }

    public static void WriteDB() throws SQLException
    {
        statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Petya', 16);");
        statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Vasya', 14);");
        statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Masha', 18);");

        System.out.println("Таблица заполнена");
    }

    public static void ReadDB() throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM \"users\"");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String age = resSet.getString("age");
            out.println("ID = " + id);
            out.println("name = " + name);
            out.println("age = " + age);
            out.println();
        }

        out.println("Таблица выведена");
    }

    public static void CloseDB() throws SQLException {
        conn.close();
        statmt.close();
        resSet.close();

        out.println("Соединения закрыты");
    }
}
