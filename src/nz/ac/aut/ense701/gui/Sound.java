/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import nz.ac.aut.ense701.gameModel.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author Bonaliza
 */
public class Sound {
    
    URL url = Sound.class.getResource("LostJungle.wav");
    AudioClip clip = Applet.newAudioClip(url);
    
    public Sound() {
       clip.play();
    }
    
}
