package transactionmanagementdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TransactionManagementDemo {
    public static void main(String[] args) throws Exception {
        try(Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
            PreparedStatement ps = con.prepareStatement("update employees set salary=? where employee_id=?");
                ){
            Scanner s =  new Scanner(System.in);
            System.out.println("Enter EmployeeId");
            int emp_id = s.nextInt();
            System.out.println("Enter Salary");
            int salary = s.nextInt();
            ps.setInt(1, salary);
            ps.setInt(2, emp_id);
            con.setAutoCommit(false);
            int row=0 ;try{
                row= ps.executeUpdate();
                con.commit();
            }catch(Exception e){
                con.rollback();
            }System.out.println(row);
        }
    }
    
}
