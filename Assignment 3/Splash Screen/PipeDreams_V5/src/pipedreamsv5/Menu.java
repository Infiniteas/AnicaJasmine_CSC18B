
package pipedreamsv5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static pipedreamsv5.PipeDreamsV5.height;
import static pipedreamsv5.PipeDreamsV5.width;

/**
 *
 * @author Jasmine
 */
public class Menu extends JPanel {
    
    private BufferedImage menuBackground = null;
    private BufferedImageLoader load = new BufferedImageLoader();
    
    private Rectangle newPlayerButtonRect = new Rectangle(400, 400, 300, 100);
    private Rectangle loginButtonRect = new Rectangle(450, 600, 200, 100);
    
    JButton loginButton = new JButton();
    JButton newPlayerButton = new JButton();
    
    Font font0 = new Font("arial" , Font.BOLD, 85);
    Font font1 = new Font("arial" , Font.BOLD, 50);
    
    boolean displayLB = false;
    boolean displayNPB = false;
    
    Color turquoise = new Color(70,166,154);
    
    JFrame frame = new JFrame("Menu");
    Login loginPlayer = new Login();
    
    
    public Menu(){
        this.setLayout(null);
        
        frame.setPreferredSize(new Dimension(width,height));
        
        
        this.add(loginButton);
        loginButton.setBorder(null);
        loginButton.setBounds(loginButtonRect);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        
        this.add(newPlayerButton);
        newPlayerButton.setBorder(null);
        newPlayerButton.setBounds(newPlayerButtonRect);
        newPlayerButton.setOpaque(false);
        newPlayerButton.setContentAreaFilled(false);
        
        loginButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayLB = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayLB = false;
                repaint();
            }
         
        });
        
        newPlayerButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayNPB = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayNPB = false;
                repaint();
            }
            
        });
       
        
  
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try {
            menuBackground = load.loadImage("PDMenu.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        g.drawImage(menuBackground, 0, 0, null);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g.setFont(font0);
        g.setColor(Color.ORANGE);
        g.drawString("Pipe", 240, 140);
        g.drawString("Dreams", 310, 300);
        
        g2d.draw(newPlayerButtonRect);
        g2d.draw(loginButtonRect);
        
        if (displayLB) {
            g.drawRect(450, 600, 200, 100);
            g.setColor(turquoise);
            g2d.draw(loginButtonRect);
            g.fillRect(450, 600, 200, 100);
            
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("New Player", 420 , 460);
            g.drawString("Login", 480 , 660);
             
        } else if (!displayLB) {
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("New Player", 420 , 460);
            g.drawString("Login", 480 , 660);
        }
        
        if (displayNPB) {
            g.drawRect(400, 400, 300, 100);
            g.setColor(turquoise);
            g2d.draw(newPlayerButtonRect);
            g.fillRect(400, 400, 300, 100);
           
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("New Player", 420 , 460);
            g.drawString("Login", 480 , 660);
            
        } else if (!displayNPB) {
            
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("New Player", 420 , 460);
            g.drawString("Login", 480 , 660);
        }
        
        
    }
       
}
