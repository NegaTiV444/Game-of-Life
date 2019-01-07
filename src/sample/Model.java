package sample;

import java.util.Iterator;
import java.util.LinkedList;

public class Model {

    final static int MAXHEIGHT = 80;
    final static int MAXWIDTH = 160;

    static boolean[][] currentMap = new boolean[MAXWIDTH][MAXHEIGHT];

    static
    {
        boolean state;
        for (int i = 1; i < MAXWIDTH - 1; i++)
            for (int j = 1; j < MAXHEIGHT - 1; j++)
                currentMap[i][j] = Math.random() < 0.2;
    }

    public static boolean[][] UpdateMap()
    {
        boolean[][] newMap = new boolean[MAXWIDTH][MAXHEIGHT];

        int counter;
        for (int i = 1; i < MAXWIDTH - 1; i++)             //TODO add bounds checking
            for (int j = 1; j < MAXHEIGHT - 1; j++)
            {
                counter = 0;
                if (currentMap[i - 1][j - 1])
                    counter++;
                if (currentMap[i - 1][j])
                    counter++;
                if (currentMap[i - 1][j + 1])
                    counter++;
                if (currentMap[i][j - 1])
                    counter++;
                if (currentMap[i][j + 1])
                    counter++;
                if (currentMap[i + 1][j - 1])
                    counter++;
                if (currentMap[i + 1][j])
                    counter++;
                if (currentMap[i + 1][j + 1])
                    counter++;
                if (currentMap[i][j])
                {
                    if ((counter < 2) || (counter > 3))
                        newMap[i][j] = false; //die
                    else
                        newMap[i][j] = true;  //stay alive
                }
                else
                    if (counter == 3)
                        newMap[i][j] = true;  //come alive
            }
            currentMap = newMap;
            return currentMap;
    }
}
