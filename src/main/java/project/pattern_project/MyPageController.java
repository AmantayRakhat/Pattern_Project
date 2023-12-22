package project.pattern_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import project.pattern_project.CurrentUser;

public class MyPageController {

    @FXML
    private Label balance;

    @FXML
    private TextField dobavit;

    @FXML
    private Label email;

    @FXML
    private Label name;

    @FXML
    private Button ok;

    @FXML
    void initialize(){
        name.setText(CurrentUser.getCurrentUser().getName());
        email.setText(CurrentUser.getCurrentUser().getEmail());
        balance.setText(CurrentUser.getCurrentUser().getCash() + "");
        ok.setOnAction(actionEvent -> {
            CurrentUser.updateCash(name.getText(), dobavit.getText());
            CurrentUser.getCurrentUser().setCash(CurrentUser.getCurrentUser().getCash() + Double.parseDouble(dobavit.getText()));
            balance.setText(CurrentUser.getCurrentUser().getCash() + "");
        });
    }
}
