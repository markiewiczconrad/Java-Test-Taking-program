/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */



import java.io.PrintWriter;
import java.util.*;


public abstract class Answer      //We have to declare it as an abstract class since it has sub trees
{
	
	private boolean selection = false;  //First sets it equal to false
	
	
	protected Answer() //private constructor
	{

	}
	public Answer(Scanner ans) //Scanner Constructor for Answer
	{
		
	}
	
	
	
	public abstract void print(); //This will just call the method in its subtree class
	
	
	public abstract double getCredit(Answer rightAnswer); //This will just call the method in its subtree class
	
	public abstract void save(PrintWriter ans);
}



















