package project.pattern_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CartElementController extends KorzinaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text cash;

    @FXML
    private Text cnt;

    @FXML
    private Button minus;

    @FXML
    private Button plus;

    @FXML
    private Text product_name;

    @FXML
    void initialize() {

//        itogAll.setText((Integer.parseInt(itogAll.getText()) + Integer.parseInt(cash.getText())) + "");
//        plus.setOnMousePressed(actionEvent -> {
//            cnt.setText((Integer.parseInt(cnt.getText()) + 1) + "");
//            cash.setText((131484 * Integer.parseInt(cnt.getText())) + "");
//            itogAll.setText((Integer.parseInt(itogAll.getText()) + Integer.parseInt(cash.getText())) + "");
//        });
//        minus.setOnMousePressed(actionEvent -> {
//            if(Integer.parseInt(cnt.getText()) == 0){
//            }else {
//                cnt.setText((Integer.parseInt(cnt.getText()) - 1) + "");
//                cash.setText((131484 * Integer.parseInt(cnt.getText())) + "");
//                itogAll.setText((Integer.parseInt(itogAll.getText()) - Integer.parseInt(cash.getText())) + "");
//            }
//        });
//        plus.setOnMousePressed(actionEvent -> {
//            int newQuantity = Integer.parseInt(cnt.getText()) + 1;
//            update(newQuantity);
//
//
//        });
//
//        minus.setOnMousePressed(actionEvent -> {
//            if (Integer.parseInt(cnt.getText()) > 0) {
//                int newQuantity = Integer.parseInt(cnt.getText()) - 1;
//                update(newQuantity);
//
//
//            }
//        });
//
//    }


//    void update(int quantity){
//        Connection conn = DBConnection.getConnection();
//        try {
//            String updateQuery = "UPDATE cart SET quantity = ? WHERE user_id = ?";
//            PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
//            updateStatement.setInt(1, );
//            updateStatement.setInt(2, CurrentUser.getCurrentUser().getId());
//            updateStatement.executeUpdate();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    void select(){
//        String getByUsernameAndPasswordQuery = "SELECT c.user_id, c.product_id, p.name, p.price\n" +
//                "from cart c\n" +
//                "join products p on c.product_id=p.id\n" +
//                "where c.user_id=?" +
//                "group by c.user_id, c.product_id, p.name, p.price ";
//        try {
//            Connection conn = DBConnection.getConnection();
//            PreparedStatement p = conn.prepareStatement(getByUsernameAndPasswordQuery);
//            p.setString(1, CurrentUser.getCurrentUser().getName());
//            ResultSet rs = p.executeQuery();
//
//            if (rs.next()) {
//                cnt.setText((Integer.parseInt(cnt.getText()) + 1) + "");
//            cash.setText((131484 * Integer.parseInt(cnt.getText())) + "");
//            itogAll.setText((Integer.parseInt(itogAll.getText()) + Integer.parseInt(cash.getText())) + "");
//            }
//            else{
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    }
}
