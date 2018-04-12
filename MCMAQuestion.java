//Conrad Markiewicz
//cmarki3
//CS342
//HW #4
//Group members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MCMAQuestion extends MCQuestion {
	protected double base;
	protected MCMAAnswer rightAnswer;
	protected MCMAAnswer studentAnswer;

	//DONE: Constructors
	public MCMAQuestion(String d, double mVal, double b)
	{
		super(d, mVal);
		base = b;
	}
	public MCMAQuestion(Scanner input)
	{
		super(input);
		int choices = 0;
		if(input.hasNextDouble())
			base = input.nextDouble();
		else
			base = 0.0;
		if(input.hasNextInt())
			choices = input.nextInt();
		else
			choices = 26;
		for (int i = 0; i < choices && input.hasNextLine(); i++)
			this.addAnswer(new MCMAAnswer(input));
	}
	public MCMAQuestion(MCMAQuestion q)
	{
		text = q.text;
		if (q.rightAnswer != null)
			rightAnswer = new MCMAAnswer(q.rightAnswer);
		if (q.studentAnswer != null)
			studentAnswer = new MCMAAnswer(q.studentAnswer);
		maxValue = q.maxValue;
		base = q.base;
		questions2 = new ArrayList<MCAnswer>();
		for (int i = 0; i < questions2.size(); i++)
		{
			MCMAAnswer temp_a = new MCMAAnswer(q.questions2.get(i));
			questions2.add(temp_a);
		}
	}
	
	public Answer getNewAnswer()
	{
		return new MCMAAnswer();
	}
	public Answer getNewAnswer(String d, double b)
	{
		return new MCMAAnswer(d, b);
	}
	
	//DONE: getValue(Answer)
	public double getValue(MCAnswer a) {
		double total = 0.0;
		for (int i = 0; i < questions2.size(); i++)
			total = total + super.getValue(a);
		return total + base;
	}

	//DONE: save(PrintWriter)
	public void save(PrintWriter output)
	{
		output.println("MCMAQuestion");
		output.print(maxValue);
		output.println();
		output.println(text);
		output.print(base);
		output.println();
		output.print(questions2.size());
		output.println();
		for(int i = 0; i < questions2.size();i++)
			questions2.get(i).save(output);
		output.println();
	}
	
	//DONE: saveStudentAnswer method
	public void saveStudentAnswer(PrintWriter output)
	{
		int scount = 0;
		for (int i = 0; i < questions2.size(); i++)
		{
			if (((MCAnswer)questions2.get(i)).getSelected())
				scount++;
		}
		if (scount == 0) return;
		output.println("MCMAAnswer");
		output.println(scount);
		for (int i = 0; i < questions2.size(); i++)
		{
			if (((MCAnswer)questions2.get(i)).getSelected())
				output.println(questions2.get(i).getDescription());
		}
		output.println();
	}
	
	//DONE: restoreStudentAnswer method
	public void restoreStudentAnswer(Scanner input)
	{
		int scount = input.nextInt();
		input.nextLine();
		for (int i = 0; i < scount; i++)
		{
			String check = input.nextLine();
			for (int j = 0; j < questions2.size(); j++)
			{
				if (check.equalsIgnoreCase(questions2.get(j).getDescription()))
				((MCAnswer)questions2.get(j)).setSelected(true);
			}
		}
	}

	//DONE: Clone method
	public Question clone() {
		return new MCMAQuestion(this);
	}

	//DONE: getAnswerFromStudent()
	public void getAnswerFromStudent() {
		boolean done = false;
		Scanner input = ScannerFactory.getKeyboardScanner();
		System.out.print("Please choose your answer: ");
		char choice = input.next().charAt(0);
		input.nextLine();
		char cont;
		while (done == false)
		{
			if (choice >= 'A' && choice <= 'Z' && ((int)choice - 65) < questions2.size() && ((int)choice - 65) >= 0)
			{
				if (((MCAnswer)questions2.get((int)choice - 65)).getSelected())
					((MCAnswer)questions2.get((int)choice - 65)).setSelected(false);
				else
					((MCAnswer)questions2.get((int)choice - 65)).setSelected(true);
			}
			else if (choice >= 'a' && choice <= 'z' && ((int)choice - 97) < questions2.size() && ((int)choice - 97) >= 0)
			{
				if (((MCAnswer)questions2.get((int)choice - 97)).getSelected())
					((MCAnswer)questions2.get((int)choice - 97)).setSelected(false);
				else
					((MCAnswer)questions2.get((int)choice - 97)).setSelected(true);
			}
			else
			{
				System.out.print("Invalid choice made, please make a valid choice:");
				choice = input.next().charAt(0);
			}
			System.out.print("Would you like to choose an additional answer?(Y/N):");
			cont = input.next().charAt(0);
			if (cont == 'n' || cont == 'N')
				done = true;
			else
			{
				System.out.print("Please choose your answer: ");
				choice = input.next().charAt(0);
			}
			input.nextLine();
		}
		System.out.print("Your answers are: ");
		for(int i = 0; i < questions2.size(); i++)
			if (((MCAnswer)questions2.get(i)).getSelected())
			{
				questions2.get(i).print();
			}
				
	}

	public double getValue() {
		double total = base;
		for (int i = 0; i < questions2.size(); i++)
			if (((MCAnswer)questions2.get(i)).getSelected())
				total = total + questions2.get(i).getValue();
		return total * maxValue;
	}
	public void setRightAnswers(Answer correct)
	{
		rightAnswer = new MCMAAnswer((MCMAAnswer)correct);
	}
}
