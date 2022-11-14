package Scenes.UserScenes;

import Scenes.Login;
import Util.CurrentUser;
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

public class UserMeni extends Application {

    private Label welcomeLabel = new Label("");

    private Button adoptButton = new Button("Adopt a dog");
    private Button messageButton = new Button("Send a message");
    private Button viewButton = new Button("View your dogs");
    private Button logoutButton = new Button("Log out");


    @Override
    public void start(Stage stage) throws Exception {
        welcomeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        welcomeLabel.setText("Welcome " + CurrentUser.getUserName());
        VBox root = new VBox(welcomeLabel, adoptButton, viewButton, messageButton, logoutButton);
        root.setSpacing(30);
        root.setAlignment(Pos.CENTER);
        List<Button> buttons = Arrays.asList(adoptButton, messageButton, viewButton, logoutButton);
        for (Button x : buttons) {
            x.setMinWidth(100);
            x.setMinHeight(30);
        }
        Scene scene = new Scene(root, 320, 350);
        stage.setTitle("MainMeni");
        stage.setScene(scene);
        stage.show();

        logoutButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        messageButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new UserMessage().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        adoptButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new UserAdoptADog().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        viewButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new UserAdopted().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }
}
