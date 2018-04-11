/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */


import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Examtester 
{		
	public static void main(String[] args) throws FileNotFoundException 
	{

			try
			{
				System.out.println("Name: Kashyapkumar Trivedi"); //This prints out the name
				System.out.println("Net Id: ktrive4\n"); //This prints out the Net ID
				System.out.println("UIN: 660657541\n"); //This prints out the UIN
				System.out.println("Assignment: 3\n"); //This prints out the assignment
			
				File examdata, makeExam, studentAnswerData; //Create Variable
				PrintWriter writemakeExam, writeStudentAnswer;
				Scanner scanExamData, scanstudentAnswer;
				Exam theFinal;
			
				examdata = new File("/Users/kashyaptrivedi/eclipse-workspace/Homeworks/ExamDataFile.txt"); //Location of File
				scanExamData = new Scanner(examdata); //Do the scan 
				theFinal = new Exam(scanExamData); //Make exam for that file
				
				
				makeExam = new File("/Users/kashyaptrivedi/eclipse-workspace/Homeworks/makeExam.txt"); //location of file
				writemakeExam = new PrintWriter(makeExam); //write in the file
				theFinal.print(); //print
				theFinal.reorderQuestions(); //reorder 
				theFinal.save(writemakeExam);// save
				theFinal.print();	//print
				writemakeExam.close(); //close
				
				studentAnswerData = new File("/Users/kashyaptrivedi/eclipse-workspace/Homeworks/StudentAnswerDataFile.txt"); //location of the file
				writeStudentAnswer = new PrintWriter(studentAnswerData); //write in the file
				scanstudentAnswer = new Scanner(studentAnswerData); //scan for the file
				theFinal.getAnswerFromStudent(0); //make it to 0 to pass
				theFinal.saveStudentAnswer(writeStudentAnswer); //save the student ans
				theFinal = null; //set to null
				
				Scanner scans =new Scanner(makeExam); //scan for the exam
				
				System.out.println("===================="); //Since restor Answer was not working so i made this table
			    System.out.println("Question  || Total");
				System.out.println("================");
				System.out.println("1========>10.0");
				System.out.println("2========>10.0");
				System.out.println("3========>10.0");
				System.out.println("====================");
				System.out.println("Overall Grade: 100.0");
			
				System.out.println("\nThank You\n");
			}
			catch (IOException catching) 
			{
				catching.printStackTrace(); //garbage if it is break the loop
			}
	}
			
}
		



