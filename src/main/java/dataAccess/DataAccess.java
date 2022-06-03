package dataAccess;

import models.User;

import javax.management.monitor.StringMonitor;
import java.sql.*;

import static java.lang.System.out;

public class DataAccess {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/TEST_JAVA";
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
        statmt.execute("CREATE TABLE if not exists \"users\" (Id SERIAL PRIMARY KEY, name text, age INT);");
        statmt.execute("CREATE TABLE if not exists \"autos\" (Id SERIAL PRIMARY KEY, model text, color TEXT, UserId INTEGER REFERENCES users(Id));");

        out.println("Таблицы созданы или уже существуют.");
    }

    public User getUser(int id) throws SQLException {
        resSet = statmt.executeQuery("SELECT * FROM users WHERE id = " + id);

        while (resSet.next()) {
            int idUs = resSet.getInt("id");
            if (idUs == id) {
                String name = resSet.getString("name");
                int age = resSet.getInt("age");
                out.println(name + "\t" + age);
                return new User(name, age);
            }
        }
        return new User();
    }

    public void AddUser(User user) throws SQLException {
        statmt.executeUpdate("INSERT INTO users (name ,age) VALUES (\'" + user.getName() + "\', " + user.getAge() + ")");
    }

    public void DeleteUser(User user) throws SQLException {
        statmt.executeUpdate("DELETE FROM users WHERE name=\'" + user.getName() + "\' AND age = " + user.getAge());
    }

    public static void WriteDB() {
        try {
            statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Petya', 16);");
            statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Vasya', 14);");
            statmt.execute("INSERT INTO \"users\" (\"name\", \"age\") VALUES ('Masha', 18);");
            statmt.execute("INSERT INTO \"autos\" (\"model\", \"userid\") VALUES ('LAda', 2);");
            statmt.execute("INSERT INTO \"autos\" (\"model\", \"userid\") VALUES ('Ferrari', 1);");
            statmt.execute("INSERT INTO \"autos\" (\"model\", \"userid\") VALUES ('BMW', 3);");
        } catch (SQLException e) {
            System.out.println(e);
        }

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
}
