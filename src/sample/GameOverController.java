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

public class GameOverController implements Initializable {

    @FXML
    private AnchorPane GameOverRoot;

    @FXML
    private ImageView Exit;

    @FXML
    private ImageView MainMenu;

    @FXML
    private ImageView NewGame;



    @FXML
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    public void exit(MouseEvent event) throws Exception{
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void newGame() throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        GameOverRoot.getChildren().setAll(pane);
    }


    @FXML
    public void mainMenu(MouseEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
       GameOverRoot.getChildren().setAll(pane);

    }





}
