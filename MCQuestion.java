import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class MCQuestion extends Question
{
	protected Answer[] answers;
	int count;
	int total;
	
	protected MCQuestion()
	{}
	//DONE: Initializer constructor
	protected MCQuestion(String d, double mVal)
	{
		super(d, mVal);
	}
	
	//DONE: Input constructor
	protected MCQuestion(Scanner input)
	{
		super(input);
	}
	
	public void print()
	{
		System.out.println(description);
		
		for (int i = 0; i < count; i++)
		{
			System.out.print("\t\t");
			System.out.print((char)(i + 65));
			System.out.print(' ');
			answers[i].print();
		}
	}
	public void addAnswer(Answer newAnswer)
	{
		Answer a = newAnswer.clone();
		if (total == 0)
		{
			answers = new MCAnswer[5];
			total = 5;
		}
		else if (total == count)
		{
			Answer[] temp = new Answer[total];
			for (int i = 0; i < count; i++)
			{
				temp[i] = answers[i];
			}
			answers = new MCAnswer[total*2];
			for (int i = 0; i < count; i++)
			{
				answers[i] = temp[i];
			}
			total = total * 2;
		}
		answers[count] = a;
		count = count + 1;
	}
	public void reorderAnswers()
	{
		if (count == 0) return;
		Random rand = new Random();
		Answer[] temp = new Answer[total];
		for(int i = 0; i < count; i++)
		{
			int j = rand.nextInt(count);
			while (temp[j] != null)
				j = rand.nextInt(count);
			temp[j] = answers[i];
		}
		for (int i = 0; i < count; i++)
		{
			answers[i] = temp[i];
		}
	}
	//DONE: getValue()
	public double getValue(MCAnswer a)
	{
		for (int i = 0; i < count; i++)
		{
			if (answers[i].getDescription().equals(a.getDescription()))
				return maxValue;
		}
		return 0;
	}
	
	public abstract void save (PrintWriter output);
}
