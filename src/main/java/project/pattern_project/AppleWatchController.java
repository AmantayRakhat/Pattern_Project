package project.pattern_project;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.almasb.fxgl.dsl.components.KeepOnScreenComponent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class AppleWatchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton count;

    @FXML
    private MenuItem five;

    @FXML
    private MenuItem four;

    @FXML
    private Button korzinka;

    @FXML
    private MenuItem one;

    @FXML
    private MenuItem three;

    @FXML
    private MenuItem two;
    static int n=1;
    @FXML
    void initialize() {
        if(count.isPressed()){
            one.setOnAction(e->n=1);
            two.setOnAction(e->n=2);
            three.setOnAction(e->n=3);
            four.setOnAction(e->n=4);
            five.setOnAction(e->n=5);
        }
        korzinka.setOnMousePressed(e->{
            if(guestoruser.num==1){
                insertInCart(n);
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Вы не зарегистрированы!");
                alert.show();
            }
        });
    }

    void insertInCart(int cnt){
        Connection conn=DBConnection.getConnection();
        try {
            String query = "INSERT INTO cart ("+"user_id"+","+"product_id"+ "," + "quantity" + ")"+"values(?,?,?)";
            PreparedStatement p=conn.prepareStatement(query);
            p.setInt(1, CurrentUser.getCurrentUser().getId());
            p.setInt(2, 3);
            p.setInt(3, n);
            p.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
