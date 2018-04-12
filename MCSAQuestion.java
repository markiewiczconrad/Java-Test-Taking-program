//Conrad Markiewicz
//cmarki3
//CS342
//HW #4
//Group Members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MCSAQuestion extends MCQuestion{
	protected MCSAAnswer rightAnswer;
	protected MCSAAnswer studentAnswer;
	public MCSAQuestion() {super();}
	public MCSAQuestion(String d)
	{
		text = d;
		maxValue = 1.0;
	}
	public MCSAQuestion(String d, double mVal)
	{
		text = d;
		maxValue = mVal;
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
		text = q.text;
		if (q.rightAnswer != null)
			rightAnswer = new MCSAAnswer(q.rightAnswer);
		if (q.studentAnswer != null)
			studentAnswer = new MCSAAnswer(q.studentAnswer);
		maxValue = q.maxValue;
		questions2 = new ArrayList<MCAnswer>();
		for (int i = 0; i < questions2.size(); i++)
		{
			MCSAAnswer temp_b = new MCSAAnswer((MCSAAnswer)q.questions2.get(i));
			questions2.add(temp_b);
		}
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
			if (choice >= 'A' && choice <= 'Z' && ((int)choice - 65) < questions2.size() && ((int)choice - 65) >= 0)
			{
				studentAnswer = (MCSAAnswer)questions2.get((int)choice - 65);
				studentAnswer.setSelected(true);
				for (int i = 0; i < questions2.size() && questions2.get(i).equals(studentAnswer) == false; i++)
					questions2.get(i).setSelected(false);
				done = true;
			}
			else if (choice >= 'a' && choice <= 'z' && ((int)choice - 97) < questions2.size() && ((int)choice - 97) >= 0)
			{
				studentAnswer = (MCSAAnswer)questions2.get((int)choice - 97);
				studentAnswer.setSelected(true);
				for (int i = 0; i < questions2.size() && questions2.get(i).equals(studentAnswer) == false; i++)
					questions2.get(i).setSelected(false);
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
		output.println(text);
		output.print(questions2.size());
		output.println();
		for (int i = 0; i < questions2.size(); i++)
		{
			questions2.get(i).save(output);
		}
		output.println();
	}
	//DONE: restoreStudentAnswer(Scanner)
	public void restoreStudentAnswer(Scanner input)
	{
		if (studentAnswer == null)
		{
			String check = input.nextLine();
			for (int i = 0; i < questions2.size(); i++)
			{
				if (check.equals(questions2.get(i).getDescription()))
				{
					studentAnswer = (MCSAAnswer)questions2.get(i);
				}
			}
		}
	}
	
	//DONE: saveStudentAnswer(PrintWriter)
	public void saveStudentAnswer(PrintWriter output)
	{
		if (studentAnswer == null) return;
		output.println("MCSAAnswer");
		output.println(studentAnswer.getDescription());
		output.println();
	}
	public void setRightAnswers(Answer correct)
	{
		rightAnswer = new MCSAAnswer((MCSAAnswer)correct);
	}
}
