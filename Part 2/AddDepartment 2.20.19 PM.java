/**
 * 
 */

/**
1 * @author hibaimam
 *
 */
import java.sql.*;
import java.io.*;  

public class AddDepartment {
	
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
			
		
	    // Prepare to insert departments into the DEPARTMENT table
	    PreparedStatement pstmt = conn.prepareStatement ("INSERT INTO DEPARTMENT(DNAME, DCODE, OFFICENUMBER, OFFICEPHONE, COLLEGE)" +
	      "VALUES (?, ?, ?, ?, ?)");

	    int done = 1;

	    if(done != 0) {
	      System.out.println("\nEnter Department Name: ");
	      String dName = getString();
	      System.out.println("\nEnter Department Code: ");
	      String dCode = getString();
	      System.out.println("\nEnter Office Number: ");
	      int oNumber = getInt();
	      System.out.println("\nEnter Office Phone: ");
	      String oPhone = getString();
	      System.out.println("\nEnter College: ");
	      String college = getString();
	      
	      pstmt.setString(1, dName);
	      pstmt.setString(2, dCode);
	      pstmt.setInt(3, oNumber);
	      pstmt.setString(4, oPhone);
	      pstmt.setString(5, college);
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


