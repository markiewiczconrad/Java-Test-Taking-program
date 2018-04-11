//Conrad Markiewicz
//cmarki3
//Groupmates: Kashyapkumar Trivedi & Jay Patel
//CS 342 HW 4

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExamTaker {

	public static void main(String[] args) {
		Scanner keyboard = ScannerFactory.getKeyboardScanner();
		System.out.println("Conrad Markiewicz");
		System.out.println("cmarki3");
		System.out.print("Please enter the location of your exam file: ");
		String src = keyboard.nextLine();
		File source = new File(src);
		Scanner input;
		try
		{
			input = new Scanner(source);
		}
		catch (java.io.FileNotFoundException e1)
		{
			System.out.println("File not found, aborting.");
			e1.printStackTrace();
			return;
		}
		Exam exam = new Exam(input);
		exam.print();
		char cont;
		do
		{
			System.out.print("Please choose a question to answer.\nTo answer all question, enter a negative number: ");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			exam.getAnswerFromStudent(choice-1);
			System.out.print("Would you like to answer another question? ");
			cont = keyboard.nextLine().charAt(0);
		} while (cont == 'y' || cont == 'Y');
		System.out.println("Please enter your destination answer file:");
		String dest = keyboard.nextLine();
		PrintWriter output;
		File destination;
		try
		{
			destination = new File(dest);
			destination.createNewFile();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
			return;
		}
		try
		{
			output = new PrintWriter(destination);
		}
		catch (java.io.FileNotFoundException e1)
		{
			System.out.println("File not found, aborting.");
			e1.printStackTrace();
			return;
		}
		exam.saveStudentAnswer(output,src);
		output.close();
	}
}
