package com.dach816.inceptionttt;

/**
 * Interface for the AI classes.
 */
public interface ITicTacToeAI {
    /**
     * Make a move based on the AI mode (easy, medium, hard)
     * @param selectedBoardNum the number of the currently selected board
     */
    int makeMove(int selectedBoardNum);

    /**
     * Select a board based on the AI mode (easy, medium, hard)
     */
    int selectBoard();
}
