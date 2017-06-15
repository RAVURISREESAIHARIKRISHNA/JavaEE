package connection1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.Scanner;

public class Connection1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Username");
        String username, password;
        username = s.nextLine();System.out.println("Enter Password");
        password = s.nextLine();
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:oci8:@","hr","hr");
            System.out.println("Connected");
        } catch (SQLTimeoutException e) {
            System.out.println("Connection SQLTimeout Exception");
        } catch (SQLException e) {
            System.out.println("Connection SQLException");
        }
        //System.out.println("Connected");
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Closing SQLException");
        }
    }

}
