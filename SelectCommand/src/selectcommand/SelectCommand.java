package selectcommand;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectCommand {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
        System.out.println("Connected");
        Statement st = con.createStatement();
        ResultSet set = st.executeQuery("select first_name from employees order by 1");
        System.out.println("************");
        while (set.next()) {
            System.out.println(set.getString(1));
        }
        System.out.println("************");

    }

}
