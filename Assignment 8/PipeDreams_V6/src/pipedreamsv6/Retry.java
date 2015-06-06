
package pipedreamsv6;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Jasmine
 */
public class Retry extends JFrame{
    
    Restart restartPanel = new Restart();
    
    Retry() {
        
        //this.setLayout(null);
        this.setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);   
        setVisible(true);
        
        this.setTitle("Retry?");
        
        add(restartPanel);
        
        restartPanel.setVisible(true);
        
        restartPanel.tryAgainButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                
                
                PipeDreamsV6 game = new PipeDreamsV6();

                JFrame frame = new JFrame();
                frame.setTitle("Pipe Dreams");
                frame.setSize(new Dimension(800, 800));
                game.setPreferredSize(new Dimension(787, 787));

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
        
        restartPanel.doneButton.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
                
            }
         
        });
        
    }
    
}
