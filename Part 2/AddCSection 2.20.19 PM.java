/**
 * 
 */

/**
 * @author hibaimam
 *
 */
import java.sql.*;
import java.io.*;  

public class AddCSection {
	
	public void main(String[] args) throws SQLException {
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
			
		// Prepare to insert new course sections into the CSECTION table
		PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO CSECTION(COURSENUMBER, SECTIONNUMBER, INSTRUCTOR, SYEAR, SEMESTER)" +"VALUES (?, ?, ?, ?, ?)");
			
			 
	    int done = 1;

	    if (done != 0) {
	      System.out.println("\nEnter Course Number: ");
	      String cNumber = getString();
	      System.out.println("\nEnter Section Number: ");
	      int sNumber = getInt();
	      System.out.println("\nEnter Instructor: ");
	      String instructor = getString();
	      System.out.println("\nEnter Section Year: ");
	      int sYear = getInt();
	      System.out.println("\nEnter Semester: ");
	      String semester = getString();
	      
	      
	      pstmt.setString(1, cNumber);
	      pstmt.setInt(2, sNumber);
	      pstmt.setString(3, instructor);
	      pstmt.setInt(4, sYear);
	      pstmt.setString(5, semester);
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


