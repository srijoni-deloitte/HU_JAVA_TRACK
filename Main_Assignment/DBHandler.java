package Main_Assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
    static final String InsertSQLPrefix = "INSERT INTO UserData (userid, username, emailid, password, phone, salary, name, age, company, designation, address) VALUES";
    static void createTable(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS UserData " +
                            "(userid TEXT, username TEXT, emailid TEXT, password TEXT, phone INTEGER," +
                "salary REAL, name TEXT, age INTEGER, company TEXT, designation TEXT, address TEXT)");
    }

    public static void InsertData(User user, Connection conn) throws Exception {
        Statement statement = conn.createStatement();
        String sql = InsertSQLPrefix + "(" + user.toString() + ")";
        //System.out.println(sql);
        statement.execute(sql);
    }

    public static void UpdateData(User user, Connection conn) throws Exception {
        String sql = "UPDATE UserData SET emailid='"+ user.getEmail() + "', phone='" + user.getPhone()
                        + "', salary='" + user.getSalary() + "', name='" + user.getName()
                        + "', age='" + user.getAge() + "', company='" + user.getCompany() + "', Designation='" +
                        user.getDesignation() + "', address='" + user.getAddress() + "' WHERE username='" +
                        user.getUsername() + "' AND password='" + user.getPassword() + "'";
        Statement statement = conn.createStatement();
        statement.execute(sql);
    }
    public static void DeleteUser(String username, Connection conn) throws Exception {
        String sql = "DELETE FROM UserData WHERE username='" + username + "'";
        Statement statement = conn.createStatement();
        statement.execute(sql);
    }
}
