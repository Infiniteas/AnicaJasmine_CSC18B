
package pipedreamsv3;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Jasmine
 */
public class Login extends JPanel {
    private BufferedImage loginBackground = null;
    private final BufferedImageLoader load = new BufferedImageLoader();
    
    //shape the done button
    private final Rectangle continueButtonRect = new Rectangle(310, 440, 250, 80);
    private final Rectangle newGameButtonRect = new Rectangle(300, 550, 280, 80);
    JButton continueButton = new JButton();
    JButton newGameButton = new JButton();
    
    //font for the labels
    Font font0 = new Font("arial" , Font.PLAIN, 36);
    Font font1 = new Font("arial" , Font.ITALIC, 20);
    
    Color turquoise = new Color(70,166,154);
    
    JLabel usernameLabel  = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    
    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    
    boolean displayCB = false;
    boolean displayNGB = false;
    
    
    public Login() {
        setLayout(null);
        
        add(continueButton);
        continueButton.setBorder(null);
        continueButton.setBounds(310, 440, 250, 80);
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        
        add(newGameButton);
        newGameButton.setBorder(null);
        newGameButton.setBounds(300, 550, 280, 80);
        newGameButton.setOpaque(false);
        newGameButton.setContentAreaFilled(false);
        
        //displays the Username label
        usernameLabel.setFont(font0);
        usernameLabel.setForeground(Color.ORANGE);
        usernameLabel.setBounds(160, 180, 200, 100);
        this.add(usernameLabel);
        
        //displays the Password label
        passwordLabel.setFont(font0);
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setBounds(160, 280, 200, 100);
        this.add(passwordLabel);
        
        //displays the textfields
        usernameTextField.setFont(font0);
        usernameTextField.setForeground(Color.LIGHT_GRAY);
        usernameTextField.setText("Ex: Infiniteas");
        usernameTextField.setBounds(350, 210, 290, 50);
        this.add(usernameTextField);
        
        passwordTextField.setFont(font0);
        passwordTextField.setForeground(Color.LIGHT_GRAY);
        passwordTextField.setText("******");
        passwordTextField.setBounds(350, 310, 290, 50);
        this.add(passwordTextField);
        
        
        usernameTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                usernameTextField.setText("");
                usernameTextField.setForeground(turquoise);
            }
        });        
        
        
        passwordTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                passwordTextField.setText("");
                passwordTextField.setForeground(turquoise);
            }
        });
        
        continueButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayCB = true;
                repaint();
                
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayCB = false;
            }
        });
        
        newGameButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayNGB = true;
                repaint();
                
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayNGB = false;
            }
        });
        
    }
      
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        try{
            loginBackground = load.loadImage("PDLoginBackground.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        g.drawImage(loginBackground, 0, 0, null); 
        
        
        Font font3 = new Font("arial" , Font.BOLD, 70 );
        g.setFont(font3);
        g.setColor(turquoise);
        g.drawString("Login", 300, 120);
        
        g.setColor(Color.orange);
        g2d.draw(continueButtonRect);
        g2d.draw(newGameButtonRect);
        
        //will make the continue buttons highlight if mouse hovers
        if(displayCB){
            g.drawRect(310, 440, 250, 80); 
            g.setColor(turquoise);
            g.fillRect(310, 440, 250, 80);
            
            Font font4 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font4);
            g.setColor(Color.ORANGE);
            g.drawString("Continue", 325, 490);
            g.drawString("New Game", 315, 605);
        } else if (!displayCB){
            Font font4 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font4);
            g.setColor(Color.ORANGE);
            g.drawString("Continue", 325, 490);
            g.drawString("New Game", 315, 605);
        }
        
        //will make the new game button highlight if mouse hovers
        if(displayNGB){
            g.drawRect(300, 550, 280, 80); 
            g.setColor(turquoise);
            g.fillRect(300, 550, 280, 80);
            
            Font font4 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font4);
            g.setColor(Color.ORANGE);
            g.drawString("Continue", 325, 490);
            g.drawString("New Game", 315, 605);
        } else if (!displayNGB){
            Font font4 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font4);
            g.setColor(Color.ORANGE);
            g.drawString("Continue", 325, 490);
            g.drawString("New Game", 315, 605);
        }        

    }
    

   
    
}
