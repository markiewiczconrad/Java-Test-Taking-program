/*
 * Name: Kashyapkumar Trivedi
 *  CS Account: ktrivedi
 * Net Id: ktrive4
 * Assignment: Third Homework Assignment
 * UIN: 660657541
 */
import java.util.*;

public class ScannerFactory 
{
	private static Scanner keyboardScanner = null;
	
	public static Scanner getKeyboard()
	{
		if(keyboardScanner == null) //to check if its null 
		{
			keyboardScanner = new Scanner(System.in); //for the scanning
			
		}
		return keyboardScanner; //return it
	}
}
