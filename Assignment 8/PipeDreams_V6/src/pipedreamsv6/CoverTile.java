
package pipedreamsv6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class CoverTile {    
    private BufferedImage coverTiles;

    boolean displayedCovers = false;
    boolean animation = true;
    
    int coverX1 = -1;
    int coverY1 = -1;
    
    int velX = 1;
    int velY = -1;
   
    int count = 0;
    int[][] coverBoard = new int[6][6];


    CoverTile(PipeDreamsV6 game) {
       SpriteSheet ss = new SpriteSheet(game.getSpriteSheet()); 
        coverTiles = ss.grabImage(1, 1, 100, 100);
        
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                coverBoard[i][j] = 0;
            }
        } 
    }
    

    public void render(Graphics g){
        int x = 100;
        int y = 100;

                               

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if(coverBoard[i][j] != 1 && coverBoard[i][j] != 2){ 
                    g.drawImage(coverTiles, x, y, null);
                }
                x += 100;
            }
           x = 100;
           y += 100;
        }

       if(coverX1 != -1 && coverY1 != -1) {
           if(coverBoard[(coverY1 / 100) - 1][(coverX1 / 100) - 1] == 0) {
                coverBoard[(coverY1 / 100) - 1][(coverX1 / 100) - 1] = 1;
                velX = 1;
                velY = -1;
           }
        }
        
        if (velX > 180){
           
           coverBoard[(coverY1 / 100) - 1][(coverX1 / 100) - 1] = 2;
        } 
        
        x = 100;
        y = 100;
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if(i == ((coverY1 / 100) - 1) && j == ((coverX1 / 100) - 1)){
                    if(coverBoard[(coverY1 / 100) - 1][(coverX1 / 100) - 1] == 1){

                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            ex.getStackTrace();
                        }
                        g.drawImage(coverTiles, x + velX, y + velY, null);

                        velX += velX;
                        velY += velY;

                    }
                }
                x += 100;
            }
           x = 100;
           y += 100;
        }
        
        
    } 
    
    public void setPosition(int x, int y){
        this.coverX1 = x;
        this.coverY1 = y;
    }
      
    
}
