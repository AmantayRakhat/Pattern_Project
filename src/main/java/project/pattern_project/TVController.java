package project.pattern_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class TVController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem five;

    @FXML
    private MenuItem four;

    @FXML
    private MenuItem one;

    @FXML
    private MenuItem three;

    @FXML
    private MenuItem two;
    @FXML
    private Button korzinka;
    @FXML
    private MenuButton count;
    int n=1;

    @FXML
    void initialize() {
        one.setOnAction(e->{
            n=1;
            count.setText(n+"");
        });two.setOnAction(e->{
            n=2;
            count.setText(n+"");
        });three.setOnAction(e->{
            n=3;
            count.setText(n+"");
        });four.setOnAction(e->{
            n=4;
            count.setText(n+"");
        });five.setOnAction(e->{
            n=5;
            count.setText(n+"");
        });

        korzinka.setOnMousePressed(e->{
            if(guestoruser.num==1){
                System.out.println(n);
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
            p.setInt(2, 2);
            p.setInt(3, cnt);
            p.executeUpdate();

        } catch (Exception e) {
            update(cnt);
        }
    }

    void update(int cnt) {
        Connection conn = DBConnection.getConnection();
        try {
            Statement p = conn.createStatement();
            String q1 = "UPDATE cart SET quantity = '" + cnt +""+
                    "' WHERE user_id =  '" + CurrentUser.getCurrentUser().getId() +"' and product_id='"+ 2 +"'";
            p.executeUpdate(q1);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
