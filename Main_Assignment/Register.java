package Main_Assignment;

import java.io.PushbackReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register {
    static void register (Connection conn, String userId, String username, String password, String repassword) throws Exception {
        Validate.validateUsername(conn, username);
        Validate.validatePassword(password, repassword);
        User user = new User(userId, username, password);
        try {
            DBHandler.InsertData(user, conn);
        } catch (Exception e) {
            throw new Exception("username already exists");
        }
    }
}