package project.pattern_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ElectronicsController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane appleWatch;

    @FXML
    private Label applew;

    @FXML
    private Label appmon;

    @FXML
    private Label monimon;

    @FXML
    private Label monit;

    @FXML
    private AnchorPane monitor;

    @FXML
    private Label sandwi;

    @FXML
    private Label sandwimon;
    @FXML
    private BorderPane borderpane;
    private String name;
    private double price;
    private static CompositeProduct concreteComposite;
    private static ConcreteProduct concreteProduct;
    @FXML
    void initialize() {
        concreteComposite = new ConcreteComposite(1, "Electronics");
        sandwi.setText(concreteComposite.getProducts().get(0).getName());
        sandwimon.setText(concreteComposite.getProducts().get(0).getPrice()+ " тг");

        monit.setText(concreteComposite.getProducts().get(1).getName());
        monimon.setText(concreteComposite.getProducts().get(1).getPrice()+ " тг");

        applew.setText(concreteComposite.getProducts().get(2).getName());
        appmon.setText(concreteComposite.getProducts().get(2).getPrice()+ " тг");


        appleWatch.setOnMousePressed(actionEvent->{
            try {
                borderpane.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(AppleWatchController.class.getResource("applewatch.fxml"));
                borderpane.setCenter(fxmlLoader.load());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        monitor.setOnMousePressed(actionEvent->{
            try {
                borderpane.getChildren().clear();
                FXMLLoader fxmlLoader = new FXMLLoader(TVController.class.getResource("tv.fxml"));
                borderpane.setCenter(fxmlLoader.load());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
