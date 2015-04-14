
package pipedreamsv2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jasmine
 */
public class KeyInput extends KeyAdapter {
    
    PipeDreamsV2 game;
    
    public KeyInput(PipeDreamsV2 game){
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e) {
       game.keyPressed(e); 
    }    
    
    public void keyReleased(KeyEvent e) {
       game.keyReleased(e);
    }
}
