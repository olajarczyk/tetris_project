/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;


/**
 *
 * @author Aleksandra
 */
public class Tetris extends JPanel implements Runnable {

   static Tetris tetris = new Tetris();
   static JFrame okno= new JFrame("Tetris");
   static Board board = new Board();
   static Thread thread = new Thread(tetris);
   
   boolean start = false;
   short op = 50;
   
   Tetris() 
   {
      super();
      setBackground(Color.DARK_GRAY);
      setLayout(null);
      start= true;
   }
   
   @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.add(tetris);
        okno.setSize(600,600);;
        okno.setLocationRelativeTo(null);
        okno.setResizable(false);
        board.setLocation(10,10); tetris.add(board);
        okno.setVisible(true);
        thread.start();
        
    }

    @Override
    public void run() {
        long wait, time_start, time_round;
        
         while(start){
             time_start = System.nanoTime();
             board.run();
             time_round = System.nanoTime()- time_start;
             wait = op - time_round/1000000;
             if(wait<=0) wait = 3;
             try {thread.sleep(wait);} catch (InterruptedException e) {e.printStackTrace();}
             System.out.println(op+" > "+wait);
             
             
         }
             
    }
    
}
