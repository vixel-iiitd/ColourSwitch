package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import javafx.scene.paint.Color;
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
    private Circle ball;

    private Color ballColour;
    private int BallSpeed;


    public void play(MouseEvent event) throws Exception {
        Bounds bounds = ballRoot.getBoundsInLocal();

        KeyValue keyValue1 = new KeyValue(ball.layoutYProperty(),ball.getLayoutY()-65);
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(200),keyValue1);


        Timeline t1 = new Timeline(keyFrame1);
        t1.setCycleCount(1/2);



        KeyValue keyValue2 = new KeyValue(ball.layoutYProperty(),bounds.getMaxY()+ ball.getRadius());
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(800),keyValue2);

        Timeline t2 = new Timeline(keyFrame2);
        t2.setCycleCount(1/2);

        t1.play();
        t1.setOnFinished(actionEvent -> t2.play());

    }

    public void initialize(URL url,ResourceBundle rb) {




    }






}