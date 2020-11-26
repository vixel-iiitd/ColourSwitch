package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.*;
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


public class CircleController implements Initializable{


    @FXML
    private AnchorPane circleRoot;

    @FXML
    private Circle OuterCircle;


    @FXML
    private Circle InnerCircle;
    @FXML
    private Circle rect;

    private Circle s1;



    public void initialize(URL url,ResourceBundle rb) {
        Shape subtract = Path.subtract(OuterCircle,InnerCircle);

        subtract.setFill(Color.RED);
        circleRoot.getChildren().addAll(subtract);
        circleRoot.getChildren().removeAll(rect);
        circleRoot.getChildren().removeAll(InnerCircle);
        circleRoot.getChildren().removeAll(OuterCircle);

        Rotate r = new Rotate();

        r.setPivotY(0);
        r.setPivotX(32);
        subtract.getTransforms().add(r);


                KeyValue keyvalue1 = new KeyValue(r.angleProperty(),36000);
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(100),keyvalue1);

        Timeline timeline = new Timeline(keyFrame1);
        timeline.play();




    }


}