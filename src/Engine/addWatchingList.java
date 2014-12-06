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
public class addWatchingList extends Login {
    Connection con = new Connection();
    
    public addWatchingList(JLabel title, JLabel message){
         if(getStatus()==true){
            message.setText("Data has been inputed to MyList.");
             
                String query = "INSERT INTO mylist WHERE id ='" + getUser() + "' (id, key) VALUES ('" + getUser() + "', '" + title + ",');";
                con.task(query);
            try {
                
                con.getPst().executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
