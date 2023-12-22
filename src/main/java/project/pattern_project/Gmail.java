package project.pattern_project;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Gmail {
    private final static String username = "rakhatjavafx@gmail.com";
    private final static String password = "xyfjwompmoxjynfz";

    private static Properties prop;
    private static Session session;
    private static Message message;

    public Gmail(){
    }
    static Message gmailsend(){
        if(message==null){
            prop = new Properties();
            prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress("rakhatjavafx@gmail.com"));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
        return message;
    }


}
