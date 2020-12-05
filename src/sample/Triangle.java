package sample;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.security.Key;
import java.sql.Time;
import java.util.ResourceBundle;

public class Triangle implements Initializable{

    @FXML
    private AnchorPane TriangleRoot;

    @FXML
    private Line l1;

    @FXML
    private Line l2;

    @FXML
    private Line l3;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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







}
