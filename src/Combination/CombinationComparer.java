package Combination;

/**
 * 
 * @author Fabien
 *
 *	Classe contenant des éléments de comparaison des combinaisons de mastermind
 */

public class CombinationComparer {

	// ATTRIBUTS
	private String sUserCombination;
	private int iNbGoodPieces = 0;
	private int iNbGoodColors = 0;
	private boolean AreCombinationEquals = false;
	
	// Ctor
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
