
package pipedreamsv6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jasmine
 */
public class Liquid {
    
    PipeDreamsV6 currentGame;
    TilePositions tiles;
    
    private BufferedImage startLiquid;
    private BufferedImage endLiquid;
    private BufferedImage temp;
    
    private BufferedImage liquidTile1;
    private BufferedImage liquidTile2;
    private BufferedImage liquidTile3;
    private BufferedImage liquidTile4;
    private BufferedImage liquidTile5;
    private BufferedImage liquidTile6;
   
    //to reset the in x and y below
    boolean reset = true;
    int xLeft = 95;
    int yUp = 95;
    int xRight = 5;
    int yDown = 5;
    
    boolean startAnimation = true;
    boolean endAnimation = false;
    boolean tileAnimation = false;
    
    //controls the speed of the liquid flow
    int condition = 50;
    
    int row;
    int col;
    
    int startRow;
    int startCol;
    
    //to add values to the xCoord. and yCoord. array
    int index = 0;
    
    SpriteSheet ss;
    
    int count = 0;
    int animationCount = 0;
    
    int[][] liquidBoard = new int[6][6];
    int[][] tileBoard = new int[6][6];
    
    //this will store the coord. of which to draw;
    int[] xCoordinates = new int[36];
    int[] yCoordinates = new int[36];
    char[] tileType = new char[36];
    
    //determines the direction of the liquid flow
    private enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }
    
    //hold current direction of liquid flow
    Direction flow;
    
    Liquid(PipeDreamsV6 game, TilePositions tiles){
        this.currentGame = game;
        this.tiles = tiles;
        ss = new SpriteSheet(game.getSpriteSheet()); 
        
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
               liquidBoard[i][j] = 0;
               
            }
        }
        
        for(int i = 0; i < 36; i++){
            tileType[i] = 'E';
            xCoordinates[i] = 0;
            yCoordinates[i] = 0;
        }
 
        setStartTile();
        row = startRow;
        col = startCol;
        getNextTileRowCol();
    }
    
    
    public void render(Graphics g){
    
        
        int x = 100;
        int y = 100;
        
        //does the animation for the startTile until it is filled
        switch(tiles.startTile) {

            case 7:     if(xLeft != 0 && startAnimation){
                            startLiquid = ss.grabImage(4, 3, 100, 100);
                            g.drawImage(startLiquid, 700 , y*tiles.startPosition, null);
                            temp = ss.grabImage(3, 3, xLeft, 100);
                            g.drawImage(temp, 700 , y*tiles.startPosition, null);
                            if(count % condition == 0){
                                xLeft -= 5;
                            }
                        } else{
                            //System.out.println("counter: " + count);
                            startAnimation = false;
                            tileAnimation = true;
                            startLiquid = ss.grabImage(4, 3, 100, 100);
                            g.drawImage(startLiquid, 700 , y*tiles.startPosition, null);
                            
                            checkAfterStartTile();
                        } 
                        
                break;

            case 8:     if(yDown != 100 && startAnimation) {
                            startLiquid = ss.grabImage(6, 3, 100, yDown);
                            g.drawImage(startLiquid, x*tiles.startPosition, 0, null);
                            if(count % condition == 0){
                                yDown += 5;
                            }                            
                        } else {
                            //System.out.println("counter: " + count);
                            startAnimation = false;
                            tileAnimation = true;
                            startLiquid = ss.grabImage(6, 3, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 0, null);
                            
                            checkAfterStartTile();
                        }
                        
                break;
            case 9:     if(yUp != 0 && startAnimation) {
                            startLiquid = ss.grabImage(2, 4, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 700, null);
                            temp = ss.grabImage(1, 4, 100, yUp);
                            g.drawImage(temp, x*tiles.startPosition, 700, null);
                            if(count % condition == 0){
                                yUp -= 5;
                            }                            
                        } else {
                            //System.out.println("counter: " + count);
                            startAnimation = false;
                            tileAnimation = true;
                            startLiquid = ss.grabImage(2, 4, 100, 100);
                            g.drawImage(startLiquid, x*tiles.startPosition, 700, null);
                            
                            checkAfterStartTile();
                        }
                    
                break;
            case 10:    if(xRight != 100 && startAnimation){
                            startLiquid = ss.grabImage(4, 4, xRight, 100);
                            g.drawImage(startLiquid, 0, y*tiles.startPosition, null);
                            if(count % condition == 0){
                                xRight += 5;
                            }                              
                        } else {
                            //System.out.println("counter: " + count);
                            startAnimation = false;
                            tileAnimation = true;
                            startLiquid = ss.grabImage(4, 4, 100, 100);
                            g.drawImage(startLiquid, 0, y*tiles.startPosition, null);
                            
                            checkAfterStartTile();
                        }
                break;
        }
        
        
        if (endAnimation){
            
            //turns off tile animation
            tileAnimation = false;
            
            //does the animation for the emdTile until it is filled
            switch(tiles.endTile) {

                case 7:     if(xLeft != 0){
                                
                                endLiquid = ss.grabImage(4, 3, 100, 100);
                                g.drawImage(endLiquid, 0 , y*tiles.endPosition, null);
                                temp = ss.grabImage(3, 3, xLeft, 100);
                                g.drawImage(temp, 0 , y*tiles.endPosition, null);

                                if(count % condition == 0){
                                    xLeft -= 5;
                                }

                            } else{
                                
                                endLiquid = ss.grabImage(4, 3, 100, 100);
                                g.drawImage(endLiquid, 0 , y*tiles.endPosition, null);


                            } 

                    break;

                case 8:     if(yDown != 100) {
                                
                                endLiquid = ss.grabImage(6, 3, 100, yDown);
                                g.drawImage(endLiquid, x*tiles.endPosition, 0, null);

                                if(count % condition == 0){
                                    yDown += 5;
                                }    

                            } else {
                    
                                endLiquid = ss.grabImage(6, 3, 100, 100);
                                g.drawImage(endLiquid, x*tiles.endPosition, 700, null);

                            }

                    break;
                case 9:     if(yUp != 0) {
                                
                                endLiquid = ss.grabImage(2, 4, 100, 100);
                                g.drawImage(endLiquid, x*tiles.endPosition, 0, null);
                                temp = ss.grabImage(1, 4, 100, yUp);
                                g.drawImage(temp, x*tiles.endPosition, 0, null);
                                if(count % condition == 0){
                                    yUp -= 5;
                                }                            
                            } else {
                               
                                endLiquid = ss.grabImage(2, 4, 100, 100);
                                g.drawImage(endLiquid, x*tiles.endPosition, 0, null);

                            }

                    break;
                case 10:    if(xRight != 100){
                                
                                endLiquid = ss.grabImage(4, 4, xRight, 100);
                                g.drawImage(endLiquid, 700, y*tiles.endPosition, null);
                                if(count % condition == 0){
                                    xRight += 5;
                                }                              
                            } else {
                                
                                endLiquid = ss.grabImage(4, 4, 100, 100);
                                g.drawImage(endLiquid, 700, y*tiles.endPosition, null);


                            }
                    break;
            }
        }
        
        
        //begins animation after the start tile is filled
        if(tileAnimation){
            
            //will reset everytime a tube is filled
            if(reset){
                xLeft = 95;
                yUp = 95;
                xRight = 5;
                yDown = 5;
            }
            
            System.out.println("row and column:  " + "["+ row + "][" + col + "]");
            
            //holds the x and y values of the current tile used to draw 
            //the tile image
            int drawX = (col + 1) * 100;
            int drawY = (row + 1) * 100;
            
            //displays animation depending on tile and direction of liquid flow
            switch(tileBoard[row][col]){
                    case 1:     if (flow == Direction.LEFT){
                                    //do animation for the tile going left
                                    if(xLeft != 0){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        liquidTile1 = ss.grabImage(2, 2, 100, 100);
                                        g.drawImage(liquidTile1, drawX, drawY, null);

                                        liquidTile1 = ss.grabImage(2, 1, xLeft, 100);
                                        g.drawImage(liquidTile1, drawX, drawY, null);

                                        if(count % condition == 0){
                                            xLeft -= 5;
                                        }                              
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }

                                } else if(flow == Direction.RIGHT){
                                    //do animation for the tile going right
                                    if(xRight != 100){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        liquidTile1 = ss.grabImage(2, 2, xRight, 100);
                                        g.drawImage(liquidTile1, drawX, drawY, null);

                                        if (count % condition == 0) {
                                            xRight += 5;
                                        }                              
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }
                                }
                        break;
                    case 2:     if (flow == Direction.UP){
                                    //do animation for the tile going down
                                    if (yUp != 0) {
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        //grabs and draws tile image
                                        liquidTile2 = ss.grabImage(3, 2, 100, 100);
                                        g.drawImage(liquidTile2, drawX, drawY, null);
                                        
                                        //grabs and draws tile image
                                        liquidTile2 = ss.grabImage(3, 1, 100, yUp);
                                        g.drawImage(liquidTile2, drawX, drawY, null);
                                        
                                        if(count % condition == 0){
                                            
                                            //changes amount of image displayed
                                            yUp -= 5;
                                        }                            
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }
                                } else if(flow == Direction.DOWN){
                                    //animation for the tile going down
                                    if (yDown != 100) {
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        //grabs and draws tile image
                                        liquidTile2 = ss.grabImage(3, 2, 100, yDown);
                                        g.drawImage(liquidTile2, drawX, drawY, null);
                                        
                                        if(count % condition == 0){
                                            yDown += 5;
                                        }     
                                        
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }
                                }
                        break;
                    case 3:     if (flow == Direction.LEFT){
                                    //do animation for the tile going left
                                               
                                    if (yUp != 0){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        //grabs and draws tile image
                                        liquidTile3 = ss.grabImage(4, 2, 100, 100);
                                        g.drawImage(liquidTile3, drawX, drawY, null);
                                        
                                        //grabs and draws tile image
                                        liquidTile3 = ss.grabImage(4, 1, xLeft, 100);
                                        g.drawImage(liquidTile3, drawX, drawY, null);
                                        
                                        if (xLeft == 80){
                                            xLeft = 100;
                                            yUp = 35;
                                        }   
                                    
                                        if(count % condition*2 == 0 && xLeft != 100){
                                            
                                            //changes amount of image displayed
                                            xLeft -= 5;
                                        } else if (count % condition*2 == 0) {
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 2, 100, 100);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 1, xLeft, yUp);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            yUp -= 5;
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 2, 100, 100);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 1, xLeft, yUp);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                        }
                                    } else {
                                      
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if (validateNextTile()) {
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                        
                                } else if(flow == Direction.DOWN){
                                    //do animation for the tile going down
                                    
                                    if (xRight != 100) {
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        //grabs and draws tile image
                                        liquidTile3 = ss.grabImage(4, 2, 80, yDown);
                                        g.drawImage(liquidTile3, drawX, drawY, null);

                                        if (yDown == 25) {
                                            yDown = 100;
                                            xRight = 60;
                                            
                                        } 
                                                                                
                                        if (count % condition == 0 && yDown != 100) {
                                            
                                           //changes amount of image displayed
                                            yDown += 5;
                                            
                                        } else if (count % condition == 0) {
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 2, xRight, yDown);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            xRight += 5;
                                            
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile3 = ss.grabImage(4, 2, xRight, yDown);
                                            g.drawImage(liquidTile3, drawX, drawY, null);
                                            
                                        }                          
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                                }
                        break;
                    case 4:     if (flow == Direction.LEFT){
                                    //do animation for the tile going left
                        
                                    if (yDown != 100) {
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                       
                                        //grabs and draws tile image
                                        liquidTile4 = ss.grabImage(5, 2, 100, 100);
                                        g.drawImage(liquidTile4, drawX, drawY, null);
                                        
                                        //grabs and draws tile image
                                        liquidTile4 = ss.grabImage(5, 1, xLeft, 100);
                                        g.drawImage(liquidTile4, drawX, drawY, null);
                                        
                                        
                                        if (count % condition*2 == 0 && xLeft != 75) {
                                        
                                            //changes amount of image displayed
                                            xLeft -= 5;
                                            
                                            //temp value change
                                            if (xLeft == 75) {

                                                yDown = 75;
                                            }
                                        } else if (count % condition*2 == 0) {
                                            
                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 2, 100, yDown);
                                            g.drawImage(liquidTile4, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            yDown += 5;
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 2, 100, yDown);
                                            g.drawImage(liquidTile4, drawX, drawY, null);
                                        }
                                        
                                    }   else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                                    
                                } else if(flow == Direction.UP){
                                    //do animation for the tile going up
                                    
                                    if (xRight != 100) {
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                  
                                        //grabs and draws tile image
                                        liquidTile4 = ss.grabImage(5, 2, 100, 100);
                                        g.drawImage(liquidTile4, drawX, drawY, null);
                                        
                                        //grabs and draws tile image
                                        liquidTile4 = ss.grabImage(5, 1, 100, yUp);
                                        g.drawImage(liquidTile4, drawX, drawY, null);
                                        
                                        //temp changes values
                                        if (yUp == 70) {
                                            yUp = 5;
                                            
                                        } 
                                        
                                        if (count % condition*2 == 0 && yUp != 5) {
                                          
                                            //changes amount of image displayed
                                            yUp -= 5;
                                            
                                        } else if (count % condition*2 == 0) {
                                            
                                            //temp changes value 
                                            if (xRight == 5){
                                                xRight = 80;
                                            }
                                            
                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 1, 100, 100);
                                            g.drawImage(liquidTile4, drawX, drawY, null);

                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 2, xRight, yUp);
                                            g.drawImage(liquidTile4, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            xRight += 5;
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 1, 100, 100);
                                            g.drawImage(liquidTile4, drawX, drawY, null);

                                            //grabs and draws tile image
                                            liquidTile4 = ss.grabImage(5, 2, xRight, yUp);
                                            g.drawImage(liquidTile4, drawX, drawY, null);
                                        }
                                        
                                    }   else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                                }
                        break;
                    case 5:     if (flow == Direction.RIGHT){
                                    //do animation for the tile going right
                        
                                    if (yDown != 100){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        if (yDown == 5){
                                            yDown = 75;
                                        }
                                        
                                        //grabs and draws tile image
                                        liquidTile5 = ss.grabImage(6, 2, xRight, yDown);
                                        g.drawImage(liquidTile5, drawX, drawY, null);
                                        
                                        if (xRight == 35){
                                            xRight = 100;
                                        }
                                        
                                        
                                        if (count % condition*2 == 0 && xRight != 100) {
                                            
                                            //changes amount of image displayed
                                            xRight += 5;
                                        } else if (count % condition*2 == 0){
                                            
                                            //changes amount of image displayed
                                            yDown += 5;
                                        }
                                        
                                        
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }
                                } else if(flow == Direction.UP){
                                    
                                    //do animation for the tile going up
                                    if (xLeft != 0){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        
                                        //grabs and draws tile image
                                        liquidTile5 = ss.grabImage(6, 2, 100, 100);
                                        g.drawImage(liquidTile5, drawX, drawY, null);
                                        
                                        //grabs and draws tile image
                                        liquidTile5 = ss.grabImage(6, 1, xLeft, yUp);
                                        g.drawImage(liquidTile5, drawX, drawY, null);
                                        
                                        
                                        if (count % condition*2 == 0 && yUp != 65) {
                                            
                                            //changes amount of image displayed
                                            yUp -= 5;
                                        } else if (count % condition*2 == 0){
                                            
                                            if (xLeft == 95){
                                                xLeft = 50;
                                            }
                                            
                                            //changes amount of image displayed
                                            xLeft -= 5;
                                        }
                                        
                                        
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    }
                                }
                        break;
                    case 6:     if (flow == Direction.RIGHT){
                        
                                    //do animation for the tile going right
                                   if (yUp != 0){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        //grabs and draws tile image
                                        liquidTile6 = ss.grabImage(1, 3, xRight, 100);
                                        g.drawImage(liquidTile6, drawX, drawY, null);
                                      
                                        if (count % condition*2 == 0 && xRight != 100) {
                                            yDown = 40;
                                            //changes amount of image displayed
                                            xRight += 5;
                                            
                                            //temp changes value
                                            if(xRight == 40){
                                                //yUp = 40;
                                                xRight = 100;
                                            }
                                        } else if (count % condition*2 == 0){
                                            
                                            //grabs and draws tile image
                                            liquidTile6 = ss.grabImage(1, 2, 100, yUp);
                                            g.drawImage(liquidTile6, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            yUp -= 5;
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile6 = ss.grabImage(1, 2, 100, yUp);
                                            g.drawImage(liquidTile6, drawX, drawY, null);
                                        }
                                        
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                                    
                                } else if(flow == Direction.DOWN){
                                    
                                    //do animation for the tile going down
                                    if (xLeft != 0){
                                        
                                        //saves values until tube is filled
                                        reset = false;
                                        
                                        
                                        //grabs and draws tile image
                                        liquidTile6 = ss.grabImage(1, 3, 100, yDown);
                                        g.drawImage(liquidTile6, drawX, drawY, null);
                                        
                                      
                                        if (count % condition*2 == 0 && yDown != 100) {
                                           xLeft = 30;
                                            //changes amount of image displayed 
                                           yDown += 5;
                                           
                                           if (yDown == 30){
                                               yDown = 100;
                                               
                                           }
                                        } else if (count % condition*2 == 0){
                                            
                                            //grabs and draws tile image
                                            liquidTile6 = ss.grabImage(1, 2, xLeft, 100);
                                            g.drawImage(liquidTile6, drawX, drawY, null);
                                            
                                            //changes amount of image displayed
                                            xLeft -= 5;
                                            
                                        } else {
                                            
                                            //grabs and draws tile image
                                            liquidTile6 = ss.grabImage(1, 2, xLeft, 100);
                                            g.drawImage(liquidTile6, drawX, drawY, null);
                                        }
                                        
                                    } else {
                                        
                                        //reset values for next tube
                                        reset = true;
                                        
                                        saveFilledTubesCoord();
                                        
                                        if(validateNextTile()){
                                            setNextTile();
                                            getNextTileRowCol();
                                        }
                                    } 
                                    
                                }
                        break;                         
            }
        }
       
       
        
        //displays the filled tubes
        for (int i = 0; i < 36; i++){
            
            switch(tileType[i]){
                case '1':   liquidTile1 = ss.grabImage(2, 2, 100, 100);
                            g.drawImage(liquidTile1, xCoordinates[i], yCoordinates[i], null);
                    break;
                case '2':   liquidTile2 = ss.grabImage(3, 2, 100, 100);
                            g.drawImage(liquidTile2, xCoordinates[i], yCoordinates[i], null);
                    break;
                case '3':   liquidTile3 = ss.grabImage(4, 2, 100, 100);
                            g.drawImage(liquidTile3, xCoordinates[i], yCoordinates[i], null);
                    break;
                case '4':   liquidTile4 = ss.grabImage(5, 2, 100, 100);
                            g.drawImage(liquidTile4, xCoordinates[i], yCoordinates[i], null);
                    break;
                case '5':   liquidTile5 = ss.grabImage(6, 2, 100, 100);
                            g.drawImage(liquidTile5, xCoordinates[i], yCoordinates[i], null);
                    break;
                case '6':   liquidTile6 = ss.grabImage(1, 3, 100, 100);
                            g.drawImage(liquidTile6, xCoordinates[i], yCoordinates[i], null);
                    break;
                default: //do nothing
                    break;
            }
        }
        
        
        
        
      count++;
    }
                
  /**
   * This method sets the row index and col index for the next tile 
   */  
  private void getNextTileRowCol(){
      
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++){
            if(liquidBoard[i][j] == 1){
                row = i;
                col = j;
                liquidBoard[i][j] = 2;
                return;
            }
        }
    }

  }

    /**
     * Checks valid tile after first
     * @return boolean true if next tile is valid, 
     * false if next tile is not valid
     */
    private boolean checkAfterStartTile(){
      
        switch(tiles.startTile){
            case 7 :    if (tileBoard[startRow][startCol] == 2 ||
                            tileBoard[startRow][startCol] == 5 ||
                            tileBoard[startRow][startCol] == 6 ){
                            System.out.println("you lose");
                            Retry tryAgain = new Retry();
                            currentGame.stop();
                            //System.exit(0);
                        }
                break;
            case 8 :    if (tileBoard[startRow][startCol] == 1 ||
                            tileBoard[startRow][startCol] == 4 ||
                            tileBoard[startRow][startCol] == 5 ){
                            System.out.println("you lose");
                            Retry tryAgain = new Retry();
                            currentGame.stop();
                            //System.exit(0);
                        }
                break;
            case 9 :    if(tileBoard[startRow][startCol] == 1 ||
                            tileBoard[startRow][startCol] == 3 ||
                            tileBoard[startRow][startCol] == 6 ){
                            System.out.println("you lose");
                            Retry tryAgain = new Retry();
                            currentGame.stop();
                            //System.exit(0);
                        } 
                break;
            case 10 :   if (tileBoard[startRow][startCol] == 2 ||
                            tileBoard[startRow][startCol] == 3 ||
                            tileBoard[startRow][startCol] == 4 ){
                            System.out.println("you lose");
                            Retry tryAgain = new Retry();
                            currentGame.stop();
                            //System.exit(0);
                        }
                break;  
        }
    
    return true;
  }
  
    /**
     * This updates the liquidBoard which states the next tile to focus on
     */
    private void setNextTile(){
        
        if (validateNextRowColIndex(tileBoard[row][col])) {
         
            switch(tileBoard[row][col]){
                case 1 :    if (flow == Direction.LEFT) {

                                liquidBoard[row][col - 1] = 1;

                            } else if (flow == Direction.RIGHT) {

                                liquidBoard[row][col + 1] = 1;

                            }
                    break;
                case 2 :    if (flow == Direction.UP) {

                                liquidBoard[row - 1][col] = 1;

                            } else if (flow == Direction.DOWN) {

                                liquidBoard[row + 1][col] = 1;

                            }     
                    break;
                case 3 :    if (flow == Direction.DOWN) {

                                liquidBoard[row][col + 1] = 1;

                                flow = Direction.RIGHT;

                            } else if (flow == Direction.LEFT) {

                                liquidBoard[row - 1][col] = 1;

                                flow = Direction.UP;
                            }
                    break;
                case 4 :   if (flow == Direction.UP) {

                                liquidBoard[row][col + 1] = 1;

                                flow = Direction.RIGHT;

                            } else if (flow == Direction.LEFT) {

                                liquidBoard[row + 1][col] = 1;

                                flow = Direction.DOWN;
                            }
                    break;
                case 5 :    if (flow == Direction.RIGHT) {

                                liquidBoard[row + 1][col] = 1;

                                flow = Direction.DOWN;

                            } else if(flow == Direction.UP) {

                                liquidBoard[row][col - 1] = 1;

                                flow = Direction.LEFT;
                            }
                    break;
                case 6 :    if (flow == Direction.RIGHT) {

                                liquidBoard[row - 1][col] = 1;
                                
                                flow = Direction.UP;

                            } else if(flow == Direction.DOWN) {

                                liquidBoard[row][col - 1] = 1;
                                
                                flow = Direction.LEFT;
                            }
                    break;                         
            }
        } else {
            System.out.println("You lose");
            Retry tryAgain = new Retry();
            currentGame.stop();
            
            //System.exit(0);
        }
    }
    
    /**
     * This method checks to make sure the indexes do not go out of bounds
     * of the 2D array
     * @param x
     * @return boolean true if next index is valid, false if not
     */
    private boolean validateNextRowColIndex(int x){
        System.out.println("col:  " + col);
        System.out.println("col + 1:  " + (col + 1));
        System.out.println("col - 1:  " + (col - 1));
        
        System.out.println("row:  " + row);
        System.out.println("row + 1:  " + (row + 1));
        System.out.println("row - 1:  " + (row - 1));
        
        switch(x) {
            case 1:     if (flow == Direction.LEFT && (col - 1 == -1)) {
                
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        } else if (flow == Direction.RIGHT && (col + 1 == 6)) {
                            
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        }
                break;
            case 2:     if (flow == Direction.DOWN && (row + 1 == 6)) {
                
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        } else if (flow == Direction.UP && (row - 1 == -1)) {
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        }
                break;
            case 3:     if (flow == Direction.DOWN && (col + 1 == 6)) {
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        } else if (flow == Direction.LEFT && (row - 1 == -1)) {
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        }
                break;
            case 4:     if (flow == Direction.UP && (col + 1 == 6)) {
                
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            
                            return false;
                        } else if (flow == Direction.LEFT && (row + 1 == 6)) {
                            
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                           
                            return false;
                        }
                break;
            case 5:     if (flow == Direction.RIGHT && (row + 1 == 6)) {
                
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        } else if (flow == Direction.UP && (col - 1 == -1)) {
                            
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        }
                break;
            case 6:     if (flow == Direction.RIGHT && (row - 1 == -1)) {
                
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        } else if (flow == Direction.DOWN && (col - 1 == -1)) {
                            if(checkEndTilePosition()){
                               System.out.println("You win");
                               tileAnimation = false;
                               endAnimation = true;
                               reset = true;
                            } else {
                                Retry tryAgain = new Retry();
                                currentGame.stop();
                            }
                            return false;
                        }
                break;
        }
        
        return true;
    }
   
    private void setStartTile(){
        
        switch(tiles.startTile){
            case 7 :    startCol = 5;
                        startRow = tiles.startPosition - 1;
                        liquidBoard[startRow][startCol] = 1;
                        
                        flow = Direction.LEFT;
                break;
            case 8 :    startCol = tiles.startPosition - 1;
                        startRow = 0;
                        liquidBoard[startRow][startCol] = 1;
                        flow = Direction.DOWN;
                break;
            case 9 :    startCol = tiles.startPosition - 1;
                        startRow = 5;
                        liquidBoard[startRow][startCol] = 1;
                        flow = Direction.UP;
                break;
            case 10 :   startCol = 0;
                        startRow = tiles.startPosition - 1;
                        liquidBoard[startRow][startCol] = 1;
                        flow = Direction.RIGHT;
                break;  
        }
    }
    
    /**
     * This function will save the filled tubes coordinates in order to display it
     */
    private void saveFilledTubesCoord(){
        System.out.println("xCoord: " + ((col + 1) * 100) );
        System.out.println("yCoord: " + ((row + 1) * 100) );
        switch(tileBoard[row][col]){
                case 1 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '1';
                            index++;
                    break;
                case 2 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '2';
                            index++; 
                    break;
                case 3 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '3';
                            index++;
                    break;
                case 4 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '4';
                            index++;
                    break;
                case 5 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '5';
                            index++;
                    break;
                case 6 :    xCoordinates[index] = (col + 1) * 100;
                            yCoordinates[index] = (row + 1) * 100;
                            tileType[index] = '6';
                            index++;
                    break;                         
        }
    }
    
    /**
     * This method checks to see if the nextTile is valid. If not valid, this
     * will end the program
     * @return true if valid tile
     */
    public boolean validateNextTile(){
        
        if (validateNextRowColIndex(tileBoard[row][col])) {
           
            switch(tiles.tileBoard[row][col]){

                case 1 :    if (flow == Direction.LEFT) {

                                if (tileBoard[row][col - 1] == 2 ||
                                    tileBoard[row][col - 1] == 5 ||
                                    tileBoard[row][col - 1] == 6 ) {
                                    
                                    
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }
                            } else if (flow == Direction.RIGHT) {

                                if (tileBoard[row][col + 1] == 2 ||
                                    tileBoard[row][col + 1] == 3 ||
                                    tileBoard[row][col + 1] == 4 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }
                            }
                    break;
                case 2 :    if (flow == Direction.UP) {

                                if (tileBoard[row - 1][col] == 1 ||
                                    tileBoard[row - 1][col] == 3 ||
                                    tileBoard[row - 1][col] == 6 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            } else if (flow == Direction.DOWN) {

                                if (tileBoard[row + 1][col] == 1 ||
                                    tileBoard[row + 1][col] == 4 ||
                                    tileBoard[row + 1][col] == 5 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            }     
                    break;
                case 3 :    if (flow == Direction.DOWN) {

                                if (tileBoard[row][col + 1] == 2 ||
                                    tileBoard[row][col + 1] == 3 ||
                                    tileBoard[row][col + 1] == 4 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            } else if (flow == Direction.LEFT) {

                                if (tileBoard[row - 1][col] == 1 ||
                                    tileBoard[row - 1][col] == 3 ||
                                    tileBoard[row - 1][col] == 6 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            }
                    break;
                case 4 :   if (flow == Direction.UP) {

                                if (tileBoard[row][col + 1] == 2 ||
                                    tileBoard[row][col + 1] == 3 ||
                                    tileBoard[row][col + 1] == 4 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            } else if (flow == Direction.LEFT) {

                                if (tileBoard[row + 1][col] == 1 ||
                                    tileBoard[row + 1][col] == 4 ||
                                    tileBoard[row + 1][col] == 5 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            }
                    break;
                case 5 :    if (flow == Direction.RIGHT) {

                                if (tileBoard[row + 1][col] == 1 ||
                                    tileBoard[row + 1][col] == 4 ||
                                    tileBoard[row + 1][col] == 5 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }


                            } else if(flow == Direction.UP) {

                                if (tileBoard[row][col - 1] == 2 ||
                                    tileBoard[row][col - 1] == 5 ||
                                    tileBoard[row][col - 1] == 6 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            }
                    break;
                case 6 :    if (flow == Direction.RIGHT) {

                                if (tileBoard[row - 1][col] == 1 ||
                                    tileBoard[row - 1][col] == 3 ||
                                    tileBoard[row - 1][col] == 6 ) {
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }

                            } else if(flow == Direction.DOWN) {

                                if (tileBoard[row][col - 1] == 2 ||
                                    tileBoard[row][col - 1] == 5 ||
                                    tileBoard[row][col - 1] == 6 ) {
                                    
                                    Retry tryAgain = new Retry();
                                    currentGame.stop();
                                    
                                }
                            }
                    break;                         
            }
            return true;
        } else { //TODO: check end tile position
            return false;
        }
    }
    
    private boolean checkEndTilePosition(){
        
        switch(tiles.endTile) {
            case 7 :    if (tiles.endPosition == (row + 1)) {
                            return true;
                        }
                break;
            case 8 :    if (tiles.endPosition == (col + 1)) {
                            return true;
                        }
                break;
            case 9 :    if (tiles.endPosition == (col + 1)) {
                            return true;
                        }
                break;
            case 10 :   if (tiles.endPosition == (row + 1)) {
                            return true;
                        }
                break;
        }
        
        return false;
    }
    
    
    private void checkEndPosition(){
        
    }
    
    
    /**
     * This method updates the new Board after a swap
     * @param board 
     */
    public void getBoard(int[][] board){
        this.tileBoard = board;
    }
    
    
    public int[] getXCoords(){
        return xCoordinates;
    }
    
    public int[] getYCoords(){
        return yCoordinates;
    }
    
    public void print(int perLine){
        System.out.println("TileBoard in Liquid");
        for (int i = 0; i < 6; i++) {
           for (int j = 0; j < 6; j++){
               System.out.print(tileBoard[i][j] + " ");
           }
           System.out.println();
        }
    }
}
