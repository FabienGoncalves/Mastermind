package Game.IOManager;

import java.util.Scanner;

/**
 * 
 * @author Fabien
 *
 *	Gere les inputs console
 */
public class ConsoleInputUserCatcher {

	private static Scanner myObj = new Scanner(System.in);
	
	public static String GetInputConsole() {
		return myObj.nextLine();
	}
}
