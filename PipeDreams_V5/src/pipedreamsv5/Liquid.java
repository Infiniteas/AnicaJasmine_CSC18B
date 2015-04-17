
package pipedreamsv5;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class Liquid {
    TilePositions tiles;
    
    private BufferedImage startLiquid;
    private BufferedImage temp;
    
    private BufferedImage liquidTile1;
    private BufferedImage liquidTile2;
    private BufferedImage liquidTile3;
    private BufferedImage liquidTile4;
    private BufferedImage liquidTile5;
    private BufferedImage tile6;
    
    int xLeft = 95;
    int yUp = 95;
    int xRight = 5;
    int yDown = 5;
    
    //true x = 0, false x == 700
    boolean startX;
    
    //true y = 0, false y = 700
    boolean startY;
    
    SpriteSheet ss;
    
    int count = 0;
    
    int liquidBoard[][] = new int[6][6];
    
    Liquid(PipeDreamsV5 game, TilePositions tiles){
        this.tiles = tiles;
        ss = new SpriteSheet(game.getSpriteSheet()); 
    }
    
    
    public void render(Graphics g){
        int x = 100;
        int y = 100;
        switch(tiles.startTile) {
            case 7 :    if(xLeft != 0){
                            startLiquid = ss.grabImage(4, 3, 100, 100);
                            g.drawImage(startLiquid, 700 , y*tiles.startPosition, null);
                            temp = ss.grabImage(3, 3, xLeft, 100);
                            g.drawImage(temp, 700 , y*tiles.startPosition, null);
                            count++;
                            if(count == 300){
                                xLeft -= 5;
                                count = 0;
                            }
                        } else{
                            startLiquid = ss.grabImage(4, 3, 100, 100);
                            g.drawImage(startLiquid, 700 , y*tiles.startPosition, null);
                        } 
                        startX = false;
                break;
                
            case 8 :    if(yDown != 100) {
                            startLiquid = ss.grabImage(6, 3, 100, yDown);
                            g.drawImage(startLiquid, x*tiles.startPosition, 0, null);
                            count++;
                            if(count == 300){
                                yDown += 5;
                                count = 0;
                            }                            
                        } else {
                            startLiquid = ss.grabImage(6, 3, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 0, null);
                        }
                        startY = true;
                break;
            case 9 :    if(yUp != 0) {
                            startLiquid = ss.grabImage(2, 4, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 700, null);
                            temp = ss.grabImage(1, 4, 100, yUp);
                            g.drawImage(temp, x*tiles.startPosition, 700, null);
                            count++;
                            if(count == 300){
                                yUp -= 5;
                                count = 0;
                            }                            
                        } else {
                            startLiquid = ss.grabImage(2, 4, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 700, null);
                        }
                        startY = false;
                break;
            case 10 :   if(xRight != 100){
                            startLiquid = ss.grabImage(4, 4, xRight, 100);
                            g.drawImage(startLiquid, 0, y*tiles.startPosition, null);
                            count++;
                            if(count == 300){
                                xRight += 5;
                                count = 0;
                            }                              
                        } else {
                            startLiquid = ss.grabImage(4, 4, 100, 100);
                            g.drawImage(startLiquid, 0, y*tiles.startPosition, null);
                        }
                        startX = true;
                break;
        }
        
        
        
        /*
        if(startX){

        } else if (!startX){
            
        }
        
        if(startY){
            
        } else if (!startY) {
          
        } 
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if(tiles.tileBoard[i][j] == 1){
                    if(xRight != 100){
                            liquidTile1 = ss.grabImage(2, 2, xRight, 100);
                            g.drawImage(liquidTile1, x, y, null);
                            count++;
                            if(count == 300){
                                xRight += 5;
                                count = 0;
                            }                              
                        } else {
                            liquidTile1 = ss.grabImage(2, 2, 100, 100);
                            g.drawImage(liquidTile1, x, y, null);
                    }
                } else if(tiles.tileBoard[i][j] == 2){ 
                    if(yDown != 100) {
                        liquidTile2 = ss.grabImage(3, 2, 100, yDown);
                        g.drawImage(liquidTile2, x, y, null);
                        count++;
                        if(count == 300){
                            yDown += 5;
                            count = 0;
                        }                            
                    } else {
                        liquidTile2 = ss.grabImage(3, 2, 100, 100);
                        g.drawImage(liquidTile2, x, y, null);
                    }
                } else if(tiles.tileBoard[i][j] == 3){ 
                    
                } else if(tiles.tileBoard[i][j] == 4){ 
                   // g.drawImage(liquidTile4, x, y, null);
                } else if(tiles.tileBoard[i][j] == 5){ 
                   // g.drawImage(liquidTile5, x, y, null);
                } else if(tiles.tileBoard[i][j] == 6){ 
                   // g.drawImage(tile6, x, y, null);
                }
                x += 100;
            }
               x = 100;
               y += 100;
        } */
        
    }
                
    
  
   
}
