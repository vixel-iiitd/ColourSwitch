package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            r1.setPivotX(32);
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
    public boolean checkColor(BallController ball) {
        return false;
    }
}

