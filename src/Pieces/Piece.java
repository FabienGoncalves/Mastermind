package Pieces;

import Exceptions.IncorrectPieceException;

/**
 * 
 * @author Fabien
 *
 * Représente un pion de la combinaison
 *
 */

public class Piece {

	// ATTRIBUT
	private PieceColors color = null;
	
	
	// Ctor
	// Génère une pièce automatiquement
	public Piece() {
		
	}
	
	// Créé la pièce à partir d'une valeur de couleur
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
