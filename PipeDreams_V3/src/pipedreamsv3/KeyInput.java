
package pipedreamsv3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jasmine
 */
public class KeyInput extends KeyAdapter {
    
    PipeDreamsV3 game;
    
    public KeyInput(PipeDreamsV3 game){
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e) {
       game.keyPressed(e); 
    }    
    
    public void keyReleased(KeyEvent e) {
       game.keyReleased(e);
    }
}
