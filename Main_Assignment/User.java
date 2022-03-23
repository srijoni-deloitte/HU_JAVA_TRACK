package Main_Assignment;

public class User {
    private String userid = null, username = null, email = null;
    private String password = null, name = null, company = null, designation = null, address = null;
    private long phone = 0, age = 0;
    private double salary;

    public User(String userId, String username, String password) {
        this.userid = userId;
        this.username = username;
        this.password = password;
    }

    public User(String userid, String username, String email, String password, String name, String company, String designation, String address, long phone, long age, double salary) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.company = company;
        this.designation = designation;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public long getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String res = "'" + userid + "','" + username + "','" + email + "','" + password + "','" + phone + "','"
                    + salary + "','" + name + "','" + age + "','" + company + "','" + designation + "','" +
                    address + "'";
        return res;
    }
}