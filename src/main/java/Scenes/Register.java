package Scenes;

import DataBase.UserController;
import Entities.User;
import Util.RegisterUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Register extends Application {

    private Label titleLabel = new Label("Register to the dog shelter!");
    private Label nameLabel = new Label("Enter User name:");
    private Label emailLabel = new Label("Enter email:");
    private Label passLabel = new Label("Enter password:");
    private Label ageLabel = new Label("Enter age:");
    private Label confirmLabel = new Label("Confirm password:");
    private Label incorrectName = new Label("Name is incorrect!");
    private Label incorrectEmail = new Label("Email is incorrect!");
    private Label incorrectPass = new Label("Password is incorrect!");
    private Label incorrectMath = new Label("Passwords do not match!");
    private Label incorrectAge = new Label("Age is incorrect!");
    private Label meesageLabel = new Label("User successfully added!");

    private TextField nameField = new TextField();
    private TextField emailField = new TextField();
    private TextField ageField = new TextField();
    private PasswordField passField = new PasswordField();
    private PasswordField confirmField = new PasswordField();

    private Button registerButton = new Button("Register");
    private Button loginButton = new Button("Login");

    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        meesageLabel.setVisible(false);
        meesageLabel.setTextFill(Color.GREEN);
        List<Label> incorrectLabels = Arrays.asList(incorrectAge, incorrectName, incorrectEmail, incorrectMath, incorrectPass);
        for (Label x : incorrectLabels) {
            x.setVisible(false);
            x.setTextFill(Color.RED);
        }
        HBox buttonBox = new HBox(loginButton, registerButton);
        VBox root = new VBox(titleLabel, nameLabel, nameField, incorrectName, emailLabel, emailField, incorrectEmail, ageLabel, ageField, incorrectAge, passLabel, passField, incorrectPass
                ,confirmLabel, confirmField,  incorrectMath, meesageLabel, buttonBox);
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        buttonBox.setSpacing(20);
        nameField.setMaxWidth(130);
        emailField.setMaxWidth(130);
        passField.setMaxWidth(130);
        confirmField.setMaxWidth(130);
        ageField.setMaxWidth(130);
        root.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 700);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        registerButton.setOnAction(actionEvent -> {

        });

        loginButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new Login().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        registerButton.setOnAction(actionEvent -> {
            meesageLabel.setVisible(false);
            for (Label x : incorrectLabels) {
                x.setVisible(false);
            }
            int correct = 0;
            if (!RegisterUtil.nameCheck(nameField.getText())) {
                incorrectName.setVisible(true);
                correct += 1;
            }
            if (!RegisterUtil.emailCheck(emailField.getText())) {
                incorrectEmail.setVisible(true);
                correct += 1;
            }
            if (!RegisterUtil.passwordIsOk(passField.getText())) {
                incorrectPass.setVisible(true);
                correct += 1;
            }
            if (!RegisterUtil.checkPassword(passField.getText(), confirmField.getText())) {
                incorrectMath.setVisible(true);
                correct += 1;
            }
            if (!RegisterUtil.checkAge(ageField.getText())) {
                incorrectAge.setVisible(true);
                correct += 1;
            }
            if (correct == 0) {
                User user = new User(nameField.getText(), passField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), 0, false);
                UserController.addUser(user);
                emailField.setText("");
                passField.setText("");
                confirmField.setText("");
                nameField.setText("");
                ageField.setText("");
                meesageLabel.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
