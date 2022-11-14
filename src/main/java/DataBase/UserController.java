package DataBase;

import Entities.Dog;
import Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public static Connection connection;

    public static void addUser(User user) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO user " +
                    "(user_name, age, email, adopted_number, admin, password) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, user.getUser_name());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getAdopted_number());
            stmt.setBoolean(5, user.isAdmin());
            stmt.setString(6, user.getPassword());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT  * FROM user");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_name(rs.getString("user_name"));
                user.setId(rs.getInt("user_id"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setAdopted_number(rs.getInt("adopted_number"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static void userAdopt(int id, int adopted) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE user SET adopted_number = ? WHERE user_id = ?");
            stmt.setInt(1, adopted);
            stmt.setInt(2, id);
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void makeAdmin(User user) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE user SET admin = ? WHERE user_id = ?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, user.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createAdoption(int user_id, Dog dog) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO user_dogs (user_id, dog_id) VALUES (?, ?)");
            stmt.setInt(1, user_id);
            stmt.setInt(2, dog.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Dog> userAdoptedDogs(int user_id) {
        List<Dog> dogs = new ArrayList<>();
        List<Dog> databaseDogs = DogController.readDogs();
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_dogs WHERE user_id = ?");
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int dogId = rs.getInt("dog_id");
                for (Dog x : databaseDogs) {
                    if (x.getId() == dogId) {
                        dogs.add(x);
                    }
                }
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dogs;
    }

}
