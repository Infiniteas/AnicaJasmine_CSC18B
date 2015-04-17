
package pipedreamsv5;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Jasmine
 */
public class TilePositions {
    final BufferedImage tile1;
    final BufferedImage tile2;
    final BufferedImage tile3;
    final BufferedImage tile4;
    final BufferedImage tile5;
    final BufferedImage tile6;
    
    private BufferedImage start;
    private BufferedImage end;
    
    private BufferedImage lockOn;
    
    int playerX1 = -1;
    int playerY1 = -1;
    
    int playerX2 = -1;
    int playerY2 = -1;
    
    int lockX = -1;
    int lockY = -1;
    
    int[][] tileBoard = new int[6][6];
    int startTile;
    int endTile;
    
    int startPosition;
    int endPosition;
    
    boolean displayLock = false;
    
    TilePositions(PipeDreamsV5 game){
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet()); 
        tile1 = ss.grabImage(2, 1, 100, 100);
        tile2 = ss.grabImage(3, 1, 100, 100);
        tile3 = ss.grabImage(4, 1, 100, 100);
        tile4 = ss.grabImage(5, 1, 100, 100);
        tile5 = ss.grabImage(6, 1, 100, 100);
        tile6 = ss.grabImage(1, 2, 100, 100);
        
        lockOn = ss.grabImage(6, 4, 100, 100);
        
        Random rand = new Random();
        int max = 6;
        int min = 1;
        
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                int randomNum = rand.nextInt((max - min) + 1) + min;
                tileBoard[i][j] = randomNum;
            }
        }    
        
        startPosition = rand.nextInt((max - min) + 1) + min;
        do {
            endPosition = rand.nextInt((max - min) + 1) + min;
        } while (startPosition == endPosition);
        
        max = 10;
        min = 7;
        startTile = rand.nextInt((max - min) + 1) + min;
        
        switch(startTile) {
            case 7 :    start = ss.grabImage(3, 3, 100, 100);
                        max = 9;
                        min = 7;
                        endTile = rand.nextInt((max - min) + 1) + min;
                break;
            case 8 :    start = ss.grabImage(5, 3, 100, 100);

                        do{
                            endTile = rand.nextInt((max - min) + 1) + min;
                        } while(endTile == 9);
                break;
            case 9 :    start = ss.grabImage(1, 4, 100, 100);
                        do{
                            endTile = rand.nextInt((max - min) + 1) + min;
                        } while(endTile == 8);
                break;
            case 10 :   start = ss.grabImage(3, 4, 100, 100);
                        max = 10;
                        min = 8;
                        endTile = rand.nextInt((max - min) + 1) + min;
                break;
        }
        
        switch(endTile) {
            case 7 :    end = ss.grabImage(3, 3, 100, 100);
                break;
            case 8 :    end = ss.grabImage(5, 3, 100, 100);
                break;
            case 9 :    end = ss.grabImage(1, 4, 100, 100);
                break;
            case 10 :   end = ss.grabImage(3, 4, 100, 100);
                break;
        }
        
        System.out.println("Start: " + startTile);
        System.out.println("End: " + endTile);
           
    }
    
    
    public void render(Graphics g) {
        int x = 100;
        int y = 100;
        
        switch(startTile) {
            case 7 :    g.drawImage(start, 700, y*startPosition, null);
                break;
            case 8 :    g.drawImage(start, x*startPosition, 0, null);
                break;
            case 9 :    g.drawImage(start, x*startPosition, 700, null);
                break;
            case 10 :   g.drawImage(start, 0, y*startPosition, null);
                break;
        }
        
        switch(endTile) {
            case 7 :    g.drawImage(end, 0, y*endPosition, null);     
                break;
            case 8 :    g.drawImage(end, x*endPosition, 700, null);
                break;
            case 9 :    g.drawImage(end, x*endPosition, 0, null);
                break;
            case 10 :   g.drawImage(end, 700, y*endPosition, null);
                break;
        }

        
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if(tileBoard[i][j] == 1){ 
                    g.drawImage(tile1, x, y, null);
                } else if(tileBoard[i][j] == 2){ 
                    g.drawImage(tile2, x, y, null);
                } else if(tileBoard[i][j] == 3){ 
                    g.drawImage(tile3, x, y, null);
                } else if(tileBoard[i][j] == 4){ 
                    g.drawImage(tile4, x, y, null);
                } else if(tileBoard[i][j] == 5){ 
                    g.drawImage(tile5, x, y, null);
                } else if(tileBoard[i][j] == 6){ 
                    g.drawImage(tile6, x, y, null);
                }
                x += 100;
            }
               x = 100;
               y += 100;
        }
        
        if(displayLock){
            g.drawImage(lockOn, lockX, lockY, null);
        }
        
        
    }
    
    public void swaptTiles(){
        if(playerY1 != -1 && playerX1 != -1) {
            if(playerY2 != -1 && playerX2 != -1) {
                int temp = tileBoard[( playerY1 / 100) - 1][( playerX1 / 100) - 1];
                tileBoard[(playerY1 / 100) - 1][(playerX1 / 100) - 1] = 
                        tileBoard[(playerY2 / 100) - 1][(playerX2 / 100) - 1];
                tileBoard[(playerY2 / 100) - 1][(playerX2 / 100) - 1] = 
                        temp;
            }
        }
    }
    public void getPlayerPosition1(int x, int y){
        this.playerX1 = x;
        this.playerY1 = y;
    }
    
    public void getPlayerPosition2(int x, int y){
        this.playerX2 = x;
        this.playerY2 = y;
    }
    public void lockedOnCoord(int x, int y){
        this.lockX = x;
        this.lockY = y;
    }
    
    public void displayLocked(){
        displayLock = true;
    }
    
    public void clearLocked(){
        displayLock = false;
    }
}
