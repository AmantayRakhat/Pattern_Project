package project.pattern_project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CartElementController extends KorzinaController {
    private TotalCalculationStrategy totalCalculationStrategy = new SimpleTotalCalculationStrategy();
    private TotalCalculationStrategy discountedCalculationStrategy = new DiscountedTotalCalculationStrategy();
    private UpdateStrategy inc=new IncrementalUpdateStrategy();
    private UpdateStrategy dec=new DecrementalUpdateStrategy();
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
    private Text prid1;
    @FXML
    private Text skidka;
    int total;
    int tl;
    void initialize() {
        add();
        plus.setOnMousePressed(actionEvent -> {
            int newQuantity = Integer.parseInt(cnt.getText()) + 1;
            inc.update(this, newQuantity);
            cnt.setText(newQuantity + "");
            select();
        });

        minus.setOnMousePressed(actionEvent -> {
            if (Integer.parseInt(cnt.getText()) > 1) {
                int newQuantity = Integer.parseInt(cnt.getText()) - 1;
                dec.update(this, newQuantity);
                cnt.setText(newQuantity + "");
                select();
            }
        });
    }
    void update(int quantity){
        Connection conn = DBConnection.getConnection();
        try {

            String updateQuery = "UPDATE cart SET quantity = ? WHERE user_id = ? and product_id=?";
            PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
            updateStatement.setInt(1, quantity);
            updateStatement.setInt(2, CurrentUser.getCurrentUser().getId());
            updateStatement.setInt(3, Integer.parseInt(prid1.getText()));
            updateStatement.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    void select(){
        total = 0;
        String getByUsernameAndPasswordQuery = "SELECT c.user_id, c.product_id, p.name, p.price " +
                "from cart c " +
                "join products p on c.product_id=p.id " +
                "where c.user_id='"+ CurrentUser.getCurrentUser().getId()+"'"+ " and c.product_id='" + Integer.parseInt(prid1.getText()) +"'"+
                "group by c.user_id, c.product_id, p.name, p.price ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement p = conn.prepareStatement(getByUsernameAndPasswordQuery);
            ResultSet rs = p.executeQuery();
            int l= Integer.parseInt(cash.getText());
            if (rs.next()) {
                if (Integer.parseInt(prid1.getText()) == 3) {
                    total = discountedCalculationStrategy.calculateTotal(Integer.parseInt(cnt.getText()), rs.getInt(4));
                    skidka.setOpacity(1);
                } else {
                    total = totalCalculationStrategy.calculateTotal(Integer.parseInt(cnt.getText()), rs.getInt(4));
                    skidka.setOpacity(0);
                }
                cash.setText(total + "");
                itogAll.setText((Integer.parseInt(itogAll.getText())-l + total) + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     void add(){
        ResultSet rs = Cart.getRs();
         try {
             if (rs.next()) {
                 prid1.setText(rs.getInt(2)+"");
                 cnt.setText(rs.getInt(3) + "");
                 if(Integer.parseInt(prid1.getText())==3) {
                     total = discountedCalculationStrategy.calculateTotal(Integer.parseInt(cnt.getText()), rs.getInt(5));
                     skidka.setOpacity(1);
                 }
                 else {
                     total = totalCalculationStrategy.calculateTotal(Integer.parseInt(cnt.getText()), rs.getInt(5));
                     skidka.setOpacity(0);
                 }
                 product_name.setText(rs.getString(4));
                 cash.setText(total+"");

                 itogAll.setText((Integer.parseInt(itogAll.getText()) + total) + "");
                 FXMLLoader fxmlLoader = new FXMLLoader(ElectronicsController.class.getResource("cart_element.fxml"));
                 korzinaVboxAll.getChildren().add(fxmlLoader.load());
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

    }
