
package pipedreamsv2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Jasmine
 */
public class Menu {
    
    private double xPosition;
    private double yPosition;
    
    private Rectangle loginButton = new Rectangle(400, 400, 300, 100);
    private Rectangle signUpButton = new Rectangle(450, 600, 200, 100);
    
    public void render1(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        Font font0 = new Font("arial" , Font.BOLD, 85 );
        g.setFont(font0);
        g.setColor(Color.ORANGE);
        g.drawString("Pipe", 235, 130);
        g.drawString("Dreams", 305, 290);
        
        g2d.draw(loginButton);
        g2d.draw(signUpButton);
        
        Font font1 = new Font("arial" , Font.BOLD, 50 );
        g.setFont(font1);
        
        g.drawRect(400, 400, 300, 100);
        
        Color turqouise = new Color(70,166,154);
        g.setColor(turqouise);
        g.fillRect(400, 400, 300, 100);
        
        g.setColor(Color.ORANGE);
        g.drawString("New Player", 420 , 460);
        

        g.setColor(turqouise);
        g.drawString("Login", 480 , 660);
    }
    
    public void render2(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        Font font0 = new Font("arial" , Font.BOLD, 85 );
        g.setFont(font0);
        g.setColor(Color.ORANGE);
        g.drawString("Pipe", 235, 130);
        g.drawString("Dreams", 305, 290);
        

        g2d.draw(loginButton);
        g2d.draw(signUpButton);
        
        Font font1 = new Font("arial" , Font.BOLD, 50 );
        g.setFont(font1);
        
        Color turqouise = new Color(70,166,154);
        g.setColor(turqouise);
        
        g.drawString("New Player", 420 , 460);
        
        
        g.drawRect(450, 600, 200, 100);
        g.setColor(turqouise);
        g.fillRect(450, 600, 200, 100);
        
        g.setColor(Color.ORANGE);
        g.drawString("Login", 480 , 660);
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
