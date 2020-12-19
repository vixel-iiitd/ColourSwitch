package sample;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.security.Key;
import java.sql.Time;
import java.util.ResourceBundle;

public class Triangle  extends Obstacle implements Initializable{

    @FXML
    private AnchorPane TriangleRoot;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Line l3;


    @FXML
    private Polygon p1;

    @FXML
    private Polygon p2;
    @FXML
    private Polygon p3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l3.setStroke(Paint.valueOf("#FF0181FF"));
        l2.setStroke(Paint.valueOf("#FAE100FF"));
        l1.setStroke(Paint.valueOf("#32DBF0FF"));
        l3.setFill(Paint.valueOf("#FF0181FF"));
        l2.setFill(Paint.valueOf("#FAE100FF"));
        l1.setFill(Paint.valueOf("#32DBF0FF"));
        name = "Triangle";


        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();


        r1.setPivotX(60);
        r1.setPivotY(60);
        l1.getTransforms().add(r1);


        r2.setPivotX(60);
        r2.setPivotY(60);
        l2.getTransforms().add(r2);


        r3.setPivotX(60);
        r3.setPivotY(60);
        l3.getTransforms().add(r3);



        timeset(new Rotate[]{r1, r2, r3});



    }







    private void timeset(Rotate[] r1) {

        Rotate r[] = r1;




        for(int i = 0;i<3;i++){

            KeyValue keyvalue1 = new KeyValue(r[i].angleProperty(),0);
            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0),keyvalue1);


            KeyValue keyvalue2 = new KeyValue(r[i].angleProperty(),32000);
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1000),keyvalue2);


            Timeline timeline = new Timeline(keyFrame1,keyFrame2);
            timeline.play();

        }

    }


    @Override
    public double getCenter() {
        return l1.getLayoutY();
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



        return arc1collision || arc2collision || arc3collision;




    }

    @Override
    public void movingSpeed(double speed) {
        l1.setLayoutY(l1.getLayoutY() + speed);
        l2.setLayoutY(l2.getLayoutY() + speed);
        l3.setLayoutY(l3.getLayoutY() + speed);
        p1.setLayoutY(p1.getLayoutY()+speed);
        p2.setLayoutY(p2.getLayoutY()+speed);
        p3.setLayoutY(p3.getLayoutY()+speed);
    }

    @Override
    public void setCenter() {
        l1.setLayoutY(-250);
        l2.setLayoutY(-250);
        l3.setLayoutY(-250);
        p1.setLayoutY(-250);
        p2.setLayoutY(-250);
        p3.setLayoutY(-250);
    }

   @Override
    public void setCenter2(double k) {
        l1.setLayoutY(k);
        l2.setLayoutY(k);
        l3.setLayoutY(k);
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
        p1.setLayoutY(k);
        p2.setLayoutY(k);
        p3.setLayoutY(k);

    }


}
