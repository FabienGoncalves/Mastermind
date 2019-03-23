package UnitTests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Combination.Combination;
import Combination.CombinationComparer;
import Exceptions.IncorrectCombinationException;
import Exceptions.IncorrectPieceException;
import Pieces.Piece;

class CombinationTest {

Combination c1, c2, c3, c4, c5 = null;
	
	@BeforeEach
	public void init() throws IncorrectPieceException, IncorrectCombinationException {
		c1 = new Combination();
		c2 = new Combination("BBBB");
		c3 = new Combination("BBBB");
		c4 = new Combination("BBJB");
		c5 = new Combination("JNBO");
	}
	
	@Test
	void testCombination() {
		assertNotNull(c1);
	}

	@Test
	void testCombinationString() {
		assertNotNull(c2);
		assertNotNull(c3);
		assertNotNull(c4);
		
		Combination c5 = null;
		try {
			c5 = new Combination("^^^^A");
			fail("should throw exception");
		} catch (IncorrectCombinationException e) {
			assertEquals(null, c5);
		}
		
		Combination c6 = null;
		try {
			c6 = new Combination("ZZZZ");
			fail("should throw exception");
		} catch (IncorrectCombinationException e) {
			assertEquals(null, c6);
		}
		
		Combination c7 = null;
		try {
			c7 = new Combination("DD");
			fail("should throw exception");
		} catch (IncorrectCombinationException e) {
			assertEquals(null, c7);
		}
	}

	@Test
	void testGetPieceArray() {
		try {
			Piece[] arrayTest = { new Piece('J'), new Piece('N'), new Piece('B'), new Piece('O') };
			assertTrue(c5.getPieceArray()[0].equals(arrayTest[0]));
			assertTrue(c5.getPieceArray()[1].equals(arrayTest[1]));
			assertTrue(c5.getPieceArray()[2].equals(arrayTest[2]));
			assertTrue(c5.getPieceArray()[3].equals(arrayTest[3]));
		} catch (IncorrectPieceException e) {
			fail("creation array failed");
		}
	}

	@Test
	void testCompareWith() {
		CombinationComparer comparer = c2.CompareWith(c3);
		assertTrue(comparer.getAreCombinationEquals());
		assertEquals(4, comparer.getNbGoodPieces());
		assertEquals(0, comparer.getNnbGoodColors());
		assertEquals("BBBB", comparer.getUserCombination());
		
		comparer = c2.CompareWith(c4);
		assertFalse(comparer.getAreCombinationEquals());
		assertEquals(3, comparer.getNbGoodPieces());
		assertEquals(0, comparer.getNnbGoodColors());
		assertEquals("BBJB", comparer.getUserCombination());

		comparer = c4.CompareWith(c5);
		assertFalse(comparer.getAreCombinationEquals());
		assertEquals(0, comparer.getNbGoodPieces());
		assertEquals(2, comparer.getNnbGoodColors());
		assertEquals("JNBO", comparer.getUserCombination());

		
	}

	@Test
	void testToString() {
		assertEquals("BBBB", c2.ToString());
		assertEquals("BBBB", c3.ToString());
		assertEquals( "BBJB", c4.ToString());
		assertEquals("JNBO", c5.ToString());

	}


}
