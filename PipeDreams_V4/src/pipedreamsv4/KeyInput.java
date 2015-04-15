
package pipedreamsv4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jasmine
 */
public class KeyInput extends KeyAdapter {
    
    PipeDreamsV4 game;
    
    public KeyInput(PipeDreamsV4 game){
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e) {
       game.keyPressed(e); 
    }    
    
    public void keyReleased(KeyEvent e) {
       game.keyReleased(e);
    }
}
