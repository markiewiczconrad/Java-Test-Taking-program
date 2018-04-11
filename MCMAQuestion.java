/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MCMAQuestion extends MCQuestion 
{
	protected double leastCredit;
	protected double ansoftheirNum;
	protected double score = 0;
	protected ArrayList<Answer> answerForStudent = new ArrayList<Answer>();	
	
	
	MCMAQuestion(String text, double maxValue, double bCredit)
	{
		super(text, maxValue);
		maxValue = maxValue;
		bCredit = leastCredit;
		score = 0;
	}
	
	
	public MCMAQuestion(Scanner writeInFile) 
	{
		super(writeInFile);
		
		  String  examTitle = writeInFile.nextLine(); //make string variable to the next line
		  leastCredit = Double.parseDouble(examTitle); //to change from double to string
	
		  examTitle = writeInFile.nextLine(); //write in the file
		  ansoftheirNum = Double.parseDouble(examTitle); //to change from double to string
		
		  String mcmaQuestion = writeInFile.nextLine();
		 
		  int i = 0;
		  
		  while(i < ansoftheirNum) //check through whoile arrry
		  {
			  String mcQuestion = mcmaQuestion;
			  
			  String splitStrd[] = mcQuestion.split(" "); //split it
			  
			  double y = Double.parseDouble(splitStrd[0]);
			  
			  String AnswerText = "";
			  for(int j = 1;j < splitStrd.length;j++) 
			  {
				  AnswerText += splitStrd[j]+" "; //split for the text
			  }
			
			  MCAnswer a1 = new MCMAAnswer(AnswerText, y);
			
			  addAnswer(a1); //add the ans
			  
			  if(writeInFile.hasNextLine())
			  {
				  mcmaQuestion = writeInFile.nextLine(); //check if it next line
			  }
			  i++; //increment the i
		  }
		  
	}

	public Answer getNewAnswer(){
		Answer f1 = new MCMAAnswer("",0);
		return f1;
	}
	
	public Answer getNewAnswer(String s, double creditIfSelected) {
		Answer f3 = new MCMAAnswer(s, creditIfSelected);	
		return f3;
	}
	
	public void getAnswerFromStudent() 
	{
		int getA = 0;
		while( getA != 1) 
		{
			System.out.println("Note: Enter Y when you want to exit\n");	
			System.out.println("For MCMA Question, provide a letter please: \n");	   
			Scanner keyboard = ScannerFactory.getKeyboard();
			char input = keyboard.next().charAt(0);
			
			switch(input)
			{
			case 'A': answerForStudent.add(questions2.get(0)); //check if its 'a' and add question 
								  break;
			case 'a': answerForStudent.add(questions2.get(0)); //check and add question
			  					  break;
			case 'B': answerForStudent.add(questions2.get(1));
								  break;
			case 'b': answerForStudent.add(questions2.get(1));
			  					  break;
			case 'C': answerForStudent.add(questions2.get(2));
								  break;
			case 'c': answerForStudent.add(questions2.get(2));
			  					  break;
			case 'D': answerForStudent.add(questions2.get(3));
			                      break;
			case 'd': answerForStudent.add(questions2.get(3));
            						 break;
			case 'E': answerForStudent.add(questions2.get(4));
								 break;
			case 'e': answerForStudent.add(questions2.get(4));
			 					break;
			case 'Y':  return; 
								 default:
			}
			System.out.println("If done with MCMA question... Please Enter 1 for Yes and Please Enter 0 for No\n");
			getA = keyboard.nextInt();
			
		}
		
	}
	
	public double getValue() 
	{
			int x = 0;
			do
			{
				MCAnswer ans = (MCAnswer) answerForStudent.get(x);
				
				score = score + super.getValue(ans);
				
				x++;
			}while(x < answerForStudent.size());
			
			return score + leastCredit;
	}
	
	
	public void save(PrintWriter writeInFile) 
	{
		super.save(writeInFile); //from the parents
		
		writeInFile.print("\n");
		
		writeInFile.print(leastCredit);
		
		writeInFile.print("\n");
		
		writeInFile.print(ansoftheirNum);
		
		
		for(int i = 0; i < questions2.size(); i++) 
		{
			questions2.get(i).save(writeInFile); //check through the whole loop and write in 
		}
		
		writeInFile.print("\n");

	}
	
	public void saveStudentAnswer(PrintWriter writeInFile)  //save the student ans
	{
		for(int i = 0; i < answerForStudent.size(); i++)
		{
			writeInFile.print("\n");
			
			answerForStudent.get(i).save(writeInFile);
			writeInFile.print("\n");
		}
	
		
	
	}

}