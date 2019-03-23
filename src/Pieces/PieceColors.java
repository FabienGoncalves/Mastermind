package Pieces;

public enum PieceColors {

	RED('R'),
	YELLOW('Y'),
	BLUE('B'),
	ORANGE('O'),
	GREEN('G'),
	BLACK('B');
	
	private char color;

	private PieceColors(char color) {
		this.color = color;
	}

	protected char getColor() {
		return color;
	}
	
	
}
