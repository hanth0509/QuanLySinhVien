package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
     public static Connection openConnection() throws Exception{
    	 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
 		 String url="jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=false;trustServerCertificate=true";
         String user="sa";
         String pass="123";
         Class.forName(driverName);
         Connection con= DriverManager.getConnection(url,user,pass);
         return con;
     }
}
