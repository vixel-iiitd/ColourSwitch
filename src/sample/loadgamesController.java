package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;


public class loadgamesController {
    @FXML
    private AnchorPane loadGameRoot;

    @FXML
    private ListView gameStateList;

    @FXML
    private Label G1 ;

    @FXML
    private ImageView Game1;


    @FXML
    private Label G2 ;

    @FXML
    private ImageView Game2;

    @FXML
    private Label G3;

    @FXML
    private ImageView Game3;

    @FXML
    private Label G4 ;

    @FXML
    private ImageView Game4;

    @FXML
    private Label G5 ;

    @FXML
    private ImageView Game5;

    @FXML
    private ImageView delete;


//    @FXML
//    private Button deleteProgress;
//    ObservableList<DataTable> d= FXCollections.observableArrayList(Main.getDatabase().getDatabaseFiles());

    private int k1 = 0;

    @FXML
    public void initialize() throws Exception {
        ObjectInputStream in = null;
        DataBase getData;
        try {
            in = new ObjectInputStream(new FileInputStream("SavedGames.txt"));
            getData = (DataBase) in.readObject();


        } finally {
            in.close();
        }


        Label G[] = new Label[]{G1,G2,G3,G4,G5};


        for(int i = 0;i<getData.data.size();i++){
        G[i].setText("Game : "+(i+1) + " Score :"+ getData.data.get(i).Score);}

    }

    @FXML
    public void ExitToMainMenu(MouseEvent event) throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
       loadGameRoot.getChildren().setAll(pane);
    }

    @FXML
    public void deserialize(Integer i) throws Exception {
        ObjectInputStream in = null;
        DataBase getData;
        try {
            in = new ObjectInputStream(new FileInputStream("SavedGames.txt"));
            getData = (DataBase) in.readObject();


        } finally {
            in.close();
        }



//  Function on nmouse click

        FXMLLoader load = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        AnchorPane Pane = load.load();
        GameplayController GPobj=load.getController();
        loadGameRoot.getChildren().setAll(Pane);


        GPobj.deserialize(i);

    }


    public void getnum1() throws Exception {
        k1=0;
        deserialize(0);
    }

    public void getnum2() throws Exception {
        k1 = 1;
        deserialize(1);
    }
    public void getnum3() throws Exception {
        k1 = 2;
        deserialize(2);
    }
    public void getnum4() throws Exception {
        k1 = 3;
        deserialize(3);
    }
    public void getnum5() throws Exception {
        k1=4;
        deserialize(4);
    }

    @FXML
    public void Delete(MouseEvent event) throws IOException {
            File file = new File("SavedGames.txt");
            if(file.exists()){
                file.delete();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                loadGameRoot.getChildren().setAll(pane);
            }
    }

}
