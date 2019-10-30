package com.carousell.main.model;

/**
 * Represents a given point in the TicTacToe grid
 *
 */
public class Point {

	private int xcor;
	private int ycor;

	public Point() {

	}

	public Point(int xcor, int ycor) {
		this.xcor = xcor;
		this.ycor = ycor;
	}

	public int getXcor() {
		return xcor;
	}

	public int getYcor() {
		return ycor;
	}

	public void setXcor(int xcor) {
		this.xcor = xcor;
	}

	public void setYcor(int ycor) {
		this.ycor = ycor;
	}

	@Override
	public String toString() {
		return "Position [xcor=" + xcor + ", ycor=" + ycor + "]";
	}

}
