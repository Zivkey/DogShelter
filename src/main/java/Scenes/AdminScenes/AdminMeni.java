package Scenes.AdminScenes;

import Scenes.Login;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AdminMeni extends Application {

    private Label adminLabel = new Label("Welcome to admin menu!");

    private Button dogsButton = new Button("View dogs");
    private Button userButton = new Button("View users");
    private Button addDogButton = new Button("Add a dog");
    private Button messagesButton = new Button("Messages");
    private Button backButton = new Button("Logout");

    @Override
    public void start(Stage stage) throws Exception {
        adminLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<Button> buttons = Arrays.asList(dogsButton, userButton, addDogButton, backButton, messagesButton);
        for (Button x : buttons) {
            x.setMinWidth(100);
            x.setMinHeight(30);
        }
        VBox root = new VBox(adminLabel, dogsButton, userButton, addDogButton, messagesButton, backButton);
        root.setSpacing(30);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 320, 390);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        addDogButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminCreateDog().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        dogsButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminViewDogs().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        userButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminUsers().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        messagesButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminMessager().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
}
