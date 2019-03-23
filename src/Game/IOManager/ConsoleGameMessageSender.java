package Game.IOManager;

import Combination.CombinationComparer;

/**
 * 
 * @author Fabien
 *
 *	Cette classe g�re les messages �crit � la console
 *	Elle est ind�pendante de la classe GameManager pour permettre de s�lectionner une autre sortie
 *  en modifiant cette classe ou en cr�ant une autre classe d�di�e
 */
public class ConsoleGameMessageSender {


	public static void StartGameMsg() {
		System.out.println("************** Nouvelle partie **************");
		System.out.println("L'ordinateur a choisi sa combinaison.");
	}
	
	public static void NewTurnMsg() {
		System.out.println("Nouveau tour, entrez une combinaison de 4 couleurs (RJBOVN) : ");
	}
	
	public static void ErrorCombination() {
		System.out.println("La combinaison entr�e est incorrecte (4 couleurs parmis la liste suivante : RJBOVN)");
	}
	
	
	public static void EndTurnMsg(CombinationComparer[] arrayComparer, int nbTurnMax) {
		
		System.out.println("|--------------------|");
		for (int i = 0; i < arrayComparer.length; i++) {
			System.out.println(String.format("|%s| %d | %d | %d/%d |", arrayComparer[i].getUserCombination(), arrayComparer[i].getNbGoodPieces(), arrayComparer[i].getNnbGoodColors(), i+1, nbTurnMax));
		}
		if(arrayComparer.length + 1 <= nbTurnMax)
			System.out.println(String.format("|....| . | . | %d/%d |", arrayComparer.length + 1, nbTurnMax));
		System.out.println("|--------------------|");
		
	}
	
	public static void EndGameMsg(boolean isWinner, int nbTurn) {
		System.out.println(isWinner ? String.format("Felicitation, vous avez gagn� en %d tours", nbTurn): "Vous avez perdu.");
	}
	
}
