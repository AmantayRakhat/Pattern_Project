package project.pattern_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class VoityController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private Button voity;

    @FXML
    void initialize() {
        voity.setOnAction(e -> {
            if (!name.getText().isEmpty() && !pass.getText().isEmpty()) {
                connect(name.getText(), pass.getText());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Заполните все поля");
                alert.show();
            }
        });
    }

    public void connect(String name, String pass) {
        CurrentUser.login(name, pass);

        if (CurrentUser.getCurrentUser() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Не удалось войти!");
            alert.show();
        } else {
            openNewScene();
        }
    }

    void openNewScene() {
        FXMLLoader fxmlLoader1=null;
        try {
            voity.getScene().getWindow().hide();
            fxmlLoader1 = new FXMLLoader(HomePageVoityController.class.getResource("homePageVoity.fxml"));
            fxmlLoader1.load();
        } catch (IOException ex) {
            System.out.println();
        }
        Parent root = fxmlLoader1.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
