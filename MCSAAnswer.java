import java.util.Scanner;

//Conrad Markiewicz
//cmarki3
//CS342

public class MCSAAnswer extends MCAnswer{
	public MCSAAnswer() {}
	public MCSAAnswer(String d)
	{
		description = d;
		selected = false;
		credit = 0.0;
	}
	public MCSAAnswer(MCSAAnswer a)
	{
		description = a.description;
		selected = a.selected;
		credit = a.credit;
	}
	public MCSAAnswer(String d, double cred)
	{
		super(d, cred);
	}
	public MCSAAnswer(Scanner input)
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
		return new MCSAAnswer(this);
	}
	public double getCredit(Answer rightAnswer)
	{
		if (rightAnswer instanceof MCSAAnswer && selected == true)
		{
			if (description.equals(rightAnswer.getDescription()) == true)
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
