//Conrad Markiewicz
//cmarki3
//CS 342
//HW #4
//Group members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;
import java.io.PrintWriter;

public class NumQuestion extends Question{
	NumAnswer rightAnswer;
	NumAnswer studentAnswer;
	double value;
	double tolerance;
	public NumQuestion()
	{
		super();
	}
	public NumQuestion(String txt, double mVal, double tol)
	{
		text = txt;
		maxValue = mVal;
		tolerance = tol;
	}
	public NumQuestion(NumQuestion t)
	{
		text = t.text;
		if (t.rightAnswer != null)
			rightAnswer = t.rightAnswer.clone();
		if (t.studentAnswer != null)
			studentAnswer = t.studentAnswer.clone();
		value = t.value;
		tolerance = t.tolerance;
		maxValue = t.maxValue;
	}
	public NumQuestion(Scanner input)
	{
		if (input.hasNextDouble())
			maxValue = input.nextDouble();
		else
			maxValue = 0.0;
		text = input.next() + input.nextLine();
		rightAnswer = new NumAnswer(input);
		tolerance = input.nextDouble();
	}
	public Question clone()
	{
		return new NumQuestion(this);
	}
	public Answer getNewAnswer()
	{
		return new NumAnswer();
	}
	public void getAnswerFromStudent()
	{
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.println("Please enter your answer:");
		double in = input.nextDouble();
		input.nextLine();
		if (studentAnswer == null)
			studentAnswer = new NumAnswer(in);
		else
		{
			NumAnswer temp_a = (NumAnswer)studentAnswer;
			temp_a.setValue(in);			
		}
		NumAnswer temp_a = (NumAnswer)studentAnswer;
		System.out.println("Your answer is now " + temp_a.getVal());
	}
	public void reorderAnswers()
	{
		System.out.println("Answer reordered!");
	}
	public double getValue()
	{
		NumAnswer temp_a = (NumAnswer)studentAnswer;
		return temp_a.getCredit(rightAnswer, tolerance) * maxValue;
	}
	public void save(PrintWriter output)
	{
		output.println("NumQuestion");
		output.print(maxValue);
		output.println();
		output.println(text);
		rightAnswer.save(output);
		output.println(tolerance);
		output.println();
	}
	public void saveStudentAnswer(PrintWriter output)
	{
		if (studentAnswer == null) return;
		output.println("NumAnswer");
		NumAnswer temp_a = (NumAnswer)studentAnswer;
		output.println(temp_a.getVal());
		output.println();
	}
	public void restoreStudentAnswer(Scanner input)
	{
		studentAnswer = new NumAnswer(input.nextDouble());
		input.nextLine();
	}
	public void print()
	{
		System.out.println(text);
		System.out.print("\t\t");
		System.out.print("Current answer: ");
		if (studentAnswer != null)
		{
			NumAnswer temp_a = (NumAnswer)studentAnswer;
			System.out.println(temp_a.getVal());
		}
		else
		{
			System.out.println("None");
		}
	}
}
