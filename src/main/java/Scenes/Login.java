package Scenes;

import DataBase.UserController;
import Entities.User;
import Scenes.AdminScenes.AdminMeni;
import Scenes.UserScenes.UserMeni;
import Util.CurrentUser;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Login extends Application {

    private Label headerLabel = new Label("Welcome to dog shelter!");
    private Label userLabel = new Label("Enter email:");
    private Label passLabel = new Label("Enter password:");
    private Label messageLabel = new Label(" ");

    private TextField mailField = new TextField();
    private PasswordField passField = new PasswordField();

    private Button loginBtn = new Button("Login");
    private Button registerBtn = new Button("Register");

    @Override
    public void start(Stage stage) throws IOException {
        headerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<User> listOfUsers = UserController.readUsers();

        HBox buttonBox = new HBox(loginBtn, registerBtn);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        VBox root = new VBox(headerLabel, userLabel, mailField, passLabel, passField, messageLabel, buttonBox);
        passField.setMaxWidth(130);
        mailField.setMaxWidth(130);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);


        Scene scene = new Scene(root, 320, 350);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        loginBtn.setOnAction(actionEvent -> {
            for (User user : listOfUsers) {
                if (passField.getText().equals(user.getPassword()) && mailField.getText().equals(user.getEmail())) {
                    CurrentUser.setCurrentId(user.getId());
                    CurrentUser.setUserName(user.getUser_name());
                    CurrentUser.setNumberAdopted(user.getAdopted_number());
                    if (user.isAdmin()) {
                        stage.close();
                        try {
                            new AdminMeni().start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        stage.close();
                        try {
                            new UserMeni().start(stage);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            messageLabel.setText("Incorect email or password!");
            messageLabel.setTextFill(Color.RED);
        });

        registerBtn.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Register().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        mailField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                passField.requestFocus();
            }
        });

        passField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                loginBtn.fire();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}