package Scenes.UserScenes;

import DataBase.MessageController;
import Entities.Message;
import Enums.MessageType;
import Util.CurrentUser;
import Util.MessageUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserMessage extends Application {

    private Label headerLabel = new Label("Leave us a message!");
    private Label selectLabel = new Label("Select the message type");
    private Label titleLabel = new Label("Title of the message:");
    private Label textLabel = new Label("Text of the message:");
    private Label messageLabel = new Label("");

    private TextField titleField = new TextField();
    private TextArea msgtextArea = new TextArea();
    private ComboBox<MessageType> typeBox = new ComboBox<>();

    private Button returnButton = new Button("Return");
    private Button addButton = new Button("Send message");

    @Override
    public void start(Stage stage) throws Exception {
        headerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        msgtextArea.setWrapText(true);
        typeBox.setItems(FXCollections.observableArrayList(MessageType.values()));
        typeBox.getSelectionModel().selectFirst();
        HBox buttonBox = new HBox(returnButton, addButton);
        VBox root = new VBox(headerLabel, selectLabel, typeBox, titleLabel, titleField, textLabel, msgtextArea, messageLabel, buttonBox);
        root.setSpacing(20);
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        titleField.setMaxWidth(130);
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Message");
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(actionEvent -> {
            if (MessageUtil.textCheck(msgtextArea) && MessageUtil.titleCheck(titleField)) {
                MessageType messageType = typeBox.getSelectionModel().getSelectedItem();
                Message message = new Message(CurrentUser.getCurrentId(), messageType, titleField.getText(), msgtextArea.getText());
                MessageController.addMessage(message);
                messageLabel.setText("Message sent successfully!");
                messageLabel.setTextFill(Color.GREEN);
                titleField.setText("");
                msgtextArea.setText("");
            } else {
                messageLabel.setText("Message is not ok!");
                messageLabel.setTextFill(Color.RED);
            }
        });

        returnButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new UserMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}
