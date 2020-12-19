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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class pauseController implements Initializable {

    @FXML
    private AnchorPane pauseGameRoot;

    public EachGameData data;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void ExitToMainMenu(MouseEvent event) throws Exception{
        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();

        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseGameRoot.getChildren().setAll(pane);


    }
    @FXML
    public void resumeGame(MouseEvent event) throws Exception{

        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();
        FXMLLoader load = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane Pane = load.load();
        GameplayController GPobj=load.getController();
        pauseGameRoot.getChildren().setAll(Pane);
        GPobj.b = true;
        GPobj.InitializeData(data.new1,data.pre1,data.newCentre,data.preCentre,data.ballPosition,data.ballColour,data.Score);


    }





}
