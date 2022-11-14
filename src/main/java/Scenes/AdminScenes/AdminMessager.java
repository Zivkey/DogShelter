package Scenes.AdminScenes;

import DataBase.MessageController;
import DataBase.UserController;
import Entities.Message;
import Entities.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdminMessager extends Application {

    private Label titleLabel = new Label("Delete the message");
    private Label messageLabel = new Label();

    private ComboBox<String> messageComboBox = new ComboBox<>();

    private TextArea messageArea = new TextArea();

    private Button backButton = new Button("Back");

    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        List<Message> currentMessage = new ArrayList<>();
        List<Message> messages = MessageController.readMessager();
        for (Message x : messages) {
            messageComboBox.getItems().add(x.getTitle());
        }
        List<User> users = UserController.readUsers();

        messageArea.setWrapText(true);
        messageArea.setEditable(false);
        VBox root = new VBox(titleLabel,messageLabel, messageComboBox, messageArea, backButton);
        root.setSpacing(30);
        root.setPadding(new Insets(20));
        messageArea.setMaxWidth(220);
        messageArea.setMaxHeight(80);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 450, 450);
        stage.setTitle("Messages");
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


        messageComboBox.valueProperty().addListener((observableValue, s, t1) -> {
            for (Message x : messages) {
                if (x.getTitle() == t1) {
                    for (User z : users) {
                        if (z.getId() == x.getUserId()) {
                            messageLabel.setText(z.getUser_name() + " " + x.getMessageType());
                            messageArea.setText(x.getText());
                            currentMessage.clear();
                            currentMessage.add(x);
                        }
                    }
                }
            }
        });
    }
}
