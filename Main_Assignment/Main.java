package Main_Assignment;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int inp;
    public static void main(String[] args) {
        try {
            DBConnect.connect();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

        System.out.println("Welcome to User Data-Base");
        while (true) {
            System.out.println("Press 1 to Login");
            System.out.println("Press 2 to Register");
            inp = scan.nextInt(); scan.nextLine();
            switch (inp) {
                case 1 -> loginUtil();
                case 2 -> registerUtil();
                default -> System.exit(0);
            }
            System.out.println();
        }
    }

    private static void registerUtil() {
        String userId = UUID.randomUUID().toString();
        //System.out.println(userId);
        String username, password, repassword;
        System.out.println("Welcome to Registration page");
        System.out.print("Username = "); username = scan.nextLine();
        System.out.print("Password = "); password = scan.nextLine();
        System.out.print("Re-enter password = "); repassword = scan.nextLine();

        try {
            Register.register(DBConnect.conn, userId, username, password, repassword);
            System.out.println("Registration Successful. Redirected to home page to continue");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    static void loginUtil() {
        String username, password;
        System.out.println("Welcome to Login page");
        System.out.print("Username = "); username = scan.nextLine().trim();
        System.out.print("Password = "); password = scan.nextLine().trim();

        try {
            Login login = new Login(username, password, DBConnect.conn);
            System.out.println("User successfully logged in");
            login.loginAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}