//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class Answer {
	protected String description;
	protected Answer() {}
	//DONE: Input constructor
	public Answer(Scanner input)
	{
		description = input.nextLine();
	}
	public abstract Answer clone();
	public abstract void print();
	public abstract double getCredit(Answer rightAnswer);
	public abstract double getValue();
	public abstract void setSelected(boolean selected);
	public void setDescription(String d)
	{
		description = d;
	}
	public String getDescription()
	{
		return description;
	}
	public abstract void save(PrintWriter output);
}
