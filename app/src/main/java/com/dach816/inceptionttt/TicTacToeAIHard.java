package com.dach816.inceptionttt;

import java.util.Map;
import java.util.Random;

/**
 * The AI when playing Single Player on hard mode
 */
public class TicTacToeAIHard implements ITicTacToeAI {
    private Map<Integer, Integer> unselectableBoardMap;
    private Map<Integer, CellPiece> cellPieceMap;

    public TicTacToeAIHard(Map<Integer, Integer> unselectableBoardMap, Map<Integer, CellPiece> cellPieceMap) {
        this.unselectableBoardMap = unselectableBoardMap;
        this.cellPieceMap = cellPieceMap;
    }

    /*
     * The possible moves to make in order of importance:
     *  1. Making a move that will win the board but not lead the other player to win the game
     *  2. Making a move that will win the board
     *  3. Preventing the other player from winning the board
     *  4. Making a move that does not lead the player to select a board
     *  5. Making a move that does not lead the player to win a board
     *  6. Making a good move when only one O piece is on a board
     *  7. Making any move
     */
    public int makeMove(int selectedBoardNum) {
        int cellNumToMakeThreeInARow = cellNumToMakeThreeInARowWithPrecautions(selectedBoardNum);
        return (cellNumToMakeThreeInARow > 0) ? cellNumToMakeThreeInARow : selectRandomCell(selectedBoardNum);
    }

    /*
     * The possible moves to make when selecting a board in order of importance:
     *  1. Select a board where you can make 3 in a row to win the game
     *  2. Select a board where you can prevent the player from getting 3 in a row to win the game
     *  3. Select a board that is selectable
     */
    public int selectBoard() {
        int board1Value = unselectableBoardMap.get(1);
        int board2Value = unselectableBoardMap.get(2);
        int board3Value = unselectableBoardMap.get(3);
        int board4Value = unselectableBoardMap.get(4);
        int board5Value = unselectableBoardMap.get(5);
        int board6Value = unselectableBoardMap.get(6);
        int board7Value = unselectableBoardMap.get(7);
        int board8Value = unselectableBoardMap.get(8);
        int board9Value = unselectableBoardMap.get(9);

        //Select board 1
        if (board1Value == Piece.NONE.getValue() &&
                (board5Value > Piece.NONE.getValue() && board5Value == board9Value ||
                board2Value > Piece.NONE.getValue() && board2Value == board3Value ||
                board4Value > Piece.NONE.getValue() && board4Value == board7Value)) {
            return 1;
        }
        //Select board 2
        if (board2Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board3Value ||
                        board5Value > Piece.NONE.getValue() && board5Value == board8Value)) {
            return 2;
        }
        //Select board 3
        if (board3Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board2Value ||
                        board5Value > Piece.NONE.getValue() && board5Value == board7Value ||
                        board6Value > Piece.NONE.getValue() && board6Value == board9Value)) {
            return 3;
        }
        //Select board 4
        if (board4Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board7Value ||
                        board5Value > Piece.NONE.getValue() && board5Value == board6Value)) {
            return 4;
        }
        //Select board 5
        if (board5Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board9Value ||
                        board2Value > Piece.NONE.getValue() && board2Value == board8Value ||
                        board4Value > Piece.NONE.getValue() && board4Value == board6Value ||
                        board3Value > Piece.NONE.getValue() && board3Value == board7Value)) {
            return 5;
        }
        //Select board 6
        if (board6Value == Piece.NONE.getValue() &&
                (board3Value > Piece.NONE.getValue() && board3Value == board9Value ||
                        board4Value > Piece.NONE.getValue() && board4Value == board5Value)) {
            return 6;
        }
        //Select board 7
        if (board7Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board4Value ||
                        board8Value > Piece.NONE.getValue() && board8Value == board9Value ||
                        board3Value > Piece.NONE.getValue() && board3Value == board5Value)) {
            return 7;
        }
        //Select board 8
        if (board8Value == Piece.NONE.getValue() &&
                (board2Value > Piece.NONE.getValue() && board2Value == board5Value ||
                        board7Value > Piece.NONE.getValue() && board7Value == board9Value)) {
            return 8;
        }
        //Select board 9
        if (board9Value == Piece.NONE.getValue() &&
                (board1Value > Piece.NONE.getValue() && board1Value == board5Value ||
                        board3Value > Piece.NONE.getValue() && board3Value == board6Value ||
                        board7Value > Piece.NONE.getValue() && board7Value == board8Value)) {
            return 9;
        }

        return selectRandomBoard();
    }

    private int cellNumToMakeThreeInARowWithPrecautions(int selectedBoardNum) {
        int cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 1);
        int cell1Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 2);
        int cell2Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 3);
        int cell3Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 4);
        int cell4Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 5);
        int cell5Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 6);
        int cell6Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 7);
        int cell7Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 8);
        int cell8Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 9);
        int cell9Value = cellPieceMap.get(cellId).getPieceValue();

        //Select a cell where the player doesn't get 3 in a row at the next board
        //Select cell 1
        if (cell1Value == Piece.NONE.getValue() &&
                (cell5Value > Piece.NONE.getValue() && cell5Value == cell9Value ||
                        cell2Value > Piece.NONE.getValue() && cell2Value == cell3Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell7Value) &&
                !hasTwoOutOfThreeInARow(1, selectedBoardNum)) {
            return 1;
        }
        //Select cell 2
        if (cell2Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell3Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell8Value) &&
                !hasTwoOutOfThreeInARow(2, selectedBoardNum)) {
            return 2;
        }
        //Select cell 3
        if (cell3Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell2Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell7Value ||
                        cell6Value > Piece.NONE.getValue() && cell6Value == cell9Value) &&
                !hasTwoOutOfThreeInARow(3, selectedBoardNum)) {
            return 3;
        }
        //Select cell 4
        if (cell4Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell7Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell6Value) &&
                !hasTwoOutOfThreeInARow(4, selectedBoardNum)) {
            return 4;
        }
        //Select cell 5
        if (cell5Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell9Value ||
                        cell2Value > Piece.NONE.getValue() && cell2Value == cell8Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell6Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell7Value) &&
                !hasTwoOutOfThreeInARow(5, selectedBoardNum)) {
            return 5;
        }
        //Select cell 6
        if (cell6Value == Piece.NONE.getValue() &&
                (cell3Value > Piece.NONE.getValue() && cell3Value == cell9Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell5Value) &&
                !hasTwoOutOfThreeInARow(6, selectedBoardNum)) {
            return 6;
        }
        //Select cell 7
        if (cell7Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell4Value ||
                        cell8Value > Piece.NONE.getValue() && cell8Value == cell9Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell5Value) &&
                !hasTwoOutOfThreeInARow(7, selectedBoardNum)) {
            return 7;
        }
        //Select cell 8
        if (cell8Value == Piece.NONE.getValue() &&
                (cell2Value > Piece.NONE.getValue() && cell2Value == cell5Value ||
                        cell7Value > Piece.NONE.getValue() && cell7Value == cell9Value) &&
                !hasTwoOutOfThreeInARow(8, selectedBoardNum)) {
            return 8;
        }
        //Select cell 9
        if (cell9Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell5Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell6Value ||
                        cell7Value > Piece.NONE.getValue() && cell7Value == cell8Value) &&
                !hasTwoOutOfThreeInARow(9, selectedBoardNum)) {
            return 9;
        }

        return -1;
    }

    private int cellNumToMakeThreeInARow(int selectedBoardNum) {
        int cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 1);
        int cell1Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 2);
        int cell2Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 3);
        int cell3Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 4);
        int cell4Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 5);
        int cell5Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 6);
        int cell6Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 7);
        int cell7Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 8);
        int cell8Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, 9);
        int cell9Value = cellPieceMap.get(cellId).getPieceValue();

        //Select cell 1
        if (cell1Value == Piece.NONE.getValue() &&
                (cell5Value > Piece.NONE.getValue() && cell5Value == cell9Value ||
                        cell2Value > Piece.NONE.getValue() && cell2Value == cell3Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell7Value)) {
            return 1;
        }
        //Select cell 2
        if (cell2Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell3Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell8Value)) {
            return 2;
        }
        //Select cell 3
        if (cell3Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell2Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell7Value ||
                        cell6Value > Piece.NONE.getValue() && cell6Value == cell9Value)) {
            return 3;
        }
        //Select cell 4
        if (cell4Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell7Value ||
                        cell5Value > Piece.NONE.getValue() && cell5Value == cell6Value)) {
            return 4;
        }
        //Select cell 5
        if (cell5Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell9Value ||
                        cell2Value > Piece.NONE.getValue() && cell2Value == cell8Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell6Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell7Value)) {
            return 5;
        }
        //Select cell 6
        if (cell6Value == Piece.NONE.getValue() &&
                (cell3Value > Piece.NONE.getValue() && cell3Value == cell9Value ||
                        cell4Value > Piece.NONE.getValue() && cell4Value == cell5Value)) {
            return 6;
        }
        //Select cell 7
        if (cell7Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell4Value ||
                        cell8Value > Piece.NONE.getValue() && cell8Value == cell9Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell5Value)) {
            return 7;
        }
        //Select cell 8
        if (cell8Value == Piece.NONE.getValue() &&
                (cell2Value > Piece.NONE.getValue() && cell2Value == cell5Value ||
                        cell7Value > Piece.NONE.getValue() && cell7Value == cell9Value)) {
            return 8;
        }
        //Select cell 9
        if (cell9Value == Piece.NONE.getValue() &&
                (cell1Value > Piece.NONE.getValue() && cell1Value == cell5Value ||
                        cell3Value > Piece.NONE.getValue() && cell3Value == cell6Value ||
                        cell7Value > Piece.NONE.getValue() && cell7Value == cell8Value)) {
            return 9;
        }

        return -1;
    }

    private int selectRandomCell(int selectedBoardNum) {
        int cellNum = 0;
        int iterations = 0;

        while (cellNum == 0) {
            Random rand = new Random();
            int randomInt = rand.nextInt(9) + 1;
            int cellPieceId = InceptionGameActivity.generateCellPieceId(selectedBoardNum, randomInt);

            if (cellPieceMap.get(cellPieceId).getPieceValue() == Piece.NONE.getValue() &&
                    unselectableBoardMap.get(randomInt) == Piece.NONE.getValue() &&
                    !hasTwoOutOfThreeInARow(randomInt, selectedBoardNum) &&
                    isInLineWithSinglePiece(randomInt, selectedBoardNum)) {
                cellNum = randomInt;
            }
            else if (cellPieceMap.get(cellPieceId).getPieceValue() == Piece.NONE.getValue() &&
                    isInLineWithSinglePiece(randomInt, selectedBoardNum) &&
                    iterations > 9) {
                cellNum = randomInt;
            }
            //Don't want an infinite loop so restricting the iterations to be 9
            else if (cellPieceMap.get(cellPieceId).getPieceValue() == Piece.NONE.getValue() &&
                    iterations > 9) {
                cellNum = randomInt;
            }

            iterations++;
        }

        return cellNum;
    }

    private int selectRandomBoard() {
        int boardNum = 0;
        while (boardNum == 0) {
            Random rand = new Random();
            int randomInt = rand.nextInt(9) + 1;

            if (unselectableBoardMap.get(randomInt) == Piece.NONE.getValue()) {
                boardNum = randomInt;
            }
        }

        return boardNum;
    }

    private boolean hasTwoOutOfThreeInARow(int possibleBoardNum, int selectedBoardNum) {
        if (possibleBoardNum == selectedBoardNum) {
            return false;
        }
        else if (unselectableBoardMap.get(possibleBoardNum) > Piece.NONE.getValue()) {
            return false;
        }
        else {
            return cellNumToMakeThreeInARow(possibleBoardNum) > 0;
        }
    }

    private int cellNumOfSingleOPiece(int boardNum) {
        int cellId = InceptionGameActivity.generateCellPieceId(boardNum, 1);
        int cell1Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 2);
        int cell2Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 3);
        int cell3Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 4);
        int cell4Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 5);
        int cell5Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 6);
        int cell6Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 7);
        int cell7Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 8);
        int cell8Value = cellPieceMap.get(cellId).getPieceValue();
        cellId = InceptionGameActivity.generateCellPieceId(boardNum, 9);
        int cell9Value = cellPieceMap.get(cellId).getPieceValue();

        if (cell1Value == Piece.O.getValue() ^
                cell2Value == Piece.O.getValue() ^
                cell3Value == Piece.O.getValue() ^
                cell4Value == Piece.O.getValue() ^
                cell5Value == Piece.O.getValue() ^
                cell6Value == Piece.O.getValue() ^
                cell7Value == Piece.O.getValue() ^
                cell8Value == Piece.O.getValue() ^
                cell9Value == Piece.O.getValue()) {
            if (cell1Value == Piece.O.getValue()) {
                return 1;
            }
            else if (cell2Value == Piece.O.getValue()) {
                return 2;
            }
            else if (cell3Value == Piece.O.getValue()) {
                return 3;
            }
            else if (cell4Value == Piece.O.getValue()) {
                return 4;
            }
            else if (cell5Value == Piece.O.getValue()) {
                return 5;
            }
            else if (cell6Value == Piece.O.getValue()) {
                return 6;
            }
            else if (cell7Value == Piece.O.getValue()) {
                return 7;
            }
            else if (cell8Value == Piece.O.getValue()) {
                return 8;
            }
            else if (cell9Value == Piece.O.getValue()) {
                return 9;
            }
        }

        return -1;
    }

    private boolean isInLineWithSinglePiece(int possibleCellNum, int selectedBoardNum) {
        int singlePieceCellNum = cellNumOfSingleOPiece(selectedBoardNum);

        if (singlePieceCellNum == 1) {
            return possibleCellNum == 2 || possibleCellNum == 3 || possibleCellNum == 4 ||
                    possibleCellNum == 5 || possibleCellNum == 7 || possibleCellNum == 9;
        }
        if (singlePieceCellNum == 2) {
            return possibleCellNum == 1 || possibleCellNum == 3 || possibleCellNum == 5 ||
                    possibleCellNum == 8;
        }
        if (singlePieceCellNum == 3) {
            return possibleCellNum == 1 || possibleCellNum == 2 || possibleCellNum == 5 ||
                    possibleCellNum == 6 || possibleCellNum == 7 || possibleCellNum == 9;
        }
        if (singlePieceCellNum == 4) {
            return possibleCellNum == 1 || possibleCellNum == 5 || possibleCellNum == 6 ||
                    possibleCellNum == 7;
        }
        if (singlePieceCellNum == 5) {
            return true;
        }
        if (singlePieceCellNum == 6) {
            return possibleCellNum == 3 || possibleCellNum == 4 || possibleCellNum == 5 ||
                    possibleCellNum == 9;
        }
        if (singlePieceCellNum == 7) {
            return possibleCellNum == 1 || possibleCellNum == 3 || possibleCellNum == 4 ||
                    possibleCellNum == 5 || possibleCellNum == 8 || possibleCellNum == 9;
        }
        if (singlePieceCellNum == 8) {
            return possibleCellNum == 2 || possibleCellNum == 5 || possibleCellNum == 7 ||
                    possibleCellNum == 9;
        }
        if (singlePieceCellNum == 9) {
            return possibleCellNum == 1 || possibleCellNum == 3 || possibleCellNum == 5 ||
                    possibleCellNum == 6 || possibleCellNum == 7 || possibleCellNum == 8;
        }

        return true;
    }
}
