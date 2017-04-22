/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.SQLMethods;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import publicizehub_service.connectionBuilder.ConnectionBuilder;
/**
 *
 * @author sangu
 */
public class SQLMethods {
    private static Connection con = ConnectionBuilder.getConnection();
    private static PreparedStatement ps;
    
    public SQLMethods() {
    }
    
    public static ResultSet selectFromProject(int id) throws SQLException{
        ps = con.prepareStatement("select * from project where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public static ResultSet selectFromRationale(int projectId) throws SQLException{
        ps = con.prepareStatement("select * from rationale where projectId = ?");
        ps.setInt(1, projectId);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    
    
    public static void closePs(){
        try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
