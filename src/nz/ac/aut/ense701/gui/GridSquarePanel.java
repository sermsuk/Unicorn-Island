package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        initComponents();
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        
        Color      color;
        ImageIcon image;
        
        switch ( terrain )
        {
            case SAND     : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/sand.jpg")); break;
            case FOREST   : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass.jpg")); break;
            case WETLAND  : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/forest.jpg")); break;
            case SCRUB    : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrub.jpg")); break;
            case WATER    : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/water.jpg")); break;
            case BRICK    : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/brick.jpg")); break;
            default       : image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/gray.jpg")); break; 
        }
        
        if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            lblText.setText(game.getOccupantStringRepresentation(row,column));
            lblText.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
            lblText.setVerticalTextPosition((int) CENTER_ALIGNMENT);
            
            setVisible(true);
            // Set the colour. 
            
            //Kiwifruit
            if( row == 6 && column == 2) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/brick2.jpg"));
            }
            
            if( row == 0 && column == 7) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrubk.jpg"));
            }
            
            if( row == 7 && column == 0 || row == 7 && column == 7 || row == 6 && column == 6 || row == 8 && column == 3 || row == 9 && column == 3 || row == 9 && column == 4 || row == 9 && column == 6) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grassk.jpg"));
            }
            
            if( row == 2 && column == 8) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrubk.jpg"));
            }
            //Trap
            if("T".equals(game.getOccupantStringRepresentation(row, column))){
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/trap.jpg"));
                lblText.setIcon(image);
            }
            //Food
            if(game.getOccupantStringRepresentation(row, column) == "apple" ) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scruba.jpg"));
            }
            //if( row == 6 && column == 7) {
            //    image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scruba.jpg"));
            //}
            
            if( row == 5 && column == 4) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grassm.jpg"));
            }
            
            if( row == 2 && column == 4) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrubs.jpg"));
            }
            
            if( row == 8 && column == 2) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grasso.jpg"));
            }
            //Predator
            if( row == 2 && column == 6) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrubr.jpg"));
                if(game.getOccupantStringRepresentation(row, column) == "") {
                    image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrub.jpg"));
                }
            }
            
            if( row == 9 && column == 7 ||row == 5 && column == 2 ) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grassp.jpg"));
                if(game.getOccupantStringRepresentation(row, column) == "") {
                    image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass.jpg"));
                }
            }
            
            if( row == 3 && column == 4 || row == 6 && column == 4 ) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grassr.jpg"));
                if(game.getOccupantStringRepresentation(row, column) == "") {
                    image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass.jpg"));
                }
            }
            
            if( row == 4 && column == 1) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/waters.jpg"));
                if(game.getOccupantStringRepresentation(row, column) == "") {
                    image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/water.jpg"));
                }
            }
            //Mystical Creature
            if( row == 7 && column == 3) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/brickf.jpg"));
            }
            
            if( row == 4 && column == 0) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/sandph.jpg"));
            }
            
            if( row == 0 && column == 3) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/sandm.jpg"));
            }
            
            if( row == 4 && column == 6 || row == 6 && column == 8) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/scrubp.jpg"));
            }
            
            if( row == 8 && column == 8) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grassd.jpg"));
            }
            
            
            //Hazard
            if( squareExplored && row == 2 && column == 2) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass2.jpg"));
                lblText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                lblText.setVerticalAlignment((int) CENTER_ALIGNMENT);
                setVisible(true);
            }
            
            if( squareExplored && row == 3 && column == 5 || squareExplored && row == 7 && column == 4 || squareExplored && row == 6 && column == 5 || squareExplored && row == 7 && column == 6) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass2.jpg"));
                lblText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                lblText.setVerticalAlignment((int) CENTER_ALIGNMENT);
                setVisible(true);
            }
            
            if( squareExplored && row == 1 && column == 4) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass2.jpg"));
                lblText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                lblText.setVerticalAlignment((int) CENTER_ALIGNMENT);
                setVisible(true);
            }
            
            if( squareExplored && row == 5 && column == 0) {
                image = new ImageIcon(getClass().getResource("/nz/ac/aut/ense701/image/grass2.jpg"));
                lblText.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                lblText.setVerticalAlignment((int) CENTER_ALIGNMENT);
                setVisible(true);
            }
            
            if ( squareVisible && !squareExplored ) 
            {

            }
            lblText.setIcon(image);
            
            // set border colour according to 
            // whether the player is in the grid square or not
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        }
        else
        {
            lblText.setText("");
            lblText.setIcon(null);
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
