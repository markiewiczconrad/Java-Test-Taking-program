//Conrad Markiewicz
//cmarki3
//CS342
//HW #4
//Group Members: Kashyapkumar Trivedi & Jay Patel

import java.util.Scanner;

public class ScannerFactory {

	private static Scanner keyboardScanner;
	public static Scanner getKeyboardScanner()
	{
		if (keyboardScanner == null)
		{
			keyboardScanner = new Scanner(System.in);
		}
		return keyboardScanner;
	}
}
