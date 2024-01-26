/**
 * 
 */

/**
 * @author Daniela
 *
 */
import java.sql.*;
import java.io.*;  

public class AddGrade {

	public void main(String[] args) throws SQLException {
		String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "T13";
        String password = "Spring2022T13";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		System.out.print("Enter Student Nnumber: N");
	    int nNumber = getInt();
	    
	    System.out.println("Enter Course Number: ");
	    String cNumber = getString();
	    
	    System.out.println("Enter Section Number: ");
	    int sNumber = getInt();
	    
	    System.out.println("Enter Grade Point: ");
	    String grade = getString();
	    
	    Statement stmt = conn.createStatement ();
	    String SqlCommand = "UPDATE ISIN SET GRADE = '" + grade + "' WHERE STUDENTNUMBER = '" + nNumber + "' AND COURSENUMBER = '" + cNumber + "' AND SECTIONNUMBER = '" + sNumber + "'";
	    ResultSet rs = stmt.executeQuery(SqlCommand);
	    
	    System.out.println("Grade updated!");
	    
	    stmt.close();
		conn.close();
	    

	}
	
	public static int getInt() 

	  {
	      String s= getString();
	      return Integer.parseInt(s);
	  }
	
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

}