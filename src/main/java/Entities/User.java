package Entities;

public class User {
    private int id;
    private String user_name;
    private String password;
    private int age;
    private String email;
    private int adopted_number;
    private boolean admin;

    public User() {
    }

    public User(String user_name, String password, int age, String email, int adopted_number, boolean admin) {
        this.user_name = user_name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.adopted_number = adopted_number;
        this.admin = admin;
    }

    public User(int id, String user_name, String password, int age, String email, int adopted_number, boolean admin) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.adopted_number = adopted_number;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdopted_number() {
        return adopted_number;
    }

    public void setAdopted_number(int adopted_number) {
        this.adopted_number = adopted_number;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", adopter_number=" + adopted_number +
                ", admin=" + admin +
                '}';
    }
}
