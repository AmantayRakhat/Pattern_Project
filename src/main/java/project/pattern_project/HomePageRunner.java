package project.pattern_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HomePageRunner extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageRunner.class.getResource("homePage.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 700, 500));
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
