//Conrad Markiewicz
//cmarki3
//CS342
//HW #4
//Group Members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;

public class MCMAAnswer extends MCAnswer {
	public MCMAAnswer() {}
	public MCMAAnswer(String d)
	{
		description = d;
		selected = false;
		credit = 0.0;
	}
	public MCMAAnswer(Answer a)
	{
		if (a instanceof MCMAAnswer == false) return;
		description = ((MCAnswer)a).description;
		selected = ((MCAnswer)a).selected;
		credit = ((MCAnswer)a).credit;
	}
	public MCMAAnswer(String d, double cred)
	{
		super(d, cred);
	}
	public MCMAAnswer(Scanner input)
	{
		if (input.hasNextDouble())
			credit = input.nextDouble();
		else
			credit = 0.0;
		description = input.nextLine();
		description = description.substring(1);
		selected = false;
	}
	public Answer clone()
	{
		return new MCMAAnswer(this);
	}
	public double getCredit(Answer rightAnswer)
	{
		if (rightAnswer instanceof MCMAAnswer && selection == true)
		{
			if (description.equals(((MCMAAnswer)rightAnswer).getDescription()) == true)
				return credit;
			else
				return 0.0;
		}
		else
			return 0.0;
	}
	public double getValue()
	{
		return credit;
	}
	public String getDescription()
	{
		return description;
	}
}
