package batchupdatedemo;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BatchUpdateDemo {

    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:oracle:oci8:@", "hr", "hr");
             Statement st = con.createStatement();  ){
        con.setAutoCommit(false);int a[]={0};
        try{
            st.addBatch("update employees set salary = 1000 where employee_id>1100");
            st.addBatch("update employees set salary = 78798 where employee_id>2200");
             a= st.executeBatch();//Execute Batch Commands
            con.commit();
        }catch(BatchUpdateException e){
            System.out.println("BatchUpdateException");
            con.rollback();
        }for(int i : a){
            System.out.println(i);
        }
        }

        }

    }
