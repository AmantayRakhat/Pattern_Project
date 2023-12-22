package project.pattern_project;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//Singleton

public class CurrentUser {
    private static User currentUser;
    private static final String getByUsernameAndPasswordQuery = "SELECT * from userdata where name=? and password=?";

    private CurrentUser() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void login(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement p = conn.prepareStatement(getByUsernameAndPasswordQuery);
            p.setString(1, username);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                currentUser = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(String name, String email, String pass, double money, String adres) {
        Connection conn = DBConnection.getConnection();
        try {
            String query = "INSERT INTO userdata (name, email, password, cash, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p=conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            p.setString(1, name);
            p.setString(2, email);
            p.setString(3, pass);
            p.setBigDecimal(4, BigDecimal.valueOf(money));
            p.setString(5, adres);
            p.executeUpdate();

            login(name, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateCash(String name, String money){
        Connection conn = DBConnection.getConnection();
        try {
            Statement p = conn.createStatement();
            String q1 = "UPDATE userdata SET cash = '" + (CurrentUser.getCurrentUser().getCash() + Double.parseDouble(money)) + "" +
                    "' WHERE name =  '" + name +"'";

            p.executeUpdate(q1);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void logout() {
        currentUser = null;
    }


}
