/**
 * 
 */

/**
 * @author Daniela
 *
 */
import java.sql.*;
import java.io.*;  

public class GradeReport {

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
	    
	    Statement stmt = conn.createStatement();
	    String SqlCommand = "SELECT FIRSTNAME, LASTNAME, NNUMBER, MAJORDEPARTMENT, MINORDEPARTMENT, DEGREEPROGRAM FROM STUDENT " + "WHERE NNUMBER='" + nNumber + "'";
	    ResultSet rs = stmt.executeQuery(SqlCommand);
	    
	    
	    while(rs.next()) {
	    	String FName = rs.getString("FIRSTNAME");
	    	String LName = rs.getString("LASTNAME");
	    	int Nnumber = rs.getInt("NNUMBER");
	    	String MajorDept = rs.getString("MAJORDEPARTMENT");
	    	String MinorDept = rs.getString("MINORDEPARTMENT");
	    	String DegreePrg = rs.getString("DEGREEPROGRAM");
    	
	    	System.out.println("Student Information: ");
	    	System.out.println("\nName: " + FName + " " + LName);
	    	System.out.println("\nN-Number: " + Nnumber);
	    	System.out.println("\nMajor Department: " + MajorDept + "\nMinor Department: " + MinorDept);
	    	System.out.println("\nDegree Program: " + DegreePrg);
	    }
	    
	    stmt.close();
    	
    	Statement stmt1 = conn.createStatement();
    	String SqlCommand1 = "SELECT COURSENUMBER, SECTIONNUMBER, GRADE FROM ISIN WHERE STUDENTNUMBER='" + nNumber + "'";
    	ResultSet rs1 = stmt1.executeQuery(SqlCommand1);
    	double count = 0;
    	double sum = 0;
    	
    	while(rs1.next()) {
	    	//Gets the required info from each course of the student
    		String CNumber = rs1.getString("COURSENUMBER");
        	String SNumber = rs1.getString("SECTIONNUMBER");
        	String LGrade = rs1.getString("GRADE");
        	double Grade = convertToPointGrade(LGrade);
        	
	    	//Prints the course info + student grade
        	System.out.print("\nCourse Number: " + CNumber + "\nSection Number: " + SNumber + "\nGrade Point: " + Grade + "\nLetter Grade: " + LGrade);
        	System.out.println();
        	count = count + 1; 
        	sum = sum + Grade;
	    }
    	
    	
    	double GPA = sum / count;
    	System.out.println();
    	System.out.println("\nGPA = " + GPA);
    	stmt1.close();
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
	
	
	
	public static double convertToPointGrade(String letterGrade) {
		double gradePoint = 0;
		if (letterGrade.equals("A")) {
			gradePoint = 4.0;
		}
		else if (letterGrade.equals("A-")) {
			gradePoint = 3.7;
		}
		else if (letterGrade.equals("B+")) {
			gradePoint = 3.3;
		}
		else if (letterGrade.equals("B")) {
			gradePoint = 3.0;
		}
		else if (letterGrade.equals("B-")) {
			gradePoint = 2.7;
		}
		else if (letterGrade.equals("C+")) {
			gradePoint = 2.3;
		}
		else if (letterGrade.equals("C")) {
			gradePoint = 2.0;
		}
		else if (letterGrade.equals("D")) {
			gradePoint = 1.0;
		}
		else {gradePoint = 0.0;}
		
		return gradePoint;
		
	}

}

