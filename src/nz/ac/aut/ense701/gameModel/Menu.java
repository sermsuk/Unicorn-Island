/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aoshi
 */
public class Menu extends Canvas implements Runnable{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 410;
    private final String TITLE = "Unicorn Island";
    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage background = null;
    private BufferedImage otherMenuBack = null;
    private BufferedImage desTab = null;
    JFrame frame = new JFrame(TITLE);
    JLabel desLabel = new JLabel();
    Menu menu;
    
    public static GameState state;
    
    //Menu buttons
    public Rectangle playBut = new Rectangle(270, 130, 85, 30);
    public Rectangle hSBut = new Rectangle(210, 180, 220, 30);
    public Rectangle desBut = new Rectangle(210, 230, 220, 30);
    public Rectangle exitBut = new Rectangle(270, 280, 85, 30);
    
    public void Menu(){
        menu = new Menu();
        
        if(state != GameState.DESCRIPTION || state != GameState.HIGHSCORE){
            state = GameState.MENU;
        }
        
        //Setting the size of the JFrame
        menu.setPreferredSize(new Dimension(WIDTH , HEIGHT));
        menu.setMaximumSize(new Dimension(WIDTH , HEIGHT));
        menu.setMinimumSize(new Dimension(WIDTH , HEIGHT));
        
        menu.start();
        
        //JLabel empty = new JLabel("");
        
        desLabel.setLocation(100, 100);
        desLabel.setSize(200, 200);
        desLabel.setVisible(false);
        desLabel.setText("<html>Unicorn Island consists of many mystical creatures"
                + "such as; Fairies, Pegasus, Mermaids, Griffins, Pixies, and more. "
                + "For many years, the Unicorns have been huntered by many preditors"
                + "and forcing them into hiding. Your quest as an adventurer is to"
                + "find and trap these preditors to bring peace back to Unicorn Island</html>");
        
            
        
        
         //Setup for JFrame
        frame.add(desLabel);
        frame.add(menu);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 438);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
           background = loader.loadImage("Home_menu.jpg");
           otherMenuBack = loader.loadImage("Other_menu.jpg");
           desTab = loader.loadImage("des_menu.jpg");
        }catch(IOException e){
        e.printStackTrace();
        }
        this.addMouseListener(new MouseInput());
    }
    
    private synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop(){
        if(!running)
            return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }

    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amoutOfTicks = 60.0;
        double ns = 1000000000 / amoutOfTicks;
        double delta = 0;
        int update = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1 ){
                update++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println(update + " Ticks, Fps " + frames);
                update = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        //Renders everything from here to dispose();
        if(state == GameState.MENU){
            g.drawImage(background, 0, 0, this);
            menuItems(g);
        }else if(state == GameState.HIGHSCORE){
            g.drawImage(otherMenuBack, 0, 0, this);
            highscore(g);
        }else if(state == GameState.DESCRIPTION){
            g.drawImage(desTab, 0, 0, this);
            Description(g);
        }
        
        g.dispose();
        bs.show();
    }
    
    public void menuItems(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
       
        Font font = new Font("ravie", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("Play", playBut.x + 5, playBut.y + 23);
        g2d.draw(playBut);
        g.drawString("Highscores", hSBut.x + 15, hSBut.y + 23);
        g2d.draw(hSBut);
        g.drawString("Description", desBut.x + 5, desBut.y + 23);
        g2d.draw(desBut);
        g.drawString("Exit", exitBut.x + 5, exitBut.y + 23);
        g2d.draw(exitBut);
    }
    
    public void highscore(Graphics g ){
        Graphics2D g2d = (Graphics2D) g;
        state = GameState.HIGHSCORE;
        //draws title
        Font font = new Font("ravie", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("HIGHSCORE", 170, 40);
        
        //Creates and draws back button
        Font font1 = new Font("ravie", Font.BOLD, 20);
        g.setFont(font1);
        Rectangle backBut = new Rectangle(500, 365, 85, 30);
        g.drawString("Back", backBut.x + 5, backBut.y + 23);
        g2d.draw(backBut);
    }
    
    public void Description(Graphics g ){
        Graphics2D g2d = (Graphics2D) g;
        
        //draws title
        Font font = new Font("ravie", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("DESCRIPTION", 170, 40);
        
        //Description text
        String desText1 = "Unicorn Island consists of many mystical creatures such as;";
        String desText2 = "Fairies, Pegasus, Mermaids, Griffins, Pixies, and more.";
        String desText3 = "For many years, the Unicorns have been huntered by many ";
        String desText4 = "preditors and forcing them into hiding. Your quest as ";
        String desText5 = "an adventurer is to find and trap these predators to";
        String desText6 = "bring peace back to Unicorn Island.";
        String desText7 = "Good Luck Adventurer!";
        Font font2 = new Font("arial", Font.PLAIN, 17);
        g.setFont(font2);
        g.drawString(desText1, 80, 100);
        g.drawString(desText2, 80, 120);
        g.drawString(desText3, 80, 140);
        g.drawString(desText4, 80, 160);
        g.drawString(desText5, 80, 180);
        g.drawString(desText6, 80, 200);
        g.drawString(desText7, 80, 220);
        
        //Creates and draws back button
        Font font1 = new Font("ravie", Font.BOLD, 20);
        g.setFont(font1);
        Rectangle backBut = new Rectangle(500, 365, 85, 30);
        g.drawString("Back", backBut.x + 5, backBut.y + 23);
        g2d.draw(backBut);
    }    
}
