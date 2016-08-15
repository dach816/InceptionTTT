package com.dach816.inceptionttt;

/**
 * The difficulty of the AI
 */
public enum GameDifficulty {
    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int value;

    GameDifficulty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameDifficulty getDifficulty(int value) {
        switch (value) {
            case 0:
                return EASY;
            case 1:
                return MEDIUM;
            case 2:
                return HARD;
            default:
                return EASY;
        }
    }
}
