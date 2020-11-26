package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class loadgamesController {
    @FXML
    private AnchorPane loadGameRoot;

    @FXML
    private ListView gameStateList;



//    @FXML
//    private Button deleteProgress;
//    ObservableList<DataTable> d= FXCollections.observableArrayList(Main.getDatabase().getDatabaseFiles());


    @FXML
    public void initialize() {

    }

    @FXML
    public void ExitToMainMenu(MouseEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
       loadGameRoot.getChildren().setAll(pane);
    }

}
