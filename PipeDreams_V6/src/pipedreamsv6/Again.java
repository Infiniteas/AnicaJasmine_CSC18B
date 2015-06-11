
package pipedreamsv6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jasmine
 */
public class Again extends JPanel {
    
     private BufferedImage retryBackground = null;
    private BufferedImageLoader load = new BufferedImageLoader();
    
    private final Rectangle tryAgainButtonRect;
    private final Rectangle doneButtonRect;
    
    JButton tryAgainButton = new JButton();
    JButton doneButton = new JButton();
    
    Font font0 = new Font("arial" , Font.BOLD, 85);
    Font font1 = new Font("arial" , Font.BOLD, 50);
    
    boolean displayAB = false;
    boolean displayDBB = false;
    
    Color turquoise = new Color(70,166,154);
    
    int drawXAB = 360;
    int drawYAB = 300;
   
    
    int drawXDB = 360;
    int drawYDB = 500;
    
    public Again(){
        
        
        doneButtonRect = new Rectangle(drawXDB - 35, drawYDB - 60, 200, 100);
        tryAgainButtonRect = new Rectangle(drawXAB - 20, drawYAB - 65, 200, 100);
        
        this.setLayout(null);
        this.setVisible(true);
               
        this.add(tryAgainButton);
        tryAgainButton.setBorder(null);
        tryAgainButton.setBounds(tryAgainButtonRect);
        tryAgainButton.setOpaque(false);
        tryAgainButton.setContentAreaFilled(false);
        
        this.add(doneButton);
        doneButton.setBorder(null);
        doneButton.setBounds(doneButtonRect);
        doneButton.setOpaque(false);
        doneButton.setContentAreaFilled(false);
        
        tryAgainButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayAB = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayAB = false;
                repaint();
            }
         
        });
        
        doneButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayDBB = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayDBB = false;
                repaint();
            }
            
        });
       
   
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        try {
            retryBackground = load.loadImage("PDLoginBackground.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        g.drawImage(retryBackground, 0, 0, null);
        
        Graphics2D g2d = (Graphics2D) g;
        
        //draws the FAILURE title
        g.setFont(font0);
        g.setColor(Color.ORANGE);
        g.drawString("Success", 220, 140);
        
        //draws the rectangles
        g2d.draw(tryAgainButtonRect);
        g2d.draw(doneButtonRect);
        
        //checks to display the Again? Button rectangle
        if (displayAB) {
            
            //draws the done button rect empty
            //g.drawRect(drawXDB - 35, drawYDB - 60, 200, 100);
            
            g.setColor(turquoise);
            g2d.draw(tryAgainButtonRect);
            g.fillRect(drawXAB - 20, drawYAB - 65, 200, 100);
            
            //draws the text
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Again?", drawXAB , drawYAB);
            g.drawString("Done", drawXDB , drawYDB);
             
        } else if (!displayAB) {
            
            //draws the text
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Again?", drawXAB , drawYAB);
            g.drawString("Done", drawXDB , drawYDB);
        }
        
        if (displayDBB) {
    
            //g.drawRect(drawXAB - 20, drawYAB - 65, 280, 100);
            g.setColor(turquoise);
            g2d.draw(doneButtonRect);
            g.fillRect(drawXDB - 35, drawYDB - 60, 200, 100);
            
            //draws the text
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Again?", drawXAB , drawYAB);
            g.drawString("Done", drawXDB , drawYDB);
            
        } else if (!displayDBB) {
            
            //draws the text
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Again?", drawXAB , drawYAB);
            g.drawString("Done", drawXDB , drawYDB);
        }
      
        
    }
}
