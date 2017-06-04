/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.PlayerRecord;
import nz.ac.aut.ense701.gameModel.ScoringSystem;

/**
 *
 * @author Bonaliza
 */
public class GamePlayerRecord extends DBrecords implements PlayerRecord{

    ResultSet resSet = null;
    Statement stmt = null;
    ScoringSystem score = new ScoringSystem();
    ArrayList<String> player ;
    ArrayList<Integer> pscore;
    Game game = new Game();
    
    public GamePlayerRecord() {
        checkTable();
    }
    
    private void checkTable() {
        openConnection();
        System.out.println("Checking database ...");
        
        try {
            DatabaseMetaData dbmd = conn.getMetaData();

            ResultSet rs = dbmd.getTables(null, "ADMIN_ADMIN" ,"GAME_DATA", null);

            if(!rs.next()) {
                createTable();
            }
            
        conn.close();
       
        } catch (SQLException ex) {
            System.out.println("Sometimes database does not load");
        }
        
        System.out.println("Database is Ready!");
    }
    private void createTable() {
        try {
            System.out.println("Creating table...");
            openConnection();
            stmt = conn.createStatement();
           
            String createTableQuery = "CREATE TABLE GAME_DATA(playerName VARCHAR(50), playerScore int)";
            
            stmt.executeUpdate(createTableQuery);
            
            String insertQuery = "INSERT INTO GAME_DATA(playerName, playerScore) VALUES ('Zel', 10), ('John', 5), ('Cha', 5)";

            System.out.println("Database if being filled with sample data...");
            
            stmt.executeLargeUpdate(insertQuery);
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GamePlayerRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Database Interaction : Table ready!");
    }
    
    public ArrayList<ScoringSystem> getPlayRecords() {
        ArrayList<ScoringSystem> playList = new ArrayList<ScoringSystem>();
        
        try {
            openConnection();
            
            stmt = conn.createStatement();
            
            resSet = stmt.executeQuery("SELECT * FROM GAME_DATA ORDER BY playerScore ASC");
            
            while(resSet.next()) {
                score.setPlayer(resSet.getString("playerName"));
                score.setHighScore(resSet.getInt("playerScore"));
                playList.add(score);
            }
            
            resSet.close();
            conn.close();
            
        } catch(SQLException ex) {
            Logger.getLogger(GamePlayerRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return playList;
    }
    

    @Override
    public void InsertUserDetails(ScoringSystem score) {
        try {
        openConnection();
        
        stmt = conn.createStatement();
        
        String sql = "INSERT INTO GAME_DATA(playerName, playerScore) VALUES ('"+score.getPlayer()+"', "+score.getCurrentScore()+")";
            
        stmt.executeUpdate(sql);
        
        } catch (SQLException ex) {
            Logger.getLogger(GamePlayerRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
