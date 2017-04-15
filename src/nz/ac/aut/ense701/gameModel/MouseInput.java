/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import nz.ac.aut.ense701.gui.KiwiCountUI;
import nz.ac.aut.ense701.gameModel.Menu;

/**
 *
 * @author aoshi
 */
public class MouseInput implements MouseListener{
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        /*public Rectangle playBut = new Rectangle(270, 130, 85, 30);
        public Rectangle hSBut = new Rectangle(210, 180, 220, 30);
        public Rectangle desBut = new Rectangle(210, 230, 220, 30);
        public Rectangle exitBut = new Rectangle(270, 280, 85, 30);*/
        
        //Play Button
        if(mx >= 270 && mx <= 355){
            if(my >= 130 && my <= 160){
                //Play button pressed
                // create the game object
                final Game game = new Game();
                // create the GUI for the game
                final KiwiCountUI  gui  = new KiwiCountUI(game);
                // make the GUI visible
                java.awt.EventQueue.invokeLater(new Runnable() 
                {
                    @Override
                    public void run() 
                    {
                        gui.setVisible(true);
                    }
                });
            }
        }
        
        //exit Button
        if(mx >= 270 && mx <= 355){
            if(my >= 280 && my <= 310){
                //exit button pressed
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
