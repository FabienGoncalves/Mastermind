package Combination;

/**
 * 
 * @author Fabien
 *
 *	Classe contenant le résultat d'un tour de jeu de mastermind
 */

public class CombinationComparer {

	// ATTRIBUTS
	private String sUserCombination;
	private int iNbGoodPieces = 0;
	private int iNbGoodColors = 0;
	private boolean AreCombinationEquals = false;
	
	/**
	 * Constructeur de l'objet
	 * @param _sUserCombination Combinaison entree
	 * @param _iNbGoodPieces 	Nb de pions bien places
	 * @param _iNbGoodColors	Nb de couleurs mal placees
	 * @param _AreCombinationEquals	True si les combinaisons sont identiques
	 */
	public CombinationComparer(String _sUserCombination, int _iNbGoodPieces, int _iNbGoodColors, boolean _AreCombinationEquals) {
		sUserCombination = _sUserCombination;
		iNbGoodPieces = _iNbGoodPieces;
		iNbGoodColors = _iNbGoodColors;
		AreCombinationEquals = _AreCombinationEquals;
	}


	public String getUserCombination() {
		return sUserCombination;
	}

	public int getNbGoodPieces() {
		return iNbGoodPieces;
	}

	public int getNnbGoodColors() {
		return iNbGoodColors;
	}
	
	public boolean getAreCombinationEquals() {
		return AreCombinationEquals;
	}

	
}
