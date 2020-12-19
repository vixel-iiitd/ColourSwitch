package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import javax.swing.text.html.ImageView;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class BallController implements Initializable{


    @FXML
    private AnchorPane ballRoot;


    @FXML
    public Circle ball;
    public double speed=300;
    private Color ballColour;
    private int BallSpeed;
    public int Score=0;
//    private Button button ;

    public void play(ActionEvent event) throws Exception {
        Media sound = new Media(getClass().getResource("/Music/deadclock.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.01));
        mediaPlayer.play();

        if(ball.getLayoutY()>300) {
//            speed +=10;
           Bounds bounds = ballRoot.getBoundsInLocal();
           Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                   new KeyValue(ball.layoutYProperty(), ball.getLayoutY()-80)));
           timeline.setCycleCount(1);

           Timeline t2 = new Timeline(new KeyFrame(Duration.millis(2000),
                   new KeyValue(ball.layoutYProperty(), bounds.getMaxY()+ball.getRadius()-50)));
           t2.setCycleCount(1);
           timeline.play();
           timeline.setOnFinished(actionEvent -> t2.play());

       }

       else{
//           System.out.println("elsehgggggggggggggggggggggggggggggggggggggggggggg   " + speed);
            speed-=20;
       }

    }

    public void initialize(URL url,ResourceBundle rb) {
//       ball.setFill(Paint.valueOf("900dffff"));

    }



}