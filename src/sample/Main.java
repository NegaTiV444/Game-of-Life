package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {



    public static ImageView getMap() {
        return map;
    }

    private static ImageView map;


    public static void setMap(ImageView map) {
        map = map;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Game of Live");
        primaryStage.setScene(new Scene(root, 1600, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
