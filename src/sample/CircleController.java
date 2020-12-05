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
import javafx.scene.paint.Paint;
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


public class CircleController  extends Obstacle implements Initializable{


    @FXML
    private AnchorPane circleRoot;

    @FXML
    private Circle OuterCircle;


    @FXML
    private Circle InnerCircle;


    @FXML
    private Circle rect;


    private Circle s1;


    @FXML
    private Arc arc1;

    @FXML
    private Arc arc2;
    @FXML
    private Arc arc3;
    @FXML
    private Arc arc4;



    public void initialize(URL url,ResourceBundle rb) {
        arc1.setFill(Paint.valueOf("#ff0385ff"));
        arc2.setFill(Paint.valueOf("#fae100ff"));
        arc3.setFill(Paint.valueOf("#32dbf0ff"));
        arc4.setFill(Paint.valueOf("#900dffff"));

        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        r1.setPivotX(0);
        r1.setPivotY(0);
        arc1.getTransforms().add(r1);


        r2.setPivotX(0);
        r2.setPivotY(0);
        arc2.getTransforms().add(r2);




        r3.setPivotX(0);
        r3.setPivotY(0);
        arc3.getTransforms().add(r3);


        r4.setPivotX(0);
        r4.setPivotY(0);
        arc4.getTransforms().add(r4);


        timeset(r1,r2,r3,r4);

    }


    public void timeset(Rotate r1, Rotate r2, Rotate r3, Rotate r4){
        KeyValue keyvalue1 = new KeyValue(r1.angleProperty(),0);
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0),keyvalue1);


        KeyValue keyvalue2 = new KeyValue(r1.angleProperty(),32000);
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1000),keyvalue2);


        Timeline timeline1 = new Timeline(keyFrame1,keyFrame2);
        timeline1.play();

        KeyValue keyvalue3 = new KeyValue(r2.angleProperty(),0);
        KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(0),keyvalue3);


        KeyValue keyvalue4 = new KeyValue(r2.angleProperty(),32000);
        KeyFrame keyFrame4 = new KeyFrame(Duration.seconds(1000),keyvalue4);


        Timeline timeline2 = new Timeline(keyFrame3,keyFrame4);
        timeline2.play();

        KeyValue keyvalue5 = new KeyValue(r3.angleProperty(),0);
        KeyFrame keyFrame5 = new KeyFrame(Duration.seconds(0),keyvalue5);


        KeyValue keyvalue6 = new KeyValue(r3.angleProperty(),32000);
        KeyFrame keyFrame6 = new KeyFrame(Duration.seconds(1000),keyvalue6);


        Timeline timeline3 = new Timeline(keyFrame5,keyFrame6);
        timeline3.play();

        KeyValue keyvalue7 = new KeyValue(r4.angleProperty(),0);
        KeyFrame keyFrame7 = new KeyFrame(Duration.seconds(0),keyvalue7);


        KeyValue keyvalue8 = new KeyValue(r4.angleProperty(),32000);
        KeyFrame keyFrame8 = new KeyFrame(Duration.seconds(1000),keyvalue8);


        Timeline timeline4 = new Timeline(keyFrame7,keyFrame8);
        timeline4.play();




    }


    @Override
    public boolean checkColor(BallController ball) {
//        ball.ball.setFill(Paint.valueOf("#900dff00"));
//        arc4.setFill(Paint.valueOf("#900dff00"));
        System.out.println(ball.ball.getFill());
//        System.out.println("arc1 "+arc1.getFill());
//        System.out.println("arc2 "+arc2.getFill());
//        System.out.println("arc3 "+arc3.getFill());
        System.out.println("arc4 "+arc4.getFill());



        if (ball.ball.getFill().equals(arc1.getFill())) {
            System.out.println("here1");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;


                } else return false;

            }
        } else if (ball.ball.getFill().equals(arc2.getFill())) {
            System.out.println("here2");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc1.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;
                } else return false;

            }
        } else if (ball.ball.getFill().equals(arc3.getFill())) {
            System.out.println("here3");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc1.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;


                } else return false;

            }
        } else if (ball.ball.getFill().equals(arc4.getFill())) {
//            System.out.println("here4a");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                {
//                    System.out.println("Here4b");
                    return false;
                }
            } else {
//                System.out.println("Here4c");
                if (arc1.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    {
//                        System.out.println("Here4d");
                        return true;
                    }
                } else  {
//                    System.out.println("Here4e");
                    return false;
                }

            }
        }
//        System.out.println("Chla jaa");
        return false;
    }
}