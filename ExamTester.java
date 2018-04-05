//Conrad Markiewicz
//cmarki3
//CS342
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class ExamTester {

	public static void main(String[] args) {
		System.out.println("Conrad Markiewicz");
		System.out.println("cmarki3");
		
		//Creating a test exam and populating it with questions & answers
		Scanner keyboard = ScannerFactory.getKeyboardScanner();
		System.out.println("Please enter your input file:");
		String src = keyboard.nextLine();
		File source = new File("./"+src);
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
		Exam test_exam;
		test_exam = new Exam(input);
		test_exam.print();
		//Reordering the exam
		test_exam.reorderMCAnswers(-1);
		test_exam.reorderQuestions();
		test_exam.print();
		System.out.println("Please enter your output file:");
		String dest = keyboard.nextLine();
		PrintWriter output;
		File destination;
		try
		{
			destination = new File("./"+dest);
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
		test_exam.save(output);
		test_exam.getAnswerFromStudent(-1);
		output.close();
		System.out.println("Please enter your output student answer file:");
		String dest2 = keyboard.nextLine();
		try
		{
			destination = new File("./"+dest2);
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
		catch (java.io.FileNotFoundException e)
		{
			System.out.println("File not found, aborting.");
			e.printStackTrace();
			return;
		}
		test_exam.saveStudentAnswer(output);
		output.close();
		source = new File("./"+dest);
		try
		{
			input = new Scanner(source);
		}
		catch (java.io.FileNotFoundException e)
		{
			System.out.println("File not found, aborting.");
			e.printStackTrace();
			return;
		}
		test_exam = new Exam(input);
		test_exam.print();
		source = new File("./"+dest2);
		try
		{
			input = new Scanner(source);
		}
		catch (java.io.FileNotFoundException e)
		{
			System.out.println("File not found, aborting.");
			e.printStackTrace();
			return;
		}
		test_exam.restoreStudentAnswer(input);
		test_exam.reportQuestionValues();
		output.close();
		return;
	}

}
