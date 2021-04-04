package MavenLearner.MavenLearner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LearnerShow extends App {
    

	public void getAllRecords() {
		// TODO Auto-generated method stub
qry = "select * from learnertbl;";
    	
    	try {

			
//			Execute the query
			ResultSet theResultSet = theStatement.executeQuery(qry);
			
//			Traverse through the results
			while(theResultSet.next()) {
				System.out.print("Learners Id : " + theResultSet.getInt("LearnerId"));
				System.out.print(" First Name : " + theResultSet.getString("LearnerFname"));
				System.out.print(", Last Name : " + theResultSet.getString("LearnerLname"));
				System.out.println(", Address : " + theResultSet.getString("LearnerAddr"));
			}
			
		} catch (SQLException e) {
			System.out.println("Can't get a reference to Statement : " + e.getMessage());
		}
	}
}
