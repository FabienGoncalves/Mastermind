package Game;

import java.util.ArrayList;

import Combination.Combination;
import Combination.CombinationComparer;
import Game.IOManager.ConsoleGameMessageSender;
import Game.IOManager.ConsoleInputUserCatcher;

/**
 * GameManager Classe de gestion d'une partie de Mastermind. Le jeu se
 * termine forcement par une victoire ou un nombre de tours maximum 
 * 1) La méthode Start débute le jeu 
 * 2) La méthode NextTurn est appelée à chaque nouveau tour jusqu'à la fin de la partie 
 * 3) La méthode IsWinner définit la condition de victoire
 * 4) La méthode GameOver est appelée à la fin de la partie
 */

public class GameManager {
	
	// CONSTANTES
	final int NB_TURN_MAX = 10; 				// Nombre de tours maximum d'une partie

	// ATTRIBUTS
	private int iNbTurn = NB_TURN_MAX; 			// nombre de tours restants
	private Combination combinationSolution; 	// solution de la partie en cours
	private boolean IsWinner = false;			// indique si la partie est gagnee
	private ArrayList<CombinationComparer> previousTurns = new ArrayList<CombinationComparer>(); // resultats des tours precedents

	
	// METHODES
	/**
	 * Debute la partie
	 */
	public void Start() {
		Init(); 											// repositionne les attributs a leur valeur par defaut
		while (!IsWinner && iNbTurn != 0) { NextTurn(); } 	// boucle de jeu
		GameOver(); 										// fin du jeu
	}
	

	/**
	 * Reinitialise les proprietes pour la nouvelle partie 
	 */
	protected void Init() {
		iNbTurn = NB_TURN_MAX;
		previousTurns.clear();
		IsWinner = false;
		combinationSolution = new Combination(); 	// genere une combinaison pour la solution
		ConsoleGameMessageSender.StartGameMsg(); 	// message de debut de partie
	}

	/**
	 * Joue un tour complet de mastermind
	 */
	protected void NextTurn() {
		NewTurn();
		Combination combinationUser = ProcessInput(); 				// Entree de l'utilisateur
		EndTurn(combinationSolution.CompareWith(combinationUser));  // comparaison avec la solution
		if(IsWinner(previousTurns.get(previousTurns.size()-1))) 
			IsWinner = true;
	}
	
	/**
	 * Decremente le compteur de tours restant et affiche un message de debut du tour
	 */
	protected void NewTurn() {
		iNbTurn--;
		ConsoleGameMessageSender.NewTurnMsg();
	}
	
	/**
	 * Sauve le resultat du tour et affiche un message de fin du tour
	 * @param cc Resultat du tour
	 */
	protected void EndTurn(CombinationComparer cc) {
		previousTurns.add(cc);
		ConsoleGameMessageSender.EndTurnMsg(previousTurns.toArray(new CombinationComparer[0]), NB_TURN_MAX );
	}
	

	/**
	 * Récupère et transforme une entrée de l'utilisateur en une combinaison Mastermind
	 * @return L'objet representant la combinaison
	 */
	protected Combination ProcessInput() {
		Combination combinationUser = null;
		while(combinationUser == null) {
			try {
				combinationUser = new Combination(ConsoleInputUserCatcher.GetInputConsole());
			} catch (Exception e) {
				ConsoleGameMessageSender.ErrorCombination();
			}
		}
		return combinationUser;
	}
	
	/**
	 * Définit la condition de fin du jeu du mastermind
	 * @param comparer Resultat du tour
	 * @return True si le joueur a gagne
	 */
	protected boolean IsWinner(CombinationComparer comparer) {
		return comparer.getAreCombinationEquals();
	}

	/**
	 * Message de fin de partie
	 */
	protected void GameOver() {
		ConsoleGameMessageSender.EndGameMsg(IsWinner, NB_TURN_MAX-iNbTurn);
	}

}
