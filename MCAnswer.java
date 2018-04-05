//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class MCAnswer extends Answer{
	protected String description;
	protected double credit;
	protected boolean selected;
	protected MCAnswer() {}
	protected MCAnswer(String d)
	{
		description = d;
		selected = false;
	}
	protected MCAnswer(String d, double cred)
	{
		description = d;
		selected = false;
		credit = cred;
	}
	//DONE: Input constructor
	public MCAnswer(Scanner input)
	{
		if (input.hasNextDouble())
			credit = input.nextDouble();
		else
			credit = 0.0;
		description = input.nextLine();
		description.substring(1);
		selected = false;
	}
	public void print()
	{
		System.out.println(description);
	}
	public abstract double getCredit(Answer a);
	public void setSelected(boolean s)
	{
		selected = s;
	}
	public String getDescription()
	{
		return description;
	}
	//DONE: Save method
	public void save(PrintWriter output)
	{
		output.print(credit);
		output.print(' ');
		output.println(description);
	}
}
