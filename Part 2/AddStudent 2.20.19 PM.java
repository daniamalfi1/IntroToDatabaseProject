/**
 * 
 */

/**
 * @author hibaimam
 *
 */
import java.sql.*;
import java.io.*;  

public class AddStudent {
	
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
			

	    // Prepare to insert students into the STUDENT table
	    PreparedStatement pstmt =
	      conn.prepareStatement ("INSERT INTO STUDENT(FIRSTNAME, MIDDLEINITIAL, LASTNAME, NNUMBER, SSN, BIRTHDATE, SEX, STUDENTCLASS, CURRENTADDRESS, CAZIP, CASTATE, CACITY, CAPHONE, PERMANANTADDRESS, PAZIP, PASTATE, PACITY, PAPHONE, MAJORDEPARTMENT, MINORDEPARTMENT, DEGREEPROGRAM) " +
	      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

	    int done = 1;

	    if (done != 0) {
	    	
	      System.out.println("\nEnter First Name: ");
	      String fName = getString();
	      System.out.println("\nEnter Middle Initial: ");
	      String mInitial = getString();
	      System.out.println("\nEnter Last Name: ");
	      String lName = getString();
	      System.out.print("\nEnter N Number : N");
	      int nNumber = getInt();
	      System.out.println("\nEnter Social Security Number in the format (XXX-XX-XXXX): ");
	      String SSN = getString();
	      System.out.println("\nEnter Birth Date Number in the format (MM-DD-YYYY): ");
	      String bDate = getString();
	      System.out.println("\nEnter Sex: ");
	      String SEX = getString();
	      System.out.println("\nEnter Student Class: ");
	      String sClass = getString();
	      System.out.println("\nEnter Current Address: ");
	      String cAddress = getString();
	      System.out.println("\nEnter Current Zip Code: ");
	      int cZIP = getInt();
	      System.out.println("\nEnter Current State: ");
	      String cState = getString();
	      System.out.println("\nEnter Current City: ");
	      String cCity = getString();
	      System.out.println("\nEnter Current Phone Number in the format (XXX-XXX-XXXX): ");
	      String cPhone = getString();
	      System.out.println("\nEnter Permanant Address: ");
	      String pAddress = getString();
	      System.out.println("\nEnter Permanant Zip Code: ");
	      int pZIP = getInt();
	      System.out.println("\nEnter Permanant State: ");
	      String pState = getString();
	      System.out.println("\nEnter Permanant City: ");
	      String pCity = getString();
	      System.out.println("\nEnter Permanant Phone Number in the format (XXX-XXX-XXXX): ");
	      String pPhone = getString();
	      System.out.println("\nEnter Major Deparment: ");
	      String majorDepartment = getString();
	      System.out.println("\nEnter Minor Department: ");
	      String minorDepartment = getString();
	      System.out.println("\nEnter Degree Program (B.A., B.S., ..., Ph.D.): ");
	      String dProgram = getString();

	      pstmt.setString(1, fName);
	      pstmt.setString(2, mInitial);
	      pstmt.setString(3, lName);
	      pstmt.setInt(4, nNumber);
	      pstmt.setString(5, SSN);
	      pstmt.setString(6, bDate);
	      pstmt.setString(7, SEX);
	      pstmt.setString(8, sClass);
	      pstmt.setString(9, cAddress);
	      pstmt.setInt(10, cZIP);
	      pstmt.setString(11, cState);
	      pstmt.setString(12, cCity);
	      pstmt.setString(13, cPhone);
	      pstmt.setString(14, pAddress);
	      pstmt.setInt(15, pZIP);
	      pstmt.setString(16, pState);
	      pstmt.setString(17, pCity);
	      pstmt.setString(18, pPhone);
	      pstmt.setString(19, majorDepartment);
	      pstmt.setString(20, minorDepartment);
	      pstmt.setString(21, dProgram);
	      
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


