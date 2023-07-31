package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "R";
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
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			// Define the position as true, and now the piece can go there
			board[position.getRow()][position.getColumn()] = true;

			// Defines a new position to the next while check
			position.setRow(position.getRow() - 1);
		}
		// If a piece is found in the next position, check if is a opponent piece.
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// BELOW
		position.setValues(position.getRow() + 1, position.getColumn());

		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;

			position.setRow(position.getRow() + 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// LEFT
		position.setValues(position.getRow(), position.getColumn() - 1);

		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;

			position.setColumn(position.getColumn() - 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		// RIGHT
		position.setValues(position.getRow(), position.getColumn() + 1);

		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;

			position.setColumn(position.getColumn() + 1);
		}
		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			board[position.getRow()][position.getColumn()] = true;
		}

		return board;
	}

}
