//Juliet B.

import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.text.*;


class AddingStudents {

	void main(String args[]) 
				throws SQLException
				{

		    
		    String uid = "T13";

		   
		    String pword = "Spring2022T13";

		    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";


		    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		    
		    Connection conn =
		      DriverManager.getConnection (url, uid, pword);


		    Statement stmt = conn.createStatement ();
		
		    String SqlCommand = "";
		    
		    
		    System.out.print("\nEnter Nnumber of student to add to course/section: N");
		    System.out.println();
		    int NNumber = getInt();

		   // int v = 1;

		   // while (true) {
		      // read vendor code
		    //  System.out.print("Student N Number (enter 0 for exit): \n");
		    //  v = getInt(); 
		      
		      
		      
		      
		      System.out.print("Enter Course Number to put student in: \n");
		      
		      	String coursenumber = getString();
		      
		      System.out.print("Enter Section Number to put student in: \n");
		    	  
		    	int sectionnumber = getInt();
		    	
		    	
		    	Statement put = conn.createStatement();
		    	SqlCommand = "INSERT INTO ISIN " + "VALUES ('" + NNumber + "','" + coursenumber + "'," + sectionnumber + ",null)";
		        put.executeUpdate(SqlCommand);
		        
		        System.out.println("\nStudent added!");

		    	
			    put.close();
				conn.close();
		
	
	}
	//}

	public static String getString() {
		try {
		    StringBuffer buffer = new StringBuffer();
		    int c = System.in.read();
		    while (c != '\n' && c != -1) {
			  buffer.append((char)c);
			  c = System.in.read();
		    }
		    return buffer.toString().trim();
		}
		catch (IOException e){return "";}
	    }

	  public static int getInt() 

	  {
	      String s= getString();
	      return Integer.parseInt(s);
	  }
}