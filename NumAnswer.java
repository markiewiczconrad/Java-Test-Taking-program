//Conrad Markiewicz
//cmarki3
//An implementation of the NumAnswer class, based on code by Kashyapkumar Trivedi (ktriv4)

import java.io.PrintWriter;
import java.util.Scanner;

public class NumAnswer extends Answer{

	protected double text;
	
	public NumAnswer()
	{
		
	}
	
	public NumAnswer(double txt)
	{
		text = txt;
	}
	
	public NumAnswer(Scanner input)
	{
		text = input.nextDouble();
		input.nextLine();
	}
	
	public void print()
	{
		System.out.println(" " + text);
	}
	
	public double getCredit(Answer rAnswer)
	{
		if (rAnswer instanceof NumAnswer)
		{
			NumAnswer nA = (NumAnswer) rAnswer;
			if (text == nA.text)
			{
				return 1;
			}
		}
		return 0;
	}
	
	public void save(PrintWriter ans)
	{
		ans.print(text);
	}
	
}
