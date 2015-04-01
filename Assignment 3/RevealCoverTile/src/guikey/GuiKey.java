
package guikey;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GuiKey extends JPanel implements ActionListener {
    
    //GUI Timer goes 5 miliseconds
    Timer time = new Timer(5,this); //keyword this refers to ActionListener
    
    //x is the horizontal position
    int x = 0;
    
    //y is the vertical position
    int y = 0;
    
    int count = 1;
    
    int size = 10;
  
    //refers to the speed of the moving rectangle in the horizontal direction
    int speedX = 2;
    int speedY = -1;
    
 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        //adds an image to the panel
        //needs two back slashes between dividers
        ImageIcon i = new ImageIcon("C:\\Users\\Jasmine\\Documents\\NetBeansProjects\\GuiKey\\src\\guikey\\Cover_100x100.png");
        i.paintIcon(this, g, x, y);
        
        /*
        //creates a rectangle to move
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 30);
        */
        
        //time.start();
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
           x += speedX;
           y += speedY;
           //repaints to rectangle every 5 miliseconds
           repaint();
   
    }
   


    
}
