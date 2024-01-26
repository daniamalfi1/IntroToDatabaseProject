/**
 * @author Emily O.
 *
 */


import java.util.*;
import java.sql.*;

public class Menu {

	public static void main(String[] args) throws SQLException {
		
		do{
	        int currentCommand = 0;
	        Scanner input = new Scanner(System.in);

	        System.out.println("-----------------------------------");
	        System.out.println(
	            "1. Add a department\n"
	            +"2. Add a student\n"
	            +"3. Add a course\n"
	            +"4. Add a course section\n"
	            +"5. Add student to a course\n"
	            +"6. Generate a student grade report\n"
	            +"7. Look at courses offered in a department\n"
	            +"8. Put in a student grade\n"
	            +"9. Exit the program\n");
	        System.out.printf("Please enter the number of the command you would like to execute: \n");

	        try{
	            currentCommand = input.nextInt();

	            if(currentCommand == 9) break;

	            if(currentCommand > 0 && currentCommand < 9){

	              //call to add a department
	               if (currentCommand == 1) {
	            	   AddDepartment Test1 = new AddDepartment();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to add a student
	               if (currentCommand == 2) {
	            	   AddStudent Test1 = new AddStudent();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            	   }
	               }
	               
	               //call to add course
	               if (currentCommand == 3) {
	            	   AddCourse Test1 = new AddCourse();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to add a course section
	               if (currentCommand == 4) {
	            	   AddCSection Test1 = new AddCSection();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to add a student to a course
	               if (currentCommand == 5) {
	            	   AddingStudents Test1 = new AddingStudents();
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to generate a student grade report
	               if (currentCommand == 6) {
	            	   GradeReport Test1 = new GradeReport();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to view courses
	               if (currentCommand == 7) {
	            	   ViewCourses Test1 = new ViewCourses();
	            	 
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	               //call to put in student grade
	               if (currentCommand == 8) {
	            	   AddGrade Test1 = new AddGrade();
	            	   
	            	   try {
	            		   Test1.main(args);
	            		   }
	            	   
	            	   catch(Exception e){
	            		   System.out.println("Oh no! Something went wrong!");
	            		   }
	               }
	               
	            }

	            else{

	            System.out.println("Try again with a valid menu option!");

	            }
	        }

	        catch(InputMismatchException e){

	            input.next();
	            System.out.println("Try again with a valid menu option!");

	        }

	    } while(true);
	    //WILL CAUSE THIS MENU TO KEEP POPPING UP
	}

	
	
	
}
