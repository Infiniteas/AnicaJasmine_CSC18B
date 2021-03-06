
package pipedreamsv5;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jasmine
 */
public class BufferedImageLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) throws IOException {
        
        image = ImageIO.read(getClass().getResource(path));
        return image;
    }
    
    
}
