package Pieces;

import Exceptions.IncorrectPieceException;

/**
 * 
 * @author Fabien
 *
 * Represente un pion d'une combinaison
 *
 */

public class Piece {

	// ATTRIBUT
	private PieceColors color = null;
	
	/**
	 * Constructeur de pion, il genere un pion
	 */
	public Piece() {
		int idx = (int) ((Math.random() * 100) % PieceColors.values().length);
		color = PieceColors.values()[idx];
	}
	
	/**
	 * Constructeur de pion a partir d'une valeur de couleur
	 * @param cValue Valeur de couleur
	 * @throws IncorrectPieceException La couleur n'est pas correcte
	 */
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
	/**
	 * Renvoi un caractere representant le pion par sa couleur
	 * @return La couleur du pion (char)
	 */
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
