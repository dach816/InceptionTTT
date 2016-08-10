package com.dach816.inceptionttt;

/**
 * Class for a cell piece with a value of NONE(0), O(1), X(2), or UNSELECTABLE(-1), a board number
 * to represent which board the cell piece resides and a cell number for the cell number within that board.
 */
public class CellPiece {
    private int pieceValue;
    private int id;

    public CellPiece(int boardNum, int cellNum) {
        this.pieceValue = Piece.NONE.getValue();
        id = boardNum * 10 + cellNum;

    }

    public int getPieceValue() {
        return pieceValue;
    }

    public int getId() {
        return id;
    }

    public void setPieceValue(int pieceValue) {
        this.pieceValue = pieceValue;
    }
}
