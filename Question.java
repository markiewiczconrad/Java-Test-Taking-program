/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */

import java.util.Arrays;


import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;


public  abstract class Question
{
	protected String text; //For the string
	protected Answer rightAnswer; //for the Answer
	protected Answer studentAnswer; //For the Answer
	protected double maxValue; //for the double
	protected double fordouble; //for the double
	
	
	public Question(String message, double maxValue) //public constructor for the string and the double
	{
		this.text = message; //Sets the string
		this.fordouble = maxValue; //Sets the double
	}
	
	public Question(Scanner quesFile)
	{
		String qFile;
		
		qFile = quesFile.nextLine();
		
		maxValue = Double.parseDouble(qFile); //change from the double to string
		
		text = quesFile.nextLine();
	}
	
	
	
	public void print() 
	{
		System.out.print(" " + text);	//prints the string	
		System.out.print("\n");
	}
	
	
	public void setRightAnswers(Answer solution) 
	{
		this.rightAnswer = solution; //Sets the rightAnswer 
		
	}

	public abstract Answer getNewAnswer(); //Abstract since method gets implemented in the sub tree
	public abstract void getAnswerFromStudent(); //Abstract since method gets implemented in the sub tree
	public abstract double getValue(); //Abstract since method gets implemented in the sub tree
	public abstract void save(PrintWriter writeInFile);
	
	public void saveStudentAnswer(PrintWriter writeInFile)
	{
		studentAnswer.save(writeInFile);
	}
	public void restoreStudentAnswer(Scanner fileScan) 
	{
		
	}
	
}


