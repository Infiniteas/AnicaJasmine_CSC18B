
package pipedreamsv2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static pipedreamsv2.PipeDreamsV2.height;
import static pipedreamsv2.PipeDreamsV2.width;

/**
 *
 * @author Jasmine
 */
public class NewPlayer extends JPanel {
  
    private BufferedImage newPlayerBackground = null;
    private BufferedImageLoader load = new BufferedImageLoader();
    
    //shape the done button
    private final Rectangle doneButtonRect = new Rectangle(300, 600, 200, 60);
    JButton doneButton = new JButton();
    
    //font for the labels
    Font font0 = new Font("arial" , Font.PLAIN, 36);
    Font font1 = new Font("arial" , Font.ITALIC, 20);
    
    JLabel usernameLabel  = new JLabel("Username");
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    
    JLabel usernameErrorLabel  = new JLabel("*Must have at least 3 characters");
    JLabel emailErrorLabel = new JLabel("*Invalid email");
    JLabel passwordErrorLabel = new JLabel("*Needs: 1 number, 1 lower case, 1 upper, 5 character");
    
    JTextField usernameTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    
    Color turquoise = new Color(70,166,154);
    
    boolean proceed = false;
        
    
    //Valid user input
    ValidateInput valid = new ValidateInput();
    
    //save info
    NewPlayerInfo info = new NewPlayerInfo();
    
    JFrame frame = new JFrame("New Player");

    public NewPlayer() {
        
        this.setLayout(null);
        
        doneButtonRect.setBounds(300, 600, 200, 60);
        
        this.add(doneButton);
        doneButton.setBounds(300, 600, 200, 60);
        doneButton.setOpaque(false);
        doneButton.setContentAreaFilled(false);
        
        //displays the Username label
        usernameLabel.setFont(font0);
        usernameLabel.setForeground(Color.ORANGE);
        usernameLabel.setBounds(40, 230, 200, 100);
        this.add(usernameLabel);

        //displays the Username  error label
        usernameErrorLabel.setFont(font1);
        usernameErrorLabel.setForeground(turquoise);
        usernameErrorLabel.setBounds(250, 195, 400, 100);
        this.add(usernameErrorLabel);
        usernameErrorLabel.setVisible(false);
        
        //displays the Email label
        emailLabel.setFont(font0);
        emailLabel.setForeground(Color.ORANGE);
        emailLabel.setBounds(40, 340, 200, 100);
        this.add(emailLabel); 
        
        //displays the Email error label
        emailErrorLabel.setFont(font1);
        emailErrorLabel.setForeground(turquoise);
        emailErrorLabel.setBounds(250, 300, 400, 100);
        this.add(emailErrorLabel);
        emailErrorLabel.setVisible(false);
        
        //displays the Password label
        passwordLabel.setFont(font0);
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setBounds(40, 450, 200, 100);
        this.add(passwordLabel);
        
        //displays the Email error label
        passwordErrorLabel.setFont(font1);
        passwordErrorLabel.setForeground(turquoise);
        passwordErrorLabel.setBounds(250, 410, 500, 100);
        this.add(passwordErrorLabel);
        passwordErrorLabel.setVisible(false);
        
        //displays the textfields
        usernameTextField.setFont(font0);
        usernameTextField.setForeground(Color.LIGHT_GRAY);
        usernameTextField.setText("Ex: Infiniteas");
        usernameTextField.setBounds(250, 260, 290, 50);
        this.add(usernameTextField);

        
        emailTextField.setFont(font0);
        emailTextField.setForeground(Color.LIGHT_GRAY);
        emailTextField.setText("Ex: name@domain.com");
        emailTextField.setBounds(250, 365, 390, 50);
        this.add(emailTextField);
        
        passwordTextField.setFont(font0);
        passwordTextField.setForeground(Color.LIGHT_GRAY);
        passwordTextField.setText("******");
        passwordTextField.setBounds(250, 475, 290, 50);
        this.add(passwordTextField);
         
        //erase text after textfield is clicked
        usernameTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                usernameTextField.setText("");
                usernameTextField.setForeground(turquoise);
            }
        });
        
        emailTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                emailTextField.setText("");
                emailTextField.setForeground(turquoise);
            }
        });
        
        passwordTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                passwordTextField.setText("");
                passwordTextField.setForeground(turquoise);
            }
        });
        
        usernameTextField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (!usernameTextField.getText().equals("Ex: Infiniteas")){

                    if(!valid.validUsername(usernameTextField.getText())) {
                        usernameErrorLabel.setVisible(true);
                        doneButton.setVisible(false);
                    } else if(valid.validUsername(usernameTextField.getText())) {
                        usernameErrorLabel.setVisible(false);
                        doneButton.setVisible(true);
                    }
                }
            
            }
        });
        
        emailTextField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if(!valid.validEmail(emailTextField.getText())) {
                    emailErrorLabel.setVisible(true);
                    doneButton.setVisible(false);
                } else if(valid.validEmail(emailTextField.getText())) {
                    emailErrorLabel.setVisible(false);
                    doneButton.setVisible(true);
                }
            
            }
        });
        
        passwordTextField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            
            @Override
            public void focusLost(FocusEvent e) {
               
                if(!valid.validPassword(passwordTextField.getText())) {
                    passwordErrorLabel.setVisible(true);
                    doneButton.setVisible(false);
                } else if(valid.validPassword(passwordTextField.getText())) {
                    passwordErrorLabel.setVisible(false);
                    doneButton.setVisible(true);
                }
            }
        });

        frame.setPreferredSize(new Dimension(width,height));

        frame.add(this);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
        
        doneButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                info.setUsername(usernameTextField.getText());
                info.setEmail(emailTextField.getText());
                info.setPassword(passwordTextField.getText());
                proceed = true;
                frame.dispose();
            }
        });
        

    }
    
    
  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        try{
            newPlayerBackground = load.loadImage("PDNewPlayer.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        g.drawImage(newPlayerBackground, 0, 0, null); 
        
        Font font0 = new Font("arial" , Font.BOLD, 70 );
        g.setFont(font0);
        g.setColor(Color.ORANGE);
        g.drawString("New Player", 215, 130);
        
        g2d.draw(doneButtonRect);

        g.drawRect(300, 600, 200, 60);

        Color turqouise = new Color(70,166,154);
        g.setColor(turqouise);
        g.fillRect(300, 600, 200, 60);

        Font font1 = new Font("arial" , Font.BOLD, 50 );
        g.setFont(font1);
        g.setColor(Color.ORANGE);
        g.drawString("Done", 335, 645);

    }
    

   

    
    
}
