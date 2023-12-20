package project.pattern_project;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class KorzinaController {
    public static Text itogAll;
    public static VBox korzinaVboxAll;
    @FXML
    private Text itog;

    @FXML
    private VBox korzinaVbox;

    @FXML
    void initialize() {
        korzinaVboxAll = korzinaVbox;
        itogAll = itog;
    }
}
