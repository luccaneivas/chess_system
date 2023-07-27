package chess;

import boardgame.Board;

import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] pieces = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i = 0; i < board.getColumns(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				pieces[i][j] = (ChessPiece) board.piece(i,j); // desse jeito você força a peça a ser do tipo ChessPiece, que herda a classe Piece.
			}
		}
		
		return pieces;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('a', 8, new Rook(board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
		
		placeNewPiece('a', 1, new Rook(board, Color.BLACK));
		placeNewPiece('h', 1, new Rook(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.BLACK));
	}
	
}
