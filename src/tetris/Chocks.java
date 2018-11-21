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
public class Chocks {
    final static boolean [][][] CHOCKS = 
    {
        {
            {false, false, false, false},  //....
            {true, true, true, false},     //***.
            {false, false, true, false},   //..*.
            {false, false, false, false}   //....
         },
        
         {
            {false, false, false, false},  //....
            {true, true, true, false},     //***.
            {false, true, false, false},   //.*..
            {false, false, false, false}   //....
         }
    };
}
