package com.dach816.inceptionttt;

/**
 * The difficulty of the AI
 */
public enum GameDifficulty {
    EASY(0, "Easy"),
    MEDIUM(1, "Medium"),
    HARD(2, "Hard");

    private int value;
    private String string;

    GameDifficulty(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public int getValue() {
        return value;
    }
    public String getString() { return string; }

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

    public static GameDifficulty getDifficulty(String string) {
        switch (string) {
            case "Easy":
                return EASY;
            case "Medium":
                return MEDIUM;
            case "Hard":
                return HARD;
            default:
                return EASY;
        }
    }
}
