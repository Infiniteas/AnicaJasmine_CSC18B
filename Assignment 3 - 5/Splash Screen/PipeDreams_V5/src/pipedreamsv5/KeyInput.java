
package pipedreamsv5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jasmine
 */
public class KeyInput extends KeyAdapter {
    
    PipeDreamsV5 game;
    
    public KeyInput(PipeDreamsV5 game){
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e) {
       game.keyPressed(e); 
    }    
    
    public void keyReleased(KeyEvent e) {
       game.keyReleased(e);
    }
}
