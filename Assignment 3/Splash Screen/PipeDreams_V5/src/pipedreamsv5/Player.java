
package pipedreamsv5;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class Player {
    
    private int xPosition;
    private int yPosition;
    

    
    private BufferedImage player;
   
    
    public Player(int x, int y, PipeDreamsV5 game) {
        this.xPosition = x;
        this.yPosition = y;
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        
        player = ss.grabImage(5, 4, 100, 100);
    }
    
    public void tick(){
        
        if (xPosition <= 100) {
            xPosition = 100;
        }
        
        if (xPosition >= 600 ) {
            xPosition = 600;
        }
        
        if (yPosition <= 100) {
            yPosition = 100;
        }
        
        if (yPosition >= 600) {
            yPosition = 600;
        }
    }
    
    public void render(Graphics g) {
        g.drawImage(player, xPosition, yPosition, null);
    }
    
    public int getX() {
        return xPosition;
    }
    
    public int getY(){
        return yPosition;
    }
    
    public void setX(int x) {
        this.xPosition = x;
    }
    
    public void setY(int y) {
        this.yPosition = y;
    }
    

}
