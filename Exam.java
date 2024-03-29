/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Fourth Homework Assignment
 * Group members: Conrad Markiewicz, Jay Patel
 * UIN: 660657541
 */


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Random;


public class Exam  
{

	

	private ArrayList<Question>questions1 = new ArrayList<Question>(); //array list for the questions
	
	private String text; //For the String Exam
	
	private  double reportQuestionTotal; //For the reportQuestion
	
	private static double examTotal;    //the total
	
	private String printExam; 
	
	Exam(String exam) //Private constructor that sets the string
	{
		this.text = exam; //This initialize it
	
		reportQuestionTotal = 0; //Make it equal to 0 
		
		examTotal = 0; //Set this to 0 
	}
	
	Exam(Scanner EDF)
	{
		String examEDF;
		
		examEDF = EDF.nextLine(); //to go to the new line
		
		printExam = examEDF;
		
		EDF.nextLine();
		do
		{
			examEDF = EDF.nextLine();
			switch(examEDF)
			{
				case "MCSAQuestion" : Question ques1 = new MCSAQuestion(EDF); //To check if its MCSAQuestion
									  addQuestion(ques1);
									  break;
				case "SAQuestion": Question ques2 = new SAQuestion(EDF); //To check if its SAQuestion 
								   addQuestion(ques2);
								   break;
				case "MCMAQuestion" : Question ques3 = new MCMAQuestion(EDF); //To check if its MCMAQuestion
								      addQuestion(ques3);
								      break;
				case "NumQuestion"	: Question ques4 = new NumQuestion(EDF);
									  addQuestion(ques4);
									  break;
								      default:
			}
		}while(EDF.hasNextLine()); //While its not space
	}
	
	
	public void addQuestion(Question question) //this will add the questions
	{
		questions1.add(question); //This adds the questions in the array list
	}
	
	public void removeQuestion(int question)
	{
		questions1.remove(question);
	}
	
	public void print()  //This will print the questions
	{
		
		int n = 1;
		
		for(int i = 0; i < questions1.size(); i++) //This will check the whole for loop of the arraylist
		{
			System.out.print(n);
			
			questions1.get(i).print(); //This gets the question and print
			
			n++; //This is to increment question 1 2 and so on
		}
		
		System.out.print("\n");
	}
	
	public void reorderQuestions()
	{
		Collections.shuffle(questions1); //this will shuffle the arraylist of the questions
	}
	
	
	public void reorderMCAnswers(int p) //This method will reorder MCAnswer based on the position
	{
		if( p <= -1) //To check if userinput is less than for equal to -1
		{
			for(int i = 0; i < questions1.size(); i++) //To go through all array
			{
				Question q = questions1.get(i); //Make object of Question class
				if(q instanceof MCQuestion) //Check with the object if it is from MCQuestion
				{
					((MCQuestion) questions1.get(i)).reorderAnswers(); //This will reorder if position is less or equal to -1
				}
			}
		}
	
		else
		{
			((MCQuestion) questions1.get(p-1)).reorderAnswers(); //else it will reorder if its not less or equal to -1
		}
		
	}
	
	
	public void getAnswerFromStudent(int position) //This will get the answer according to the position
	{
		int i;
		
		if (position < 0)
			for(i = 0; i < questions1.size(); i++) //To check the whole array 
			{
				System.out.println("\nEnter your answer for question "+(i+1) +" : ");
				questions1.get(i).getAnswerFromStudent(); // This gets the answer from student for the question each
			}
		else
			questions1.get(position).getAnswerFromStudent();
	}
	public double getValue() //this will get the val 
	{
			
		for(int i = 0; i <questions1.size(); i++) //Checking the whole array
		{
			examTotal = examTotal +  questions1.get(i).fordouble; //This will get the total points for the exam
				
		}
		System.out.println("  \nThe total points can be get in the Exam is: " + examTotal + "\n");
		
		return examTotal; //This method will return the total exam points
	}
	
	public void reportQuestionValues() //This prints the table of question with the total
	{
		System.out.println("\n\nWarning.....Exam Result is Coming now....\n");
		
		System.out.println("====================");
		
		System.out.println("Question  || Total");
		
		System.out.println("====================");
		
		System.out.println("\n====================\n");
		
		int pq = 1;
		
		for(int i = 0; i < questions1.size(); i++)  //Check the entire array
		{

			System.out.println("   " + pq  + "========>" + questions1.get(i).getValue()); //Print The Question question and the total points
			
			reportQuestionTotal = reportQuestionTotal + questions1.get(i).getValue();
			
			pq++; //So it increments to all questions
		}
		
		System.out.println("\n====================\n");
		
		System.out.println(" \n Overall Grade: " + reportQuestionTotal); //Print out the total
		
	}
	public void save(PrintWriter writeInFile) 
	{
		int i;
		
		writeInFile.println(printExam);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		writeInFile.println(timeStamp);
		writeInFile.println();
		
		i = 0;
		
		while(i < questions1.size())
		{
			if(questions1.get(i) instanceof MCMAQuestion) //Check if its MCMA Question
			{	
				questions1.get(i).save(writeInFile);
				
				writeInFile.print("\n");
			}
			if(questions1.get(i) instanceof MCSAQuestion) //Check if its MCSAQuestion
			{	
				questions1.get(i).save(writeInFile);
				
				writeInFile.print("\n");
			}
			if(questions1.get(i) instanceof SAQuestion) //Check if its SAQuestion 
			{	
				questions1.get(i).save(writeInFile);
				
				writeInFile.print("\n");
			}
			if(questions1.get(i) instanceof NumQuestion) //Check if its NumQuestion
			{
				questions1.get(i).save(writeInFile);
				
				writeInFile.print("\n");
			}
			i++;
		}
	}
	
	public void saveStudentAnswer(PrintWriter writeInFile)
	{
		
		String userName;
		
		System.out.println("What is your name?\n");
		
		Scanner scanForTheNname = ScannerFactory.getKeyboardScanner();
		
		userName = scanForTheNname.nextLine();
		
		writeInFile.print(userName);
		writeInFile.print("\n\n");
		int i = 0;
		do
		{
			if(questions1.get(i) instanceof SAQuestion)  //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
				
			
			}
			
			if(questions1.get(i) instanceof MCSAQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
				
				
			}
			
			if(questions1.get(i) instanceof MCMAQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);			
			}
			
			if(questions1.get(i) instanceof NumQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
			}
			i++;
		}while(i < questions1.size());
		
			
	}

	public void saveStudentAnswer(PrintWriter writeInFile, String sourceFile)
	{
		
		String userName;
		
		System.out.println("What is your name?\n");
		
		Scanner scanForTheNname = ScannerFactory.getKeyboardScanner();
		
		userName = scanForTheNname.nextLine();
		
		writeInFile.println(userName);
		writeInFile.println(sourceFile);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		writeInFile.println(timeStamp);
		writeInFile.println();
		int i = 0;
		do
		{
			if(questions1.get(i) instanceof SAQuestion)  //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
				
			
			}
			
			if(questions1.get(i) instanceof MCSAQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
				
				
			}
			
			if(questions1.get(i) instanceof MCMAQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);			
			}
			
			if(questions1.get(i) instanceof NumQuestion) //check if its what kind of question
			{
				questions1.get(i).saveStudentAnswer(writeInFile);
			}
			i++;
		}while(i < questions1.size());
		
			
	}
	
	public void restoreStudentAnswers(Scanner writInfile) 
	{
		System.out.println("Student name: "+writInfile.nextLine());
		
		String check;
		while (writInfile.hasNextLine())
		{
			check = writInfile.nextLine();
			check = check.toLowerCase();
			if (check.equals("mcsaanswer"))
			{
				for (int i = 0; i < questions1.size(); i++)
				{
					if (questions1.get(i) instanceof MCSAQuestion)
					{
						questions1.get(i).restoreStudentAnswer(writInfile);
					}
				}
			}
			else if (check.equals("mcmaanswer"))
			{
				for (int i = 0; i < questions1.size(); i++)
				{
					if (questions1.get(i) instanceof MCMAQuestion)
					{
						questions1.get(i).restoreStudentAnswer(writInfile);
					}
				}
			}
			else if (check.equals("saanswer"))
			{
				for (int i = 0; i < questions1.size(); i++)
				{
					if (questions1.get(i) instanceof SAQuestion)
					{
						questions1.get(i).restoreStudentAnswer(writInfile);
					}
				}
			}
			else if (check.equals("numanswer"))
			{
				for (int i = 0; i < questions1.size(); i++)
				{
					if (questions1.get(i) instanceof NumQuestion)
					{
						questions1.get(i).restoreStudentAnswer(writInfile);
					}
				}
			}
		}

	}
}

