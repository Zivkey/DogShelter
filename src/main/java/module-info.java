module com.example.azil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jsoup;


    exports Scenes;
    opens Scenes to javafx.fxml;
    exports Scenes.UserScenes;
    opens Scenes.UserScenes to javafx.fxml;
    exports Entities;
    opens Entities to javafx.fxml;
    exports Scenes.AdminScenes;
    opens Scenes.AdminScenes to javafx.fxml;
}