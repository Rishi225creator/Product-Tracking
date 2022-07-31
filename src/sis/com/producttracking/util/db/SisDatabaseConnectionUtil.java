package sis.com.producttracking.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SisDatabaseConnectionUtil {
	private SisDatabaseConnectionUtil() {}//no one can create object
	
   public static final String DRIVER_CLASS_NAME="oracle.jdbc.driver.OracleDriver";  
   public static final String DB_USER_NAME="system";  
   public static final String DB_PASSWORD="root";
   public static final String JDBC_ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
   
   private static boolean isDriverLoaded;
   
   //load driver one time  //static block 1 time execute at class loading 
   static{
	   try {
		Class.forName(DRIVER_CLASS_NAME);
		 System.out.println("driver   loaded.." );
		isDriverLoaded =true;
	} catch (ClassNotFoundException e) {
		 System.out.println("driver not loaded.." + e.getMessage());
	}
   }
   
   
   
   
	
	
	//provide method for get connection
   
   public static Connection getConnection() throws SQLException{
	   Connection  con  = null;
	   if(isDriverLoaded){
			con  = DriverManager.getConnection(JDBC_ORACLE_URL,DB_USER_NAME,DB_PASSWORD);
	   }
	   return con;
   }
   
   
   public static void closeConnection(Connection con)throws SQLException{
	   if(con!=null){
					con.close();
	   }
	   
   }
   
	//provide method for close connection
	
}
