package preparedstatementdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementDemo1 {

    public static void main(String[] args)throws Exception {
        try(
            Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr","hr");
            PreparedStatement ps = con.prepareStatement("update employees set salary=? where employee_id=?");
            
        ){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter EmployeeID");
            int emp_id = s.nextInt();
            System.out.println("Enter Salary");
            int salary = s.nextInt();
            ps.setInt(1, salary);
            ps.setInt(2, emp_id);
            int row = ps.executeUpdate();
            System.out.println(row);
        }
    }

}
