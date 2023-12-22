package project.pattern_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePageVoityController {
    public static BorderPane borderPaneAll;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AvtoTovaty;

    @FXML
    private Button Bytovaia;

    @FXML
    private Button DetskiMir;

    @FXML
    private Button KansTovary;

    @FXML
    private Button TovaryDliaDoma;

    @FXML
    private Text VenomHome;

    @FXML
    private BorderPane borderHbox;

    @FXML
    private Button electronika;

    @FXML
    private Button knigi;

    @FXML
    private Pane korzinka;

    @FXML
    private Button krasota;

    @FXML
    private MenuButton m;

    @FXML
    private Button nayti;

    @FXML
    private TextField naytitext;

    @FXML
    private Button odezhda;

    @FXML
    private Button posuda;

    @FXML
    private Button producty;

    @FXML
    private Button sport;

    @FXML
    private MenuItem v;
    @FXML

    private MenuItem v1;

    @FXML
    private Button zooTovary;

    static public int num = 1;
    @FXML
    void initialize() throws IOException {
        guestoruser guestoruser=new guestoruser(num);
        borderPaneAll=borderHbox;
        VenomHome.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(ElectronicsController.class.getResource("homePageHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        borderHbox.setCenter(new FXMLLoader(HomePageVoityController.class.getResource("homePageHbox.fxml")).load());
        electronika.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(ElectronicsController.class.getResource("electronicsHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        knigi.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageVoityController.class.getResource("booksHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        krasota.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageVoityController.class.getResource("krasotaHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        producty.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageVoityController.class.getResource("productsHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        zooTovary.setOnMousePressed(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(HomePageVoityController.class.getResource("zooproductsHbox.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        v.setOnAction(ee->{
            CurrentUser.logout();
            producty.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getResource("homePage.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException ex) {
                System.out.println();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        v1.setOnAction(actionEvent -> {
            try {
                borderHbox.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(MyPageController.class.getResource("myPage.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        korzinka.setOnMousePressed(e->{
            try {
                borderHbox.getChildren().clear();
                Cart.rs=null;
                FXMLLoader fxmlLoader = new FXMLLoader(KorzinaController.class.getResource("korzina.fxml"));
                borderHbox.setCenter(fxmlLoader.load());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

}
