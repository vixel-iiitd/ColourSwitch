package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainController  {
    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ImageView circle1;

    @FXML
    private ImageView circle2;

    @FXML
    private ImageView circle4;

    @FXML
    private ImageView circle5;

    @FXML
    private ImageView circle3;

    @FXML
    private ImageView Exit;





    @FXML
    void exitGame(MouseEvent event) {

        System.exit(0);
    }

    public void initialize() throws Exception{
        File file = new File("SavedGames.txt");

        if(!file.exists()){
            System.out.println("WOAHHHHHHHHHHHHHHHHHHHH");
            ArrayList<EachGameData> arr = new ArrayList<>();
            DataBase oj = new DataBase(arr);
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream (new FileOutputStream("SavedGames.txt"));
                out.writeObject(oj);
            }
            finally {
                out.close();
            }
        }


        Media sound = new Media(getClass().getResource("/Music/Main.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();


        RotateTransition transition1 = new RotateTransition(Duration.seconds(500),circle1);
        transition1.setByAngle(360000);
        transition1.play();

        RotateTransition transition2 = new RotateTransition(Duration.seconds(500),circle2);
        transition2.setByAngle(-360000);
        transition2.play();


        RotateTransition transition3 = new RotateTransition(Duration.seconds(500),circle3);

        transition3.setFromAngle(45);
        transition3.setToAngle(360000);

        transition3.play();

        RotateTransition transition4 = new RotateTransition(Duration.seconds(500),circle4);
        transition4.setFromAngle(125);
        transition4.setToAngle(-250000);
        transition4.play();

        RotateTransition transition5 = new RotateTransition(Duration.seconds(500),circle5);
        transition5.setFromAngle(180);
        transition5.setToAngle(150000);
        transition5.play();



    }
    
    @FXML
    void startGame(MouseEvent event) throws Exception {
        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();

        AnchorPane pane = FXMLLoader.load((getClass().getResource("Gameplay.fxml")));
        mainRoot.getChildren().setAll(pane);
    }


    @FXML
    void loadGame(MouseEvent event) throws Exception {

        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loadGames.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void Exit(MouseEvent event) throws Exception{

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

}
