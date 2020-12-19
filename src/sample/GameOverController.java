package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public Label Score;
    public EachGameData data;
    public int score1=90;
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
       // Score.setText(score1+"");
        //System.out.println("sCORE" + Score.getText());

    }

    @FXML
    public void exit(MouseEvent event) throws Exception{
        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void newGame() throws Exception{
        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        GameOverRoot.getChildren().setAll(pane);
    }


    @FXML
    public void mainMenu(MouseEvent event) throws Exception{

        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        GameOverRoot.getChildren().setAll(pane);

    }

    @FXML
    public void revive() throws Exception{
        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();


        if(Integer.parseInt(Score.getText())>=1) {
            FXMLLoader load = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
            AnchorPane Pane = load.load();
            GameplayController GPobj=load.getController();
            GameOverRoot.getChildren().setAll(Pane);
            GPobj.b = true;
            GPobj.Score.setText(Integer.parseInt(Score.getText()) - 1 + "");
            GPobj.ball.Score -= 1;
            GPobj.Score.setText(Score.getText());
            GPobj.ball.Score=Integer.parseInt(Score.getText());
            GPobj.InitializeData(data.new1,data.pre1,data.newCentre,data.preCentre,data.ballPosition,data.ballColour,data.Score-1);

        }

        else{
//          System.out.println("Insufficient Stars");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            GameOverRoot.getChildren().setAll(pane);
        }

    }


}
