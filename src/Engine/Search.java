/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import Interface.MainDisplay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Sora
 */
public class Search {
    Data data = new Data();
    Engine.Connection con = new Engine.Connection();
    Engine.InformationData id;
    Interface.Information info;
    String[] value = null;
    //private Interface.Information info = new Interface.Information;
    
    public Search(JFrame frame, String query, String user){
        
        try {
            con.task(query);
            boolean isResult = con.getPst().execute();
            
            do{
                con.initRs();
                while(con.getRs().next()){
                    id = new Engine.InformationData(con.getRs().getString(1), con.getRs().getString(2), con.getRs().getString(3), con.getRs().getString(4), con.getRs().getString(5), con.getRs().getString(6), con.getRs().getString(7), con.getRs().getString(8));
                    
                }
                isResult = con.getPst().getMoreResults();
            } while(isResult);
            
            setinfo(frame, id, info, user);
            
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.closeConnection();
        }
    }
    
    public Search(JTable table, String find, String text){
        try {
            String query = "SELECT code, title, episodes, year, producers, genre, rating FROM list WHERE " + find + " LIKE " + "'%" + text + "%'" + " ;";
            con.task(query);
            boolean isResult = con.getPst().execute();
            
            do {                
                con.initRs();
                emptyTable(table);

                while (con.getRs().next()) {
                    if(find.equalsIgnoreCase("genre")){
                        update(con.getRs(), table, false);
                    } else{
                        update(con.getRs(), table, false);
                    }
                }

                isResult = con.getPst().getMoreResults();
            } while (isResult);


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Search.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            con.closeConnection();
        }

    }
    
    public Search(boolean login, JTable table, String user){
        if(login){
            try {
                String query = "SELECT * FROM mylist WHERE id = '" + user + "';";
                con.task(query);
                //System.out.println("user :" + user);
                boolean isResult = con.getPst().execute();

                do {                
                    con.initRs();                    
                    con.getRs().next();
                    String[] keys = con.getRs().getString(2).split(",");
                    filterTitle(table, keys);
                    break;
                } while (isResult);


            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Search.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

            } finally {
                con.closeConnection();
            }
        }
    }
    
    public Search(JTable table){
        try {
            String query = "SELECT * FROM list ORDER BY rating";
            con.task(query);
            
            boolean isResult = con.getPst().execute();
            
            do {
                con.initRs();
                con.getRs().next();
                
                while (con.getRs().next()) {
                    update(con.getRs(), table, false);              
                }
                isResult = con.getPst().getMoreResults();
            } while (isResult);
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    private void update(ResultSet rs, JTable table, boolean genre){
        int row = data.getRow();
        int column = data.getColumn();
       for(int i=0; i<table.getColumnCount(); i++){
           
           
           try {
               System.out.println("row : " + data.getRow() + "col : " + data.getColumn());
               if(genre == false){
                   table.setValueAt(rs.getString(i+1), row, column);
               } else{
                   table.setValueAt(rs.getString(i+1), data.getRow(), data.getColumn());
               }
               
               
               data.setColumn(column++);//column++;
               
               if(i == table.getColumnCount() - 1){
                   //if(genre == false){
                       data.setColumn(0);//column = 0;
                       //System.out.println("col baru :" + data.getColumn());
                       data.setRow(data.getRow() + 1);//row++;
                       //System.out.println("row baru :" + data.getRow());
                   //}     
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
           } 

        }
    }
    
    private void emptyTable(JTable table){
        for(int i=0; i<table.getRowCount(); i++){
            for(int j=0; j<table.getColumnCount(); j++){
                table.setValueAt(null, i, j);
                
            }
        }
       
    }
    
    private void filterTitle(JTable table, String[] keys){
        emptyTable(table);
        try {
            
            
            for(int i=0; i<keys.length; i++){
                String query = "SELECT * FROM list WHERE code = '" + keys[i] + "';";
                con.task(query);
                boolean isResult = con.getPst().execute();
                
                do {                
                    con.initRs();
                    while(con.getRs().next()){
                        update(con.getRs(), table, false);
                    }
                    //update(con.getRs(), table, false);
                        
                    isResult = con.getPst().getMoreResults();
                } while (isResult);
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
                    con.closeConnection();
        }
                
    }    
        
    public void setinfo(JFrame frame, InformationData id, Interface.Information info, String user){
        info = new Interface.Information(frame, true);
        info.setUser(user);
        info.setInterface(id);
        info.setVisible(true);
        
        
    }

    
    
}
