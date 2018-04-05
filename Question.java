//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class Question {
	protected String description;
	protected Answer rightAnswer;
	protected Answer studentAnswer;
	protected double maxValue;
	
	protected Question()
	{}
	protected Question(String d, double mVal)
	{
		description = d;
		maxValue = mVal;
	}
	//DONE: Scanner constructor
	public Question(Scanner input)
	{
		if (!input.hasNextLine()) return;
		maxValue = input.nextDouble();
		description = input.next() + input.nextLine();
	}
	public abstract Question clone();
	public void print()
	{}
	public void setRightAnswer(Answer a)
	{
		rightAnswer = a.clone();
	}
	public double getMax()
	{
		return maxValue;
	}
	public abstract Answer getNewAnswer();
	public abstract void getAnswerFromStudent();
	public abstract double getValue();
	public abstract void reorderAnswers();
	public abstract void save(PrintWriter output);
	public abstract void saveStudentAnswer(PrintWriter output);
	public abstract void restoreStudentAnswer(Scanner input);
}
