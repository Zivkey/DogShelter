package Scenes.UserScenes;

import DataBase.DogController;
import DataBase.UserController;
import Entities.Dog;
import Entities.User;
import Enums.DogGender;
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

public class UserAdopted extends Application {

    private Label titleLabel = new Label("Your adopted dogs:");
    private Label messageLabel = new Label(" ");

    private TableView<Dog> tableView = TableViewUtil.createDogTable();

    private Button backButton = new Button("Back");
    private Button vaccinateButton = new Button("Vaccinate");

    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        CurrentUser.setDogs(UserController.userAdoptedDogs(CurrentUser.getCurrentId()));

        for (Dog x : CurrentUser.getDogs()) {
            tableView.getItems().add(x);
        }

        HBox buttonBox = new HBox(backButton, vaccinateButton);
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(titleLabel, tableView, messageLabel, buttonBox);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Adopted Dogs");
        stage.setScene(scene);
        stage.show();

        vaccinateButton.setOnAction(actionEvent -> {
            Dog currentDog = tableView.getSelectionModel().getSelectedItem();
            if (currentDog == null) {
                messageLabel.setText("You need to select a dog!");
                messageLabel.setTextFill(Color.RED);
            } else if (currentDog.isVaccinated()) {
                messageLabel.setText("Dog is already vaccinated!");
                messageLabel.setTextFill(Color.RED);
            } else {
                currentDog.setVaccinated(true);
                DogController.updateDog(currentDog);
                tableView.getItems().clear();
                for (Dog x : CurrentUser.getDogs()) {
                    tableView.getItems().add(x);
                }
                messageLabel.setText("Dog successfully vaccinated!");
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
