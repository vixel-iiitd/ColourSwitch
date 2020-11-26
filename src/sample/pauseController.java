package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class pauseController implements Initializable {

    @FXML
    private AnchorPane pauseGameRoot;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    public void ExitToMainMenu(MouseEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseGameRoot.getChildren().setAll(pane);


    }
    @FXML
    public void resumeGame(MouseEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        pauseGameRoot.getChildren().setAll(pane);


    }





}
