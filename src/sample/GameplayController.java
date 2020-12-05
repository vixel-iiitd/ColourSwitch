package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

import javafx.scene.input.MouseEvent;

import java.util.Random;


public class GameplayController {


    @FXML
    AnimationTimer timer;

    double t;

    @FXML
    private AnchorPane gamePlayRoot;

    @FXML
    private ImageView pauseButton;

   Obstacle obstacle;

    BallController ball;

    @FXML
    public void pauseGame(MouseEvent event) throws  Exception {
        AnchorPane pane = FXMLLoader.load((getClass().getResource("pauseGame.fxml")));
        gamePlayRoot.getChildren().setAll(pane);


    }

    public void initialize() throws Exception {


        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));

        AnchorPane Ballpane = load1.load();
        ball = load1.getController();
        FXMLLoader load2 = new FXMLLoader(getClass().getResource(getObstacle()));

        AnchorPane ObstaclePane = load2.load();
        obstacle =load2.getController();
        gamePlayRoot.getChildren().addAll(ObstaclePane);
        gamePlayRoot.getChildren().addAll(Ballpane);





        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try{
                    update();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        };

        timer.start();

    }


    private void update() throws Exception {
        t+=0.016;

        boolean color=obstacle.checkColor(ball);
        if(color){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            gamePlayRoot.getChildren().setAll(pane);
        }

        if(t>2){
            t= 0;
        }
    }

    

    public int generateRandom(){
        Random random = new Random();
        int r = random.nextInt(4)+1;

        return r;
    }



    public String getObstacle() {

        int k = generateRandom();
//        System.out.println(k);

        k = 2;
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



    public void moveObject(){


    }



}
