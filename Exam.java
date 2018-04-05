//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class Exam {
	Question[] questions;
	String description;
	int count;
	int total;
	
	public Exam(String d)
	{
		description = d;
		count = 0;
		total = 0;
	}
	//DONE: input constructor
	public Exam(Scanner input)
	{
		//Initialize the count and total variables for use later
		count = 0;
		total = 0;
		//Get the Exam Title
		if (input.hasNextLine())
			description = input.nextLine();
		
		//Keep reading until you reach an acceptable question type
		while (input.hasNextLine())
		{
			String qtype = input.nextLine();
			if (qtype.toLowerCase().equals("mcsaquestion"))
			{
				this.addQuestion(new MCSAQuestion(input));
			}
			else if (qtype.toLowerCase().equals("mcmaquestion"))
			{
				MCMAQuestion temp = new MCMAQuestion(input);
				this.addQuestion(temp);
			}
			else if (qtype.toLowerCase().equals("saquestion"))
			{
				this.addQuestion(new SAQuestion(input));
			}
		}
	}
	public void print()
	{
		System.out.println(description);
		for (int i = 0; i < count; i++)
		{
			System.out.print("\t");
			System.out.print((i + 1));
			System.out.print(" ");
			questions[i].print();
		}
	}
	public void addQuestion(Question q)
	{
		if (total == 0)
		{
			questions = new Question[5];
			total = 5;
		}
		else if (count == total)
		{
			Question[] temp = new Question[total];
			for (int i = 0; i < total; i++)
				temp[i] = questions[i];
			questions = new Question[total * 2];
			for (int i = 0; i < total; i++)
			{
				questions[i] = temp[i];
			}
			total = total * 2;
		}
		questions[count] = q.clone();
		count++;
	}
	public void reorderQuestions()
	{
		if (count == 0) return;
		Random rand = new Random();
		Question[] temp = new Question[total];
		for (int i = 0; i < count; i++)
		{
			int j = rand.nextInt(count);
			while (temp[j] != null)
				j = rand.nextInt(count);
			temp[j] = questions[i];
		}
		for (int i = 0; i < count; i++)
			questions[i] = temp[i];
	}
	public void reorderMCAnswers(int pos)
	{
		if (count == 0) return;
		if (pos < 0)
		{
			for (int i = 0; i < count; i++)
			{
				if (questions[i] instanceof MCQuestion)
				{
					questions[i].reorderAnswers();
				}
			}
		}
		else
		{
			if (questions[pos] instanceof MCQuestion)
			{
				questions[pos].reorderAnswers();
			}
		}
	}
	public void getAnswerFromStudent(int pos)
	{
		if (pos < 0)
			for (int i = 0; i < count; i++)
				questions[i].getAnswerFromStudent();
		else
			questions[pos].getAnswerFromStudent();
	}
	public double getValue()
	{
		double ret = 0.0;
		for (int i = 0; i < count; i++)
		{
			ret = ret + questions[i].getValue();
		}
		return ret;
	}
	public void reportQuestionValues()
	{
		double total = 0.0;
		double max = 0.0;
		for (int i = 0; i < count; i++)
		{
			System.out.println("Value of question " + (i + 1) + ": " + questions[i].getValue());
			total = total + questions[i].getValue();
			max = max + questions[i].getMax();
		}
		System.out.println("Total score: " + total + " out of " + max);
	}
	//DONE: Save method
	public void save(PrintWriter output)
	{
		//Write the description to the file
		output.println(description);
		output.println();
		
		//Write the questions and their answers to the file
		for (int i = 0; i < count; i++)
		{
			questions[i].save(output);
		}
	}
	//DONE: Save Student Answers method
	public void saveStudentAnswer(PrintWriter output)
	{
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.println("Please enter your name:");
		String name = input.nextLine();
		output.println(name);
		output.println();
		for (int i = 0; i < count; i++)
		{
			questions[i].saveStudentAnswer(output);
		}
	}
	//TODO: restoreStudentAnswer method
	public void restoreStudentAnswer(Scanner input)
	{
		System.out.println("Student name: "+input.nextLine());
		
		String check;
		while (input.hasNextLine())
		{
			check = input.nextLine();
			check = check.toLowerCase();
			if (check.equals("mcsaanswer"))
			{
				for (int i = 0; i < count; i++)
				{
					if (questions[i] instanceof MCSAQuestion)
					{
						questions[i].restoreStudentAnswer(input);
					}
				}
			}
			else if (check.equals("mcmaanswer"))
			{
				for (int i = 0; i < count; i++)
				{
					if (questions[i] instanceof MCMAQuestion)
					{
						questions[i].restoreStudentAnswer(input);
					}
				}
			}
			else if (check.equals("saanswer"))
			{
				for (int i = 0; i < count; i++)
				{
					if (questions[i] instanceof SAQuestion)
					{
						questions[i].restoreStudentAnswer(input);
					}
				}
			}
		}
	}
}
