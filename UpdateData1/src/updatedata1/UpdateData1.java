package updatedata1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateData1 {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
        System.out.println("Connected");
        Statement st = con.createStatement();
        int count = st.executeUpdate("update employees set salary=100 where employee_id=873687");
        if (count == 0) {
            System.out.println("Success");//I know that there is no such employee
        }else{
            System.out.println("Failure");
        }
    }

}
