package UnitTests;
import static org.junit.Assert.*;
import org.junit.*;

import Exceptions.IncorrectPieceException;
import Pieces.Piece;

public class PieceTest {

	Piece p1, p2, p3, p4 = null;
	
	@Before
	public void init() throws IncorrectPieceException {
		p1 = new Piece();
		p2 = new Piece('B');
		p3 = new Piece('B');
		p4 = new Piece('J');
	}
	

	@Test
	public void testToChar() {
		char p1char = p1.ToChar();
		assertTrue(p1char == 'R' ||  p1char == 'J' ||  p1char == 'B' ||  p1char == 'O' ||  p1char == 'V' ||  p1char == 'N');
		assertEquals('B',p2.ToChar());
		try {
			new Piece('^');
			fail("Should throw exception");
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testEqualsObject() {
		assertTrue(p2.equals(p3));
		assertFalse(p2.equals(p4));
		assertFalse(p2.equals(null));

		
	}

}
