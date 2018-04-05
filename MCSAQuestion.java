import java.util.Scanner;
import java.io.PrintWriter;

public class MCSAQuestion extends MCQuestion{
	public MCSAQuestion() {super();}
	public MCSAQuestion(String d)
	{
		description = d;
		count = 0;
		total = 0;
		maxValue = 1.0;
	}
	public MCSAQuestion(String d, double mVal)
	{
		description = d;
		maxValue = mVal;
		count = 0;
		total = 0;
	}
	//DONE: Input constructor
	public MCSAQuestion(Scanner input)
	{
		//Gets the description and max values from the input
		super(input);
		
		//get the number of choices, if provided, else
		int choices = 0;
		if (input.hasNextInt())
			choices = input.nextInt();
		else
			choices = 26;
		
		//Parse the file until the number of choices or a blank line has been reached
		for (int i = 0; i < choices && input.hasNextLine(); i++)
			this.addAnswer(new MCSAAnswer(input));
		
	}
	public MCSAQuestion(MCSAQuestion q)
	{
		description = q.description;
		if (q.rightAnswer != null)
			rightAnswer = q.rightAnswer.clone();
		if (q.studentAnswer != null)
			studentAnswer = q.studentAnswer.clone();
		maxValue = q.maxValue;
		total = q.total;
		count = q.count;
		answers = new Answer[total];
		for (int i = 0; i < count; i++)
			answers[i] = q.answers[i].clone();
	}
	public MCSAQuestion clone()
	{
		return new MCSAQuestion(this);
	}
	public Answer getNewAnswer()
	{
		return new MCSAAnswer();
	}
	public Answer getNewAnswer(String d, double creditIfSelected)
	{
		return new MCSAAnswer(d, creditIfSelected);
	}
	//DONE: Get this thing working with the scannerfactory class
	public void getAnswerFromStudent()
	{
		boolean done = false;
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.print("Please choose your answer: ");
		char choice = input.next().charAt(0);
		input.nextLine();
		while (done == false)
		{
			if (choice >= 'A' && choice <= 'Z' && ((int)choice - 65) < count && ((int)choice - 65) >= 0)
			{
				studentAnswer = answers[(int)choice - 65];
				studentAnswer.setSelected(true);
				for (int i = 0; i < count && answers[i].equals(studentAnswer) == false; i++)
					answers[i].setSelected(false);
				done = true;
			}
			else if (choice >= 'a' && choice <= 'z' && ((int)choice - 97) < count && ((int)choice - 97) >= 0)
			{
				studentAnswer = answers[(int)choice - 97];
				studentAnswer.setSelected(true);
				for (int i = 0; i < count && answers[i].equals(studentAnswer) == false; i++)
					answers[i].setSelected(false);
				done = true;
			}
			else
			{
				System.out.print("Invalid choice made, please make a valid choice:");
				choice = input.next().charAt(0);
			}
		}
		System.out.print("Your answer is: ");
		studentAnswer.print();
	}
	public double getValue()
	{
		return studentAnswer.getValue() * maxValue;
	}
	//DONE: getValue(MCAnswer a)
	public double getValue(MCAnswer a)
	{
		return super.getValue(a);
	}
	//DONE: save method
	public void save(PrintWriter output)
	{
		output.println("MCSAQuestion");
		output.print(maxValue);
		output.println();
		output.println(description);
		output.print(count);
		output.println();
		for (int i = 0; i < count; i++)
		{
			answers[i].save(output);
		}
		output.println();
	}
	//DONE: restoreStudentAnswer(Scanner)
	public void restoreStudentAnswer(Scanner input)
	{
		if (studentAnswer == null)
		{
			String check = input.nextLine();
			for (int i = 0; i < count; i++)
			{
				if (check.equals(answers[i].getDescription()))
				{
					studentAnswer = answers[i];
				}
			}
		}
	}
	
	//DONE: saveStudentAnswer(PrintWriter)
	public void saveStudentAnswer(PrintWriter output)
	{
		output.println("MCSAAnswer");
		output.println(studentAnswer.getDescription());
		output.println();
	}
}
