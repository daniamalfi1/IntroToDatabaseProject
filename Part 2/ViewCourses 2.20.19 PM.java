
/**
 * Emily O.
 *
 */

import java.sql.*;
import java.io.*;  

public class ViewCourses { 
	
	void main(String[] args) throws SQLException {
		String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "T13";
        String password = "Spring2022T13";
		Connection conn = DriverManager.getConnection(url, username, password);
			    
			    System.out.println("Please press 1 if you would like to enter a department name and 2 if you would like to enter a department code:");
			    int Action = getInt();
			    
			    
			  //initializes an important variable for sending queries to the server
			    String SqlCommand = "";

			    //Gets the code either from the user or by sending a query to the database
			    String Dcode = null;
			    if (Action == 1) {
			    	
			    	//Gets Department code from database based on department name
			    	System.out.println("Please enter in the department name to see all the offered courses: ");
				    String Dname = getString();
				    
				    Statement ntmt = conn.createStatement();
				    SqlCommand = "SELECT DCODE FROM DEPARTMENT WHERE DNAME = '" + Dname + "'";
				    ResultSet rs = ntmt.executeQuery(SqlCommand);
				    
				    if (rs.next()) {
				    	Dcode = rs.getString("DCODE");
				    }
				    
				    ntmt.close();
				    
			    } else {
			    	
			    	//Gets department code from user
			    	System.out.println("Please enter in the department code to see all the offered courses: ");
				    Dcode = getString();  
			    }
			    
			    //Sends the SQL query to find class information to the database
			    Statement stmt = conn.createStatement();
			    SqlCommand = "SELECT CNUMBER, COURSELEVEL, COURSENAME, CDESCRIPTION, CHOURS FROM COURSE " + "WHERE DCODE='" + Dcode + "'";
			    ResultSet rs = stmt.executeQuery(SqlCommand);

			    
			    while(rs.next()) {
			    	//Gets the required info from each course
			    	String CNumber = rs.getString("CNUMBER");
			    	int CLevel = rs.getInt("COURSELEVEL");
			    	String CName = rs.getString("COURSENAME");
			    	String CDescription = rs.getString("CDESCRIPTION");
			    	int CHours = rs.getInt("CHOURS");
			    	
			    	//Prints the course info
			    	System.out.println("------------------------------------");
			    	System.out.println(CName);
			    	System.out.println("Course Number: " + CNumber + "  Course Level: " + CLevel);
			    	System.out.println("Hours: " + CHours);
			    	System.out.println(CDescription);
			    	System.out.println("------------------------------------");
			    }
			   
			//closes the statement and connection
			stmt.close();
			conn.close();
			
	} //end main method
	
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
