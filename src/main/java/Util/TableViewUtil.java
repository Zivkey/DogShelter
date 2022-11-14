package Util;

import DataBase.UserController;
import Entities.Dog;
import Entities.Message;
import Entities.User;
import Enums.DogGender;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableViewUtil {
    public static TableView<Dog> createDogTable() {
        TableView<Dog> tableView = new TableView<>();

        TableColumn<Dog, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Dog, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Dog, DogGender> genderColumn = new TableColumn<>("Gender");
        TableColumn<Dog, String> breedColumn = new TableColumn<>("Breed");
        TableColumn<Dog, Boolean> vaccinatedColumn = new TableColumn<>("Vaccinated");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("dogBreed"));
        vaccinatedColumn.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(ageColumn);
        tableView.getColumns().add(genderColumn);
        tableView.getColumns().add(breedColumn);
        tableView.getColumns().add(vaccinatedColumn);

        tableView.setMaxWidth(355);
        nameColumn.setMaxWidth(70);
        ageColumn.setMaxWidth(70);
        genderColumn.setMaxWidth(70);
        breedColumn.setMaxWidth(70);
        vaccinatedColumn.setMaxWidth(70);

        return tableView;
    }

    public static TableView<User> createUserTable() {
        TableView<User> tableView = new TableView<>();

        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        TableColumn<User, String> passColumn = new TableColumn<>("Password");
        TableColumn<User, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        TableColumn<User, Integer> adoptedColumn = new TableColumn<>("Adopted");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        adoptedColumn.setCellValueFactory(new PropertyValueFactory<>("adopted_number"));

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(passColumn);
        tableView.getColumns().add(ageColumn);
        tableView.getColumns().add(emailColumn);
        tableView.getColumns().add(adoptedColumn);

        tableView.setMaxWidth(355);
        nameColumn.setMaxWidth(70);
        ageColumn.setMaxWidth(70);
        passColumn.setMaxWidth(70);
        emailColumn.setMaxWidth(70);
        adoptedColumn.setMaxWidth(70);

        return tableView;

    }

}
