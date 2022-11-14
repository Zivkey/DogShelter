package DataBase;

import Entities.Dog;
import Enums.DogGender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogController {
    public static Connection connection;

    public static void addDog(Dog dog) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO dogs " +
                    "(dog_name, dog_age, dog_gender, dog_breed, vacinated, adopted) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, dog.getName());
            stmt.setInt(2, dog.getAge());
            stmt.setString(3, String.valueOf(dog.getGender()));
            stmt.setString(4, dog.getDogBreed());
            stmt.setBoolean(5, dog.isVaccinated());
            stmt.setBoolean(6, dog.isAdopted());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Dog> readDogs() {
        List<Dog> dogs = new ArrayList<>();
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM dogs");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setId(rs.getInt("dog_id"));
                dog.setName(rs.getString("dog_name"));
                dog.setAge(rs.getInt("dog_age"));
                dog.setDogBreed(rs.getString("dog_breed"));
                dog.setVaccinated(rs.getBoolean("vacinated"));
                dog.setAdopted(rs.getBoolean("adopted"));
                dog.setGender(DogGender.valueOf(rs.getString("dog_gender")));
                dogs.add(dog);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dogs;
    }

    public static void updateDog(Dog dog) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("UPDATE dogs SET adopted = ?, vacinated = ? WHERE dog_id = ?");
            stmt.setBoolean(1, dog.isAdopted());
            stmt.setBoolean(2, dog.isVaccinated());
            stmt.setInt(3, dog.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDog(Dog dog) {
        try {
            connection = DBConnect.openConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM dogs WHERE dog_id = ?");
            stmt.setInt(1, dog.getId());
            stmt.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
