
/**
 * line 33,41 useless need to fix
 */
package guikey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame{
private static final int a = 6; //size of board a x a
private static JFrame frame = new JFrame("Animation");
private JPanel[][] panel;
private JButton[][] button;

ImageIcon cover = new ImageIcon("C:\\Users\\Jasmine\\Documents\\NetBeansProjects\\GuiKey\\src\\guikey\\Cover_100x100.png");


  public Main() {

    JPanel jp = new JPanel();
 
    ActionListener clk = new ButtonListener();
    Dimension d = new Dimension(100,100);
    GridLayout gl = new GridLayout(a,a);
    gl.setHgap(0);
    jp.setLayout(gl);

    
    //declare size of button array
    panel = new JPanel[a][a];
    button = new JButton[a][a];
    
    for(int i=0;i<a;i++){
      for(int j=0;j<a;j++){

        button[i][j] = new JButton();
        button[i][j].addActionListener(clk);
        button[i][j].setPreferredSize(d);
        button[i][j].setFocusable(true);
        button[i][j].setOpaque(false);
        button[i][j].setContentAreaFilled(false);

        
        panel[i][j] = new GuiKey();
        panel[i][j].add(button[i][j]);
        panel[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jp.add(panel[i][j]);
      }
    }

    //define jframe and add objects
    frame.setSize(new Dimension(600,600));
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(jp);
    frame.setResizable(false);
  }
  
    private class ButtonListener implements ActionListener{
      
    @Override
    public void actionPerformed(ActionEvent e){
      for (int i = 0; i < a; i++){
        for (int j = 0; j < a; j++){
          if(e.getSource()==button[i][j]){ //gameButtons[i][j] was clicked
           //Your code here
            //System.out.println(panel[i][j].getComponent(0));
              GuiKey gkey = (GuiKey) panel[i][j];
              gkey.time.start();
            System.out.println(i+" "+j);
          }
        }
      }
    }
  }

  


   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        public void run() {
          new Main(); //create a TwoD object
          frame.setVisible(true);
        }
      });
   }
}