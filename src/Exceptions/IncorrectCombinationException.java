package Exceptions;

@SuppressWarnings("serial")
public class IncorrectCombinationException extends Exception {

	public IncorrectCombinationException() {
		System.out.println("Exception : La combinaison est incorrecte");
	}
}
