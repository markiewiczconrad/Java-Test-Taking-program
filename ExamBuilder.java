/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Fourth Homework Assignment
 * Group Members: Conrad Markiewicz & Jay Patel
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
		File forExam = new File("makeExam.txt");
		try
		{
			forExam.createNewFile();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
			return;
		}
		Scanner fe = new Scanner(forExam);
		Exam exambuild = new Exam("Software");
		
		
		boolean done = false;
		while(!done)
		{
			System.out.println("Welcome to the Exambuilder\n");
			
			System.out.println("1.Load");
			
			System.out.println("2.Add");
			
			System.out.println("3.Remove");
			
			System.out.println("4.Reorder");
			
			System.out.println("5.Print");
			
			System.out.println("6.Save");
			
			System.out.println("7.Quit");
			
			Scanner s = new Scanner(System.in);
			char choice = s.next().charAt(0);
			
			switch(choice)
			{
				case '1': File f = new File("ExamDataFile.txt");
				try
				{
					f.createNewFile();
				}
				catch (java.io.IOException e)
				{
					e.printStackTrace();
					return;
				}
				
				Scanner s1;
				
				try 
				{
					s1 = new Scanner(f);
				
					exambuild = new Exam(s1);
					
					exambuild.print();
					  
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
					return;
				}
						  
						  
						  
						break;
				case '2': System.out.println("\nThe types of Questions there are is:");
						  System.out.println("1.SAQuestion");
						  System.out.println("2.MCSAQuestion");
						  System.out.println("3.MCMAQuestion");
						  System.out.println("4.NumQuestion");
						  
						  Scanner user = new Scanner(System.in);
						  String u = user.nextLine();
						  int input = Integer.parseInt(u);
						  
						  
						  switch(input)
						  {
							  case 1:
								  
								  System.out.println("1.SAQuestion");
								  Scanner s2 = new Scanner(System.in);
								  System.out.println("Please enter the question text: ");
								  String saques = s2.nextLine();
								  System.out.println("Please enter the question value: ");
								  Double d = s2.nextDouble();
								  s2.nextLine();
								  System.out.println("Please enter the correct answer: ");
								  String a = s2.nextLine();
								  SAQuestion qa=new SAQuestion(saques, d);
								  SAAnswer saa = new SAAnswer(a);
								  qa.setRightAnswers(saa);
								  exambuild.addQuestion(qa);
								  break;
				
								  
								  
							
							  case 2:
								  
								  System.out.println("2.MCSAQuestion");
								  Scanner s3 = new Scanner(System.in);
								  System.out.println("Please enter the question text: ");
								  String mcsaques = s3.nextLine();
								  System.out.println("Please enter the question value: ");
								  Double d1 = s3.nextDouble();
								  s3.nextLine();
								  MCSAQuestion qb=new MCSAQuestion(mcsaques, d1);
								  boolean done2 = false;
								  while (done2 == false)
								  {
									  System.out.println("Please enter a possible answer: ");
									  String mcsa = s3.nextLine();
									  System.out.println("Please enter its value: ");
									  Double d2 = s3.nextDouble();
									  s3.nextLine();
									  MCSAAnswer mcsaa = new MCSAAnswer(mcsa, d2);
									  qb.addAnswer(mcsaa);
									  System.out.println("Add another choice? ");
									  char another = s3.nextLine().charAt(0);
									  if (another == 'N' || another == 'n') done2 = true;
								  }
								  exambuild.addQuestion(qb);
								  break;
								  
							  case 3:  
								  
								  System.out.println("3.MCMAQuestion");
								  Scanner s4 = new Scanner(System.in);
								  System.out.println("Please enter the question text: ");
								  String mcmaques = s4.nextLine();
								  System.out.println("Please enter the question value: ");
								  Double d2 = s4.nextDouble();
								  s4.nextLine();
								  System.out.println("Please enter the question base value: ");
								  Double d3 = s4.nextDouble();
								  s4.nextLine();
								  MCMAQuestion qc=new MCMAQuestion(mcmaques, d2, d3);
								  boolean done3 = false;
								  while (done3 == false)
								  {
									  System.out.println("Please enter the answer text: ");
									  String mcma = s4.nextLine();
									  System.out.println("Please enter the answer value: ");
									  Double d4 = s4.nextDouble();
									  s4.nextLine();
									  MCMAAnswer mcmaa = new MCMAAnswer(mcma, d4);
									  qc.addAnswer(mcmaa);
									  System.out.println("Add another answer? ");
									  char another2 = s4.nextLine().charAt(0);
									  if (another2 == 'N' || another2 == 'n') done3 = true;
								  }
								  exambuild.addQuestion(qc);
								  break;
							
								  
							  case 4:  
								  System.out.println("4.NumQuestion");
								  Scanner s5 = new Scanner(System.in);
								  System.out.println("Please enter the question text: ");
								  String numques = s5.nextLine();
								  System.out.println("Please enter the question value: ");
								  Double d5 = s5.nextDouble();
								  s5.nextLine();
								  System.out.println("Please enter the tolerance: ");
								  Double d6 = s5.nextDouble();
								  s5.nextLine();
								  NumQuestion qd=new NumQuestion(numques, d5, d6);
								  System.out.println("Please enter the right answer: ");
								  Double s7 = s5.nextDouble();
								  s5.nextLine();
								  NumAnswer numa = new NumAnswer(s7);
								  qd.setRightAnswers(numa);
								  exambuild.addQuestion(qd);
								  break;
							
						  }
					
						  
						break;
				case '3': System.out.println("Which questions would you like to remove? Enter -999 to stop");
						  
						  Scanner q = new Scanner(System.in);
						  
						  int ik = q.nextInt();
						  q.nextLine();
						  if (ik == -999) break;
						  
						  exambuild.removeQuestion(ik - 1);
						 
						break;
				case '4': exambuild.reorderQuestions();
						  
						  exambuild.reorderMCAnswers(-1);
						  
						break;
				case '5': exambuild.print();
						
						  break;
				case	 '6': 
						  PrintWriter p = new PrintWriter("makeExam.txt");
					      
						  exambuild.save(p);
						  p.close();
						
						  break;
				case 'Q':
				case '7': done = true;		  
				          break;
			}
			
			
		}
	}
	
	
}
