package Pieces;

import Exceptions.IncorrectPieceException;

/**
 * 
 * @author Fabien
 *
 * Repr�sente un pion de la combinaison
 *
 */

public class Piece {

	// ATTRIBUT
	private PieceColors color = null;
	
	
	// Ctor
	// G�n�re une pi�ce automatiquement
	public Piece() {
		
	}
	
	// Cr�� la pi�ce � partir d'une valeur de couleur
	public Piece(char cValue) throws IncorrectPieceException {
		for (PieceColors colorItem : PieceColors.values() ) {
			if(cValue == colorItem.getColor()) {
				color = colorItem;
			}
		}
		
		if(color == null)
			throw new IncorrectPieceException();
	}
	
	
	// METHODES
	
	
	
}
