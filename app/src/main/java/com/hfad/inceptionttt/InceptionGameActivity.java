package com.hfad.inceptionttt;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InceptionGameActivity extends AppCompatActivity {
    //X always goes first
    boolean isCurrentPlayerX = true;

    //Represents the currently selected board number, 1-9, and is 0 if no board is selected
    private int selectedBoardNumber;
    private Map<Integer, Integer> boardIdMap = createBoardIdMap();
    private Map<Integer, List<Integer>> cellPieceIdMap = createCellPieceIdMap();

    //Pieces in board1, i.e. cell(board #)(cell #)Piece
    private int cell11Piece;
    private int cell12Piece;
    private int cell13Piece;
    private int cell14Piece;
    private int cell15Piece;
    private int cell16Piece;
    private int cell17Piece;
    private int cell18Piece;
    private int cell19Piece;
    //Pieces in board2
    private int cell21Piece;
    private int cell22Piece;
    private int cell23Piece;
    private int cell24Piece;
    private int cell25Piece;
    private int cell26Piece;
    private int cell27Piece;
    private int cell28Piece;
    private int cell29Piece;
    //Pieces in board3
    private int cell31Piece;
    private int cell32Piece;
    private int cell33Piece;
    private int cell34Piece;
    private int cell35Piece;
    private int cell36Piece;
    private int cell37Piece;
    private int cell38Piece;
    private int cell39Piece;
    //Pieces in board4
    private int cell41Piece;
    private int cell42Piece;
    private int cell43Piece;
    private int cell44Piece;
    private int cell45Piece;
    private int cell46Piece;
    private int cell47Piece;
    private int cell48Piece;
    private int cell49Piece;
    //Pieces in board5
    private int cell51Piece;
    private int cell52Piece;
    private int cell53Piece;
    private int cell54Piece;
    private int cell55Piece;
    private int cell56Piece;
    private int cell57Piece;
    private int cell58Piece;
    private int cell59Piece;
    //Pieces in board6
    private int cell61Piece;
    private int cell62Piece;
    private int cell63Piece;
    private int cell64Piece;
    private int cell65Piece;
    private int cell66Piece;
    private int cell67Piece;
    private int cell68Piece;
    private int cell69Piece;
    //Pieces in board7
    private int cell71Piece;
    private int cell72Piece;
    private int cell73Piece;
    private int cell74Piece;
    private int cell75Piece;
    private int cell76Piece;
    private int cell77Piece;
    private int cell78Piece;
    private int cell79Piece;
    //Pieces in board8
    private int cell81Piece;
    private int cell82Piece;
    private int cell83Piece;
    private int cell84Piece;
    private int cell85Piece;
    private int cell86Piece;
    private int cell87Piece;
    private int cell88Piece;
    private int cell89Piece;
    //Pieces in board9
    private int cell91Piece;
    private int cell92Piece;
    private int cell93Piece;
    private int cell94Piece;
    private int cell95Piece;
    private int cell96Piece;
    private int cell97Piece;
    private int cell98Piece;
    private int cell99Piece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inception_game);
    }

    public void selectBoard1(View view) {
        int boardNumber = 1;
        int boardImageId = R.id.board1;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard2(View view) {
        int boardNumber = 2;
        int boardImageId = R.id.board2;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard3(View view) {
        int boardNumber = 3;
        int boardImageId = R.id.board3;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard4(View view) {
        int boardNumber = 4;
        int boardImageId = R.id.board4;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard5(View view) {
        int boardNumber = 5;
        int boardImageId = R.id.board5;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard6(View view) {
        int boardNumber = 6;
        int boardImageId = R.id.board6;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard7(View view) {
        int boardNumber = 7;
        int boardImageId = R.id.board7;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard8(View view) {
        int boardNumber = 8;
        int boardImageId = R.id.board8;

        selectBoard(boardNumber, boardImageId);
    }

    public void selectBoard9(View view) {
        int boardNumber = 9;
        int boardImageId = R.id.board9;

        selectBoard(boardNumber, boardImageId);
    }

    public void placePieceCell1(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(1, (ImageButton) findViewById(R.id.cellButton1));
        }
    }

    public void placePieceCell2(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(2, (ImageButton) findViewById(R.id.cellButton2));
        }
    }

    public void placePieceCell3(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(3, (ImageButton) findViewById(R.id.cellButton3));
        }
    }

    public void placePieceCell4(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(4, (ImageButton) findViewById(R.id.cellButton4));
        }
    }

    public void placePieceCell5(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(5, (ImageButton) findViewById(R.id.cellButton5));
        }
    }

    public void placePieceCell6(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(6, (ImageButton) findViewById(R.id.cellButton6));
        }
    }

    public void placePieceCell7(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(7, (ImageButton) findViewById(R.id.cellButton7));
        }
    }

    public void placePieceCell8(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(8, (ImageButton) findViewById(R.id.cellButton8));
        }
    }

    public void placePieceCell9(View view) {
        //Only do something if the interactive board is visible
        if (isInteractiveBoardVisible()) {
            placePieceByCell(9, (ImageButton) findViewById(R.id.cellButton9));
        }
    }

    private void placePieceByCell(int cellNumber, ImageButton button) {
        List<Integer> cellPieces = createCellPieceMap().get(selectedBoardNumber);
        int cellPiece = cellPieces.get(cellNumber - 1);
        List<Integer> cellPieceIds = cellPieceIdMap.get(selectedBoardNumber);
        int cellPieceId = cellPieceIds.get(cellNumber - 1);
        ImageView cellImage = (ImageView) findViewById(cellPieceId);

        if (cellPiece == Piece.NONE.getValue() && isCurrentPlayerX) {
            button.setImageResource(R.drawable.tictactoex);
            cellImage.setImageResource(R.drawable.tictactoex);
            cellPiece = Piece.X.getValue();
            setCellPieceValue(selectedBoardNumber, cellNumber, Piece.X.getValue());
        }
        else if (cellPiece == Piece.NONE.getValue() && !isCurrentPlayerX) {
            button.setImageResource(R.drawable.tictactoeo);
            cellImage.setImageResource(R.drawable.tictactoeo);
            cellPiece = Piece.O.getValue();
            setCellPieceValue(selectedBoardNumber, cellNumber, Piece.O.getValue());
        }

        //check for board winner

        isCurrentPlayerX = !isCurrentPlayerX;
    }

    private void selectBoard(int boardNumber, int boardImageId) {
        ImageView board = (ImageView) findViewById(boardImageId);
        ImageView interactiveBoard = (ImageView) findViewById(R.id.interactiveBoard);

        //Unselect the previously selected board
        int prevSelectedBoardNumber = selectedBoardNumber;
        selectedBoardNumber = boardNumber;
        if (prevSelectedBoardNumber > 0 && prevSelectedBoardNumber != boardNumber) {
            ImageView prevSelectedBoard = (ImageView) findViewById(boardIdMap.get(prevSelectedBoardNumber));
            prevSelectedBoard.setImageResource(R.drawable.tictactoeboard);
        }
        //Create the interactive board at the bottom if not previously there
        else if (prevSelectedBoardNumber == 0) {
            interactiveBoard.setImageResource(R.drawable.tictactoeboardgoldoutlined);
        }

        //Select the new board
        board.setImageResource(R.drawable.tictactoeboardgold);

        ImageButton cellButton1 = (ImageButton) findViewById(R.id.cellButton1);
        ImageButton cellButton2 = (ImageButton) findViewById(R.id.cellButton2);
        ImageButton cellButton3 = (ImageButton) findViewById(R.id.cellButton3);
        ImageButton cellButton4 = (ImageButton) findViewById(R.id.cellButton4);
        ImageButton cellButton5 = (ImageButton) findViewById(R.id.cellButton5);
        ImageButton cellButton6 = (ImageButton) findViewById(R.id.cellButton6);
        ImageButton cellButton7 = (ImageButton) findViewById(R.id.cellButton7);
        ImageButton cellButton8 = (ImageButton) findViewById(R.id.cellButton8);
        ImageButton cellButton9 = (ImageButton) findViewById(R.id.cellButton9);

        //Set the buttons to show the correct pieces
        if (prevSelectedBoardNumber != boardNumber) {
            List<Integer> cellPieces = createCellPieceMap().get(boardNumber);
            setButtonPiece(cellButton1, cellPieces.get(0));
            setButtonPiece(cellButton2, cellPieces.get(1));
            setButtonPiece(cellButton3, cellPieces.get(2));
            setButtonPiece(cellButton4, cellPieces.get(3));
            setButtonPiece(cellButton5, cellPieces.get(4));
            setButtonPiece(cellButton6, cellPieces.get(5));
            setButtonPiece(cellButton7, cellPieces.get(6));
            setButtonPiece(cellButton8, cellPieces.get(7));
            setButtonPiece(cellButton9, cellPieces.get(8));
        }
    }

    private void setButtonPiece(ImageButton cellButton1, int cellPiece) {
        if (cellPiece == Piece.X.getValue()) {
            cellButton1.setImageResource(R.drawable.tictactoex);
        }
        else if (cellPiece == Piece.O.getValue()) {
            cellButton1.setImageResource(R.drawable.tictactoeo);
        }
        else if (cellPiece == Piece.NONE.getValue()) {
            cellButton1.setImageResource(android.R.color.transparent);
        }
    }

    private Map<Integer, Integer> createBoardIdMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, R.id.board1);
        map.put(2, R.id.board2);
        map.put(3, R.id.board3);
        map.put(4, R.id.board4);
        map.put(5, R.id.board5);
        map.put(6, R.id.board6);
        map.put(7, R.id.board7);
        map.put(8, R.id.board8);
        map.put(9, R.id.board9);

        return map;
    }

    private Map<Integer, List<Integer>> createCellPieceIdMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> cellPieces = Arrays.asList(R.id.cell11, R.id.cell12, R.id.cell13, R.id.cell14,
                R.id.cell15, R.id.cell16, R.id.cell17, R.id.cell18, R.id.cell19);
        map.put(1, cellPieces);
        cellPieces = Arrays.asList(R.id.cell21, R.id.cell22, R.id.cell23, R.id.cell24,
                R.id.cell25, R.id.cell26, R.id.cell27, R.id.cell28, R.id.cell29);
        map.put(2, cellPieces);
        cellPieces = Arrays.asList(R.id.cell31, R.id.cell32, R.id.cell33, R.id.cell34,
                R.id.cell35, R.id.cell36, R.id.cell37, R.id.cell38, R.id.cell39);
        map.put(3, cellPieces);
        cellPieces = Arrays.asList(R.id.cell41, R.id.cell42, R.id.cell43, R.id.cell44,
                R.id.cell45, R.id.cell46, R.id.cell47, R.id.cell48, R.id.cell49);
        map.put(4, cellPieces);
        cellPieces = Arrays.asList(R.id.cell51, R.id.cell52, R.id.cell53, R.id.cell54,
                R.id.cell55, R.id.cell56, R.id.cell57, R.id.cell58, R.id.cell59);
        map.put(5, cellPieces);
        cellPieces = Arrays.asList(R.id.cell61, R.id.cell62, R.id.cell63, R.id.cell64,
                R.id.cell65, R.id.cell66, R.id.cell67, R.id.cell68, R.id.cell69);
        map.put(6, cellPieces);
        cellPieces = Arrays.asList(R.id.cell71, R.id.cell72, R.id.cell73, R.id.cell74,
                R.id.cell75, R.id.cell76, R.id.cell77, R.id.cell78, R.id.cell79);
        map.put(7, cellPieces);
        cellPieces = Arrays.asList(R.id.cell81, R.id.cell82, R.id.cell83, R.id.cell84,
                R.id.cell85, R.id.cell86, R.id.cell87, R.id.cell88, R.id.cell89);
        map.put(8, cellPieces);
        cellPieces = Arrays.asList(R.id.cell91, R.id.cell92, R.id.cell93, R.id.cell94,
                R.id.cell95, R.id.cell96, R.id.cell97, R.id.cell98, R.id.cell99);
        map.put(9, cellPieces);
        return map;
    }

    private Map<Integer, List<Integer>> createCellPieceMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> cellPieces = Arrays.asList(cell11Piece, cell12Piece, cell13Piece, cell14Piece,
                cell15Piece, cell16Piece, cell17Piece, cell18Piece, cell19Piece);
        map.put(1, cellPieces);
        cellPieces = Arrays.asList(cell21Piece, cell22Piece, cell23Piece, cell24Piece,
                cell25Piece, cell26Piece, cell27Piece, cell28Piece, cell29Piece);
        map.put(2, cellPieces);
        cellPieces = Arrays.asList(cell31Piece, cell32Piece, cell33Piece, cell34Piece,
                cell35Piece, cell36Piece, cell37Piece, cell38Piece, cell39Piece);
        map.put(3, cellPieces);
        cellPieces = Arrays.asList(cell41Piece, cell42Piece, cell43Piece, cell44Piece,
                cell45Piece, cell46Piece, cell47Piece, cell48Piece, cell49Piece);
        map.put(4, cellPieces);
        cellPieces = Arrays.asList(cell51Piece, cell52Piece, cell53Piece, cell54Piece,
                cell55Piece, cell56Piece, cell57Piece, cell58Piece, cell59Piece);
        map.put(5, cellPieces);
        cellPieces = Arrays.asList(cell61Piece, cell62Piece, cell63Piece, cell64Piece,
                cell65Piece, cell66Piece, cell67Piece, cell68Piece, cell69Piece);
        map.put(6, cellPieces);
        cellPieces = Arrays.asList(cell71Piece, cell72Piece, cell73Piece, cell74Piece,
                cell75Piece, cell76Piece, cell77Piece, cell78Piece, cell79Piece);
        map.put(7, cellPieces);
        cellPieces = Arrays.asList(cell81Piece, cell82Piece, cell83Piece, cell84Piece,
                cell85Piece, cell86Piece, cell87Piece, cell88Piece, cell89Piece);
        map.put(8, cellPieces);
        cellPieces = Arrays.asList(cell91Piece, cell92Piece, cell93Piece, cell94Piece,
                cell95Piece, cell96Piece, cell97Piece, cell98Piece, cell99Piece);
        map.put(9, cellPieces);
        return map;
    }

    private boolean isInteractiveBoardVisible() {
        return selectedBoardNumber > 0;
    }

    private void setCellPieceValue(int boardNumber, int cellNumber, int value) {
        switch (boardNumber) {
            case 1:
                switch (cellNumber) {
                    case 1: cell11Piece = value; break;
                    case 2: cell12Piece = value; break;
                    case 3: cell13Piece = value; break;
                    case 4: cell14Piece = value; break;
                    case 5: cell15Piece = value; break;
                    case 6: cell16Piece = value; break;
                    case 7: cell17Piece = value; break;
                    case 8: cell18Piece = value; break;
                    case 9: cell19Piece = value; break;
                    default: break;
                }
                break;
            case 2:
                switch (cellNumber) {
                    case 1: cell21Piece = value; break;
                    case 2: cell22Piece = value; break;
                    case 3: cell23Piece = value; break;
                    case 4: cell24Piece = value; break;
                    case 5: cell25Piece = value; break;
                    case 6: cell26Piece = value; break;
                    case 7: cell27Piece = value; break;
                    case 8: cell28Piece = value; break;
                    case 9: cell29Piece = value; break;
                    default: break;
                }
                break;
            case 3:
                switch (cellNumber) {
                    case 1: cell31Piece = value; break;
                    case 2: cell32Piece = value; break;
                    case 3: cell33Piece = value; break;
                    case 4: cell34Piece = value; break;
                    case 5: cell35Piece = value; break;
                    case 6: cell36Piece = value; break;
                    case 7: cell37Piece = value; break;
                    case 8: cell38Piece = value; break;
                    case 9: cell39Piece = value; break;
                    default: break;
                }
                break;
            case 4:
                switch (cellNumber) {
                    case 1: cell41Piece = value; break;
                    case 2: cell42Piece = value; break;
                    case 3: cell43Piece = value; break;
                    case 4: cell44Piece = value; break;
                    case 5: cell45Piece = value; break;
                    case 6: cell46Piece = value; break;
                    case 7: cell47Piece = value; break;
                    case 8: cell48Piece = value; break;
                    case 9: cell49Piece = value; break;
                    default: break;
                }
                break;
            case 5:
                switch (cellNumber) {
                    case 1: cell51Piece = value; break;
                    case 2: cell52Piece = value; break;
                    case 3: cell53Piece = value; break;
                    case 4: cell54Piece = value; break;
                    case 5: cell55Piece = value; break;
                    case 6: cell56Piece = value; break;
                    case 7: cell57Piece = value; break;
                    case 8: cell58Piece = value; break;
                    case 9: cell59Piece = value; break;
                    default: break;
                }
                break;
            case 6:
                switch (cellNumber) {
                    case 1: cell61Piece = value; break;
                    case 2: cell62Piece = value; break;
                    case 3: cell63Piece = value; break;
                    case 4: cell64Piece = value; break;
                    case 5: cell65Piece = value; break;
                    case 6: cell66Piece = value; break;
                    case 7: cell67Piece = value; break;
                    case 8: cell68Piece = value; break;
                    case 9: cell69Piece = value; break;
                    default: break;
                }
                break;
            case 7:
                switch (cellNumber) {
                    case 1: cell71Piece = value; break;
                    case 2: cell72Piece = value; break;
                    case 3: cell73Piece = value; break;
                    case 4: cell74Piece = value; break;
                    case 5: cell75Piece = value; break;
                    case 6: cell76Piece = value; break;
                    case 7: cell77Piece = value; break;
                    case 8: cell78Piece = value; break;
                    case 9: cell79Piece = value; break;
                    default: break;
                }
                break;
            case 8:
                switch (cellNumber) {
                    case 1: cell81Piece = value; break;
                    case 2: cell82Piece = value; break;
                    case 3: cell83Piece = value; break;
                    case 4: cell84Piece = value; break;
                    case 5: cell85Piece = value; break;
                    case 6: cell86Piece = value; break;
                    case 7: cell87Piece = value; break;
                    case 8: cell88Piece = value; break;
                    case 9: cell89Piece = value; break;
                    default: break;
                }
                break;
            case 9:
                switch (cellNumber) {
                    case 1: cell91Piece = value; break;
                    case 2: cell92Piece = value; break;
                    case 3: cell93Piece = value; break;
                    case 4: cell94Piece = value; break;
                    case 5: cell95Piece = value; break;
                    case 6: cell96Piece = value; break;
                    case 7: cell97Piece = value; break;
                    case 8: cell98Piece = value; break;
                    case 9: cell99Piece = value; break;
                    default: break;
                }
                break;
            default: break;
        }
    }
}