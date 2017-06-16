package preparedstatementdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {

    public static void main(String[] args) throws Exception{
        try(
                Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@","hr","hr");
                PreparedStatement ps = con.prepareStatement("select first_name from employees");
        ){
            ResultSet set = ps.executeQuery();
            while(set.next()){
                System.out.println(set.getString(1));
            }
        }
    }

}
