//Conrad Markiewicz
//cmarki3
//An implementation of the NumAnswer class
import java.util.Scanner;
import java.io.PrintWriter;

public class NumAnswer extends Answer{
	protected double value;
	
	public NumAnswer()
	{
		
	}
	public NumAnswer(Scanner input)
	{
		value = input.nextDouble();
		input.nextLine();
	}
	public NumAnswer(double v)
	{
		value = v;
	}
	public NumAnswer(NumAnswer n)
	{
		value = n.value;
	}
	public NumAnswer clone()
	{
		NumAnswer temp = new NumAnswer(this);
		return temp;
	}
	public void print()
	{
		System.out.println(value);
	}
	
	public double getCredit(Answer rightAnswer)
	{
		if (rightAnswer instanceof NumAnswer)
		{
			NumAnswer temp_a = (NumAnswer)rightAnswer;
			if (value == temp_a.value)
			{
				return 1.0;
			}
		}
		return 0.0;
	}
	public double getValue()
	{
		return 1.0;
	}
	public double getVal()
	{
		return value;
	}
	public void setSelected(boolean s)
	{
		System.out.println("This method is for use with multiple-choice questions, please try again.");
	}
	public void save(PrintWriter output)
	{
		output.println(value);
	}
	public void setValue(double in)
	{
		value = in;
	}
}
