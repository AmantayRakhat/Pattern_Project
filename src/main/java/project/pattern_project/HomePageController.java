    package project.pattern_project;

    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.control.Button;
    import javafx.scene.control.MenuItem;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.HBox;
    import javafx.scene.text.Text;

    import java.net.URL;
    import java.security.Guard;
    import java.util.ResourceBundle;


    public class HomePageController {
        public static BorderPane borderPaneAll;

        @FXML
        private Text VenomHome;

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
        private BorderPane borderHbox;

        @FXML
        private Button electronika;

        @FXML
        private Button knigi;

        @FXML
        private Text korzinka;

        @FXML
        private Button krasota;

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
        private Text voity;

        @FXML
        private Button zooTovary;
        @FXML
        private AnchorPane appleWatch;

        @FXML
        private HBox hboxElectr;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;
        @FXML
        private MenuItem v1;

        @FXML
        private MenuItem v2;

        static public int num = 0;
        @FXML
        void initialize() throws Exception {
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
            borderHbox.setCenter(new FXMLLoader(HomePageController.class.getResource("homePageHbox.fxml")).load());
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
                    FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getResource("booksHbox.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
            krasota.setOnMousePressed(actionEvent -> {
                try {
                    borderHbox.getChildren().clear();
                    FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getResource("krasotaHbox.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
            producty.setOnMousePressed(actionEvent -> {
                try {
                    borderHbox.getChildren().clear();
                    FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getResource("productsHbox.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
            zooTovary.setOnMousePressed(actionEvent -> {
                try {
                    borderHbox.getChildren().clear();
                    FXMLLoader fxmlLoader = new FXMLLoader(HomePageController.class.getResource("zooproductsHbox.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });

            v1.setOnAction(ee->{
                try {
                    borderHbox.getChildren().clear();
                    FXMLLoader fxmlLoader = new FXMLLoader(RegisController.class.getResource("voity.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
            v2.setOnAction(ee->{
                try {
                    borderHbox.getChildren().clear();
                    FXMLLoader fxmlLoader = new FXMLLoader(VoityController.class.getResource("regis.fxml"));
                    borderHbox.setCenter(fxmlLoader.load());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            });
        }
    }
