/**
 * 
 */

/**
 * @author hibaimam
 *
 */
import java.sql.*;
import java.io.*;  

class AddCourse {
	
	void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "T13";
        String password = "Spring2022T13";
		Connection conn = DriverManager.getConnection(url, username, password);
			
	    // Prepare to insert courses into the COURSE table
	    PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO COURSE(CNUMBER, COURSELEVEL, COURSENAME, CDESCRIPTION, CHOURS, DCODE)" +
	      "VALUES (?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    if (done != 0) {
	      System.out.println("\nEnter Course Number: ");
	      String cNumber = getString();
	      System.out.println("\nEnter Course Level: ");
	      int cLevel = getInt();
	      System.out.println("\nEnter Course Name: ");
	      String cName = getString();
	      System.out.println("\nEnter Course Description: ");
	      String cDescription = getString();
	      System.out.println("\nEnter Course Hours: ");
	      int cHours = getInt();
	      System.out.println("\nEnter Department Code: ");
	      String dCode = getString();
	      
	      
	      pstmt.setString(1, cNumber);
	      pstmt.setInt(2, cLevel);
	      pstmt.setString(3, cName);
	      pstmt.setString(4, cDescription);
	      pstmt.setInt(5, cHours);
	      pstmt.setString(6, dCode);
	      int NumRows = pstmt.executeUpdate();
	      System.out.println("\n" + NumRows + " row(s) inserted");

	      } // if done
	    conn.close();

	  } // main

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


