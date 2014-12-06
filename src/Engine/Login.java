/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Sora
 */
public class Login {
    Engine.Connection con = new Engine.Connection();
    private boolean match = false;
    private String user;
    
    public Login(){
        
    }
    public Login(String user, String pass){
        try {
            //String query = "SELECT id, pass FROM accounts WHERE " + user + " LIKE " + "'%" + text + "%'" + " ;";
            
            String query = "SELECT id, pass from accounts WHERE id='" + user + "' && pass='" + pass + "'";
            con.task(query);
            con.getPst().executeQuery();
            con.initRs();
            
            if(!con.getRs().next()){
                //status.setText("User name and Password doesn't match. Please try again!");
                setStatus(false);
            } else {
                setStatus(true);
                setUser(user);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setStatus(boolean match){
        this.match = match;
    }
    
    public boolean getStatus(){
        return match;
    }
    
    private void setUser(String user){
        this.user = user;
    }
    
    public String getUser(){
        return user;
    }
    
}
