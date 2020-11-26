package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class GameplayController {


    @FXML
    private AnchorPane gamePlayRoot;

    @FXML
    private ImageView pauseButton;


    @FXML
    public void pauseGame(MouseEvent event) throws  Exception {
        AnchorPane pane = FXMLLoader.load((getClass().getResource("pauseGame.fxml")));
        gamePlayRoot.getChildren().setAll(pane);


    }

    public void initialize() throws Exception {

        AnchorPane Ballpane = FXMLLoader.load(getClass().getResource("Ball.fxml"));
        gamePlayRoot.getChildren().addAll(Ballpane);

        AnchorPane ObstaclePane = FXMLLoader.load(getClass().getResource(getObstacle()));
        gamePlayRoot.getChildren().addAll(ObstaclePane);



    }



    public int generateRandom(){
        Random random = new Random();
        int r = random.nextInt(4)+1;

        return r;

    }



    public String getObstacle() {

        int k = generateRandom();
//        System.out.println(k);
        if (k == 1) {

            return "Line.fxml";

        } else if (k == 2) {
            return "Circle.fxml";

        }
        else if(k==3){
            return "Triangle.fxml";
        }

        else{

            return "Rectangle.fxml";
        }


    }


}
