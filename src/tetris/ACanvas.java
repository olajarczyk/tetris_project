/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/**
 *
 * @author Aleksandra
 */
public abstract class ACanvas extends Canvas {
    BufferedImage image;
    Graphics2D graphic;
    
    ACanvas(short width, short height)
    {
        super();
        setSize(width,height);
        image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
        graphic = (Graphics2D) image.getGraphics();
        
    }
    
    public abstract void drawImage();
    
    private void naEkran()
    {
        Graphics g = getGraphics();
        g.drawImage(image,0,0,null);
        g.dispose();
    }
    
    public void run()
    {
        drawImage();
        naEkran();
    }
    
}
