package Exceptions;

@SuppressWarnings("serial")
public class IncorrectPieceException extends Exception {

	public IncorrectPieceException() {
		System.out.println("Exception : La piece est incorrecte");
	}
}
