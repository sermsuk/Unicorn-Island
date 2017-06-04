/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import Records.GamePlayerRecord;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.ScoringSystem;

/**
 *
 * @author Bonaliza
 */
public class HighScore extends javax.swing.JPanel {
    Game game;
    MainFrame main;
    /**
     * Creates new form HighScore
     */
    public HighScore(MainFrame frame) {
        this.main = frame;
        game  = new Game();
        this.setBounds(0, 0, 600, 410);
        initComponents();
        loadScore();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hscoreHead = new javax.swing.JLabel();
        backBut = new javax.swing.JButton();
        lblPlyr1 = new javax.swing.JLabel();
        lblPlyr2 = new javax.swing.JLabel();
        lblPlyr3 = new javax.swing.JLabel();
        scorePlyr1 = new javax.swing.JLabel();
        scorePlyr2 = new javax.swing.JLabel();
        scorePlyr3 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hscoreHead.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        hscoreHead.setText("Highscore");
        add(hscoreHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 37, -1, 41));

        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });
        add(backBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        lblPlyr1.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        lblPlyr1.setText("Player 1");
        add(lblPlyr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, 30));

        lblPlyr2.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        lblPlyr2.setText("Player 2");
        add(lblPlyr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 150, 30));

        lblPlyr3.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        lblPlyr3.setText("Player 3");
        add(lblPlyr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 150, 30));

        scorePlyr1.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        scorePlyr1.setText("Score 1");
        add(scorePlyr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 90, 30));

        scorePlyr2.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        scorePlyr2.setText("Score 1");
        add(scorePlyr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 90, 30));

        scorePlyr3.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        scorePlyr3.setText("Score 1");
        add(scorePlyr3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 90, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/background2_1.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void backButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButActionPerformed
        // TODO add your handling code here:
        main.remove(this);
        main.add(main.menu);
        main.panelRedraw();
    }//GEN-LAST:event_backButActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBut;
    private javax.swing.JLabel background;
    private javax.swing.JLabel hscoreHead;
    private javax.swing.JLabel lblPlyr1;
    private javax.swing.JLabel lblPlyr2;
    private javax.swing.JLabel lblPlyr3;
    private javax.swing.JLabel scorePlyr1;
    private javax.swing.JLabel scorePlyr2;
    private javax.swing.JLabel scorePlyr3;
    // End of variables declaration//GEN-END:variables

    private void loadScore() {
        ArrayList<ScoringSystem> list = main.playerRecord.getPlayRecords();
        lblPlyr3.setText("John");
        scorePlyr3.setText("5");
        lblPlyr2.setText("Hazel");
        scorePlyr2.setText("5");
        lblPlyr1.setText(list.get(0).getPlayer());
        scorePlyr1.setText(String.valueOf(list.get(0).getHighScore()));
    }
}
