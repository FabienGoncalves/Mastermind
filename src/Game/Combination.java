package Game;
import java.util.Locale;

import Exceptions.IncorrectCombinationException;
import Pieces.Piece;

/**
 * 
 * @author Fabien
 *
 *         Repr�sente une combinaison de Mastermind
 */
public class Combination {

	// CONSTANTE
	final int NB_PIECES_IN_COMBINAISON = 4;

	// ATTRIBUTS
	private Piece[] pieceArray; // tableau de pions

	// Ctor : renvoie null si la cr�ation a �chou�
	// Construit une combinaison en g�n�rant les valeurs
	public Combination() {
		pieceArray = new Piece[4];
		for (int i = 0; i < pieceArray.length; i++) {
			pieceArray[i] = new Piece(); // appelle le constructeur qui g�n�re un pion
		}
	}

	// construit une combinaison � partir d'une entr�e texte
	public Combination(String sEntry) throws IncorrectCombinationException {
		// V�rifie la longeur de la chaine et formate le texte en un tableau de pions
		if (sEntry.length() == NB_PIECES_IN_COMBINAISON) {
			char[] arrayColors = sEntry.toUpperCase(Locale.ROOT).toCharArray();
			pieceArray = new Piece[4];
			for (int i = 0; i < pieceArray.length; i++) {
				try {
					pieceArray[i] = new Piece(arrayColors[i]); // appelle le constructeur qui g�n�re un pion
				} catch (Exception e) {
					throw new IncorrectCombinationException();
				}
			}
		} else {
			throw new IncorrectCombinationException();
		}
	}

	// ACCESSEURS

	// METHODES
	
}
