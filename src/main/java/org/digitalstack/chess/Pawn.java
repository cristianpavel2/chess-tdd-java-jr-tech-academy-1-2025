package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (chessBoard == null) {
            return;
        }

        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }

        // Pawns can only move forward (decreasing Y for BLACK, increasing Y for WHITE)
        if (movementType == MovementType.MOVE) {
            if (pieceColor == PieceColor.BLACK) {
                // Black pawns move down (decreasing Y)
                if (newX == xCoordinate && newY == yCoordinate - 1) {
                    xCoordinate = newX;
                    yCoordinate = newY;
                }
            } else {
                // White pawns move up (increasing Y)
                if (newX == xCoordinate && newY == yCoordinate + 1) {
                    xCoordinate = newX;
                    yCoordinate += newY;
                }
            }
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
