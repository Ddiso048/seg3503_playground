package tic;

public class Tic {

	String[][] board;
	int rows;
	int cols;
	String turn;

	public Tic(int row, int col) {
		board = new String[row][col];
		rows = row;
		cols = col;
		turn = "X";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = "_";
			}
		}
	}

	// jouer un coup
	public boolean play(int row, int col) {
		if (board[row][col].equals("_")) {
			board[row][col] = turn;
			turn = turn.equals("X") ? "O" : "X";
			return true;
		}
		return false;
	}

	// verifier gagnant sur les lignes
	public String winner() {
		for (int i = 0; i < 3; i++) {
			if (!board[i][0].equals("_") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]))
				return board[i][0];
		}
		return null;
	}

}
