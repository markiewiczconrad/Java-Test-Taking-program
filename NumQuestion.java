//Conrad Markiewicz
//cmarki3
//An implementation of the NumQuestion class, using code by Kashyapkumar Trivedi (ktrive4)

import java.io.PrintWriter;
import java.util.Scanner;

public class NumQuestion extends Question{

	protected double tolerance;
	protected Answer getNewAnswerNA1, getNewAnswerNA2;
	private double getVNAQ;
	protected double dOubleForNQ;
	
	public NumQuestion(String txt, double mVal)
	{
		super(txt, mVal);
	}
	
	public NumQuestion(String txt, double mVal, double tol)
	{
		super(txt, mVal);
		tolerance = tol;
	}
	
	public NumQuestion(Scanner quesFile)
	{
		super(quesFile);
		
		NumQuestion numques;
		NumAnswer numans;
		
		numques = new NumQuestion(text, maxValue);
		
		dOubleForNQ = quesFile.nextDouble();
		quesFile.nextLine();
		
		numans = (NumAnswer) numques.getNewAnswer(dOubleForNQ);
		
		numques.setRightAnswers(numans);
		
	}
	
	public Answer getNewAnswer()
	{
		getNewAnswerNA1 = new NumAnswer(0.0);
		return getNewAnswerNA1;
	}
	
	public Answer getNewAnswer(double in)
	{
		getNewAnswerNA2 = new NumAnswer(in);
		return getNewAnswerNA2;
	}
	
	public void getAnswerFromStudent()
	{
		System.out.println("\nEnter Numerical Answer\n"); //Gets the Ans from the Student for the SA Question
		Scanner getAnsFromStudentNQ = new Scanner(System.in);  //User Input
		String message = getAnsFromStudentNQ.nextLine();
		studentAnswer = new SAAnswer(message);  //Sets the string to the student Answer
	}	
	
	public double getValue() //Gets the val and returns it
	{
		getVNAQ = studentAnswer.getCredit(rightAnswer);  //Gets the val according to the studentAns
		
		return getVNAQ * fordouble; //Returns the value * By the points of the options
	}
	
	public void save(PrintWriter writeInFile) 
	{
		writeInFile.print("\n"); //Print one by one
	
		writeInFile.print(text);
		
		writeInFile.print("\n");
		
		writeInFile.print(dOubleForNQ);
		
		writeInFile.print("\n");
	}
}
