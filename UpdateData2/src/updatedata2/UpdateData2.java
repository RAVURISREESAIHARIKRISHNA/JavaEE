package updatedata2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData2 {

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int emp_id,salary;
        emp_id = s.nextInt();
        System.out.println("Enter Salary");
        salary = s.nextInt();
        Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr","hr");
        System.out.println("Conneccted");
        Statement st = con.createStatement();
        int count;
        count=st.executeUpdate("update employees set salary="+salary+" where employee_id="+emp_id);
        System.out.println(count);
    }

}
