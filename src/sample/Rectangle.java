package sample;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.security.Key;
import java.sql.Time;
import java.util.ResourceBundle;

public class Rectangle extends Obstacle implements Initializable{

    @FXML
    private AnchorPane rectangleRoot;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Line l3;

    @FXML
    private Line l4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setStroke(Paint.valueOf("#900dffff"));



        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        r1.setPivotX(3);
        r1.setPivotY(86);
        l1.getTransforms().add(r1);


        r2.setPivotX(3);
        r2.setPivotY(86);
        l2.getTransforms().add(r2);


        r3.setPivotX(3);
        r3.setPivotY(86);
        l3.getTransforms().add(r3);

        r4.setPivotX(3);
        r4.setPivotY(86);
        l4.getTransforms().add(r4);


        timeset(new Rotate[]{r1, r2, r3, r4});



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

    }

    @Override
    public double getCenter() {
        return 0;
    }

    @Override
    public boolean checkColor(BallController ball) {

        //System.out.println(ball.ball.getFill());

        if(ball.ball.getFill().equals(l1.getStroke())){
            if(ball.ball.getBoundsInParent().intersects(l2.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l3.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l4.getBoundsInParent())){
                return true;
            }
            else if(ball.ball.getBoundsInParent().intersects(l1.getBoundsInParent())){
                return false;
            }

        }

        else if(ball.ball.getFill().equals(l2.getStroke())){
            if(ball.ball.getBoundsInParent().intersects(l1.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l3.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l4.getBoundsInParent())){
                return true;
            }
            else if(ball.ball.getBoundsInParent().intersects(l2.getBoundsInParent())){
                return false;
            }

        }

        else if(ball.ball.getFill().equals(l3.getStroke())){
            if(ball.ball.getBoundsInParent().intersects(l2.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l1.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l4.getBoundsInParent())){
                return true;
            }
            else if(ball.ball.getBoundsInParent().intersects(l3.getBoundsInParent())){
                return false;
            }

        }

        else if(ball.ball.getFill().equals(l4.getStroke())){
            if(ball.ball.getBoundsInParent().intersects(l2.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l3.getBoundsInParent())||ball.ball.getBoundsInParent().intersects(l1.getBoundsInParent())){
                return true;
            }
            else if(ball.ball.getBoundsInParent().intersects(l4.getBoundsInParent())){
                return false;
            }

        }


        return false;
    }

    @Override
    public void movingSpeed(double speed) {


    }

    @Override
    public void setCenter() {

    }


}
