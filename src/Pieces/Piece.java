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
		int idx = (int) ((Math.random() * 100) % PieceColors.values().length);
		color = PieceColors.values()[idx];
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
	public char ToChar() {
		return color.getColor();
	}
	
	public boolean equals(Object obj) {
		if (obj == null) 
            return false;
        
		final Piece otherPiece = (Piece) obj;
		if(color == otherPiece.color)
			return true;
		return false;
	}
	
}
