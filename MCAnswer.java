/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.io.PrintWriter;
import java.util.Scanner;


public abstract class MCAnswer extends Answer 
{
	protected String text; //For constructor
	protected boolean selected; //To check if its selected
	protected boolean check; //To check 
	protected double creditifSelected; //Credit given only if its selected
	protected double pap; //For the double value in the Constuctor
	
	
	protected MCAnswer(String mcan, double dmcan) //This is the protected constructor that initialize text, dmcan, and selected
	{
		text = mcan; //Sets the string
	
		this.pap = dmcan; //Sets the double
		
		check = false; //Set to the false in the beginning
	}
	public MCAnswer(Scanner mcans)
	{
		super(mcans); //from the parents
	}
	public void print() //Will print the MCAnswer
	{
		System.out.println(" " + text);	//puts the answer string Ex) "A. bla bla bla
		
		System.out.println(" ");
    	}

	public void setSelected(boolean sS) //This will check if its selected
	{
		check = selected;        //It will set equal to false
	}

	public double getCredit(Answer rightAnswer) 
	{
		return 0.0;
	}
	
	public void save(PrintWriter writeInFile) 
	{
		writeInFile.print(text); //write
		writeInFile.print("\n"); //do the spacing
	}
}
