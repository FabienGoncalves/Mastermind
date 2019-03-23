package Pieces;

public enum PieceColors {

	RED('R'),
	YELLOW('J'),
	BLUE('B'),
	ORANGE('O'),
	GREEN('V'),
	BLACK('N');
	
	private char color;

	private PieceColors(char color) {
		this.color = color;
	}

	protected char getColor() {
		return color;
	}
	
	
}
