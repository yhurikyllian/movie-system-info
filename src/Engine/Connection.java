/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sora
 */
public class Connection {
    public java.sql.Connection con = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;
        
    public Connection() {
        //String cs = "jdbc:mysql://localhost:3306/anime?allowMultiQueries=true";
        String cs = "jdbc:mysql://sql13.main-hosting.eu:3306/u250702723_anime?allowMultiQueries=true";
        String user = "u250702723_anime";
        String password = "anime123";
        
        try {
            con = DriverManager.getConnection(cs, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public PreparedStatement getPst(){
        return pst;
    }
    
    public ResultSet getRs(){
        return rs;
    }
    
    public java.sql.Connection getCon(){
        return con;
    }
    
    public void initRs(){
        try {
            //rs = pst.getResultSet();
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PreparedStatement task(String query){
        try {
            pst = con.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pst;
    }
    
    public void closeConnection(){
        try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

                Logger lgr = Logger.getLogger(Search.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
    }
}
