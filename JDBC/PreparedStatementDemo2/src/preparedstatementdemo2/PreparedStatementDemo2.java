package preparedstatementdemo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatementDemo2 {

    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
                PreparedStatement ps = con.prepareStatement("update employees set first_name=? where employee_id=?");) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter EmployeeID");
            int emp_id = s.nextInt();
            s.nextLine();
            System.out.println("Enter First Name");
            String f_name = s.nextLine();
            ps.setString(1, f_name);
            ps.setInt(2, emp_id);
            int row = ps.executeUpdate();
            System.out.println(row);
        }
    }
}
