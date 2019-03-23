package Game;

/**
 * 
 * @author Fabien
 *
 *	Cette classe gère les messages écrit à la console
 *	Elle est indépendante de la classe GameManager pour permettre de sélectionner une autre sortie
 *  en modifiant cette classe ou en créant une autre classe dédiée
 */
public class ConsoleGameMessageSender {


	public static void StartGameMsg() {
		System.out.println("Nouvelle partie");
	}
	
	public static void NewTurnMsg() {
		System.out.println("Nouveau tour");
	}
	
	public static void ErrorCombination() {
		System.out.println("La combinaison entrée est incorrecte (4 couleurs parmis la liste suivante : RJBOVN)");
	}
	
	
	public static void EndTurnMsg(String input, int nbOK, int nbColorOK, int nbTurn, int nbTurnMax) {
		System.out.println("|--------------------|");
		System.out.println(String.format("|%s| %d| %d| %d/%d|", input, nbOK, nbColorOK, nbTurn, nbTurnMax));
		System.out.println("|--------------------|");
	}
	
}
