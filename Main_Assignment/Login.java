package Main_Assignment;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class Login {
    private Connection conn = null;
    private User admin = null;
    Scanner scan = new Scanner(System.in);
    
    public Login(String username, String password, Connection conn) throws Exception {
        this.conn = conn;
        Statement statement = conn.createStatement();
        ResultSet row = statement.executeQuery("SELECT * FROM UserData WHERE username='" +username+"' AND password='" + password + "'");
        if (row.next()) {
            this.admin = new User(row.getString("userid"), row.getString("username"),
                                row.getString("emailid"), row.getString("password"),
                                row.getString("name"), row.getString("company"),
                                row.getString("designation"), row.getString("address"),
                                row.getInt("phone"), row.getInt("age"), row.getDouble("salary"));
        } else throw new Exception("User does not exists");
    }

    public void loginAction() {
        int inp;
        while (true) {
            printActionStatement();
            inp = scan.nextInt(); scan.nextLine();
            switch (inp) {
                case 1 -> addUserData();
                case 2 -> listUserData();
                case 3 -> updateUserData();
                case 4 -> deleteUserData();
                default -> System.exit(0);
            }
        }
    }

    private void deleteUserData() {
        String username;
        System.out.println("Write the username whose data you want to delete");
        username = scan.nextLine();
        try {
            DBHandler.DeleteUser(username, conn);
            System.out.println("============= User Successfully Dleted ==============");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUserData() {
        String name, company, designation, address;
        long phone, age;
        double salary;
        name = askForString("Name");
        company = askForString("Company Name");
        designation = askForString("Designation");
        address = askForString("Address");
        phone = askForIntValue("Phone");
        age = askForIntValue("Age");
        salary = askSalary();
        try {
            Validate.validatePhoneNumber(conn, phone);
            Validate.validateAge(age);
            Validate.validateSalary(salary);
            admin.setName(name); admin.setCompany(company); admin.setDesignation(designation);
            admin.setAddress(address); admin.setPhone(phone); admin.setAge(age);
            admin.setSalary(salary);
            DBHandler.UpdateData(admin, conn);
            System.out.println("========== User Data Successfully updated ==========");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void listUserData() {
        if (admin.getName() == null || admin.getAge() == 0 || admin.getCompany() == null || admin.getAddress() == null
            || admin.getPhone() == 0 || admin.getSalary() == 0) {
            System.out.println("========= Fill all the user entries ===========");
            return;
        }
        System.out.println("========== Listing user Data =========");
        System.out.println("User id = " + admin.getUserid());
        System.out.println("Name = " + admin.getName());
        System.out.println("Age = " + admin.getAge());
        System.out.println("Company name = " + admin.getCompany());
        System.out.println("Designation = " + admin.getDesignation());
        System.out.println("Salary = " + admin.getSalary());
        System.out.println("Address = " + admin.getAddress());
        System.out.println("Phone number = " + admin.getPhone());
        System.out.println("========== Listing user Data =========");
    }

    private void addUserData() {
        String userId = UUID.randomUUID().toString();
        String name, company, address, designation, email, username, password;
        long age, phone;
        double salary;
        name = askForString("Name");
        username = askForString("Username");
        password = askForString("Password");
        age = askForIntValue("Age");
        company = askForString("Company Name");
        designation = askForString("Designation");
        email = askForString("Email");
        salary = askSalary();
        address = askForString("Address");
        phone = askForIntValue("Phone");

        try {
            Validate.validateEmail(conn, email);
            Validate.validateAge(age);
            Validate.validateSalary(salary);
            Validate.validateUsername(conn, username);
            Validate.validatePhoneNumber(conn, phone);
            Validate.validatePassword(password, password);
            User user = new User(userId, username, email, password, name, company, designation, address, phone, age, salary);
            try {
                DBHandler.InsertData(user, conn);
                System.out.println("=========== User Successfully added ==========");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Invalid entry");
            e.printStackTrace();
        }
    }

    private String askForString(String type) {
        String res;
        System.out.print(type + " = "); res = scan.nextLine().trim();
        return res;
    }

    private long askForIntValue(String type) {
        String x;
        System.out.print(type + " = "); x = scan.nextLine().trim();
        return Long.parseLong(x);
    }

    private double askSalary() {
        String x;
        System.out.print("Salary = "); x = scan.nextLine().trim();
        return Double.parseDouble(x);
    }


    public void printActionStatement() {
        System.out.println("Press 1 to add user data");
        System.out.println("Press 2 to List user data");
        System.out.println("Press 3 to Update user data");
        System.out.println("Press 4 to Delete user data");
        System.out.println("Press 5 to exit");
    }

}