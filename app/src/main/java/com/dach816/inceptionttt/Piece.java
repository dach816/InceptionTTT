package com.dach816.inceptionttt;

/**
 * Enum for the different piece options: none, O, X, unselectable
 */
public enum Piece {
    NONE(0),
    O(1),
    X(2),
    UNSELECTABLE(-1);

    private int value;

    Piece(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
