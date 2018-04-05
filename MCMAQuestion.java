//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;

public class MCMAQuestion extends MCQuestion {
	protected Answer[] studentAnswers;
	double base;
	int scount;
	int stotal;

	//DONE: Constructors
	public MCMAQuestion(String d, double mVal, double b)
	{
		super(d, mVal);
		base = b;
		scount = 0;
		stotal = 0;
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
		scount = 0;
		stotal = 0;
	}
	public MCMAQuestion(MCMAQuestion q)
	{
		description = q.description;
		if (q.rightAnswer != null)
			rightAnswer = q.rightAnswer.clone();
		if (q.studentAnswer != null)
			studentAnswer = q.studentAnswer.clone();
		maxValue = q.maxValue;
		base = q.base;
		total = q.total;
		count = q.count;
		answers = new Answer[total];
		for (int i = 0; i < count; i++)
			answers[i] = q.answers[i].clone();
		scount = q.scount;
		stotal = q.stotal;
		studentAnswers = new Answer[stotal];
		for (int i = 0; i < scount; i++)
			studentAnswers[i] = q.studentAnswers[i].clone();
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
		for (int i = 0; i < count; i++)
			total = total + super.getValue(a);
		return total + base;
	}

	//DONE: save(PrintWriter)
	public void save(PrintWriter output)
	{
		output.println("MCMAQuestion");
		output.print(maxValue);
		output.println();
		output.println(description);
		output.print(base);
		output.println();
		output.print(count);
		output.println();
		for(int i = 0; i < count;i++)
			answers[i].save(output);
		output.println();
	}
	
	//DONE: saveStudentAnswer method
	public void saveStudentAnswer(PrintWriter output)
	{
		output.println("MCMAAnswer");
		output.println(scount);
		for (int i = 0; i < scount; i++)
			output.println(studentAnswers[i].getDescription());
		output.println();
	}
	
	//DONE: restoreStudentAnswer method
	public void restoreStudentAnswer(Scanner input)
	{
		if (scount == 0)
		{
			if (input.hasNextInt())
				scount = input.nextInt();
			else
				scount = 0;
			studentAnswers = new MCMAAnswer[scount];
			stotal = scount;
			scount = 0;
			String check = input.next() + input.nextLine();
			for (int i = 0; i < count; i++)
			{
				if (check.equals(answers[i].getDescription()))
				{
					studentAnswers[scount] = answers[i];
					scount++;
					check = input.nextLine();
					i = 0;
				}
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
			if (choice >= 'A' && choice <= 'Z' && ((int)choice - 65) < count && ((int)choice - 65) >= 0)
			{
				if (scount == stotal)
				{
					Answer[] temp = new Answer[scount];
					for (int i = 0; i < scount; i++)
						temp[i] = studentAnswers[i];
					studentAnswers = new Answer[stotal + 5];
					stotal = stotal + 5;
					for (int i = 0; i < scount; i++)
						studentAnswers[i] = temp[i];
				}
				studentAnswers[scount] = answers[(int)choice - 65];
				studentAnswers[scount].setSelected(true);
				scount++;
			}
			else if (choice >= 'a' && choice <= 'z' && ((int)choice - 97) < count && ((int)choice - 97) >= 0)
			{
				if (scount == stotal)
				{
					Answer[] temp = new Answer[scount];
					for (int i = 0; i < scount; i++)
						temp[i] = studentAnswers[i];
					studentAnswers = new Answer[stotal + 5];
					stotal = stotal + 5;
					for (int i = 0; i < scount; i++)
						studentAnswers[i] = temp[i];
				}
				studentAnswers[scount] = answers[(int)choice - 97];
				studentAnswers[scount].setSelected(true);
				scount++;
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
		for(int i = 0; i < scount; i++)
		studentAnswers[i].print();
	}

	public double getValue() {
		double total = base;
		for (int i = 0; i < scount; i++)
			total = total + studentAnswers[i].getValue();
		return total * maxValue;
	}

}
