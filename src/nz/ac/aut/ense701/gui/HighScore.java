/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

/**
 *
 * @author Bonaliza
 */
public class HighScore extends javax.swing.JPanel {

    MainFrame main;
    /**
     * Creates new form HighScore
     */
    public HighScore(MainFrame frame) {
        this.main = frame;
        this.setBounds(0, 0, 600, 410);
        initComponents();
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
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hscoreHead.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        hscoreHead.setForeground(new java.awt.Color(0, 0, 0));
        hscoreHead.setText("Highscore");
        add(hscoreHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 37, -1, 41));

        backBut.setText("Back");
        backBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButActionPerformed(evt);
            }
        });
        add(backBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Other_menu.jpg"))); // NOI18N
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
    // End of variables declaration//GEN-END:variables
}