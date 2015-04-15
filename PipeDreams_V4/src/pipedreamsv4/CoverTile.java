
package pipedreamsv4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class CoverTile {    
    private BufferedImage coverTiles;
    boolean displayedCovers = false;
    double xPosition = -1;
    double yPosition = -1;
    int[][] coverBoard = new int[6][6];


    CoverTile(PipeDreamsV4 game) {
       SpriteSheet ss = new SpriteSheet(game.getSpriteSheet()); 
        coverTiles = ss.grabImage(1, 1, 100, 100);
        
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                coverBoard[i][j] = 0;
            }
        } 
    }
    
    public void placeCovers(Graphics g){
 
    }

    public void render(Graphics g){
            int x = 100;
            int y = 100;


            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++){
                    if(coverBoard[i][j] != 1){ 
                        g.drawImage(coverTiles, (int) x, (int) y, null);
                    }
                    x += 100;
                }
               x = 100;
               y += 100;
            }
            
           
            
            if(xPosition != -1 && yPosition != -1) {
                coverBoard[((int)yPosition / 100) - 1][((int)xPosition / 100) - 1] = 1;
            } 
                 
    }  

    public void tick(){
        
    }
    
    public void setPosition(int x, int y){
        this.xPosition = x;
        this.yPosition = y;
    }
}
