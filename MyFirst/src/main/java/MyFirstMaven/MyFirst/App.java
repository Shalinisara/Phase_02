package MyFirstMaven.MyFirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	String qry;
	Connection dbcon;
	Statement theStatement;
	
	App(){
		try {	
	    		String urlToConnect = "jdbc:mysql://localhost:3306/shalini";
	        	String dbUserName = "root";
	        	String dbPwd = "";
	        	String mysqlDriver = "com.mysql.cj.jdbc.Driver";
	    	//Load the Driver
	    	
				
					Class.forName(mysqlDriver);
				
			
	    	
	    	//Try to establish db cnctn
	    
				//Connection dbcon;
			
				dbcon = DriverManager.getConnection(urlToConnect,dbUserName,dbPwd);
				 
				
			//Get reference to the statement
				
				theStatement = dbcon.createStatement();
				
			 
	    	System.out.println("connection successful");
	    	}
	    	catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
    public static void main( String[] args )
    {
    	//new App().getAllRecords();
    	//new App().getCourseDetailsById(2);
    	//new App().addNewCourse();
    	new App().delCoursebyId(1);
    	//System.out.println("Please enter Cname, Institute and Marks");
    	//Scanner theScanner = new Scanner(System.in);
    	//String CourseName = theScanner.nextLine();
    	//String Institute = theScanner.nextLine();
       	//int Marks = theScanner.nextInt();
       	
       	//new App().addNewCourseFromRuntime(CourseName, Institute, Marks);
    }
    
    void getAllRecords()
    {
    	qry = "select * from courses;";
    	
    	try {

			
//			Execute the query
			ResultSet theResultSet = theStatement.executeQuery(qry);
			
//			Traverse through the results
			while(theResultSet.next()) {
				System.out.print("Name : " + theResultSet.getString("CourseName"));
				System.out.print(", Institute : " + theResultSet.getString("Institute"));
				System.out.println(", Marks : " + theResultSet.getInt("Marks"));
			}
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to Statement : " + e.getMessage());
		}
    }
    
    
    
    
 // Get Course details for a particular id
    void getCourseDetailsById(int id) {
//    	Write the query to fetch details from the table:learners
    	qry = "select * from Courses where CourseId = " + id;
    	

    	try {
//        	Execute the query
			ResultSet theResultSet = theStatement.executeQuery(qry);
			
			System.out.println("Details of learner for id : " + id);
			
//			Traverse through the results
			while(theResultSet.next()) {
				System.out.println("Name : " + theResultSet.getString("CourseName") + ", Institute : " + theResultSet.getString("Institute"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}
    }
    
    //Add a new Learner to the table:learners
    void addNewCourse() {
//    Write the query to insert a new record
    	qry = "insert into Courses(CourseName, Institute, Marks) values ('ENGMECH', 'IIT', 95)";
    	

    	try {
//        	Execute the query
			int result = theStatement.executeUpdate(qry);
			
			if(result > 0)
				System.out.println("New Course details addedd successfully...");
		} catch (SQLException e) {
			System.out.println("Can't add to the table : " + e.getMessage());
		}
    }
    
 // Get Course details for a particular id
    void delCoursebyId(int id) {
//    	Write the query to fetch details from the table:learners
    	qry = "delete from Courses where CourseId = " + id;
    	

    	try {
//        	Execute the query
			if (theStatement.executeUpdate(qry)> 0)
			{
				System.out.println("Deleted id : " + id);
			}
					
		} catch (SQLException e) {
			System.out.println("Can't execute the query : " + e.getMessage());
		}
    }
//  Add a new Course to the table - learner details taken from runtime
  void addNewCourseFromRuntime(String CourseName, String Institute, int Marks) {
//  	Write the query to insert a new record
  	qry = "insert into Courses(CourseName, Institute, Marks) values "
  			//+ "values "
  			+ "('" 
  			+ CourseName + "','" 
  			+ Institute + "',"
  			+ Marks+")";
  	

  	try {
//      	Execute the query
			if(theStatement.executeUpdate(qry) >  0)
				System.out.println("Successfully added a new Course...");
		} catch (SQLException e) {
			System.out.println("Can't add to the table : " + e.getMessage());
		}
  }
}
