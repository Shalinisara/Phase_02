package MyFirstMaven.MyFirst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsingPreparedStmt {

	String qry;
	Connection dbCon;
	Statement theStatement;
	
	public UsingPreparedStmt(){

    	try {
//    		Define the URL to connect
    		String urlToConnect = "jdbc:mysql://localhost:3306/shalini";
    		
//    		Define the username for db to connect
    		String dbUserName = "root";
    		
//    		Define the password
    		String dbUserPassword = "";
    		
//    		Define the driver for the database
    		String mySqlDriver = "com.mysql.cj.jdbc.Driver";
    		
    		
//        	Load the Driver
			Class.forName(mySqlDriver);
			
//			Try to establish the connection
			dbCon = DriverManager.getConnection(urlToConnect, dbUserName, dbUserPassword);		
			
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the Driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect to DB : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Scanner theScanner = new Scanner(System.in);
		
//		System.out.println("Please enter name Institue &Marks");
		
//		new UsingPreparedStmt().addNewCourse(theScanner.nextLine(), theScanner.nextLine(), theScanner.nextInt());
		
		System.out.println("Enter id : ");
		
		int CourseId = theScanner.nextInt();
		
		new UsingPreparedStmt().getCourseDetailsById(CourseId);
	}
	
//	Insert a new record in the table:learners using PreparedStatement
	void addNewCourse(String CourseName, String Institute, int Marks) {
//		Write the query to insert
		qry = "insert into courses(CourseName, Institute, Marks) values(?, ?, ?)";
		

		try {
//			Get a reference to the PreparedStatement
			PreparedStatement thePreparedStatement = dbCon.prepareStatement(qry);
			
//			Set the values for ?
			thePreparedStatement.setString(1, CourseName);
			thePreparedStatement.setString(2, Institute);
			thePreparedStatement.setInt(3, Marks);
			
//			Execute the query
			if(thePreparedStatement.executeUpdate() > 0)
				System.out.println("Record added...");
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
		}
	}
	

	//Fetch all details of a learner by id from table:learners
	void getCourseDetailsById(int Courseid) {
//		Write the query
		qry = "select * from courses where CourseId = ?";
		

		try {
//			Get a reference to the PreparedStatement
			PreparedStatement thePreparedStatement = dbCon.prepareStatement(qry);
			
//			Set the value for ?
			thePreparedStatement.setInt(1, Courseid);
			
//			Execute the query
			ResultSet theResultSet = thePreparedStatement.executeQuery();
			
//			Traverse through the results
			while(theResultSet.next()) {
				System.out.print("Name : " + theResultSet.getString("CourseName"));
				System.out.print(", Institute : " + theResultSet.getString("Institute"));
				System.out.print(", Marks : " + theResultSet.getInt("Marks"));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
		}
	}
	
	
	
	
	
}
