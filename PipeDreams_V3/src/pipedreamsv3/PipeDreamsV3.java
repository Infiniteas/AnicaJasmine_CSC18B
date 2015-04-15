
package pipedreamsv3;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;



/**
 *
 * @author Jasmine
 */
public class PipeDreamsV3 extends Canvas implements Runnable {
    
    public static final int width = 800;
    public static final int height = 800;
   // public final int scale = 2;
    public final String title = "Pipe Dreams";
    
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    private BufferedImage background = null;
    private BufferedImage spriteSheet = null;
    
    private boolean running = false;
    private boolean menuControl = true;
    private Thread thread;
    
    private Player player;

 
    
    
    public void initialize() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            //loads the sprite sheet with all of the tiles for gameplay
            spriteSheet = loader.loadImage("SpriteSheetPD.png");
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        addKeyListener(new KeyInput(this));
        this.requestFocus();
        
        player = new Player(200,200,this);
        

    }
    
    public synchronized void start() {
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop() {
        if(!running) {
            return;
        }
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        System.exit(1);
    }
    
   
    public void run() {
        initialize();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0 ;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            
            frames++;
            
            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                System.out.println(updates + "Ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
    }
    
    private void tick(){
            player.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            //3 buffers
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
       
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        player.render(g);
            
        
        
        g.dispose();
        bs.show();
    }
    
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
           if(key == KeyEvent.VK_D) {
               //player.setVelX(5);
               player.setX(player.getX() + 100);

           } else if (key == KeyEvent.VK_A) {
               //player.setVelX(-5);
               player.setX(player.getX() - 100);

           } else if(key == KeyEvent.VK_W) {
               //player.setVelY(-5);
               player.setY(player.getY() - 100);

           } else if (key == KeyEvent.VK_S) {
              // player.setVelY(5);
               player.setY(player.getY() + 100);

           }
    }    
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
    


    
    
    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

}
