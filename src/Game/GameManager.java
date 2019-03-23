package Game;

import java.util.ArrayList;

import Combination.Combination;
import Combination.CombinationComparer;
import Exceptions.IncorrectCombinationException;
import Game.IOManager.ConsoleGameMessageSender;
import Game.IOManager.ConsoleInputUserCatcher;

/**
 * GameManager Classe de gestion d'un jeu du type tour par tour. Le jeu se
 * termine forc�ment par une victoire ou un nombre de tours maximum 
 * 1) La m�thode Start d�bute le jeu 
 * 2) La m�thode NextTurn est appel�e tant que n�cessaire 
 * 3) La m�thode IsWinner d�finit la condition de victoire
 * 4) La m�thode GameOver est appel�e � la fin de la partie
 */

public class GameManager {
	// CONSTANTES
	final int NB_TURN_MAX = 10; // Nombre de tours maximum d'une partie

	// ATTRIBUTS
	private int iNbTurn = NB_TURN_MAX; // nombre de tours restants
	private Combination combinationSolution; // solution de la partie en cours
	private boolean IsWinner = false;			// indique si la partie est gagn�e
	private ArrayList<CombinationComparer> previousTurns = new ArrayList<CombinationComparer>();

	// METHODES

	// D�bute le jeu
	public void Start() {
		// repositionne les propri�t�s � leur valeur par d�faut
		Init();
		// g�n�re une combinaison pour la solution (le ctor sans param�tre g�n�re une
		// combinaison)
		combinationSolution = new Combination();
		// boucle de jeu
		while (!IsWinner && iNbTurn != 0) { NextTurn(); }
		// fin du jeu, on sort de la boucle
		GameOver();
	}

	// R�initialise les propri�t�s pour la nouvelle partie
	protected void Init() {
		iNbTurn = NB_TURN_MAX;
		previousTurns.clear();
		IsWinner = false;
	}

	// Joue un tour complet
	protected void NextTurn() {
		iNbTurn--;
		ConsoleGameMessageSender.NewTurnMsg();
		// Entr�e de l'utilisateur
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
		// Ecrit dans la console le r�sultat du tour (et ceux des tours pr�c�dents)
		ConsoleGameMessageSender.EndTurnMsg(previousTurns.toArray(new CombinationComparer[0]), NB_TURN_MAX );
		
		if(IsWinner(comparer)) 
			IsWinner = true;
	}
	
	// D�finit la condition de fin du jeu
	// Toutes les pi�ces sont bien plac�es
	protected boolean IsWinner(CombinationComparer comparer) {
		return comparer.getAreCombinationEquals();
	}

	// M�thode appel�e � la fin de la partie.
	// R�capitule le score
	protected void GameOver() {
		ConsoleGameMessageSender.EndGameMsg(IsWinner, NB_TURN_MAX-iNbTurn);
	}

}
