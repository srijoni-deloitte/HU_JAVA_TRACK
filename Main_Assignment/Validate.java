package Main_Assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Validate {
    static void validatePassword(String password, String rePassword) throws Exception {
        if (password.compareTo(rePassword) > 0) {
            throw new Exception("password missmatch");
        }
        int len = password.length();
        if (len < 5 || len > 10) throw new Exception("Password length should be between 5 and 10");
        int cntUpperCase = 0, cntLowerCase = 0, cntDigit = 0, cntSpecialChar = 0;
        for (char i: password.toCharArray()) {
            if (i >= 'A' && i <= 'Z') cntUpperCase++;
            if (i >= 'a' && i <= 'z') cntLowerCase++;
            if (i >= '0' && i <= '9') cntDigit++;
            if (i == '@' || i == '#' || i == '&' || i == '%' || i == '*' || i == '!') cntSpecialChar++;
        }
        if (cntUpperCase == 0) throw new Exception("Password must have at least one uppercase alphabet");
        if (cntLowerCase == 0) throw new Exception("Password must have at least one lowercase alphabet");
        if (cntDigit == 0) throw new Exception("Password must have at least one Digit");
        if (cntSpecialChar == 0) throw new Exception("Password must have at least one special characters(@,#,&,%,*,!)");
    }

    static void validatePhoneNumber(Connection conn, long phone) throws Exception {
        if (phone < 0) throw new Exception("Invalid Phone number");
        long n = phone;
        int cnt = 0;
        while (n > 0) {
            cnt++; n /= 10;
        }
        if (cnt != 10) throw new Exception("Phone number should be of 10 digits");

        Statement statement = conn.createStatement();
        ResultSet row = statement.executeQuery("SELECT * FROM UserData WHERE phone='" + phone+"'");
        if (row.next()) throw new Exception("Phone number already exists");
    }
    static void validateEmail(Connection conn, String email) throws Exception {
        Statement statement = conn.createStatement();
        ResultSet row = statement.executeQuery("SELECT * FROM UserData WHERE emailid='" + email+"'");
        if (row.next()) throw new Exception("Email id already exists");
    }

    static void validateUsername(Connection conn, String username) throws Exception {
        Statement statement = conn.createStatement();
        ResultSet row = statement.executeQuery("SELECT * FROM UserData WHERE username='" + username+"'");
        // System.out.println(row.next());
        if (row.next()) throw new Exception("Username already exists");
    }

    static void validateAge(long age) throws Exception {
        if (age < 18 || age > 90) throw new Exception("Age should be between 18 and 90");
    }
    static void validateSalary(double salary) throws Exception {
        if (salary <= 0) throw new Exception("Salary must be positive");
    }
}