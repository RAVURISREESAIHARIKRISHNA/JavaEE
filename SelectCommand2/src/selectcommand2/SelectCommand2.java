package selectcommand2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectCommand2 {

    public static void main(String[] args)throws Exception {
        String job_id;
        Scanner s = new Scanner(System.in);System.out.println("Enter jobid");
        job_id = (s.nextLine()).toUpperCase();
        Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@","hr","hr");
        Statement st = con.createStatement();
        ResultSet set = st.executeQuery("select first_name from employees where job_id='"+job_id+"'");
        System.out.println("*******");while(set.next()){
            System.out.println(set.getString(1));
        }System.out.println("*******");
    }

}
