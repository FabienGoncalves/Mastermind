package Combination;

import java.util.ArrayList;
import java.util.Locale;

import Exceptions.IncorrectCombinationException;
import Pieces.Piece;

/**
 * 
 * @author Fabien
 *
 * Represente une combinaison de Mastermind
 *
 */
public class Combination {

	// CONSTANTE
	final int NB_PIECES_IN_COMBINAISON = 4;

	// ATTRIBUTS
	private Piece[] pieceArray; // tableau de pions

	/**
	 * Constructeur sans parametre, il genere une combinaison
	 */
	public Combination() {
		pieceArray = new Piece[4];
		for (int i = 0; i < pieceArray.length; i++) {
			pieceArray[i] = new Piece();
		}
	}

	/**
	 * Constructeur de combinaison a partir d'une entree texte
	 * @param sEntry Chaine de caracteres a convertir en combinaison
	 * @throws IncorrectCombinationException : la chaine passee n'est pas une combinaison acceptable
	 */
	public Combination(String sEntry) throws IncorrectCombinationException {
		// Verifie la longeur de la chaine et formate le texte en un tableau de pions
		if (sEntry.length() == NB_PIECES_IN_COMBINAISON) {
			char[] arrayColors = sEntry.toUpperCase(Locale.ROOT).toCharArray();
			pieceArray = new Piece[4];
			for (int i = 0; i < pieceArray.length; i++) {
				try {
					pieceArray[i] = new Piece(arrayColors[i]);
				} catch (Exception e) {
					throw new IncorrectCombinationException();
				}
			}
		} else {
			throw new IncorrectCombinationException();
		}
	}

	// ACCESSEURS
	/**
	 * Acesseur tableau de pions
	 * @return le tableau de pions de la combinaison
	 */
	public Piece[] getPieceArray() {
		return pieceArray;
	}

	// METHODES
	/**
	 * Compare la combinaison actuelle avec celle passee en parametre
	 * @param combination = La combinaison entree par le joueur
	 * @return un objet contenant le résultat de la comparaison
	 */
	public CombinationComparer CompareWith(Combination combination) {
		int iNbGoodPieces = 0;
		int iNbGoodColors = 0;
		Piece[] pieceArrayProposition = combination.getPieceArray();
		Piece[] pieceArraySolution = getPieceArray();
		
		ArrayList<Piece> lstPieceLeftProposition = new ArrayList<Piece>();
		ArrayList<Piece> lstPieceLeftSolution = new ArrayList<Piece>();

		// on trouve les pions bien places
		for (int i = 0; i < pieceArraySolution.length; i++) {
			if(pieceArrayProposition[i].equals(pieceArraySolution[i])) {
				// la piece est bien placee
				iNbGoodPieces++;
			}
			else {
				// la piece est mal placee, on sauve pour analyse des pions mal places
				lstPieceLeftSolution.add(pieceArraySolution[i]);
				lstPieceLeftProposition.add(pieceArrayProposition[i]);
			}
		}
		
		// on trouve les pions mal placees
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
	
	/**
	 * Transforme la combinaison en chaine pour l'affichage
	 * @return une chaine representant la combinaison
	 */
	public String ToString() {
		String sCombination = "";
		for (Piece piece : pieceArray) {
			sCombination = String.format(sCombination + "%c", piece.ToChar());
		}
		return sCombination;
	}
	
}
