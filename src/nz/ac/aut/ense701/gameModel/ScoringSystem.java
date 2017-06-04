/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

/**
 *
 * @author Bonaliza
 */

public class ScoringSystem {    
    
    //initialize variables
    private int highScore;    
    private int currentScore;

    
    //default constructor
    public ScoringSystem() {
        //default constructor
        this.highScore = 0;
        this.currentScore = 0;
    }
    
    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
    
}
