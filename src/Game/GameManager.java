package Game;

import Exceptions.IncorrectCombinationException;

/**
 * GameManager Classe de gestion d'un jeu du type tour par tour. Le jeu se
 * termine forcément par une victoire ou un nombre de tours maximum 
 * 1) La méthode Start débute le jeu 
 * 2) La méthode NextTurn est appelée tant que nécessaire
 * 3) La méthode GameOver est appelée à la fin de la partie
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

	// Débute le jeu
	protected void Start() {
		// repositionne les propriétés à leur valeur par défaut
		Init();
		// génère une combinaison pour la solution (le ctor sans paramètre génère une combinaison)
		combinationSolution = new Combination();
		// boucle de jeu
		while (NextTurn() != 0 && iNbTurn != 0) {}
		// fin du jeu
		GameOver();
	}

	// Réinitialise les propriétés pour la nouvelle partie
	protected void Init() {
		setiNbTurn(NB_TURN_MAX);
	}

	// Joue un tour complet
	protected int NextTurn() {
		ConsoleGameMessageSender.NewTurnMsg();
		// Entrée de l'utilisateur
		Combination combinationUser = null;
		try {
			combinationUser = new Combination(ConsoleInputUserCatcher.GetInputConsole());
		} catch (Exception e) {
			// L'entrée n'est pas correcte
			ConsoleGameMessageSender.ErrorCombination();
		}
		// Comparaison avec la combinaison solution
		
		// Ecrit dans la console le résultat du tour
		ConsoleGameMessageSender.EndTurnMsg();
		// Renvoie le résultat de la comparaison
		return 1;
	}
	
	// Méthode appelée à la fin de la partie.
	// Récapitule le score
	protected void GameOver() {
		
	}

}
