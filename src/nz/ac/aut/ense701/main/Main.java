package nz.ac.aut.ense701.main;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Menu;
import nz.ac.aut.ense701.gui.KiwiCountUI;

/**
 * Kiwi Count Project
 * 
 * @author AS
 * @version 2011
 */
public class Main 
{
    public static Mixer mixer;
    public static Clip clip;
    /**
     * Main method of Kiwi Count.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.print("asdfasf");
        Menu menu = new Menu();
        menu.Menu();
        
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfos[0]);
        
        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try{
            clip = (Clip)mixer.getLine(dataInfo);
        }catch(LineUnavailableException e){
            e.printStackTrace();
        }
        
        try{
            URL soundURL = sun.applet.Main.class.getResource("/Music/menusound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(audioStream);
        }catch(LineUnavailableException e){
            e.printStackTrace();
        }catch(UnsupportedAudioFileException e){
           e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        clip.start();
        
        do{
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }while(clip.isActive());
    }
}
