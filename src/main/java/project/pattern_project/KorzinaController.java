package project.pattern_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class KorzinaController {
    private DeliveryStrategy deliveryStrategy = new HomeDeliveryStrategy();
    private TotalCalculationStrategy totalCalculationStrategy = new SimpleTotalCalculationStrategy();

    public static Text itogAll;
    public static VBox korzinaVboxAll;
    @FXML
    private Text itog;

    @FXML
    private VBox korzinaVbox;
    @FXML
    private Button zakaz;
    double t;

    @FXML
    void initialize() throws IOException {
        korzinaVboxAll = korzinaVbox;
        itogAll = itog;
        FXMLLoader fxmlLoader = new FXMLLoader(ElectronicsController.class.getResource("cart_element.fxml"));
        korzinaVboxAll.getChildren().add(fxmlLoader.load());
        korzinaVbox.getChildren().remove(0, 1);
        zakaz.setOnAction(e -> {
            t=CurrentUser.getCurrentUser().getCash()-Integer.parseInt(itogAll.getText());
            if(t>=0 && Integer.parseInt(itogAll.getText())!=0) {
                String address = getAddressFromDatabase();
                gmailsendmessage(deliveryStrategy.deliverOrder(CurrentUser.getCurrentUser().getId(), address));
                korzinaVbox.getChildren().clear();
                Connection conn = DBConnection.getConnection();
                try {
                    Statement p = conn.createStatement();
                    String q1 = "truncate table cart";
                    p.executeUpdate(q1);

                    Statement p1 = conn.createStatement();
                    String q2 = "update userdata set cash='"+t+"'"+" where id='"+CurrentUser.getCurrentUser().getId()+"'";
                    p.executeUpdate(q2);

                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("У вас недостаточно денег");
                alert.show();
            }
        });


    }

    private String getAddressFromDatabase() {
        String getByUsernameAndPasswordQuery = "SELECT u.address from userdata u join cart c on u.id=c.user_id where user_id = '" + CurrentUser.getCurrentUser().getId() + "'" + " group by u.address";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement p = conn.prepareStatement(getByUsernameAndPasswordQuery);

            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return "Kaspi Postomat";
    }

    void gmailsendmessage(String text) {
        Message message=Gmail.gmailsend();
        try {
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(CurrentUser.getCurrentUser().getEmail())
            );
            message.setSubject("Venom Online Shop");
            message.setText(text);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
