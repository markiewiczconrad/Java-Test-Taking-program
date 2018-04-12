//Conrad Markiewicz
//cmarki3
//CS342
//HW #4
//Group members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;
import java.io.PrintWriter;

public class SAQuestion extends Question{
	protected SAAnswer rightAnswer;
	protected SAAnswer studentAnswer;
	public SAQuestion() {}
	public SAQuestion(String d)
	{
		text = d;
		maxValue = 1.0;
	}
	public SAQuestion(String d, double mVal)
	{
		text = d;
		maxValue = mVal;
	}
	//DONE: Input constructor
	public SAQuestion(Scanner input)
	{
		if (input.hasNextDouble())
			maxValue = input.nextDouble();
		else
			maxValue = 0.0;
		text = input.next() + input.nextLine();
		rightAnswer = new SAAnswer(input);
	}
	public SAQuestion(SAQuestion q)
	{
		text = q.text;
		if (q.rightAnswer != null)
			rightAnswer = q.rightAnswer.clone();
		if (q.studentAnswer != null)
			studentAnswer = q.studentAnswer.clone();
		maxValue = q.maxValue;
	}
	public SAQuestion clone()
	{
		return new SAQuestion(this);
	}
	public void print()
	{
		System.out.println(text);
		System.out.print("\t\t");
		System.out.print("Current answer: ");
		if (studentAnswer != null)
		{
			System.out.println(studentAnswer.getDescription());
		}
		else
		{
			System.out.println("None");
		}
	}
	public Answer getNewAnswer()
	{
		return new SAAnswer();
	}
	public Answer getNewAnswer(String d)
	{
		return new SAAnswer(d);
	}
	//DONE: Get this thing working with the keyboardscanner
	public void getAnswerFromStudent()
	{
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.println("Please enter your answer:");
		String in = input.nextLine();
		if (studentAnswer == null)
			studentAnswer = new SAAnswer(in);
		else
			studentAnswer.setDescription(in);
		System.out.println("Your answer is now " + studentAnswer.getDescription());
	}
	public void reorderAnswers()
	{
		System.out.println("Answer reordered!");
	}
	public double getValue()
	{
		return studentAnswer.getCredit(rightAnswer) * maxValue;
	}
	//DONE: Save method
	public void save(PrintWriter output)
	{
		output.println("SAQuestion");
		output.print(maxValue);
		output.println();
		output.println(text);
		rightAnswer.save(output);
		output.println();
	}
	public void saveStudentAnswer(PrintWriter output)
	{
		if (studentAnswer == null) return;
		output.println("SAAnswer");
		output.println(studentAnswer.getDescription());
		output.println();
	}
	
	public void restoreStudentAnswer(Scanner input)
	{
		studentAnswer = new SAAnswer(input.nextLine());
	}
	public void setRightAnswers(Answer correct)
	{
		rightAnswer = new SAAnswer((SAAnswer)correct);
	}
}
