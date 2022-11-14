package Scenes.AdminScenes;

import DataBase.UserController;
import Entities.User;
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

public class AdminUsers extends Application {

    private Label titleLabel = new Label("Make another user admin");
    private Label messageLabel = new Label(" ");

    private TableView<User> tableView = TableViewUtil.createUserTable();

    private Button backButton = new Button("Back");
    private Button adminButton = new Button("Make admin");

    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<User> users = UserController.readUsers();
        for (User x : users) {
            if (!x.isAdmin()) {
                tableView.getItems().add(x);
            }
        }


        HBox buttonBox = new HBox(backButton, adminButton);
        VBox root = new VBox(titleLabel, tableView, messageLabel, buttonBox);
        root.setSpacing(20);
        buttonBox.setSpacing(20);
        root.setPadding(new Insets(20));
        buttonBox.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
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


        adminButton.setOnAction(actionEvent -> {
            User currentUser = tableView.getSelectionModel().getSelectedItem();
            if (currentUser == null) {
                messageLabel.setText("You need to select a user!");
                messageLabel.setTextFill(Color.RED);
            } else {
                currentUser.setAdmin(true);
                UserController.makeAdmin(currentUser);
                tableView.getItems().clear();
                for (User x : users) {
                    if (!x.isAdmin()) {
                        tableView.getItems().add(x);
                    }
                }
                messageLabel.setText("User had been successfully made to admin!");
                messageLabel.setTextFill(Color.GREEN);
            }
        });
    }
}
