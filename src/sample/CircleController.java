package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    @FXML
    private Polygon p1;

    @FXML
    private Polygon p2;
    @FXML
    private Polygon p3;

    public void initialize(URL url,ResourceBundle rb) {
//        arc1.setFill(Paint.valueOf("#ff0385ff"));
//        arc2.setFill(Paint.valueOf("#fae100ff"));
//        arc3.setFill(Paint.valueOf("#32dbf0ff"));
//        arc4.setFill(Paint.valueOf("#900dffff"));

       


//        arc1.setFill(Paint.valueOf("#ff0181ff"));
//        arc2.setFill(Paint.valueOf("#fae100ff"));
//        arc3.setFill(Paint.valueOf("#32dbf0ff"));
//        arc4.setFill(Paint.valueOf("#900dffff"));
        name = "Circle" ;
        arc1.setStroke(Paint.valueOf("#ff0181ff"));
        arc2.setStroke(Paint.valueOf("#fae100ff"));
        arc3.setStroke(Paint.valueOf("#32dbf0ff"));
        arc4.setStroke(Paint.valueOf("#900dffff"));


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
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(800),keyvalue2);


        Timeline timeline1 = new Timeline(keyFrame1,keyFrame2);
        timeline1.play();

        KeyValue keyvalue3 = new KeyValue(r2.angleProperty(),0);
        KeyFrame keyFrame3 = new KeyFrame(Duration.seconds(0),keyvalue3);


        KeyValue keyvalue4 = new KeyValue(r2.angleProperty(),32000);
        KeyFrame keyFrame4 = new KeyFrame(Duration.seconds(800),keyvalue4);


        Timeline timeline2 = new Timeline(keyFrame3,keyFrame4);
        timeline2.play();

        KeyValue keyvalue5 = new KeyValue(r3.angleProperty(),0);
        KeyFrame keyFrame5 = new KeyFrame(Duration.seconds(0),keyvalue5);


        KeyValue keyvalue6 = new KeyValue(r3.angleProperty(),32000);
        KeyFrame keyFrame6 = new KeyFrame(Duration.seconds(800),keyvalue6);


        Timeline timeline3 = new Timeline(keyFrame5,keyFrame6);
        timeline3.play();

        KeyValue keyvalue7 = new KeyValue(r4.angleProperty(),0);
        KeyFrame keyFrame7 = new KeyFrame(Duration.seconds(0),keyvalue7);


        KeyValue keyvalue8 = new KeyValue(r4.angleProperty(),32000);
        KeyFrame keyFrame8 = new KeyFrame(Duration.seconds(800),keyvalue8);


        Timeline timeline4 = new Timeline(keyFrame7,keyFrame8);
        timeline4.play();

    }


    @Override
    public double getCenter() {
        return arc1.getLayoutY();
    }

    @Override
    public boolean checkColor(BallController ball) {

        if(p1.getBoundsInParent().intersects(ball.ball.getBoundsInParent()) || p2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())  || p3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())){
            p1.setLayoutY(-500);
            p2.setLayoutY(-500);
            p3.setLayoutY(-500);
            ball.Score++;
            Media sound = new Media(getClass().getResource("/Music/Star.wav").toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(1);
            mediaPlayer.setStartTime(Duration.seconds(0));
            mediaPlayer.setStopTime(Duration.seconds(0.15));
            mediaPlayer.play();
//            System.out.print(ball.Score);
        }




//        ball.ball.setFill(Paint.valueOf("#900dff00"));

//        System.out.println(ball.ball.getFill());

//        System.out.println("arc1 "+arc1.getFill());
//        System.out.println("arc2 "+arc2.getFill());
//        System.out.println("arc3 "+arc3.getFill());
//        System.out.println("arc4 "+arc4.getFill());



        if (ball.ball.getFill().equals(arc1.getStroke())) {
//            System.out.println("here1");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;


                } else return false;

            }
        } else if (ball.ball.getFill().equals(arc2.getStroke())) {
//            System.out.println("here2");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc1.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc3.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;
                } else return false;

            }
        } else if (ball.ball.getFill().equals(arc3.getStroke())) {
//            System.out.println("here3");
            if ((InnerCircle.getBoundsInParent().intersects(ball.ball.getBoundsInParent()))) {
                return false;
            } else {
                if  (arc1.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc2.getBoundsInParent().intersects(ball.ball.getBoundsInParent())||arc4.getBoundsInParent().intersects(ball.ball.getBoundsInParent())) {
                    return true;


                } else return false;

            }

        } else if (ball.ball.getFill().equals(arc4.getStroke())) {
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



    @Override
    public void movingSpeed(double speed) {
        arc1.setLayoutY(arc1.getLayoutY()+speed);
        arc2.setLayoutY(arc2.getLayoutY()+speed);
        arc3.setLayoutY(arc3.getLayoutY()+speed);
        arc4.setLayoutY(arc4.getLayoutY()+speed);
        InnerCircle.setLayoutY(InnerCircle.getLayoutY()+speed);
        p1.setLayoutY(p1.getLayoutY()+speed);
        p2.setLayoutY(p2.getLayoutY()+speed);
        p3.setLayoutY(p3.getLayoutY()+speed);
    }

    @Override
    public void setCenter() {

        arc1.setLayoutY(-250);
        arc2.setLayoutY(-250);
        arc3.setLayoutY(-250);
        InnerCircle.setLayoutY(-250);
        arc4.setLayoutY(-250);
        p1.setLayoutY(-280);
        p2.setLayoutY(-280);
        p3.setLayoutY(-280);


    }
    @Override
    public void setCenter2(double k) {

        arc1.setLayoutY(k);
        arc2.setLayoutY(k);
        arc3.setLayoutY(k);
        InnerCircle.setLayoutY(k);
        arc4.setLayoutY(k);
        p1.setLayoutY(k-30);
        p2.setLayoutY(k-30);
        p3.setLayoutY(k-30);


    }
    @Override
    public void setCenter3() {
        double k = -1000;
        arc1.setLayoutY(k);
        arc2.setLayoutY(k);
        arc3.setLayoutY(k);
        InnerCircle.setLayoutY(k);
        arc4.setLayoutY(k);
        p1.setLayoutY(k-30);
        p2.setLayoutY(k-30);
        p3.setLayoutY(k-30);


    }

}