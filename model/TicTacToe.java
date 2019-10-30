package com.carousell.main.model;

import com.carousell.main.util.TicTacToeUtils;

/**
 * 
 * POJO that represents the tic tac toe grid 
 * N is the size of the square grid, i.e. number
 * of rows and columns in the 2D square matrix
 *
 */
public class TicTacToe {

	private int N;
	private char[][] grid;
	private int availableSlots;

	public TicTacToe() {

	}

	/**
	 * Initialise the TicTacToe grid given the dimensions
	 * 
	 * @param N
	 */
	public void init(int N) {
		this.N = N;
		this.grid = new char[N][N];
		this.availableSlots = N * N;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = TicTacToeUtils.DEFAULT_GRID_CHAR;
			}
		}
	}

	/**
	 * Place X or O at the given coordinates
	 * 
	 * @param p
	 * @param ch
	 */
	public void addMoveToGrid(Point p, char ch) {
		int i = p.getXcor();
		int j = p.getYcor();
		grid[i][j] = ch;

		// decrement available slots
		this.availableSlots--;
	}

	/**
	 * Check if there is a winner
	 * 
	 * For further optimisation, check the below link  
	 * https://codereview.stackexchange.com/questions/116830/check-if-a-game-of-tic-tac-toe-has-a-winner
	 * 
	 * @param grid
	 * @return
	 */
	public char hasWinner(Point latestMove) {

		int sum = 0;
		char first = TicTacToeUtils.DEFAULT_GRID_CHAR;

		// check if the current row is complete
		int xCor = latestMove.getXcor();
		first = grid[xCor][0];
		for (int j = 0; j < N; j++) {
			if (grid[xCor][j] == first) {
				sum++;
			} else {
				sum = 0;
				first = TicTacToeUtils.DEFAULT_GRID_CHAR;
				break;
			}
		}
		if (sum == N) {
			return first;
		}

		// check if the current column is complete
		int yCor = latestMove.getYcor();
		first = grid[0][yCor];
		for (int i = 0; i < N; i++) {
			if (grid[i][yCor] == first) {
				sum++;
			} else {
				sum = 0;
				first = TicTacToeUtils.DEFAULT_GRID_CHAR;
				break;
			}
		}
		if (sum == N) {
			return first;
		}

		// if the latest move is on the diagonal point, check for diagonals
		boolean liesOnDiagonal = isDiagonalPoint(latestMove);

		if (liesOnDiagonal) {
			// check for leading diagonal
			first = grid[0][0];
			sum = 1;
			for (int i = 1; i < N; i++) {
				int j = i;
				if (grid[i][j] == first) {
					sum++;
				}
			}

			if (sum == N) {
				return first;
			}
		}

		if (liesOnDiagonal) {
			// check for other diagonal
			sum = 1;
			first = grid[0][N - 1];
			for (int i = 1; i < N; i++) {
				int j = N - 1 - i;
				if (grid[i][j] == first) {
					sum++;
				}
			}
			if (sum == N) {
				return first;
			}
		}

		return TicTacToeUtils.DEFAULT_GRID_CHAR;
	}

	/**
	 * Checks if the latest move lies on the grid diagonals
	 * 
	 * @param p
	 * @return
	 * 	true if lies on the diagonal, false otherwise
	 */
	private boolean isDiagonalPoint(Point p) {
		int i = p.getXcor();
		int j = p.getYcor();
		if (i == j) {
			return true;
		} else if (i + j == N - 1) {
			return true;
		} else {
			return false;
		}
	}

	
	/*
	 * Getters and Setters
	 */
	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}

}
