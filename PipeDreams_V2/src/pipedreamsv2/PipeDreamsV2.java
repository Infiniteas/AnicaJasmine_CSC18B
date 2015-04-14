
package pipedreamsv2;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Jasmine
 */
public class PipeDreamsV2 extends Canvas implements Runnable {
    
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
    private Menu menu;
    private NewPlayer newPlayerPanel;
    
    
    private enum STATE{
        menu,
        newPlayer,
        gameplay;
    }
    
    private STATE state = STATE.menu;
    
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
        menu = new Menu();

    }
    
    private synchronized void start() {
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
        if(state == STATE.gameplay){
            player.tick();
        }
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        BufferedImageLoader loader = new BufferedImageLoader();
        
        try {
            background = loader.loadImage("PDBackground.png");
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        if(bs == null){
            //3 buffers
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
        
        if (state == STATE.gameplay) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            player.render(g);
            
        } else if (state == STATE.menu) {
            if (menuControl){
                menu.render1(g);
            } else {
                menu.render2(g);
            }
        } else if (state == STATE.newPlayer) {
           
            try {
                Thread.sleep(1500);
                newPlayerPanel = new NewPlayer();
                while(newPlayerPanel.proceed == false){
                    System.out.println("eh");
                }
                state = STATE.gameplay;
            } catch (InterruptedException ex) {
                Logger.getLogger(PipeDreamsV2.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        g.dispose();
        bs.show();
    }
    
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
       if (state == STATE.gameplay) {
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
       } else if (state == STATE.menu) {
           if (key == KeyEvent.VK_DOWN) {
                menuControl = false;
           } else if (key == KeyEvent.VK_UP) {
                menuControl = true;
           } else if (key == KeyEvent.VK_ENTER) {
              // state == STATE.newPlayer;
               state = STATE.newPlayer;
           }
       }
    }    
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
    
   
    /**
     * 
     * This creates the JFrame the canvas will be using and starts the game
     *
     * @param args 
     */
    public static void main(String[] args) {
        
        PipeDreamsV2 game = new PipeDreamsV2();
 
        game.setPreferredSize(new Dimension(600,600));
        game.setMaximumSize(new Dimension(600,600));
        game.setMinimumSize(new Dimension(600,600));
        
        JFrame frame = new JFrame(game.title);
        frame.setPreferredSize(new Dimension(width,height));
        
        frame.add(game);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
        
    }
    
    
    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

}
