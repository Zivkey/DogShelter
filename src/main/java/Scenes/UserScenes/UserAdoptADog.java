package Scenes.UserScenes;

import DataBase.DogController;
import DataBase.UserController;
import Entities.Dog;
import Util.CurrentUser;
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

public class UserAdoptADog extends Application {

    private Label titleLabel = new Label("Adopt your new dog:");

    private TableView<Dog> tableView = TableViewUtil.createDogTable();

    private Label messageLabel = new Label(" ");

    private Button backButton = new Button("Back");
    private Button adoptButton = new Button("Adopt");

    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<Dog> dogs = DogController.readDogs();
        for (Dog x : dogs) {
            if (!x.isAdopted()) {
                tableView.getItems().add(x);
            }
        }

        HBox buttonBox = new HBox(backButton, adoptButton);
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(titleLabel, tableView, messageLabel, buttonBox);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("MainMeni");
        stage.setScene(scene);
        stage.show();

        adoptButton.setOnAction(actionEvent -> {
            Dog currentDog = tableView.getSelectionModel().getSelectedItem();
            if (currentDog == null) {
                messageLabel.setText("You need to select a dog!");
                messageLabel.setTextFill(Color.RED);
            } else {
                currentDog.setAdopted(true);
                DogController.updateDog(currentDog);
                tableView.getItems().clear();
                for (Dog x : dogs) {
                    if (!x.isAdopted()) {
                        tableView.getItems().add(x);
                    }
                }
                CurrentUser.setNumberAdopted(CurrentUser.getNumberAdopted() + 1);
                UserController.userAdopt(CurrentUser.getCurrentId(), CurrentUser.getNumberAdopted());
                UserController.createAdoption(CurrentUser.getCurrentId(), currentDog);
                messageLabel.setText("Dog successfully adopted!");
                messageLabel.setTextFill(Color.GREEN);
            }
        });

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new UserMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
