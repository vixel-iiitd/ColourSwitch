package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainController implements Initializable {
    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ImageView circle1;

    @FXML
    private ImageView circle2;

    @FXML
    private ImageView circle4;

    @FXML
    private ImageView circle5;

    @FXML
    private ImageView circle3;

    @FXML
    private ImageView Exit;





    @FXML
    void exitGame(MouseEvent event) {

        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition transition1 = new RotateTransition(Duration.seconds(500),circle1);
        transition1.setByAngle(360000);
        transition1.play();

        RotateTransition transition2 = new RotateTransition(Duration.seconds(500),circle2);
        transition2.setByAngle(-360000);
        transition2.play();

        RotateTransition transition3 = new RotateTransition(Duration.seconds(500),circle3);

        transition3.setFromAngle(45);
        transition3.setToAngle(360000);

        transition3.play();

        RotateTransition transition4 = new RotateTransition(Duration.seconds(500),circle4);
        transition4.setFromAngle(125);
        transition4.setToAngle(-250000);
        transition4.play();

        RotateTransition transition5 = new RotateTransition(Duration.seconds(500),circle5);
        transition5.setFromAngle(180);
        transition5.setToAngle(150000);
        transition5.play();



    }
    
    @FXML
    void startGame(MouseEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load((getClass().getResource("Gameplay.fxml")));
        mainRoot.getChildren().setAll(pane);
    }


    @FXML
    void loadGame(MouseEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loadGames.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void Exit(MouseEvent event) throws Exception{
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

}
