package Game.IOManager;

import Combination.CombinationComparer;

/**
 * 
 * @author Fabien
 *
 *	Cette classe gere les messages ecrit a la console pour le mastermind
 *	Elle est independante de la classe GameManager
 */
public class ConsoleGameMessageSender {


	/**
	 * Affiche le message de debut de partie
	 */
	public static void StartGameMsg() {
		System.out.println("************** Nouvelle partie **************");
		System.out.println("L'ordinateur a choisi sa combinaison.");
	}
	
	/**
	 * Affiche le message de debut d'un nouveau tour
	 */
	public static void NewTurnMsg() {
		System.out.println("Nouveau tour, entrez une combinaison de 4 couleurs (RJBOVN) : ");
	}
	
	/**
	 * Affiche le message d'erreur de combinaison entree
	 */
	public static void ErrorCombination() {
		System.out.println("La combinaison entree est incorrecte (4 couleurs parmis la liste suivante : RJBOVN)");
	}
	
	/**
	 * Affiche tous les resultats des tours passes
	 * @param arrayComparer Les resultats des tours precedents
	 * @param nbTurnMax Le nombre maximum de tours
	 */
	public static void EndTurnMsg(CombinationComparer[] arrayComparer, int nbTurnMax) {
		
		System.out.println("|-------------------|");
		for (int i = 0; i < arrayComparer.length; i++) {
			System.out.println(String.format("|%s| %d | %d | %d/%d |", arrayComparer[i].getUserCombination(), arrayComparer[i].getNbGoodPieces(), arrayComparer[i].getNnbGoodColors(), i+1, nbTurnMax));
		}
		if(arrayComparer.length + 1 <= nbTurnMax)
			System.out.println(String.format("|....| . | . | %d/%d |", arrayComparer.length + 1, nbTurnMax));
		System.out.println("|-------------------|");
		
	}
	
	/**
	 * Affiche le message de fin de partie
	 * @param isWinner True si le joueur a gagne
	 * @param nbTurn Nombre de tours depuis le debut de la partie
	 */
	public static void EndGameMsg(boolean isWinner, int nbTurn) {
		System.out.println(isWinner ? String.format("Felicitation, vous avez gagne en %d tours", nbTurn): "Vous avez perdu.");
	}
	
}
