/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;





/**
 *
 * @author Aleksandra
 */
public class Board extends ACanvas implements MouseListener, KeyListener {
    
    final static short size = 25;
    final static short WIDTH = size * 10;
    final static short HEIGHT = size * 20;
    
    final Color [] COLOR = {Color.GRAY, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN, Color.ORANGE};
            
    byte[][] tab = new byte[10][20];
    Random random = new Random();
    Chock chock = new Chock();
    byte chockX, chockY;
    boolean kDown, kUp, kRight, kLeft;

    
    
    
    Board()
    {
        super(WIDTH, HEIGHT); addMouseListener(this); addKeyListener(this);
       
    }

    @Override
    public void drawImage() {
        drawBoard();    
        cmpBoard();
        drawChock(chockX,chockY);
        Key();
       
    }
    private void drawBoard()
    {
        for (byte x=0; x<10; ++x)
            for (byte y=0; y<20; y++)
            {
                graphic.setColor(COLOR [tab[x][y]]);
                graphic.fillRect(x*size,y*size,size,size);
                graphic.setColor(Color.BLACK);
                if(tab[x][y]>0) graphic.drawRect(x*size, y*size,size-1,size-1);
                
                
            }
                  
    }
    private void drawCube(byte x, byte y, byte k)
    {
        graphic.setColor(COLOR [k]);
                graphic.fillRect(x*size,y*size,size,size);
                graphic.setColor(Color.BLACK);
                graphic.drawRect(x*size, y*size,size-1,size-1);
    }
    
    private boolean isLine(byte y)
    {
        for(byte x=0; x<10; x++) {if(tab[x][y]==0) return false;}
        return true;
    }
    
    private void setLine(byte y)
    {
        for(byte x=0; x<10;x++) tab[x][y]=8;
    }
          
    private void cmpBoard()
    {
        for(byte y=0; y<20; y++)
        {
            if(tab[0][y]==8) downBoard(y);
            if(isLine(y)) setLine(y); //3 powyższe funkcje powoduja zmiane koloru 10 klocków ułożonych w linii
        }
    }
    
    private void downBoard(byte y) //powoduje zniknięcie 10 tych samych klocków ułożonych w jendej linii
    {
        for(byte ty=y; ty>0; ty--)
            for(byte x=0; x<10; x++) tab[x][ty]= tab[x][ty-1];
        for(byte x=0; x<10; x++) tab[x][0]=0;
    }
    
    private void drawChock(byte x, byte y)
    {
        for(byte tx=0;tx<4;tx++)
            for(byte ty=0;ty<4;ty++)
                if(chock.tab[tx][ty]) drawCube((byte) (x+tx),(byte)(y+ty),(byte) (chock.aChock+1));
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    tab[e.getX()/size][e.getY()/size]=1; //jeśli kliknę na planszy to pojawi się kwadracik
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int k=e.getKeyCode();
      if(k==VK_UP) kUp=true;
      if(k==VK_DOWN) kDown=true;
      if(k==VK_RIGHT) kRight=true;
      if(k==VK_LEFT) kLeft=true;
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int k=e.getKeyCode();
      if(k==VK_UP) kUp=false;
      if(k==VK_DOWN) kDown=false;
      if(k==VK_RIGHT) kRight=false;
      if(k==VK_LEFT) kLeft=false;
    }
    
    private boolean isLineChockX(byte x)
    {
        for(byte y=0; y<4 ;y++) {if(chock.tab[x][y]) return false;}
        return true;
    }
    
    private boolean moveLeft()
    {
        if(chockX==0 && !isLineChockX((byte)0)) return false; else
        if(chockX==-1 && !isLineChockX((byte)1)) return false; else
        if(chockX==2 && !isLineChockX((byte)2)) return false; else
        return true;
    }
    
    private void Key()
    {
        if(kUp) chock.turn();
        if(kLeft && moveLeft())
        {
            chockX--;
        }
        if(kRight)
        {
            chockX++;
        }
    }
        
        
    
}
