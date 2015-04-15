
package pipedreamsv4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Jasmine
 */
public class TilePositions {
    private final BufferedImage tile1;
    private final BufferedImage tile2;
    private final BufferedImage tile3;
    private final BufferedImage tile4;
    private final BufferedImage tile5;
    private final BufferedImage tile6;
    
    int playerX1 = -1;
    int playerY1 = -1;
    
    int playerX2 = -1;
    int playerY2 = -1;
    
    int tile1X;
    int tile1Y;
    int tile2X;
    int tile2Y;
    int tile3X;
    int tile3Y;
    int tile4X;
    int tile4Y;
    int tile5X;
    int tile5Y;
    int tile6X;
    int tile6Y;
    
    int[][] tileBoard = new int[6][6];
    
    TilePositions(PipeDreamsV4 game){
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet()); 
        tile1 = ss.grabImage(2, 1, 100, 100);
        tile2 = ss.grabImage(3, 1, 100, 100);
        tile3 = ss.grabImage(4, 1, 100, 100);
        tile4 = ss.grabImage(5, 1, 100, 100);
        tile5 = ss.grabImage(6, 1, 100, 100);
        tile6 = ss.grabImage(1, 2, 100, 100);
        
        
        Random rand = new Random();
        int max = 6;
        int min = 1;
        
        
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                int randomNum = rand.nextInt((max - min) + 1) + min;
                tileBoard[i][j] = randomNum;
            }
        }    
        
        
    }
    
    public void render(Graphics g) {
        int x = 100;
        int y = 100;
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if(tileBoard[i][j] == 1){ 
                    g.drawImage(tile1, (int) x, (int) y, null);
                } else if(tileBoard[i][j] == 2){ 
                    g.drawImage(tile2, (int) x, (int) y, null);
                } else if(tileBoard[i][j] == 3){ 
                    g.drawImage(tile3, (int) x, (int) y, null);
                } else if(tileBoard[i][j] == 4){ 
                    g.drawImage(tile4, (int) x, (int) y, null);
                } else if(tileBoard[i][j] == 5){ 
                    g.drawImage(tile5, (int) x, (int) y, null);
                } else if(tileBoard[i][j] == 6){ 
                    g.drawImage(tile3, (int) x, (int) y, null);
                }
                x += 100;
            }
               x = 100;
               y += 100;
        }
        
    }
    
    public void swaptTiles(){
        if(playerY1 != -1 && playerX1 != -1) {
            if(playerY2 != -1 && playerX2 != -1) {
                int temp = tileBoard[((int) playerY1 / 100) - 1][((int) playerX1 / 100) - 1];
                tileBoard[((int) playerY1 / 100) - 1][((int) playerX1 / 100) - 1] = 
                        tileBoard[((int) playerY2 / 100) - 1][((int) playerX2 / 100) - 1];
                tileBoard[((int) playerY2 / 100) - 1][((int) playerX2 / 100) - 1] = 
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
    
}
