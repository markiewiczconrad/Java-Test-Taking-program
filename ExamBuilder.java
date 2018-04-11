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
		File forExam = new File("makeExam.txt");
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
				
				Scanner s1;
				
				try 
				{
					s1 = new Scanner(f);
				
					exambuild = new Exam (s1);
					
					exambuild.print();
					  
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
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
								  String saques = s2.nextLine();
								  Double d = s2.nextDouble();
								  SAQuestion qa=new SAQuestion(saques, d);
								  exambuild.addQuestion(qa);
								  
				
								  
								  
							
							  case 2:
								  
								  System.out.println("2.MCSAQuestion");
								  Scanner s3 = new Scanner(System.in);
								  String mcsaques = s3.nextLine();
								  Double d1 = s3.nextDouble();
								  MCSAQuestion qb=new MCSAQuestion(mcsaques, d1);
								  exambuild.addQuestion(qb);
								  
								  
							  case 3:  
								  
								  System.out.println("3.MCMAQuestion");
								  Scanner s4 = new Scanner(System.in);
								  String mcmaques = s4.nextLine();
								  Double d2 = s4.nextDouble();
								  SAQuestion qc=new SAQuestion(mcmaques, d2);
								  exambuild.addQuestion(qc);
								  
							
								  
							  case 4:  
								  System.out.println("4.NumQuestion");
								  Scanner s5 = new Scanner(System.in);
								  String numques = s5.nextLine();
								  Double d3 = s5.nextDouble();
								  SAQuestion qd=new SAQuestion(numques, d3);
								  exambuild.addQuestion(qd);
								  
							
						  }
					
						  
						break;
				case '3': System.out.println("Which questions would you like to remove? Enter -999 to stop");
						  
						  Scanner q = new Scanner(System.in);
						  
						  int ik = q.nextInt();
						  
						  exambuild.removeQuestion(ik - 1);
						 
						break;
				case '4': exambuild.reorderQuestions();
						  
						  exambuild.reorderMCAnswers(5);
						  
						break;
				case '5': exambuild.print();
						
						  break;
				case	 '6': 
						  PrintWriter p = new PrintWriter("makeExam.txt");
					      
						  exambuild.save(p);
						
						  break;
				case 'Q': done = true;
						  
				          break;
			}
			
			
		}
	}
	
	
}
