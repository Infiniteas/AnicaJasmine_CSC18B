
package pipedreamsv6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
public class NewPlayer extends JPanel {
  
    private BufferedImage newPlayerBackground = null;
    private BufferedImageLoader load = new BufferedImageLoader();
    
    //shape the done button
    private final Rectangle doneButtonRect = new Rectangle(300, 680, 200, 60);
    JButton doneButton = new JButton();
    
    //font for the labels
    Font font0 = new Font("arial" , Font.PLAIN, 36);
    Font font1 = new Font("arial" , Font.ITALIC, 20);
    
    JLabel firstNameLabel  = new JLabel("First Name");
    JLabel lastNameLabel = new JLabel("Last Name");
    JLabel usernameLabel  = new JLabel("Username");
    JLabel emailLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    
    JLabel firstNameErrorLabel = new JLabel("*Must have one uppercase characters");
    JLabel lastNameErrorLabel = new JLabel("*Must have one uppercase characters");
    JLabel usernameErrorLabel  = new JLabel("*Must have at least 3 characters");
    JLabel emailErrorLabel = new JLabel("*Invalid email");
    JLabel passwordErrorLabel = new JLabel("*Needs: 1 number, 1 lower case, 1 upper, 5 character");
    
    JTextField firstNameTextField = new JTextField();
    JTextField lastNameTextField = new JTextField();
    JTextField usernameTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    
    Color turquoise = new Color(70,166,154);
    
    boolean displayDB = false;
        
    
    //Valid user input
    ValidateInput valid = new ValidateInput();
    

    public NewPlayer() {
        
        this.setLayout(null);
        
        this.add(doneButton);
        doneButton.setBorder(null);
        doneButton.setBounds(doneButtonRect);
        doneButton.setOpaque(false);
        doneButton.setContentAreaFilled(false);
        
        //displays the firstName label
        firstNameLabel.setFont(font0);
        firstNameLabel.setForeground(Color.ORANGE);
        firstNameLabel.setBounds(40, 160, 200, 100);
        this.add(firstNameLabel);
        
        //displays the name error label
        firstNameErrorLabel.setFont(font1);
        firstNameErrorLabel.setForeground(turquoise);
        firstNameErrorLabel.setBounds(250, 130, 400, 100);
        this.add(firstNameErrorLabel);
        firstNameErrorLabel.setVisible(false);
        
        //displays the lastName label
        lastNameLabel.setFont(font0);
        lastNameLabel.setForeground(Color.ORANGE);
        lastNameLabel.setBounds(40, 250, 200, 100);
        this.add(lastNameLabel);
        
        //displays the name error label
        lastNameErrorLabel.setFont(font1);
        lastNameErrorLabel.setForeground(turquoise);
        lastNameErrorLabel.setBounds(250, 220, 400, 100);
        this.add(lastNameErrorLabel);
        lastNameErrorLabel.setVisible(false);
        
        //displays the Username label
        usernameLabel.setFont(font0);
        usernameLabel.setForeground(Color.ORANGE);
        usernameLabel.setBounds(40, 350, 200, 100);
        this.add(usernameLabel);

        //displays the Username  error label
        usernameErrorLabel.setFont(font1);
        usernameErrorLabel.setForeground(turquoise);
        usernameErrorLabel.setBounds(250, 315, 400, 100);
        this.add(usernameErrorLabel);
        usernameErrorLabel.setVisible(false);
        
        //displays the Email label
        emailLabel.setFont(font0);
        emailLabel.setForeground(Color.ORANGE);
        emailLabel.setBounds(40, 460, 200, 100);
        this.add(emailLabel); 
        
        //displays the Email error label
        emailErrorLabel.setFont(font1);
        emailErrorLabel.setForeground(turquoise);
        emailErrorLabel.setBounds(250, 420, 400, 100);
        this.add(emailErrorLabel);
        emailErrorLabel.setVisible(false);
        
        //displays the Password label
        passwordLabel.setFont(font0);
        passwordLabel.setForeground(Color.ORANGE);
        passwordLabel.setBounds(40, 570, 200, 100);
        this.add(passwordLabel);
        
        //displays the Password error label
        passwordErrorLabel.setFont(font1);
        passwordErrorLabel.setForeground(turquoise);
        passwordErrorLabel.setBounds(250, 530, 500, 100);
        this.add(passwordErrorLabel);
        passwordErrorLabel.setVisible(false);
        
        //displays the textfields
        firstNameTextField.setFont(font0);
        firstNameTextField.setForeground(Color.LIGHT_GRAY);
        firstNameTextField.setText("Ex: Jasmine");
        firstNameTextField.setBounds(250, 190, 290, 50);
        this.add(firstNameTextField);
        
        lastNameTextField.setFont(font0);
        lastNameTextField.setForeground(Color.LIGHT_GRAY);
        lastNameTextField.setText("Ex: Anica");
        lastNameTextField.setBounds(250, 280, 290, 50);
        this.add(lastNameTextField);
        
        usernameTextField.setFont(font0);
        usernameTextField.setForeground(Color.LIGHT_GRAY);
        usernameTextField.setText("Ex: Infiniteas");
        usernameTextField.setBounds(250, 380, 290, 50);
        this.add(usernameTextField);

        emailTextField.setFont(font0);
        emailTextField.setForeground(Color.LIGHT_GRAY);
        emailTextField.setText("Ex: name@domain.com");
        emailTextField.setBounds(250, 485, 390, 50);
        this.add(emailTextField);
        
        passwordTextField.setFont(font0);
        passwordTextField.setForeground(Color.LIGHT_GRAY);
        passwordTextField.setText("******");
        passwordTextField.setBounds(250, 595, 290, 50);
        this.add(passwordTextField);
        
        if(usernameTextField.getText().equals("Ex: Infiniteas")){
            doneButton.setVisible(false);
        }
         
        //erase text after textfield is clicked
        firstNameTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                firstNameTextField.setText("");
                firstNameTextField.setForeground(turquoise);
            }
        });
        
        lastNameTextField.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                lastNameTextField.setText("");
                lastNameTextField.setForeground(turquoise);
            }
        });
        
        
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
        
        firstNameTextField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (!firstNameTextField.getText().equals("Ex: Jasmine")){

                    if(!valid.validFirstName(firstNameTextField.getText())) {
                        firstNameErrorLabel.setVisible(true);
                        doneButton.setVisible(false);
                    } else if(valid.validLastName(firstNameTextField.getText())) {
                        firstNameErrorLabel.setVisible(false);
                        doneButton.setVisible(true);
                    }
                }
            
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
        
        lastNameTextField.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (!lastNameTextField.getText().equals("Ex: Anica")){

                    if(!valid.validLastName(lastNameTextField.getText())) {
                        lastNameErrorLabel.setVisible(true);
                        doneButton.setVisible(false);
                    } else if(valid.validLastName(lastNameTextField.getText())) {
                        lastNameErrorLabel.setVisible(false);
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
        
        doneButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                displayDB = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                displayDB = false;
                repaint();
            }
        });
        

    }
    
    
  
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        try {
            newPlayerBackground = load.loadImage("PDNewPlayer.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        g.drawImage(newPlayerBackground, 0, 0, null); 
        
        Font font3 = new Font("arial" , Font.BOLD, 70 );
        g.setFont(font3);
        g.setColor(Color.ORANGE);
        g.drawString("New Player", 215, 130);
        
        g2d.draw(doneButtonRect);
        
        if(displayDB){
            
            g.drawRect(300, 680, 200, 60);
            g.setColor(turquoise);
            g2d.draw(doneButtonRect);
            g.fillRect(300, 680, 200, 60);
            
            Font font1 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Done", 335, 730);
            
        } else if (!displayDB){
            Font font1 = new Font("arial" , Font.BOLD, 50 );
            g.setFont(font1);
            g.setColor(Color.ORANGE);
            g.drawString("Done", 335, 730); 
        }


    }
    

   

    
    
}
