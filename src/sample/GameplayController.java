package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
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

    public EachGameData data ;


    @FXML
    public void pauseGame(MouseEvent event) throws  Exception {

        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();

        timer.stop();
        int k ;
        if(ball.ball.getFill().equals("#FAE100FF")){
            k=1;
        }
        else if(ball.ball.getFill().equals("#900DFFFF")){
            k=2;
        }
        else if(ball.ball.getFill().equals("#FF0181FF")){
            k=3;
        }
        else{
            k=4;
        }

        data = null;
        data = new EachGameData(preObstacle.name,newObstacle.name,newObstacle.getCenter(),preObstacle.getCenter(),ball.ball.getLayoutY(),k,ball.Score);

        FXMLLoader load = new FXMLLoader(getClass().getResource("pauseGame.fxml"));
        AnchorPane Pane = load.load();
        pauseController GPobj=load.getController();
        gamePlayRoot.getChildren().setAll(Pane);
        GPobj.data=data;

    }

    public void collect(){
        int k ;

        if(ball.ball.getFill().equals("#FAE100FF")){
            k=1;
        }
        else if(ball.ball.getFill().equals("#900DFFFF")){
            k=2;
        }
        else if(ball.ball.getFill().equals("#FF0181FF")){
            k=3;
        }
        else{
            k=4;
        }

        data = new EachGameData(preObstacle.name,newObstacle.name,newObstacle.getCenter(),preObstacle.getCenter(),ball.ball.getLayoutY(),k,ball.Score);




    }


    @FXML
    public void saveGame(MouseEvent event) throws  IOException, ClassNotFoundException{

        Media sound = new Media(getClass().getResource("/Music/Button.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(1);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(0.15));
        mediaPlayer.play();

        data = null;
        collect();
        System.out.println(data.new1);
        System.out.println(data.pre1);
        System.out.println(data.ballColour);
        System.out.println(data.ballPosition);
        System.out.println(data.Score);

        ObjectInputStream in = null;
        DataBase GamesData ;

        try{
            in = new ObjectInputStream(new FileInputStream("SavedGames.txt"));
            GamesData = (DataBase) in.readObject();
            GamesData.data.add(data);

        }
        finally {
            in.close();
        }


        ObjectOutputStream out = null;

        try{
            out = new ObjectOutputStream(new FileOutputStream("SavedGames.txt"));
            out.writeObject(GamesData);

        }
        finally {
            out.close();
        }
        System.exit(0);
    }

    public void deserialize(Integer gameNumber) throws Exception {
        ObjectInputStream in = null;
        DataBase getData;
        try{
            in = new ObjectInputStream(new FileInputStream("SavedGames.txt"));
            getData = (DataBase) in.readObject();


            System.out.println("1");

            System.out.println("Size   "+getData.data.size());
//            Obstacle o1 = getData.data.get(gameNumber).newobstacles;
            System.out.println("2");
//            Obstacle o2 = getData.data.get(gameNumber).preobstacles;
            System.out.println("3");

            Double p = getData.data.get(gameNumber).ballPosition;
            System.out.println("4");
//            Paint p1 = getData.data.get(gameNumber).ballColour;
            System.out.println("5");
            int S = getData.data.get(gameNumber).Score;
            System.out.println("6");


            InitializeData(getData.data.get(gameNumber).new1,getData.data.get(gameNumber).pre1,getData.data.get(gameNumber).newCentre,getData.data.get(gameNumber).preCentre,
                    getData.data.get(gameNumber).ballPosition,getData.data.get(gameNumber).ballColour,getData.data.get(gameNumber).Score);

            if(getData.data.size()>0){
                getData.data.remove(getData.data.get(gameNumber));
            }

        }finally {
            in.close();
        }

        ObjectOutputStream out = null;

        try{
            out = new ObjectOutputStream(new FileOutputStream("SavedGames.txt"));
            out.writeObject(getData);
        }
        finally {
            out.close();
        }
    }

    public void InitializeData(String new1,String pre1,double newCentre,double preCentre,Double ballPostion1, int ballColour1,int Score1 ) throws Exception{
        b =true;

        Media sound1 = new Media(getClass().getResource("/Music/Main.mp3").toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(sound1);
        mediaPlayer1.setAutoPlay(true);
        mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer1.setStartTime(Duration.seconds(0));
        mediaPlayer1.setStopTime(Duration.seconds(50));
        mediaPlayer1.play();


//        Obstacle o1 = newObstacle1;
        System.out.println(new1);
        Obstacle obstacle;

            FXMLLoader load2 = new FXMLLoader(getClass().getResource(new1+".fxml"));
            AnchorPane ObstaclePane = load2.load();
            obstacle =load2.getController();
            gamePlayRoot.getChildren().addAll(ObstaclePane);
            obstacle.setCenter2(newCentre);

            newObstacle = obstacle;


//        System.out.println(o1.getCenter() + " Cneter of 01  DSFDSFSDA");
//
//        System.out.println(o2.getCenter() + " Cneter of 01  DSFDSFSDA");
        Obstacle obstacle2;
//        if(!pre1.equals("ColourChanger")) {
//
//            FXMLLoader load3 = new FXMLLoader(getClass().getResource(pre1 + ".fxml"));
//            AnchorPane ObstaclePane1 = load3.load();
//            obstacle2 = load3.getController();
//            gamePlayRoot.getChildren().addAll(ObstaclePane1);
//            obstacle2.setCenter2(preCentre);
//
//            preObstacle = obstacle2;
//        }
//        else{
//            FXMLLoader load3 = new FXMLLoader(getClass().getResource(pre1 + ".fxml"));
//            AnchorPane ObstaclePane1 = load3.load();
//            obstacle2 = load3.getController();
//            gamePlayRoot.getChildren().addAll(ObstaclePane1);
//            obstacle2.setCenter2(-1000);
//
//            preObstacle = obstacle2;
//
//        }


        ball.ball.setLayoutY(ballPostion1);

        if(ballColour1==1){

            ball.ball.setFill(Paint.valueOf("#FAE100FF"));

        }

        else if(ballColour1==2){

            ball.ball.setFill(Paint.valueOf("#900DFFFF"));


        }

        else if(ballColour1==3){


            ball.ball.setFill(Paint.valueOf("#FF0181FF"));

        }
        else if(ballColour1==4){


            ball.ball.setFill(Paint.valueOf("#32DBF0FF"));

        }


        ball.Score= Score1;
        timer.start();
    }


    boolean b =false;


    public void initialize() throws Exception {

        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));

        AnchorPane Ballpane = load1.load();
        ball = load1.getController();



        gamePlayRoot.getChildren().addAll(Ballpane);
        b=true;

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


    @FXML
    public Label Score;

    private double s = 300;
    private int just= 0;
    private Obstacle newObstacle;
    private Obstacle preObstacle;

    private Obstacle generateObstacle() throws IOException {
        if(preObstacle.name.equals("ColourChanger")){
        Obstacle obstacle;

        FXMLLoader load2 = new FXMLLoader(getClass().getResource(getObstacle()));
        AnchorPane ObstaclePane = load2.load();
        obstacle =load2.getController();
        gamePlayRoot.getChildren().addAll(ObstaclePane);
        obstacle.setCenter();
        return obstacle;
        }

        else if(just%2==0 && (ball.ball.getFill().equals(Paint.valueOf("#ff0181ff"))||(ball.ball.getFill().equals(Paint.valueOf("#fae100ff"))) || (ball.ball.getFill().equals(Paint.valueOf("#32dbf0ff"))))){
            Obstacle obstacle;
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("Triangle.fxml"));
            AnchorPane ObstaclePane = load2.load();
            obstacle =load2.getController();
            gamePlayRoot.getChildren().addAll(ObstaclePane);
            obstacle.setCenter();
            just++;
            return obstacle;

        }

        else{
            Obstacle obstacle;
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("ColourChanger.fxml"));
            AnchorPane ObstaclePane = load2.load();
            obstacle =load2.getController();
            gamePlayRoot.getChildren().addAll(ObstaclePane);
            obstacle.setCenter();
            just++;
            return obstacle;
        }

    }

    private int Count = 0;



    private void update() throws Exception {

        if(newObstacle == null){
            System.out.println("hereeafdsfds");
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("ColourChanger.fxml"));

            AnchorPane ObstaclePane = load2.load();
            newObstacle = load2.getController();
            gamePlayRoot.getChildren().addAll(ObstaclePane);
        }




        Score.setText(ball.Score + "");
        t += 0.001;

//        System.out.println(ball.ball.getLayoutY());

        boolean color = newObstacle.checkColor(ball);
        if(!color && Count!=0) color = preObstacle.checkColor(ball);

        if (color || ball.ball.getLayoutY()<0) {
            timer.stop();
            int k ;

            if(ball.ball.getFill().equals("#FAE100FF")){
                k=1;
            }
            else if(ball.ball.getFill().equals("#900DFFFF")){
                k=2;
            }
            else if(ball.ball.getFill().equals("#FF0181FF")){
                k=3;
            }
            else{
                k=4;
            }
            color=false;
            data=null;
            data = new EachGameData(preObstacle.name,newObstacle.name,newObstacle.getCenter(),preObstacle.getCenter(),ball.ball.getLayoutY(),k,ball.Score);


            FXMLLoader load = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            AnchorPane Pane = load.load();
            GameOverController GPobj=load.getController();
            gamePlayRoot.getChildren().setAll(Pane);
            GPobj.Score.setText((Score.getText()));
            GPobj.data=data;





//            System.out.println(color);
//            System.out.println("GAMEOVER");
            return;

        }

        if (t > 2) {
            t = 0;
        }

        if (ball.speed < s) {
//            System.out.println(ball.speed);
            newObstacle.movingSpeed(3);
            if(Count!=0) {
                preObstacle.movingSpeed(3);
            }

            s-=1;

        }



//        System.out.print(newObstacle.getCenter() +" ");System.out.println(ball.ball.getLayoutY());

        if(ball.ball.getLayoutY()<newObstacle.getCenter()){
//            preObstacle= null;
            if(preObstacle!=null) {
                preObstacle.setCenter3();
            }
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
        System.out.println(k);

        //k = 5;

        if (k == 1) {
            return "Line.fxml";

        } else if (k == 2) {
            return "Circle.fxml";

        }
        else{

            return "Rectangle.fxml";
        }

    }



    public void moveObject(){


    }



}
