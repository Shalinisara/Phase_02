package MavenLearner.MavenLearner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LearnerUpdate extends App {
	

	public void getLearner(String LearnerAddr,int LearnerId) {
		// TODO Auto-generated method stub
//		Write the query to insert
		qry = "Update learnertbl" + "set LearnerAddr = ?" + "where LearnerId = ? ";
		

		try {
//			Get a reference to the PreparedStatement
			PreparedStatement thePreparedStatement = dbcon.prepareStatement(qry);
			
//			Set the value for ?
			thePreparedStatement.setString(1, LearnerAddr);
			thePreparedStatement.setInt(2, LearnerId);
			
//			Execute the query
			thePreparedStatement.executeUpdate();
			thePreparedStatement.close();
			
//			Traverse through the results
//			while(theResultSet.next()) {
//				System.out.print("LearnerFname : " + theResultSet.getString("LearnerFname"));
//				System.out.print(", LearnerLname : " + theResultSet.getString("LearnerLname"));
//				System.out.print(", LearnerAddr : " + theResultSet.getString("LearnerAddr"));
			}
			
			
		catch (SQLException e) {
			System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
		}
		
	}
}
