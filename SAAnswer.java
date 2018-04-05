/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class SAAnswer extends Answer
{
	protected String text; //Protected String 
	
	SAAnswer(String te)
	{
		
		text = te; //This initialize it
	}
	public SAAnswer(Scanner saans)
	{
		
	}
	public void print()
	{
		System.out.println(" " + text);     //This will print out the text
	}
	public double getCredit(Answer rightAnswer) //This function will get the credit if it equals
	{
		if(rightAnswer instanceof SAAnswer)   //This checks it
		{
			SAAnswer saas = (SAAnswer) rightAnswer;              
			if(text.equalsIgnoreCase(saas.text)) //Check if the strings are equal
			{
				
				return 1; //If equal then return 1
			}
			
		}
		
		return 0; //return 0 otherwise
	}
	
	public void save(PrintWriter ans)
	{
		ans.print(text); //save it
	}
	
}
