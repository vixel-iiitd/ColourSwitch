package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.security.Key;
import java.sql.Time;
import java.util.ResourceBundle;

public class LineController extends Obstacle implements Initializable {



    @FXML
    private AnchorPane lineRoot;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Line l3;

    @FXML
    private Line l4;

    @FXML
    private Line l5;

    @FXML
    private Line l6;

    @FXML
    private Line l7;

    @FXML
    private Line l8;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;


    @FXML
    private Polygon p1;

    @FXML
    private Polygon p2;
    @FXML
    private Polygon p3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        name = "Line";
        l1.setStroke(Paint.valueOf("#ff0181ff"));
        l2.setStroke(Paint.valueOf("#fae100ff"));
        l3.setStroke(Paint.valueOf("#32dbf0ff"));
        l4.setStroke(Paint.valueOf("#900dffff"));

        l5.setStroke(Paint.valueOf("#ff0181ff"));
        l6.setStroke(Paint.valueOf("#fae100ff"));
        l7.setStroke(Paint.valueOf("#32dbf0ff"));
        l8.setStroke(Paint.valueOf("#900dffff"));


        l1.setFill(Paint.valueOf("#ff0181ff"));
        l2.setFill(Paint.valueOf("#fae100ff"));
        l3.setFill(Paint.valueOf("#32dbf0ff"));
        l4.setFill(Paint.valueOf("#900dffff"));

        l5.setFill(Paint.valueOf("#ff0181ff"));
        l6.setFill(Paint.valueOf("#fae100ff"));
        l7.setFill(Paint.valueOf("#32dbf0ff"));
        l8.setFill(Paint.valueOf("#900dffff"));

        Line[] l = new Line[8];
        l[0] = l1;
        l[1] = l2;
        l[2] = l3;
        l[3] = l4;
        l[4] = l5;
        l[5] = l6;
        l[6] = l7;
        l[7] = l8;


        Rotate r[]= new Rotate[8];



        for(int i = 0;i<8;i++){
            Rotate r1 = new Rotate();
            r1.setPivotX(36);
            r1.setPivotY(0);
            l[i].getTransforms().add(r1);

            r[i] = r1;

        }



        timeset(r);


    }

    private void timeset(Rotate[] r1) {

        Rotate r[] = r1;




        for(int i = 0;i<4;i++){

            KeyValue keyvalue1 = new KeyValue(r[i].angleProperty(),0);
            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0),keyvalue1);


            KeyValue keyvalue2 = new KeyValue(r[i].angleProperty(),32000);
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1000),keyvalue2);


            Timeline timeline = new Timeline(keyFrame1,keyFrame2);
            timeline.play();

        }

        for(int i = 4;i<8;i++){

            KeyValue keyvalue1 = new KeyValue(r[i].angleProperty(),0);
            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0),keyvalue1);


            KeyValue keyvalue2 = new KeyValue(r[i].angleProperty(),-32000);
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1000),keyvalue2);


            Timeline timeline = new Timeline(keyFrame1,keyFrame2);
            timeline.play();

        }



    }


    @Override
    public double getCenter() {

        return c1.getLayoutY();
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
            System.out.print(ball.Score);
        }



        boolean collisionhappens = false;
        boolean colorsame = false;

        Shape shape = Shape.intersect(l1,ball.ball);
//        System.out.println(shape.getStrokeWidth());
        if(shape.getBoundsInParent().getWidth() != -1){
            collisionhappens = true;
        }
        if(!(l1.getFill().equals(ball.ball.getFill()))){
            colorsame = true;
        }

        boolean arc1collision = collisionhappens && colorsame;
//        System.out.println("arc1collision" + arc1collision);

        boolean collisionhappens2 = false;
        boolean colorsame2 = false;
        Shape shape2 = Shape.intersect(l2,ball.ball);
        if(shape2.getBoundsInParent().getWidth() != -1){
            collisionhappens2 = true;
        }
        if(!(l2.getFill().equals(ball.ball.getFill()))){
            colorsame2 = true;
        }
        boolean arc2collision = collisionhappens2 && colorsame2;
//        System.out.println("arc2collision" + arc2collision);

        boolean collisionhappens3 = false;
        boolean colorsame3 = false;
        Shape shape3 = Shape.intersect(l3,ball.ball);
        if(shape3.getBoundsInParent().getWidth() != -1){
            collisionhappens3 = true;
        }
        if(!(l3.getFill().equals(ball.ball.getFill()))){
            colorsame3 = true;
        }
        boolean arc3collision = collisionhappens3 && colorsame3;
//        System.out.println("arc3collision" + arc3collision);

        boolean collisionhappens4 = false;
        boolean colorsame4 = false;
        Shape shape4 = Shape.intersect(l4,ball.ball);
        if(shape4.getBoundsInParent().getWidth() != -1){
            collisionhappens4 = true;
        }
        if(!(l4.getFill().equals(ball.ball.getFill()))){
            colorsame4 = true;
        }
        boolean arc4collision = collisionhappens4 && colorsame4;
//        System.out.println("arc4collision" + arc4collision);







        boolean collisionhappens5 = false;
        boolean colorsame5 = false;

        Shape shape5 = Shape.intersect(l5,ball.ball);
//        System.out.println(shape.getStrokeWidth());
        if(shape5.getBoundsInParent().getWidth() != -1){
            collisionhappens5 = true;
        }
        if(!(l5.getFill().equals(ball.ball.getFill()))){
            colorsame5 = true;
        }
        boolean arc5collision = collisionhappens5 && colorsame5;
//        System.out.println("arc1collision" + arc1collision);

        boolean collisionhappens6 = false;
        boolean colorsame6 = false;
        Shape shape6 = Shape.intersect(l6,ball.ball);
        if(shape6.getBoundsInParent().getWidth() != -1){
            collisionhappens6 = true;
        }
        if(!(l6.getFill().equals(ball.ball.getFill()))){
            colorsame6 = true;
        }
        boolean arc6collision = collisionhappens6 && colorsame6;
//        System.out.println("arc2collision" + arc2collision);

        boolean collisionhappens7 = false;
        boolean colorsame7 = false;
        Shape shape7 = Shape.intersect(l7,ball.ball);
        if(shape7.getBoundsInParent().getWidth() != -1){
            collisionhappens7 = true;
        }
        if(!(l7.getFill().equals(ball.ball.getFill()))){
            colorsame7 = true;
        }
        boolean arc7collision = collisionhappens7 && colorsame7;
//        System.out.println("arc3collision" + arc3collision);

        boolean collisionhappens8 = false;
        boolean colorsame8 = false;
        Shape shape8 = Shape.intersect(l8,ball.ball);
        if(shape8.getBoundsInParent().getWidth() != -1){
            collisionhappens8 = true;
        }
        if(!(l8.getFill().equals(ball.ball.getFill()))){
            colorsame8 = true;
        }
        boolean arc8collision = collisionhappens8 && colorsame8;
//        System.out.println("arc4collision" + arc4collision);



        return arc1collision || arc2collision || arc3collision || arc4collision||arc5collision || arc6collision || arc7collision || arc8collision;


    }

    @Override
    public void movingSpeed(double speed) {
        l1.setLayoutY(l1.getLayoutY() + speed);
        l2.setLayoutY(l2.getLayoutY() + speed);
        l3.setLayoutY(l3.getLayoutY() + speed);
        l4.setLayoutY(l4.getLayoutY() + speed);
        l5.setLayoutY(l5.getLayoutY() + speed);
        l6.setLayoutY(l6.getLayoutY() + speed);
        l7.setLayoutY(l7.getLayoutY() + speed);
        l8.setLayoutY(l8.getLayoutY() + speed);
        c1.setLayoutY(c1.getLayoutY()+speed);
        c2.setLayoutY(c1.getLayoutY()+speed);
        p1.setLayoutY(p1.getLayoutY()+speed);
        p2.setLayoutY(p2.getLayoutY()+speed);
        p3.setLayoutY(p3.getLayoutY()+speed);
    }

    @Override
    public void setCenter() {
        l1.setLayoutY(-250);
        l2.setLayoutY(-250);
        l3.setLayoutY(-250);
        l4.setLayoutY(-250);
        l5.setLayoutY(-250);
        l6.setLayoutY(-250);
        l7.setLayoutY(-250);
        l8.setLayoutY(-250);
        c1.setLayoutY(-250);
        c2.setLayoutY(-250);
        p1.setLayoutY(-250);
        p2.setLayoutY(-250);
        p3.setLayoutY(-250);

    }

    @Override
    public void setCenter2(double k) {
        l1.setLayoutY(k);
        l2.setLayoutY(k);
        l3.setLayoutY(k);
        l4.setLayoutY(k);
        l5.setLayoutY(k);
        l6.setLayoutY(k);
        l7.setLayoutY(k);
        l8.setLayoutY(k);
        c1.setLayoutY(k);
        c2.setLayoutY(k);
        p1.setLayoutY(k);
        p2.setLayoutY(k);
        p3.setLayoutY(k);

    }
    @Override
    public void setCenter3() {
        double k = -1000;
        l1.setLayoutY(k);
        l2.setLayoutY(k);
        l3.setLayoutY(k);
        l4.setLayoutY(k);
        l5.setLayoutY(k);
        l6.setLayoutY(k);
        l7.setLayoutY(k);
        l8.setLayoutY(k);
        c1.setLayoutY(k);
        c2.setLayoutY(k);
        p1.setLayoutY(k);
        p2.setLayoutY(k);
        p3.setLayoutY(k);

    }
}

