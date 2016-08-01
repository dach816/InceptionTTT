package com.hfad.inceptionttt;

/**
 * Enum for the different piece options: none, O, and X
 */
public enum Piece {
    NONE(0),
    O(1),
    X(2);

    private int value;

    Piece(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
