package Game;

import Exceptions.IncorrectCombinationException;

/**
 * GameManager Classe de gestion d'un jeu du type tour par tour. Le jeu se
 * termine forc�ment par une victoire ou un nombre de tours maximum 
 * 1) La m�thode Start d�bute le jeu 
 * 2) La m�thode NextTurn est appel�e tant que n�cessaire
 * 3) La m�thode GameOver est appel�e � la fin de la partie
 */

public class GameManager {
	// CONSTANTES
	final int NB_TURN_MAX = 10; // Nombre de tours maximum d'une partie

	// ATTRIBUTS
	private int iNbTurn = NB_TURN_MAX; // nombre de tours restants
	private Combination combinationSolution; // solution de la partie en cours
	
	// ACCESSEURS
	protected int getiNbTurn() { // getter nb tours restants
		return iNbTurn;
	}

	protected void setiNbTurn(int iNbTurn) { // setter nb tours restants
		this.iNbTurn = iNbTurn;
	}

	// METHODES

	// D�bute le jeu
	protected void Start() {
		// repositionne les propri�t�s � leur valeur par d�faut
		Init();
		// g�n�re une combinaison pour la solution (le ctor sans param�tre g�n�re une combinaison)
		combinationSolution = new Combination();
		// boucle de jeu
		while (NextTurn() != 0 && iNbTurn != 0) {}
		// fin du jeu
		GameOver();
	}

	// R�initialise les propri�t�s pour la nouvelle partie
	protected void Init() {
		setiNbTurn(NB_TURN_MAX);
	}

	// Joue un tour complet
	protected int NextTurn() {
		ConsoleGameMessageSender.NewTurnMsg();
		// Entr�e de l'utilisateur
		Combination combinationUser = null;
		try {
			combinationUser = new Combination(ConsoleInputUserCatcher.GetInputConsole());
		} catch (Exception e) {
			// L'entr�e n'est pas correcte
			ConsoleGameMessageSender.ErrorCombination();
		}
		// Comparaison avec la combinaison solution
		
		// Ecrit dans la console le r�sultat du tour
		ConsoleGameMessageSender.EndTurnMsg();
		// Renvoie le r�sultat de la comparaison
		return 1;
	}
	
	// M�thode appel�e � la fin de la partie.
	// R�capitule le score
	protected void GameOver() {
		
	}

}
