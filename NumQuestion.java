//Conrad Markiewicz
//cmarki3
//CS 342
import java.util.Scanner;
import java.io.PrintWriter;

public class NumQuestion extends Question{
	double value;
	double tolerance;
	public NumQuestion()
	{
		super();
	}
	public NumQuestion(String text, double mVal, double tol)
	{
		description = text;
		maxValue = mVal;
		tolerance = tol;
	}
	public NumQuestion(NumQuestion t)
	{
		description = t.description;
		if (t.rightAnswer != null)
			rightAnswer = t.rightAnswer.clone();
		if (t.studentAnswer != null)
			studentAnswer = t.studentAnswer.clone();
	}
	public NumQuestion(Scanner input)
	{
		
	}
	public Question clone()
	{
		NumQuestion temp = new NumQuestion();
		temp.tolerance = tolerance;
		temp.description = description;
		temp.rightAnswer = rightAnswer.clone();
		temp.studentAnswer = studentAnswer.clone();
		temp.maxValue = maxValue;
		return temp;
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
		//input.nextLine();
		if (studentAnswer == null)
			studentAnswer = new NumAnswer(in);
		else
		{
			NumAnswer temp_a = (NumAnswer)studentAnswer;
			temp_a.setValue(in);			
		}

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
	public void save(PrintWriter output)
	{
		output.println("NumQuestion");
		output.print(maxValue);
		output.println();
		output.println(value);
		rightAnswer.save(output);
		output.println();
	}
	public void saveStudentAnswer(PrintWriter output)
	{
		output.println("NumAnswer");
		output.println(value);
		output.println();
	}
	public void restoreStudentAnswer(Scanner input)
	{
		studentAnswer = new NumAnswer(input);
	}

}
