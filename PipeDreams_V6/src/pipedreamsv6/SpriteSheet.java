
package pipedreamsv6;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class SpriteSheet {
    
    private BufferedImage image;
    
    public SpriteSheet(BufferedImage ss) {
        this.image = ss;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height) {
        
        BufferedImage img = image.getSubimage((col*100)-100, (row*100)-100, width, height);
        
        return img;
    }
    
}
