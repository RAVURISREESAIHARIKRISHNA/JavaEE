package updatedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

public class UpdateData {

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
            System.out.println("Connected");
        } catch (SQLTimeoutException e) {
            System.out.println("Connection SQLTimeoutException");
        } catch (SQLException e) {
            System.out.println("Connection SQLException");
        }
        Statement st = null;
        try {
            st = con.createStatement();

        } catch (SQLException e) {
            System.out.println("Statement creation SQLException");
        }int count=0;
        try {
            count = st.executeUpdate("update employees set salary=salary*1.1 where employee_id=1111");
        } catch (SQLException e) {
            System.out.println("SQLEXception");
        }
        if (count == 0) {//I know that there is no such employee
            System.out.println("SUCCESS");
        }else{
            System.out.println("FAIL");
        }
        try{
            con.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Closing problem");
        }
    }

}
