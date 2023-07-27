package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8,8);
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
	
}
