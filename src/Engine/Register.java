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
public class Register {
    Connection con = new Connection();
    private boolean correct = false;
    String message = "";
    
    public Register(JLabel label, String user, String pass, String retypePass, boolean agreement){
        label.setText(checkValue(user, pass, retypePass, agreement));
        label.setText(insertToDb(user, pass));
    }
    
    private String checkValue(String user, String pass, String retypePass, boolean agreement){
        
        if(user.equals("") || pass.equals("") || retypePass.equals("")){
            return message = "Please fill all information! ";
        } else if(!pass.equals(retypePass)){
            return message = "Password doesn't match ";
        } else if(agreement == false){
            return message = "Please check the agreement! ";
        } 
        
        if(!user.equals("") && pass.equals(retypePass) && agreement==true){
            correct = true;
        } else{
            correct = false;
        }
        
        return message;
    }
    
    private String insertToDb(String user, String pass){
        
        if(correct){
            message = "User " + user + " has been inputed. Please log in to activate MyList feature.";
                String query = "INSERT INTO accounts (id, pass) VALUES ('" + user + "', '" + pass + "');";
                con.task(query);
            try {
                
                con.getPst().executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return message;
    }
}
