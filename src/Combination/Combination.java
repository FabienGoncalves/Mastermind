package Combination;

import java.util.ArrayList;
import java.util.Locale;

import Exceptions.IncorrectCombinationException;
import Pieces.Piece;

/**
 * 
 * @author Fabien
 *
 * Repr�sente une combinaison de Mastermind
 *
 */
public class Combination {

	// CONSTANTE
	final int NB_PIECES_IN_COMBINAISON = 4;

	// ATTRIBUTS
	private Piece[] pieceArray; // tableau de pions

	// Ctor
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
	public Piece[] getPieceArray() {
		return pieceArray;
	}

	// METHODES
	public CombinationComparer CompareWith(Combination combination) {
		int iNbGoodPieces = 0;
		int iNbGoodColors = 0;
		Piece[] pieceArrayProposition = combination.getPieceArray();
		Piece[] pieceArraySolution = getPieceArray();
		
		ArrayList<Piece> lstPieceLeftProposition = new ArrayList<Piece>();
		ArrayList<Piece> lstPieceLeftSolution = new ArrayList<Piece>();

		// on trouve les pions bien plac�s
		for (int i = 0; i < pieceArraySolution.length; i++) {
			if(pieceArrayProposition[i].equals(pieceArraySolution[i])) {
				// la pi�ce est bien plac�e
				iNbGoodPieces++;
			}
			else {
				// la pi�ce est mal plac�e, on sauve pour analyse des pions mal plac�s
				lstPieceLeftSolution.add(pieceArraySolution[i]);
				lstPieceLeftProposition.add(pieceArrayProposition[i]);
			}
		}
		
		// on trouve les pions mal plac�es
		if(!lstPieceLeftProposition.isEmpty()) {
			for (Piece piece : lstPieceLeftProposition) {
				if(lstPieceLeftSolution.contains(piece)) {
					lstPieceLeftSolution.remove(piece);
					iNbGoodColors++;
				}
			}
		}
		
		return new CombinationComparer(combination.ToString(), iNbGoodPieces, iNbGoodColors, iNbGoodPieces == NB_PIECES_IN_COMBINAISON ? true : false);
	}
	
	
	public String ToString() {
		String sCombination = "";
		for (Piece piece : pieceArray) {
			sCombination = String.format(sCombination + "%c", piece.ToChar());
		}
		return sCombination;
	}
	
}
