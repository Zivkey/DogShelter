package Scenes.AdminScenes;

import DataBase.DogController;
import Entities.Dog;
import Enums.DogGender;
import Util.JsoupUtil;
import Util.RegisterUtil;
import Util.WordUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class AdminCreateDog extends Application {

    private Label titleLabel = new Label("Add a new dog:");
    private Label nameLabel = new Label("Select dog:");
    private Label ageLabel = new Label("Select dogs age:");
    private Label genderLabel = new Label("Select gender:");
    private Label breedLabel = new Label("Select breed:");
    private Label vacinatedLabel = new Label("Is vaccinated:");
    private Label incorrectNameLabel = new Label("Name is not correct!");
    private Label incorrectAgeLabel = new Label("Age is not correct!");
    private Label messageLabel = new Label("Dog successfully added!");

    private TextField nameFiled = new TextField();
    private TextField ageField = new TextField();

    private RadioButton male = new RadioButton("Male");
    private RadioButton female = new RadioButton("Female");
    private ToggleGroup genderGroup = new ToggleGroup();

    private ComboBox<String> breedCombo = new ComboBox<>();

    private CheckBox yesCheck = new CheckBox("Yes");

    private Button backButton = new Button("Back");
    private Button addButton = new Button("Create");


    @Override
    public void start(Stage stage) throws Exception {
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16");
        messageLabel.setVisible(false);
        incorrectNameLabel.setVisible(false);
        incorrectAgeLabel.setVisible(false);
        messageLabel.setTextFill(Color.GREEN);
        incorrectNameLabel.setTextFill(Color.RED);
        incorrectAgeLabel.setTextFill(Color.RED);
        List<String> breeds = JsoupUtil.dogBreadJsoup();
        for (String s : breeds) {
            breedCombo.getItems().add(s);
        }
        breedCombo.setMaxWidth(150);
        breedCombo.getSelectionModel().selectFirst();
        female.setSelected(true);

        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        HBox buttonBox = new HBox(backButton, addButton);
        HBox radioBox = new HBox(female, male);
        VBox root = new VBox(titleLabel, nameLabel, nameFiled, incorrectNameLabel, ageLabel, ageField, incorrectAgeLabel, genderLabel, radioBox, breedLabel,
                breedCombo, vacinatedLabel, yesCheck, messageLabel, buttonBox);
        root.setSpacing(15);
        buttonBox.setSpacing(20);
        radioBox.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        radioBox.setAlignment(Pos.CENTER);

        nameFiled.setMaxWidth(120);
        ageField.setMaxWidth(120);

        Scene scene = new Scene(root, 400, 550);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(actionEvent -> {
            incorrectNameLabel.setVisible(false);
            incorrectAgeLabel.setVisible(false);
            messageLabel.setVisible(false);
            if (!RegisterUtil.nameCheck(nameFiled.getText())) {
                incorrectNameLabel.setVisible(true);
            }
            if (!WordUtil.onlyNumbers(ageField.getText()) || ageField.getText() == "" || Integer.parseInt(ageField.getText()) > 20) {
                incorrectAgeLabel.setVisible(true);
            } else {
                boolean vaccinated = false;
                if (yesCheck.isSelected()) {
                    vaccinated = true;
                }
                DogGender dogGender = DogGender.FEMALE;
                if (male.isSelected()) {
                    dogGender = DogGender.MALE;
                }
                String breed = breedCombo.getSelectionModel().getSelectedItem().toString();
                Dog bigDawg = new Dog(nameFiled.getText(), Integer.parseInt(ageField.getText()),dogGender, breed, vaccinated, false);
                DogController.addDog(bigDawg);
                nameFiled.setText("");
                ageField.setText("");
                messageLabel.setVisible(true);
            }
        });

        backButton.setOnAction(actionEvent -> {
            stage.close();
            try {
                new AdminMeni().start(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
