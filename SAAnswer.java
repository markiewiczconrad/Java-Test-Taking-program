//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;

public class SAAnswer extends Answer{
	protected String description;
	public SAAnswer() {}
	public SAAnswer(String d)
	{
		description = d;
	}
	//DONE: Input constructor
	public SAAnswer(Scanner input)
	{
		description = input.nextLine();
	}
	public SAAnswer(SAAnswer a)
	{
		description = a.description;
	}
	public SAAnswer clone()
	{
		SAAnswer temp = new SAAnswer(this);
		return temp;
	}
	public void print()
	{
		System.out.println(description);
	}
	//DONE: Check to make sure it's working in accordance with HW#3
	public double getCredit(Answer rightAnswer)
	{
		if (rightAnswer instanceof SAAnswer)
		{
			String temp_d = description.toLowerCase();
			if (temp_d.equals(rightAnswer.getDescription().toLowerCase()) == true)
			{
				return 1.0;
			}
			else
				return 0.0;
		}
		else
			return 0.0;
	}
	public double getValue()
	{
		return 1.0;
	}
	public String getDescription()
	{
		return description;
	}
	public void setSelected(boolean s)
	{
		System.out.println("This method is for use with multiple-choice questions, please try again.");
	}
	//DONE: save method
	public void save(PrintWriter output)
	{
		output.println(description);
	}
}
