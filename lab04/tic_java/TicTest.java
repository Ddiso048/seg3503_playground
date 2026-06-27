package tic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TicTest {

	// groupe 1 - plateau de base
	@Test
	void test1() {
		Tic b = new Tic(3, 3);
		assertEquals("_", b.board[0][0]);
	}

	@Test
	void test2() {
		Tic b = new Tic(3, 3);
		assertEquals("X", b.turn);
	}

	// groupe 2 - jouer un coup
	@Test
	void test3() {
		Tic b = new Tic(3, 3);
		b.play(0, 0);
		assertEquals("X", b.board[0][0]);
	}

	@Test
	void test4() {
		Tic b = new Tic(3, 3);
		b.play(0, 0);
		assertEquals("O", b.turn);
	}

	// groupe 3 - case deja occupee
	@Test
	void test5() {
		Tic b = new Tic(3, 3);
		b.play(0, 0);
		assertFalse(b.play(0, 0));
	}

	// groupe 4 - X gagne sur une ligne
	@Test
	void test6() {
		Tic b = new Tic(3, 3);
		b.play(0, 0); // X
		b.play(1, 0); // O
		b.play(0, 1); // X
		b.play(1, 1); // O
		b.play(0, 2); // X gagne
		assertEquals("X", b.winner());
	}

	// groupe 5 - pas de gagnant
	@Test
	void test7() {
		Tic b = new Tic(3, 3);
		assertNull(b.winner());
	}

}
