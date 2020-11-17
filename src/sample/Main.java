package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    public static MediaPlayer mediaPlayer;
    public static void main(String[] args) {
        launch(args);
        System.out.println("First1");

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //addMusic();
        Parent mainPage=FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene scene = new Scene(mainPage,1024,600);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        //primaryStage.setScene(scene);
        primaryStage.show();
    }



}