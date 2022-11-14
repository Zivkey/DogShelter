package Scenes.AdminScenes;

import DataBase.DogController;
import Entities.Dog;
import Util.TableViewUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class AdminViewDogs extends Application {

    private Label titleLabel = new Label("Delete dogs");
    private Label messageLabel = new Label(" ");

    private TableView<Dog> tableView = TableViewUtil.createDogTable();

    private Button deleteButton = new Button("Delete");
    private Button backButton = new Button("Back");


    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<Dog> dogs = DogController.readDogs();
        for (Dog d : dogs) {
            if (!d.isAdopted()) {
                tableView.getItems().add(d);
            }
        }

        HBox buttonBox = new HBox(backButton, deleteButton);
        VBox root = new VBox(titleLabel, tableView, messageLabel, buttonBox);
        root.setSpacing(20);
        buttonBox.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        deleteButton.setOnAction(actionEvent -> {
            Dog currentDog = tableView.getSelectionModel().getSelectedItem();
            if (currentDog == null) {
                messageLabel.setText("You need to select a dog!");
                messageLabel.setTextFill(Color.RED);
            } else {
                DogController.deleteDog(currentDog);
                tableView.getItems().clear();
                for (int i = 0; i < dogs.size(); i++) {
                    if (dogs.get(i).getId() == currentDog.getId()) {
                        dogs.remove(i);
                    }
                }
                for (Dog d : dogs) {
                    if (!d.isAdopted()) {
                        tableView.getItems().add(d);
                    }
                }
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Dog successfully deleted!");
            }
        });
    }
}
