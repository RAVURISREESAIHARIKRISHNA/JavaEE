package cachedrowsetdemo;

import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo{
    public static void main(String[] args) throws Exception {
        CachedRowSet rset = new OracleCachedRowSet();
        rset.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        rset.setUsername("hr");
        rset.setPassword("hr");
        rset.setCommand("select employee_id,first_name from employees order by 1");
        rset.execute();
        
        while(rset.next()){
            System.out.printf("%-15s %-15s\n",rset.getString(1),rset.getString(2));
        }
    }
}