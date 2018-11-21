/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Aleksandra
 */
public class Chock {
    public boolean [][] tab = new boolean [4][4];
    public boolean [][] tabE = new boolean [4][4];
    
    byte aChock;
    
    Chock()
    {
        setChock((byte)  0);
    }
    
    public void setChock(byte k)
    {
        aChock = k;
        for(byte x=0;x<4;x++)
            for(byte y=0; y<4;y++)
                tab[x][y]=Chocks.CHOCKS[aChock][x][y];
    }
    
    public void turn()
    {
        for(byte x=0;x<4;x++) for(byte y=0; y<4;y++) tabE[x][y]=tab[x][y];
        for(byte x=0;x<4;x++) for(byte y=0; y<4;y++) tab[3-y][x]=tabE[x][y];
                
    }
   
    
}
