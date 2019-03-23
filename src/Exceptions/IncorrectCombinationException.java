package Exceptions;

import sun.rmi.runtime.Log;
import sun.util.logging.resources.logging;

@SuppressWarnings("serial")
public class IncorrectCombinationException extends Exception {

	public IncorrectCombinationException() {
		System.out.println("Exception : La combinaison est incorrecte");
	}
}
