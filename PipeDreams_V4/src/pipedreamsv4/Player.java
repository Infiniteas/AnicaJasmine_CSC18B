
package pipedreamsv4;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class Player {
    
    private double xPosition;
    private double yPosition;
    

    
    private BufferedImage player;
   
    
    public Player(double x, double y, PipeDreamsV4 game) {
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
        g.drawImage(player, (int) xPosition, (int) yPosition, null);
    }
    
    public double getX() {
        return xPosition;
    }
    
    public double getY(){
        return yPosition;
    }
    
    public void setX(double x) {
        this.xPosition = x;
    }
    
    public void setY(double y) {
        this.yPosition = y;
    }
    

}
