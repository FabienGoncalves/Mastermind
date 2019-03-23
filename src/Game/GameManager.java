package Game;

import java.util.ArrayList;

import Combination.Combination;
import Combination.CombinationComparer;
import Exceptions.IncorrectCombinationException;
import Game.IOManager.ConsoleGameMessageSender;
import Game.IOManager.ConsoleInputUserCatcher;

/**
 * GameManager Classe de gestion d'un jeu du type tour par tour. Le jeu se
 * termine forcément par une victoire ou un nombre de tours maximum 
 * 1) La méthode Start débute le jeu 
 * 2) La méthode NextTurn est appelée tant que nécessaire 
 * 3) La méthode IsWinner définit la condition de victoire
 * 4) La méthode GameOver est appelée à la fin de la partie
 */

public class GameManager {
	// CONSTANTES
	final int NB_TURN_MAX = 10; // Nombre de tours maximum d'une partie

	// ATTRIBUTS
	private int iNbTurn = NB_TURN_MAX; // nombre de tours restants
	private Combination combinationSolution; // solution de la partie en cours
	private boolean IsWinner = false;			// indique si la partie est gagnée
	private ArrayList<CombinationComparer> previousTurns = new ArrayList<CombinationComparer>();

	// METHODES

	// Débute le jeu
	public void Start() {
		// repositionne les propriétés à leur valeur par défaut
		Init();
		// génère une combinaison pour la solution (le ctor sans paramètre génère une
		// combinaison)
		combinationSolution = new Combination();
		// boucle de jeu
		while (!IsWinner && iNbTurn != 0) { NextTurn(); }
		// fin du jeu, on sort de la boucle
		GameOver();
	}

	// Réinitialise les propriétés pour la nouvelle partie
	protected void Init() {
		iNbTurn = NB_TURN_MAX;
		previousTurns.clear();
		IsWinner = false;
	}

	// Joue un tour complet
	protected void NextTurn() {
		iNbTurn--;
		ConsoleGameMessageSender.NewTurnMsg();
		// Entrée de l'utilisateur
		Combination combinationUser = null;
		while(combinationUser == null) {
			try {
				combinationUser = new Combination(ConsoleInputUserCatcher.GetInputConsole());
			} catch (Exception e) {
				ConsoleGameMessageSender.ErrorCombination();
			}
		}
		// Comparaison avec la combinaison solution
		CombinationComparer comparer = combinationSolution.CompareWith(combinationUser);
		previousTurns.add(comparer);
		// Ecrit dans la console le résultat du tour (et ceux des tours précédents)
		ConsoleGameMessageSender.EndTurnMsg(previousTurns.toArray(new CombinationComparer[0]), NB_TURN_MAX );
		
		if(IsWinner(comparer)) 
			IsWinner = true;
	}
	
	// Définit la condition de fin du jeu
	// Toutes les pièces sont bien placées
	protected boolean IsWinner(CombinationComparer comparer) {
		return comparer.getAreCombinationEquals();
	}

	// Méthode appelée à la fin de la partie.
	// Récapitule le score
	protected void GameOver() {
		ConsoleGameMessageSender.EndGameMsg(IsWinner, NB_TURN_MAX-iNbTurn);
	}

}
