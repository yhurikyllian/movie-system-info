/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Practices;

import java.sql.Connection;
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
public class RetrieveDb {
    
    private void retrieve(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/anime";
        String user = "root";
        String password = "";

        try {
            
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("SELECT * FROM listanime");
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RetrieveDb.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {

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
                Logger lgr = Logger.getLogger(RetrieveDb.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
    
    private void retrieveMultipleStat(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String cs = "jdbc:mysql://localhost:3306/anime?allowMultiQueries=true";
        String user = "root";
        String password = "";

        try {

            con = DriverManager.getConnection(cs, user, password);
            String text = "'%ad%'";
            String text2 = "1";
            String query = "SELECT code, title, episodes FROM list WHERE code LIKE " + text2 + " ;";
            

            pst = con.prepareStatement(query);
            //pst.setString(1, text);
            
            boolean isResult = pst.execute();

            do {
                rs = pst.getResultSet();
                int i=0;
                while (rs.next()) {
                    System.out.print(rs.getString(1));
                    System.out.print(": ");
                    System.out.println(rs.getString(2));
                    System.out.println(" : " + rs.getString(3));
                    System.out.println("rs : " + i++);
                }

                isResult = pst.getMoreResults();
            } while (isResult);


        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(RetrieveDb.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

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

                Logger lgr = Logger.getLogger(RetrieveDb.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

    }
    
    public static void main(String[] args) {

        new RetrieveDb().retrieveMultipleStat();
    }

}
