
package pipedreamsv5;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static pipedreamsv5.PipeDreamsV5.height;
import static pipedreamsv5.PipeDreamsV5.width;

/**
 *
 * @author Jasmine
 */
public class StartUp extends JFrame {
    
    Menu menuPanel = new Menu();
    NewPlayer newPlayerPanel = new NewPlayer();
    Login loginPlayerPanel = new Login();
    
   
    NewPlayerInfo info = new NewPlayerInfo();
    NewPlayerInfo savedInfo = new NewPlayerInfo();
    SavePlayerInfo saveInfo = new SavePlayerInfo();
    LoadPlayerInfo loadInfo = new LoadPlayerInfo();
    
    public StartUp(){
        
       
        add(menuPanel);
        setTitle("Menu");
        
        menuPanel.loginButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                menuPanel.setVisible(false);
                setTitle("Login");
                add(loginPlayerPanel);
                loginPlayerPanel.setVisible(true);
            }
         
        });
        
        menuPanel.newPlayerButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){                           
                menuPanel.setVisible(false);
                setTitle("New Player");
                add(newPlayerPanel);
                newPlayerPanel.setVisible(true);
     
            }
        });
        
        loginPlayerPanel.continueButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                //TO DO: needs to continue where user left off

                dispose();
            }
        });
        
        loginPlayerPanel.newGameButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                
                loadInfo.setInfo(loginPlayerPanel.usernameTextField.getText());
                if(loadInfo.checkFileExistence()){
                    loadInfo.openFile();
                    loadInfo.readRecords();
                    loadInfo.closeFile();
                    if(loadInfo.record.getPassword().equals(loginPlayerPanel.passwordTextField.getText())){
                        savedInfo = loadInfo.getInfo();
                        setVisible(false);
                        
                        PipeDreamsV5 game = new PipeDreamsV5();

                        JFrame frame = new JFrame();
                        frame.setTitle("Pipe Dreams");
                        frame.setSize(new Dimension(800, 800));
                        game.setPreferredSize(new Dimension(787, 787));
                        //game.setMaximumSize(new Dimension(800, ));
                        //game.setMinimumSize(new Dimension(width, height));

                        frame.add(game);
                        frame.pack();

                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setResizable(false);
                        frame.setLocationRelativeTo(null);   
                        frame.setVisible(true);
                        game.start();
                        
                        dispose();
                    } else {
                        showError();
                    }
                    
                } else {
                    showError();
                }

            }
        });
        
        newPlayerPanel.doneButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                //TO DO: Save Info and start new game
                info.setUsername(newPlayerPanel.usernameTextField.getText());
                info.setEmail(newPlayerPanel.emailTextField.getText());
                info.setPassword(newPlayerPanel.passwordTextField.getText());
                saveInfo.setInfo(info);
                SavePlayerInfo.openFile();
                SavePlayerInfo.addRecords();
                SavePlayerInfo.closeFile();

                PipeDreamsV5 game = new PipeDreamsV5();

                JFrame frame = new JFrame();
                frame.setTitle("Pipe Dreams");
                frame.setSize(new Dimension(width, height));

                game.setPreferredSize(new Dimension(width, height));
                game.setMaximumSize(new Dimension(width, height));
                game.setMinimumSize(new Dimension(width, height));

                frame.add(game);
                frame.pack();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);   
                frame.setVisible(true);
                game.start();
 
                dispose();
            }
        });
        
        setSize(new Dimension(width, height));      
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void showError(){
        JOptionPane.showMessageDialog(this,
                 "Invalid username or password",
                    "Invalid",
                JOptionPane.WARNING_MESSAGE);
        
    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
               try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    // Do something, if there is a exception
                    System.out.println(ex.toString());
                }

                StartUp s = new StartUp();
            }
        });

        
    }
    
}
