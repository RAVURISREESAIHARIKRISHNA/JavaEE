package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDemo{
    public static void main(String args[]){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:oracle:oci8:@","hr","hr");
        }catch(java.sql.SQLTimeoutException e){
            System.out.println("Connection SQLTimeoutException");
        }
        catch(java.sql.SQLException e){
            System.out.println("Connection SQLException");
        }
        System.out.println("Connected");
        try{
            con.close();
        }catch(java.sql.SQLException e){
            System.out.println("Closing SQL Exception");
        }
    }
}
