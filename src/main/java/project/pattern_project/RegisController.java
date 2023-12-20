package project.pattern_project;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.sql.SQLException;


public class RegisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adres;

    @FXML
    private TextField codetextfill;

    @FXML
    private TextField email;

    @FXML
    private TextField money;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private Button registrate;

    @FXML
    private Button send;
    int id=0;

    @FXML
    void initialize() {
        send.setOnMouseClicked(e -> {
                if (name.getText() != null && pass.getText() != null && money.getText() != null && adres.getText() != null && email.getText() != null) {
                    gmailsendmessage();
                    registrate.setOnAction(w->{
                        if(codetextfill.getText().equals(String.valueOf(code))) {
                            connect(name.getText(), email.getText(), pass.getText(), Double.parseDouble(money.getText()), adres.getText());
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Регистрация прошла успешно");
                        }
                    });
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Заполните пустые места!");
                    alert.show();
                }
        });
    }
    public void connect(String name, String email, String pass, double money, String adres) {
        CurrentUser.register(name, email, pass, money, adres);
    }
    int code;
    void gmailsendmessage(){
        final String username = "rakhatjavafx@gmail.com";
        final String password = "xyfjwompmoxjynfz";

        Properties prop = new Properties();
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("rakhatjavafx@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email.getText())
            );
//            message.setSubject("CODE!!!");
            code = (int) (Math.random()*900+100);
            message.setText(String.valueOf(code));
            Transport.send(message);

            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
