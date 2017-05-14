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
    Menu menu;
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
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
        
        
        //My Profile Button
        
        if(mx >= 210 && mx <= 430){
            if(my >= 180 && my <= 210){
                //My profile button pressed
              menu.state = GameState.PLAYERPROFILE;
            }
        }

        //Highscore Button
        if(mx >= 210 && mx <= 430){
            if(my >= 230 && my <= 250){
                //Highscore button pressed
                menu.state = GameState.HIGHSCORE;
            }
        }
        
        //Description Button
        if(mx >= 210 && mx <= 430){
            if(my >= 280 && my <= 310){
                //Description button pressed
                menu.state = GameState.DESCRIPTION;
            }
        }
        
        //Exit Button
        if(mx >= 270 && mx <= 355){
            if(my >= 330 && my <= 360){
                //Exit button pressed
                System.exit(0);
            }
        }
        
        //Back Button
        if(mx >= 500 && mx <= 585){
            if(my >= 365 && my <= 395){
                //Highscore button pressed
                menu.state = GameState.MENU;
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
