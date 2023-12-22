package project.pattern_project;

import javafx.fxml.FXMLLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Cart {
    private static Connection conn;
     static ResultSet rs;
    public Cart(){
    }

    static ResultSet getRs(){
        if(rs==null){
            String getByUsernameAndPasswordQuery = "SELECT c.user_id, c.product_id, c.quantity, p.name, p.price " +
                    "from cart c " +
                    "join products p on c.product_id=p.id " +
                    "where c.user_id='"+ CurrentUser.getCurrentUser().getId() +"'" +
                    "group by c.user_id, c.product_id, p.name, p.price ";
            try {
                 conn = DBConnection.getConnection();
                PreparedStatement p = conn.prepareStatement(getByUsernameAndPasswordQuery);
                 rs = p.executeQuery();
                return rs;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
