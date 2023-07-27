package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
		board.placePiece(new Rook(board, Color.WHITE), new Position(0,7));
		board.placePiece(new King(board, Color.WHITE), new Position(0,4));
		
		board.placePiece(new Rook(board, Color.BLACK), new Position(7,0));
		board.placePiece(new Rook(board, Color.BLACK), new Position(7,7));
		board.placePiece(new King(board, Color.BLACK), new Position(7,4));
	}
	
}
