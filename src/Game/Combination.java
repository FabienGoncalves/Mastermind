package Game;
import java.util.Locale;

import Exceptions.IncorrectCombinationException;
import Pieces.Piece;

/**
 * 
 * @author Fabien
 *
 *         Représente une combinaison de Mastermind
 */
public class Combination {

	// CONSTANTE
	final int NB_PIECES_IN_COMBINAISON = 4;

	// ATTRIBUTS
	private Piece[] pieceArray; // tableau de pions

	// Ctor : renvoie null si la création a échoué
	// Construit une combinaison en générant les valeurs
	public Combination() {
		pieceArray = new Piece[4];
		for (int i = 0; i < pieceArray.length; i++) {
			pieceArray[i] = new Piece(); // appelle le constructeur qui génère un pion
		}
	}

	// construit une combinaison à partir d'une entrée texte
	public Combination(String sEntry) throws IncorrectCombinationException {
		// Vérifie la longeur de la chaine et formate le texte en un tableau de pions
		if (sEntry.length() == NB_PIECES_IN_COMBINAISON) {
			char[] arrayColors = sEntry.toUpperCase(Locale.ROOT).toCharArray();
			pieceArray = new Piece[4];
			for (int i = 0; i < pieceArray.length; i++) {
				try {
					pieceArray[i] = new Piece(arrayColors[i]); // appelle le constructeur qui génère un pion
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
