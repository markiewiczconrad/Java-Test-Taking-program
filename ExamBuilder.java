/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Fourth Homework Assignment
 * UIN: 660657541
 */


import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Boolean;

public class ExamBuilder 
{	
	public static void main(String[] args) throws FileNotFoundException
	{
		File forExam = new File("makeExam.txt"); //Use file to locate the exam
		try
		{
			forExam.createNewFile(); // create an exam
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace(); //throw if anything garbage comes in
			return;
		}
		Scanner fe = new Scanner(forExam); //scan the exam
		Exam exambuild = new Exam("Software"); //initialize the exam
		
		
		boolean done = false; //set it to false first
		while(!done) //this will run until its not done
		{
			System.out.println("Welcome to the Exambuilder\n"); //the next few lines are to prompt users for its appropriate choices
			
			System.out.println("1.Load");
			
			System.out.println("2.Add");
			
			System.out.println("3.Remove");
			
			System.out.println("4.Reorder");
			
			System.out.println("5.Print");
			
			System.out.println("6.Save");
			
			System.out.println("7.Quit");
			
			Scanner s = ScannerFactory.getKeyboardScanner(); // Scan
			char choice = s.next().charAt(0); //char
			
			switch(choice)//for the choices
			{
				case '1': File f = new File("ExamDataFile.txt"); //file the .txt
				try
				{
					f.createNewFile(); //create it
				}
				catch (java.io.IOException e)
				{
					e.printStackTrace(); 
					return;
				}
				
				Scanner s1;
				
				try 
				{
					s1 = new Scanner(f); //new scanner
				
					exambuild = new Exam(s1);
					
					exambuild.print(); //print the exam with loading it from file
					  
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
					return;
				}
						  
						  
						  
						break;
				case '2': System.out.println("\nThe types of Questions there are is:"); //For the users to add questions
						  System.out.println("1.SAQuestion");
						  System.out.println("2.MCSAQuestion");
						  System.out.println("3.MCMAQuestion");
						  System.out.println("4.NumQuestion");
						  
						  Scanner user = new Scanner(System.in); //user input
						  String u = user.nextLine(); //for the string
						  int input = Integer.parseInt(u); //to convert strung to integer
						  
						  
						  switch(input)
						  {
							  case 1:
								  
								  System.out.println("1.SAQuestion");
								  Scanner s2 = new Scanner(System.in); //User input
								  String saques = s2.nextLine(); //scanner to string
								  Double d = s2.nextDouble(); //scanner to double
								  s2.nextLine();
								  String a = s2.nextLine();
								  SAQuestion qa=new SAQuestion(saques, d); //convert the string to type of questions
								  SAAnswer saa = new SAAnswer(a);
								  qa.setRightAnswers(saa); //set the right answer
								  exambuild.addQuestion(qa); //add the question
								  break;
				
								  
								  
							
							  case 2:
								  
								  System.out.println("2.MCSAQuestion");
								  Scanner s3 = new Scanner(System.in); //User input
								  String mcsaques = s3.nextLine(); //from scanner to string
								  Double d1 = s3.nextDouble(); //scanner to double
								  s3.nextLine();
								  MCSAQuestion qb=new MCSAQuestion(mcsaques, d1); //for the type of question 
								  boolean done2 = false; //set to false first
								  while (done2 == false)
								  {
									  String mcsa = s3.nextLine(); //string from scanner
									  Double d2 = s3.nextDouble(); //double from scanner
									  s3.nextLine();
									  MCSAAnswer mcsaa = new MCSAAnswer(mcsa, d2); //type of question
									  qb.addAnswer(mcsaa); //to add the answer
									  char another = s3.nextLine().charAt(0); // for the char
									  if (another == 'N' || another == 'n') done2 = true;  //for if the user says n for n then will exit it
								  }
								  exambuild.addQuestion(qb); //add the questions
								  break;
								  
							  case 3:  
								  
								  System.out.println("3.MCMAQuestion"); //does the exact same as above
								  Scanner s4 = new Scanner(System.in);
								  String mcmaques = s4.nextLine();
								  Double d2 = s4.nextDouble();
								  s4.nextLine();
								  Double d3 = s4.nextDouble();
								  s4.nextLine();
								  MCMAQuestion qc=new MCMAQuestion(mcmaques, d2, d3);
								  boolean done3 = false;
								  while (done3 == false)
								  {
									  String mcma = s4.nextLine();
									  Double d4 = s4.nextDouble();
									  s4.nextLine();
									  MCMAAnswer mcmaa = new MCMAAnswer(mcma, d4);
									  qc.addAnswer(mcmaa);
									  char another2 = s4.nextLine().charAt(0);
									  if (another2 == 'N' || another2 == 'n') done3 = true;
								  }
								  exambuild.addQuestion(qc);
								  break;
							
								  
							  case 4:  
								  System.out.println("4.NumQuestion"); //does same as for SAQuestion
								  Scanner s5 = new Scanner(System.in);
								  String numques = s5.nextLine();
								  Double d5 = s5.nextDouble();
								  s5.nextLine();
								  Double d6 = s5.nextDouble();
								  s5.nextLine();
								  NumQuestion qd=new NumQuestion(numques, d5, d6);
								  Double s7 = s5.nextDouble();
								  s5.nextLine();
								  NumAnswer numa = new NumAnswer(s7);
								  qd.setRightAnswers(numa);
								  exambuild.addQuestion(qd);
								  break;
							
						  }
					
						  
						break;
				case '3': System.out.println("Which questions would you like to remove? Enter -999 to stop");
						  
						  Scanner q = new Scanner(System.in); //User input
						  
						  int ik = q.nextInt(); //for the int
						  q.nextLine();
						  if (ik == -999) break; //if its -999 then will break it
						  
						  exambuild.removeQuestion(ik - 1); //it will remove questions
						 
						break;
				case '4': exambuild.reorderQuestions(); //this will reorder the questions
						  
						  exambuild.reorderMCAnswers(5); //this will reorder the answers
						  
						break;
				case '5': exambuild.print(); //print the exam
						
						  break;
				case	 '6': 
						  PrintWriter p = new PrintWriter("makeExam.txt"); //for the print write in the file
					      
						  exambuild.save(p); //save the file
						  p.close(); //then close it
						
						  break;
				case 'Q':
				case '7': done = true;		   //it will exit if the user says quit
				          break;
			}
			
			
		}
	}
	
	
}
