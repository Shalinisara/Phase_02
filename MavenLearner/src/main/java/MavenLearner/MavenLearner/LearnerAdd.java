package MavenLearner.MavenLearner;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LearnerAdd extends App{
	///private String lname;
	///private String fname;
	//private String lAddr;

	//String qry;
	//Connection dbCon;
	//Statement theStatement;
	
/*	public LearnerAdd() {
		this.lname = lname;
		this.fname = fname;
		this.lAddr = lAddr;
		
		
	}  */

	
	public void addLearner(String fname2, String lname2, String lAddr2) {
		// TODO Auto-generated method stub
//		Write the query to insert
		qry = "insert into learnertbl(LearnerFname, LearnerLname, LearnerAddr) values(?, ?, ?)";
		

		try {
//			Get a reference to the PreparedStatement
			PreparedStatement thePreparedStatement = dbcon.prepareStatement(qry);
			
//			Set the values for ?
			thePreparedStatement.setString(1, fname2);
			thePreparedStatement.setString(2, lname2);
			thePreparedStatement.setString(3, lAddr2);
			
//			Execute the query
			if(thePreparedStatement.executeUpdate() > 0)
				System.out.println("Record added...");
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
		}
		
	}

	
}
