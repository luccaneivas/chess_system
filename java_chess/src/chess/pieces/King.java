package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);

		return piece == null || piece.getColor() != this.getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] board = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);

		// ABOVE
		// Defines the value of the auxiliar position to the position of the piece, but
		// one house above
		position.setValues(this.position.getRow() - 1, this.position.getColumn());

		// While the position still exists and there's no piece on this position
		if (getBoard().positionExists(position) && canMove(position)) {
			// Define the position as true, and now the piece can go there
			board[position.getRow()][position.getColumn()] = true;
		}

		// BELOW
		position.setValues(this.position.getRow() + 1, this.position.getColumn());

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// LEFT
		position.setValues(this.position.getRow(), this.position.getColumn() - 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// RIGHT
		position.setValues(this.position.getRow(), this.position.getColumn() + 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// NORTHWEST
		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// NORTHEAST
		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// SOUTHWEST
		position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// SOUTHEAST
		position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);

		if (getBoard().positionExists(position) && canMove(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		return board;
	}

}
