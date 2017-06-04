package nz.ac.aut.ense701.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import nz.ac.aut.ense701.gameModel.ScoringSystem;
import nz.ac.aut.ense701.gui.KiwiCountUI;
import nz.ac.aut.ense701.gui.MainFrame;

/**
 * Kiwi Count Project
 * 
 * @author AS
 * @version 2011
 */
public class Main 
{
    /**
     * Main method of Kiwi Count.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final MainFrame gui  = new MainFrame();
        boolean musicLoop = true;
        ScoringSystem score = new ScoringSystem();
        
        System.out.print(score.getHighScore());
        // make the GUI visible
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                gui.setVisible(true);
            }
        });

        //Plays and loops the background music
        File bgMusic = new File("sounds/bg_music2.wav");
        while(musicLoop == true){
            musicPlayer(bgMusic);
        }
    }
    
    static void musicPlayer(File music){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(music));
            clip.start();
            
            Thread.sleep(clip.getMicrosecondLength()/1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
