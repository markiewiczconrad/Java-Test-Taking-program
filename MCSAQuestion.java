/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class MCSAQuestion extends MCQuestion //Extends since it has a subtree
{
	Answer getNewAnswer1, getNewAnswer2, getNewAnswer3; //Objects of typpe Answer
	
	private static double getV; //Static double for the get value
	
	private double compareStringDoubleMCSAQ;
	
	public MCSAQuestion(String message, double maxValue) 
	{
		super(message, maxValue);	 //Sets the string and the double
	}
	
	public MCSAQuestion(Scanner quesFile) 
	{		
		super(quesFile);
		
		String sMCSAQ1;
		
		sMCSAQ1 = quesFile.nextLine();
		
		compareStringDoubleMCSAQ = Double.parseDouble(sMCSAQ1); //to convert from string to double 
		 		
		int i = 0;
		 
		while( i < compareStringDoubleMCSAQ) //check through the whole array
		{
			MCAnswer fornewMCA;
			
			double changedtoS;
			
			String MCSAQuesFile, s;
			
			MCSAQuesFile = quesFile.nextLine(); //check the next space
			
			s = MCSAQuesFile;
			 
			String toSplit[] = s.split(" "); //split it
			
			changedtoS = Double.parseDouble(toSplit[0]);
			
			String AnswerText = "";
			
			for(int j = 1;j < toSplit.length;j++) 
			{
				  AnswerText += toSplit[j]+" "; //do the split
			}
			
			fornewMCA = new MCSAAnswer(AnswerText,changedtoS);
			
			addAnswer(fornewMCA);  //add the ans
			
			i++; //increment the i
			
		}
	
	}

	public Answer getNewAnswer() 
	{
		getNewAnswer1 = new MCSAAnswer("",0); //Gets the new ans and returns it
	
		return getNewAnswer1;
	}
	
	public Answer getNewAnswer(String message) 
	{
		getNewAnswer2 = new MCSAAnswer(message, 0);		//Gets the new ans and returns it with string
		
		return getNewAnswer2 ;
	}

	public Answer getNewAnswer(String message, double creditIfSelected) 
	{
		getNewAnswer3 = new MCSAAnswer(message, creditIfSelected);	//Gets the new ans and returns it with string and double 
	
		return getNewAnswer3;
	}
	
	public void getAnswerFromStudent()  //Gets the answer from the student
	{
		
		System.out.println("Enter the Answer for Multiple Choice: \n");
	
		Scanner readerInAnswer = new Scanner(System.in); //User Input
		
		char userAnswer;
		
		userAnswer = readerInAnswer.next().charAt(0);
		
		switch(userAnswer)
		{
			case 'A': studentAnswer = questions2.get(0); //check if its capital and small letters to get the question 
			case 'a': studentAnswer = questions2.get(0);
			case 'b': studentAnswer = questions2.get(1);
			case 'B': studentAnswer = questions2.get(1);
			case 'C': studentAnswer = questions2.get(2);
			case 'c': studentAnswer = questions2.get(2);
			case 'd': studentAnswer = questions2.get(3);
			case 'D': studentAnswer = questions2.get(3);
			case 'E': studentAnswer = questions2.get(4);
			case 'e': studentAnswer = questions2.get(4);
		}
		
	}
	
	public double getValue() //Gets the value from the student ans
	{
		getV= studentAnswer.getCredit(null); //Gets the val
		
		return getV * fordouble; //Return it and * with the points for the questions
	}
	public void save(PrintWriter writeInFile) 
	{
		super.save(writeInFile); //from the parents
		writeInFile.print("\n");
		writeInFile.print(compareStringDoubleMCSAQ);
		writeInFile.print("\n");
		int i = 0;
		while(i < questions2.size())
		{
			questions2.get(i).save(writeInFile); //to write according to the question
			writeInFile.print("\n");
			i++; //increment
		}
	}
}

