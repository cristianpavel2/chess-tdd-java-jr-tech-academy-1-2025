package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;
    private int blackPawnCount = 0;
    private int whitePawnCount = 0;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        // if position is outside the board, do not add the pawn
        if (!isLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        // if position is already occupied, do not add the pawn
        if (pieces[xCoordinate][yCoordinate] != null) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        int maxPawns = 8;
        // if max pawns of that color already on board, do not add the pawn
        if (pieceColor == PieceColor.BLACK && blackPawnCount >= maxPawns) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        // if max pawns of that color already on board, do not add the pawn
        if (pieceColor == PieceColor.WHITE && whitePawnCount >= maxPawns) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        // if all check passed, add the pawn to the board
        pieces[xCoordinate][yCoordinate] = pawn;
        pawn.setChessBoard(this);
        // set the pawn's coordinates
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
        if (pieceColor == PieceColor.BLACK) {
            blackPawnCount++;
        } else {
            whitePawnCount++;
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < BOARD_WIDTH &&
                yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;
    }
}
