package com.carousell.main;

import java.util.Scanner;
import com.carousell.main.model.TicTacToe;
import com.carousell.main.model.Point;
import com.carousell.main.util.TicTacToeUtils;

import static com.carousell.main.util.TicTacToeUtils.*;

/**
 * 
 * @author aishw
 *
 */
public class PlayTicTacToe {

	public static void main(String[] args) {

		System.out.println("Get grid dimensions ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		TicTacToe game = new TicTacToe();
		// initialise the tictactoe grid
		game.init(N);
		// play the game
		play(game, N, sc);

		sc.close();
	}

	/*
	 * Assumptions : 
	 * 1. There are only 2 players in the game 
	 * 2. There can be 2 separate players or 1 player in multiplayer mode 
	 * 3. The player who makes the first move will enter 'X'at any given position 
	 * 4. The second player enters 'O' at any given position 
	 * 5. Game continues till there is a winner or no moves are possible
	 *  
	 *  TODO : Implement multiplayer mode
	 * 
	 */
	private static void play(TicTacToe t, int N, Scanner sc) {
		// check if board is full
		if (t.getAvailableSlots() > 0) {
			// play the game
			while (true) {
				System.out.println("Player 1 : Please enter X position ");
				String position1 = sc.nextLine();
				Point p1 = getNextMove(position1, t, N);
				t.addMoveToGrid(p1, GRID_CHAR_X);

				// check if Player 1 wins
				if (t.hasWinner(p1) == GRID_CHAR_X) {
					System.out.println(" Player 1 wins! Congratulations!! ");
					break;
				}

				System.out.println("Player 2 : Please enter O position ");
				String position2 = sc.nextLine();
				Point p2 = getNextMove(position2, t, N);
				t.addMoveToGrid(p2, GRID_CHAR_O);

				// check if Player 2 wins
				if (t.hasWinner(p2) == GRID_CHAR_O) {
					System.out.println(" Player 2 wins! Congratulations!! ");
					break;
				}

			}

		} else {
			// board is full; no more moves possible
			System.out.println("Game ends in a DRAW! ");
		}

	}
	
	
	/**
	 * Reads the next move from standard I/O
	 * 
	 * @param position
	 * @param t
	 * @param N
	 * @return
	 * 	returns the specified move coordinates on the grid
	 * 
	 */

	private static Point getNextMove(String position, TicTacToe t, int N) {
		String[] index = position.split(",");
		Point p = null;

		try {
			int i = Integer.parseInt(index[0]);
			int j = Integer.parseInt(index[1]);

			if (!(TicTacToeUtils.isValidInput(i, j, N))) {
				System.out.println(ERROR_MESSAGE_MOVE_OUT_OF_RANGE);
				// retry reading the coordinates
			} else if (!(TicTacToeUtils.isPositionAvailable(t, i, j))) {
				System.out.println(ERROR_MESSAGE_POSITION_ALREADY_TAKEN);
				// retry reading the coordinates
			} else {
				p = new Point();
				p.setXcor(i);
				p.setYcor(j);
			}

		} catch (NumberFormatException ex) {
			System.out.println(ERROR_MESSAGE_INVALID_INPUT_FORMAT);
			// retry reading the coordinates
		}

		return p;
	}

}
