package com.carousell.main.util;

import com.carousell.main.model.TicTacToe;

public class TicTacToeUtils {

	public static final char DEFAULT_GRID_CHAR = ' ';
	public static final char GRID_CHAR_X = 'X';
	public static final char GRID_CHAR_O = 'O';
	
	public static final String ERROR_MESSAGE_POSITION_ALREADY_TAKEN = "This position is not available";
	public static final String ERROR_MESSAGE_MOVE_OUT_OF_RANGE = " Move is out of range ";
	public static final String ERROR_MESSAGE_INVALID_INPUT_FORMAT = "Invalid Input! Please specify your move in this format : x, y ";
	

	/**
	 * Checks if the provided coordinates are within the TicTacToe grid
	 * 
	 * @param xcor
	 * @param ycor
	 * @param N
	 * @return true/false
	 * 
	 */
	public static boolean isValidInput(int xcor, int ycor, int N) {
		if (xcor >= N || ycor >= N) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if the specified position is available on the TicTacToe grid or
	 * already taken
	 * 
	 * @param t
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean isPositionAvailable(TicTacToe t, int i, int j) {
		char[][] grid = t.getGrid();
		if (grid[i][j] == DEFAULT_GRID_CHAR) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the winner name based on pattern
	 * 
	 * @param first
	 * @return
	 */
	public static String getWinnerName(char first) {
		String winner;
		if (first == GRID_CHAR_X) {
			winner = "Player 1";
		} else if (first == GRID_CHAR_O) {
			winner = "Player 2";
		} else {
			return null;
		}

		return winner;
	}

}
