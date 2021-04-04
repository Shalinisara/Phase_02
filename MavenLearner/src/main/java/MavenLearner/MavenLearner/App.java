package MavenLearner.MavenLearner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
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
	    		String urlToConnect = "jdbc:mysql://localhost:3306/learners";
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
				
			 
	    	//System.out.println("connection successful");
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
    	int opt = 0;
		do {
			try {

				Scanner i = new Scanner(System.in);
				System.out.println("Please Select from the options below and press Enter: ");
				System.out.println("Option 1: Enter New Learner details: ");
				System.out.println("Option 2: Display all learners with their details ");
				System.out.println("Option 3: Search for a learner by ID:");
				System.out.println("Option 4: Update Learner details:");
				System.out.println("Option 5: Delete learner by ID:");
				System.out.println("Option 6: Do you want to sort");
				System.out.println("Option 7: Exit");
				System.out.println("===========================================");

				opt = i.nextInt();

				switch (opt) {
				case 1:
					System.out.println(" FName, Lname, Address:");
					Scanner s1 = new Scanner(System.in);
					String Fname = s1.nextLine();
					String Lname = s1.nextLine();
					String LAddr = s1.nextLine();
					LearnerAdd a = new LearnerAdd();
					a.addLearner(Fname, Lname, LAddr);
					System.out.println("=========Learner Added=========================");
					break;
					
				case 2:
					System.out.println(" Displaying all the Learners");
					LearnerShow b = new LearnerShow();
					b.getAllRecords();
					System.out.println("=========Learners displayed=================================");
					break;
					
				case 3:
					System.out.println(" Please enter Learner ID :");
					Scanner s2 = new Scanner(System.in);
					int LearnerId = s2.nextInt();
					LearnerGet c = new LearnerGet();
					c.getLearner(LearnerId);
					System.out.println("==========Learner shown====================");
					break;

				case 4:
					System.out.println(" Please enter Learner Addr and ID :");
					Scanner s3 = new Scanner(System.in);
					String LearnerUAddr =s3.nextLine();
					int LearnerUId = s3.nextInt();
					
					LearnerUpdate d = new LearnerUpdate();
					d.getLearner(LearnerUAddr, LearnerUId);
					System.out.println("===========Learner update==================");
					break;
				case 5:
					System.out.println(" Please enter Learner ID :");
					Scanner s4 = new Scanner(System.in);
					int LearnerUId1 = s4.nextInt();
					LearnerDel e = new LearnerDel();
					e.delLearner(LearnerUId1);
					System.out.println("===========Learner deleted=====================");
					break;
/*				case 2:
					
					String opt2 = null;
					String optD = "D";
					{
					do {
						
						Scanner i2 = new Scanner(System.in);
						System.out.println("Please Select from the options below and Press Enter: ");
						System.out.println("Option A: Create a Text file.  ");
						System.out.println("Option B: Delete a Text file ");
						System.out.println("Option C: Search for a Text file ");
						System.out.println("Option D: Go back to Main menu ");
						System.out.println("===========================================");

						opt2 = i2.nextLine();

						switch (opt2) {

						case "A":
							Scanner s2 = new Scanner(System.in);
							System.out.println("Please enter the text file name that you would like to create: ");
							System.out.println("Please enter file name  without the extension");
							String str1 = s2.nextLine();
							FileAdd a = new FileAdd();      
							a.creFile(str1);
							System.out.println("===========================================");
							break;
						case "B":
							Scanner s3 = new Scanner(System.in);
							System.out.println("Please enter the text file name that you would like to delete: ");
							System.out.println("Please enter file name  without the extension");
							String str2 = s3.nextLine();
							FileDel b = new FileDel();
							b.delFile(str2);
							System.out.println("===========================================");
							break;
						case "C":
							Scanner s4 = new Scanner(System.in);
							System.out.println("Please enter the text file name that you would like to search: ");
							System.out.println("Please enter file name  without the extension");
							String str3 = s4.nextLine();
							FileSrch c = new FileSrch();
							c.srchFile(str3);
							System.out.println("===========================================");
							break;

						case "D":
							
							break;
							
						default:
							System.err.println("Please choose a valid option A thru D");
							System.out.println("===========================================");
							break;
						}
						
					} while (!(opt2.equals(optD)));
					break;
					}

				case 3:
					System.out.println("Good Bye :)");
					System.out.println("===========================================");
					break;

				default:
					System.err.println("Please choose a valid option 1 thru 3");
					System.out.println("===========================================");*/
				}
			}
			catch (InputMismatchException e) {
				
				System.err.println("Please enter a number ");
				System.out.println("===========================================");
			}
			// while (opt>0 && opt<4);
		} while (opt != 7);

	}

    }
//}
