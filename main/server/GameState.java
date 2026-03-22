import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameState{

    private int playerY;
    private int playerX;
    private String[][] map;

    public Game(){

        //player starts in the middle 
        playerY = 5;
        playerX = 5;

        //hardcode the map from map.txt
        map = new String[]{
            {"S","S","S","S","S","S","S","S","S","S","S"},
            {"S","g","g","g","g","g","g","g","g","g","S"},
            {"S","g","W","W","g","g","g","W","W","g","S"},
            {"S","g","W","g","g","_","g","g","W","g","S"},
            {"S","g","g","g","t","_","t","g","g","g","S"},
            {"S","g","g","g","t","g","t","g","g","g","S"},
            {"S","g","g","g","g","_","g","g","g","g","S"},
            {"S","g","W","g","g","g","g","g","W","g","S"},
            {"S","g","W","W","g","g","g","W","W","g","S"},
            {"S","g","g","g","g","g","g","g","g","g","S"},
            {"S","S","S","S","S","S","S","S","S","S","S"}

        };
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerPosition(int y, int x) {
        playerY = y;
        playerX = x;
    }

    public boolean isValidPosition(int y, int x){
        //check if the position is within the boundaries
        if (y < 0 || x < 0) return false;
        if (y >= map.length) return false;
        if (x >= map[y].length) return false;

        //check blocking tiles
        String tile = map[y][x];
        if (tile.equals("S")) return false; //stone wall
        if (tile.equals("W")) return false; //wood wall
        if (tile.equals("B")) return false; //brick wall
        if (tile.equals("D")) return false; //door

        return true;
        
    }
}