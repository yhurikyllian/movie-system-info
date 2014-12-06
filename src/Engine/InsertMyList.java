/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sora
 */
public class InsertMyList {
    private String message;
    Connection con = new Connection();
    
    public InsertMyList(){
        
    }
    
    public String insertToDb(String id, String key){
        try {
            message = "This anime has been inputed into your list.";
            String query = "UPDATE mylist SET list = CONCAT(list,'" + key + ",') WHERE id = '" + id + "';";
            con.getCon().setAutoCommit(false);
            con.task(query);
            try {
                
                con.getPst().executeUpdate();
                con.getCon().commit();

                
            } catch (SQLException ex) {                
                if (con.getCon() != null) {
                    con.getCon().rollback();
                }

                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(InsertMyList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    } 
}
