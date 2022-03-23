package Main_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    static Connection conn = null;
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.mysql.JDBC.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db?"+ "user=root&password=12345678");
    }
}