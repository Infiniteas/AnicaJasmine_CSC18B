
package pipedreamsv6;

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
    
    //hold the players first position
    int playerX1 = -1;
    int playerY1 = -1;
    
    //holds players second position
    int playerX2 = -1;
    int playerY2 = -1;
    
    //holds the coordinates for the lockOn position
    int lockX = -1;
    int lockY = -1;
    
    //creates a 2D array to mimic a 6x6 board
    int[][] tileBoard = new int[6][6];
    
    //holds the values of the corresponding tiles
    int startTile;
    int endTile;
    
    //holds the values of the position relative to the edges of the board
    int startPosition;
    int endPosition;
    
    //holds the already filled liquid positions
    int[] liquidXCoord = new int[36];
    int[] liquidYCoord = new int[36];
    
    boolean displayLock = false;
    
    /**
     * Takes in a current game created, grabs the images for the tiles,
     * picks random tiles by comparing to a 2D array. The values to compare to
     * the Sprite sheet are as follows:
     * 
     * Empty tiles:
     * 1 = col 2, row 1
     * 2 = col 3, row 1
     * 3 = col 4, row 1
     * 4 = col 5, row 1
     * 5 = col 6, row 1
     * 6 = col 1, row 2
     * 
     * Starting/Ending tiles:
     * 7 = col 3, row 3
     * 8 = col 5, row 3
     * 9 = col 1, row 4
     * 10 = col 3, row 4
     * 
     * @param game 
     */
    TilePositions(PipeDreamsV6 game){
        
        //loads the new sprite sheet to grab 100 x 100 tile images
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet()); 
        
        //sets pictures of empty tiles to place on the board
        tile1 = ss.grabImage(2, 1, 100, 100);
        tile2 = ss.grabImage(3, 1, 100, 100);
        tile3 = ss.grabImage(4, 1, 100, 100);
        tile4 = ss.grabImage(5, 1, 100, 100);
        tile5 = ss.grabImage(6, 1, 100, 100);
        tile6 = ss.grabImage(1, 2, 100, 100);
        
        //sets the picture of the lock on tile
        lockOn = ss.grabImage(6, 4, 100, 100);
        
        //picks random values from 1-6 to place on a 6 x 6 2D array where
        //1-6 corresponds to the list stated above in the Java Doc
        Random rand = new Random();
        int max = 6;
        int min = 1;
        
        //places random values in a 2D array
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                int randomNum = rand.nextInt((max - min) + 1) + min;
                tileBoard[i][j] = randomNum;
            }
        }    
        
        //picks a random value for the starting tile position
        startPosition = rand.nextInt((max - min) + 1) + min;
        
        //picks a random value for the ending position that checks to make sure
        // the numbers is NOT equal to the starting position
        do {
            endPosition = rand.nextInt((max - min) + 1) + min;
        } while (startPosition == endPosition);
       
        //changes values to pick from 7-10
        max = 10;
        min = 7;
        
        //startTile number will narrow the endTile number
        startTile = rand.nextInt((max - min) + 1) + min;
        
        //checks which tile to grab for start according to the 
        //random values selected above AND selects a narrow random number
        //for the endTile
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
        
        //grabs an image for end
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
    
    /**
     * Places the empty tiles and start and end tiles unto the board unto the
     * canvas
     * @param g 
     */
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
    
    /**
     * This method will set the swap of the tiles
     */
    public void swaptTiles(){
        if(playerY1 != -1 && playerX1 != -1) {
            if(playerY2 != -1 && playerX2 != -1) {
                if(checkSwap()){
                    int temp = tileBoard[( playerY1 / 100) - 1][( playerX1 / 100) - 1];
                    tileBoard[(playerY1 / 100) - 1][(playerX1 / 100) - 1] = 
                            tileBoard[(playerY2 / 100) - 1][(playerX2 / 100) - 1];
                    tileBoard[(playerY2 / 100) - 1][(playerX2 / 100) - 1] = 
                            temp;
                }
            }
        }
    }
    
    public int[][] getTileBoard(){
        return tileBoard;
    }
    
    public void print(int perLine){
        System.out.println("TileBoard in TilePosition:");
        for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 6; j++){
               System.out.print(tileBoard[i][j] + " ");
           }
           System.out.println();
        }
    }
    
    public boolean checkSwap(){
        System.out.println("player1 y: " + playerY1);
           System.out.println("player1 x: " + playerX1);
           System.out.println("player2 y: " + playerY2);
           System.out.println("player2 x: " + playerX2);
           
        for (int i = 0; i < 36; i++){
          
           System.out.println("Liquid xCoord" + liquidXCoord[i]);
           System.out.println("Liquid yCoord" + liquidYCoord[i]);        
           
           
           if (playerX1  == liquidXCoord[i] &&
                    playerY1 / 100 == liquidYCoord[i]){
                return false;
            } else if (playerX2 / 100 == liquidXCoord[i] &&
                    playerY2  == liquidYCoord[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void updateLiquidXYCoord(int[] xCoord, int[] yCoord){
        liquidXCoord = xCoord;
        liquidYCoord = yCoord;
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
