package Game;

import java.util.Scanner;

/**
 * 
 * @author Fabien
 *
 *	G�re les input console
 */
public class ConsoleInputUserCatcher {

	private static Scanner myObj = new Scanner(System.in);
	
	public static String GetInputConsole() {
		return myObj.nextLine();
	}
}
