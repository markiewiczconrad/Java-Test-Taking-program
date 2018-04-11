/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class SAQuestion extends Question
{
	
	Answer getNewAnswerSA1, getNewAnswerSA2; //Objects for the Answer Class
	private double getVSAQ; //For the get val
	private String sTringForSAQ;
	
	
	public SAQuestion(String text, double maxValue)  //Public constructor
	{
		super(text, maxValue); //Sets the string and the douyble
		
		fordouble = maxValue; //Sets it to the double
	}
	public SAQuestion(Scanner quesFile) 
	{
		  super(quesFile);
		  
		  SAQuestion saques;
		  SAAnswer saans;
		  
		  
		  saques = new SAQuestion(text, maxValue); //for the new SAQuestion
		 
		  sTringForSAQ =  quesFile.nextLine();
		  
		  saans = (SAAnswer) saques.getNewAnswer(sTringForSAQ);
		  
		  saques.setRightAnswers(saans);
		 
	}
	
	
	public Answer getNewAnswer()
	{
		getNewAnswerSA1 = new SAAnswer(" "); //Gets the new Answer from the student
		return getNewAnswerSA1;
	}
	
	
	
	public Answer getNewAnswer(String text)
	{
		getNewAnswerSA2 = new SAAnswer(text); //Gets the new Answer from the student with string
		return getNewAnswerSA2;
	}
	
	
	
	public void getAnswerFromStudent()
	{
		System.out.println("\nEnter Short Answer\n"); //Gets the Ans from the Student for the SA Question
		Scanner getAnsFromStudentSAQ = new Scanner(System.in);  //User Input
		String message = getAnsFromStudentSAQ.nextLine();
		studentAnswer = new SAAnswer(message);  //Sets the string to the student Answer
	}
	
	
	public double getValue() //Gets the val and returns it
	{
		getVSAQ = studentAnswer.getCredit(rightAnswer);  //Gets the val according to the studentAns
		
		return getVSAQ * fordouble; //Returns the value * By the points of the options
	}
	public void save(PrintWriter writeInFile) 
	{
		writeInFile.print("\n"); //Print one by one
	
		writeInFile.print(text);
		
		writeInFile.print("\n");
		
		writeInFile.print(sTringForSAQ);
		
		writeInFile.print("\n");
	}
	
}

