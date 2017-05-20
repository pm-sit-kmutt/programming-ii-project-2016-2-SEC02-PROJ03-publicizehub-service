/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.connectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jaja
 */
public class ConnectionBuilder {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://10.4.56.11:3306/publicService?characterEncoding=UTF-8", "public-3", "public");
            System.out.println("yes");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}