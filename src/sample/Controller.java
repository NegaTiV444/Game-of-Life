package sample;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Controller {


    private Timer updateTimer;
    private UpdateTimerTask mMyTimerTask;
    static boolean[][] currentMap;
    private WritableImage wi;
    private PixelWriter pw;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public ImageView map;

    @FXML
    void initialize() {


        updateTimer = new Timer();
        updateTimer.scheduleAtFixedRate(new UpdateTimerTask(), 1,100);
    }



    class UpdateTimerTask extends TimerTask
    {

        public void DrowSquare(int x, int y, int size, Color color, PixelWriter pw)
        {
            for (int i = x * 10, lenX = size; lenX > 0; lenX--, i++)
                for (int j = y * 10, lenY = size; lenY > 0; lenY--, j++)
                    pw.setColor(i, j, color);
        }

        @Override
        public void run() {
            wi = new WritableImage(1600, 800);
            pw = wi.getPixelWriter();
            currentMap = Model.UpdateMap();
            for (int i = 1; i < Model.MAXWIDTH - 1; i++)
                for (int j = 1; j < Model.MAXHEIGHT - 1; j++)
                {
                    if (currentMap[i][j])
                        DrowSquare(i, j, 7, Color.BLUE, pw);
                }
            map.setImage(wi);
        }
    }
}
