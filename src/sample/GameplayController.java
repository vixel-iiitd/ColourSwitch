package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Random;


public class GameplayController {


    @FXML
    AnimationTimer timer;

    double t;

    @FXML
    private AnchorPane gamePlayRoot;

    @FXML
    private ImageView pauseButton;

//   Obstacle obstacle;

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
        newObstacle =load2.getController();
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


    private double s = 300;

    private Obstacle newObstacle;
    private Obstacle preObstacle;

    private Obstacle generateObstacle() throws IOException {
        Obstacle obstacle;

        FXMLLoader load2 = new FXMLLoader(getClass().getResource(getObstacle()));
        AnchorPane ObstaclePane = load2.load();
        obstacle =load2.getController();
        gamePlayRoot.getChildren().addAll(ObstaclePane);
        obstacle.setCenter();


        return obstacle;

    }

    private int Count = 0;

    private void update() throws Exception {
        t += 0.001;

//        System.out.println(ball.ball.getLayoutY());

        boolean color = newObstacle.checkColor(ball);
        if (color) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            gamePlayRoot.getChildren().setAll(pane);
        }

        if (t > 2) {
            t = 0;
        }

        if (ball.speed < s) {
//            System.out.println(ball.speed);
            newObstacle.movingSpeed(1);
            if(Count!=0) {
                preObstacle.movingSpeed(1);
            }

            s-=1;

        }

//        System.out.print(newObstacle.getCenter() +" ");System.out.println(ball.ball.getLayoutY());

        if(ball.ball.getLayoutY()<newObstacle.getCenter()){
            preObstacle = newObstacle;
            newObstacle = generateObstacle();
            Count=1;
        }

    }


    public int generateRandom(){
        Random random = new Random();
        int r = random.nextInt(3)+1;

        return r;
    }



    public String getObstacle() {

        int k = generateRandom();
//        System.out.println(k);

        //k = 5;

        if (k == 6) {

            return "Line.fxml";

        } else if (k == 2) {
            return "Circle.fxml";

        }
        else if(k==7){
            return "Triangle.fxml";
        }

        else if(k==4){

            return "Rectangle.fxml";
        }
        else if(k==1){
            return "ColourChanger.fxml";


        }

        else{
            return "Star.fxml";
        }


    }



    public void moveObject(){


    }



}
