package com.dach816.inceptionttt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InceptionGameActivity extends AppCompatActivity {
    //Is the game mode in single player
    private boolean isSinglePlayer = false;
    //Is the game over
    private boolean isGameOver = false;
    //X always goes first
    private boolean isCurrentPlayerX = true;
    //Represents the currently selected board number, 1-9, and is 0 if no board is selected
    private int selectedBoardNumber;
    //Whether player has a choice in board selection for their next move
    private boolean playerCanSelectBoard = true;
    //Map where key is the board number and value is the resource ID of the image view
    private Map<Integer, Integer> boardResourceIdMap = createBoardResourceIdMap();
    //Map where key is the board number and value is the resource ID of the image button overlaying the board
    private Map<Integer, Integer> boardButtonResourceIdMap = createBoardButtonResourceIdMap();
    //Map where key is the board number and value is a list of the resource IDs for each piece's image view
    private Map<Integer, List<Integer>> cellPieceResourceIdMap = createCellPieceResourceIdMap();
    //Map where key is the board number and value is 0 if selectable or Piece values representing who won the board
    private Map<Integer, Integer> unselectableBoardMap = createUnselectableBoardMap();
    //Map where the key is the CellPiece ID and the value is the CellPiece
    private Map<Integer, CellPiece> cellPieceMap = createCellPieceMap();

    public static final String EXTRA_GAME_TYPE = "Game Type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inception_game);

        if (savedInstanceState != null) {
            isSinglePlayer = savedInstanceState.getBoolean("isSinglePlayer");
            isGameOver = savedInstanceState.getBoolean("isGameOver");
            isCurrentPlayerX = savedInstanceState.getBoolean("isCurrentPlayerX");
            selectedBoardNumber = savedInstanceState.getInt("selectedBoardNumber");
            playerCanSelectBoard = savedInstanceState.getBoolean("playerCanSelectBoard");
            unselectableBoardMap =
                    unselectableBoardArrayToMap(savedInstanceState.getIntArray("unselectableBoardArray"));
            cellPieceMap = cellPieceArrayToMap(savedInstanceState.getIntArray("cellPieceArray"));
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);
        Intent intent = getIntent();
        isSinglePlayer = intent.getBooleanExtra(EXTRA_GAME_TYPE, false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean("isSinglePlayer", isSinglePlayer);
        savedInstanceState.putBoolean("isGameOver", isGameOver);
        savedInstanceState.putBoolean("isCurrentPlayerX", isCurrentPlayerX);
        savedInstanceState.putInt("selectedBoardNumber", selectedBoardNumber);
        savedInstanceState.putBoolean("playerCanSelectBoard", playerCanSelectBoard);
        savedInstanceState.putIntArray("unselectableBoardArray", generateUnselectableBoardArray());
        savedInstanceState.putIntArray("cellPieceArray", generateCellPieceArray());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                //TODO: Add settings option
                return true;

            case R.id.action_restart:
                if (isGameOver) {
                    hidePopup();
                }
                restart();
                return true;

            case R.id.action_menu:
                Intent intent = new Intent(this, MainMenuActivity.class);
                startActivity(intent);
                //TODO: Save game state

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void selectBoard1(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 1;
            int boardImageId = R.id.board1;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard2(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 2;
            int boardImageId = R.id.board2;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard3(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 3;
            int boardImageId = R.id.board3;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard4(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 4;
            int boardImageId = R.id.board4;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard5(View view) {

        if (playerCanSelectBoard) {
            int boardNumber = 5;
            int boardImageId = R.id.board5;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard6(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 6;
            int boardImageId = R.id.board6;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard7(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 7;
            int boardImageId = R.id.board7;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard8(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 8;
            int boardImageId = R.id.board8;

            selectBoard(boardNumber, boardImageId);
        }
    }

    public void selectBoard9(View view) {
        if (playerCanSelectBoard) {
            int boardNumber = 9;
            int boardImageId = R.id.board9;

            selectBoard(boardNumber, boardImageId);
        }
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

    public void selectMainMenu(View view) {
        //Go to the main menu
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    public void selectPlayAgain(View view) {
        restart();
        hidePopup();
    }

    private void placePieceByCell(int cellNumber, ImageButton button) {
        CellPiece cellPiece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, cellNumber));
        List<Integer> cellPieceResourceIds = cellPieceResourceIdMap.get(selectedBoardNumber);
        int cellPieceResourceId = cellPieceResourceIds.get(cellNumber - 1);
        ImageView cellImage = (ImageView) findViewById(cellPieceResourceId);

        if (cellPiece.getPieceValue() == Piece.NONE.getValue()) {
            if (isCurrentPlayerX) {
                button.setImageResource(R.drawable.tictactoex);
                cellImage.setImageResource(R.drawable.tictactoex);
                cellPiece.setPieceValue(Piece.X.getValue());
                setCellPieceValue(selectedBoardNumber, cellNumber, Piece.X.getValue());
            } else {
                button.setImageResource(R.drawable.tictactoeo);
                cellImage.setImageResource(R.drawable.tictactoeo);
                cellPiece.setPieceValue(Piece.O.getValue());
                setCellPieceValue(selectedBoardNumber, cellNumber, Piece.O.getValue());
            }

            //check for board winner/tie
            checkBoardForWinner(cellNumber);

            isCurrentPlayerX = !isCurrentPlayerX;

            //Setup for next player
            if (unselectableBoardMap.get(cellNumber) == 0) {
                selectBoard(cellNumber, boardResourceIdMap.get(cellNumber));

                //Prompt player to take turn
                TextView gameMessage = (TextView) findViewById(R.id.game_message);
                if (isCurrentPlayerX) {
                    gameMessage.setText(R.string.player_x_turn);
                }
                else {
                    gameMessage.setText("");
                }
            }
            else {
                int prevSelectedBoardNumber = selectedBoardNumber;
                playerCanSelectBoard = true;
                selectedBoardNumber = 0;
                clearButtonPieces();
                ((ImageView) findViewById(boardResourceIdMap.get(prevSelectedBoardNumber))).setImageResource(R.drawable.tictactoeboard);
                ((ImageView) findViewById(R.id.interactiveBoard)).setImageResource(android.R.color.transparent);

                //Prompt player to select a board
                TextView gameMessage = (TextView) findViewById(R.id.game_message);
                if (isCurrentPlayerX) {
                    gameMessage.setText(R.string.player_x_select_board);
                }
                else {
                    gameMessage.setText("");
                }
            }
        }
    }

    private void selectBoard(int boardNumber, int boardImageId) {
        if (unselectableBoardMap.get(boardNumber) == 0) {
            ImageView board = (ImageView) findViewById(boardImageId);
            ImageView interactiveBoard = (ImageView) findViewById(R.id.interactiveBoard);

            //Unselect the previously selected board
            int prevSelectedBoardNumber = selectedBoardNumber;
            selectedBoardNumber = boardNumber;
            if (prevSelectedBoardNumber > 0 && prevSelectedBoardNumber != boardNumber) {
                ImageView prevSelectedBoard = (ImageView) findViewById(boardResourceIdMap.get(prevSelectedBoardNumber));
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
                CellPiece cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 1));
                setButtonPiece(cellButton1, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 2));
                setButtonPiece(cellButton2, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 3));
                setButtonPiece(cellButton3, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 4));
                setButtonPiece(cellButton4, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 5));
                setButtonPiece(cellButton5, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 6));
                setButtonPiece(cellButton6, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 7));
                setButtonPiece(cellButton7, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 8));
                setButtonPiece(cellButton8, cellPiece.getPieceValue());
                cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, 9));
                setButtonPiece(cellButton9, cellPiece.getPieceValue());
            }

            playerCanSelectBoard = false;

            TextView gameMessage = (TextView) findViewById(R.id.game_message);
            if (isCurrentPlayerX) {
                gameMessage.setText(R.string.player_x_turn);
            }
            else {
                gameMessage.setText("");
            }
        }
    }

    private void setButtonPiece(ImageButton cellButton, int cellPiece) {
        if (cellPiece == Piece.X.getValue()) {
            cellButton.setImageResource(R.drawable.tictactoex);
        }
        else if (cellPiece == Piece.O.getValue()) {
            cellButton.setImageResource(R.drawable.tictactoeo);
        }
        else if (cellPiece == Piece.NONE.getValue()) {
            cellButton.setImageResource(android.R.color.transparent);
        }
    }

    private void clearButtonPieces() {
        ((ImageButton) findViewById(R.id.cellButton1)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton2)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton3)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton4)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton5)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton6)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton7)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton8)).setImageResource(android.R.color.transparent);
        ((ImageButton) findViewById(R.id.cellButton9)).setImageResource(android.R.color.transparent);
    }

    private Map<Integer, Integer> createBoardResourceIdMap() {
        Map<Integer, Integer> map = new HashMap<>(9);
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

    private Map<Integer, Integer> createBoardButtonResourceIdMap() {
        Map<Integer, Integer> map = new HashMap<>(9);
        map.put(1, R.id.boardButton1);
        map.put(2, R.id.boardButton2);
        map.put(3, R.id.boardButton3);
        map.put(4, R.id.boardButton4);
        map.put(5, R.id.boardButton5);
        map.put(6, R.id.boardButton6);
        map.put(7, R.id.boardButton7);
        map.put(8, R.id.boardButton8);
        map.put(9, R.id.boardButton9);

        return map;
    }

    private Map<Integer, List<Integer>> createCellPieceResourceIdMap() {
        Map<Integer, List<Integer>> map = new HashMap<>(9);
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

    private Map<Integer, Integer> createUnselectableBoardMap() {
        Map<Integer, Integer> map = new HashMap<>(9);
        map.put(1, Piece.NONE.getValue());
        map.put(2, Piece.NONE.getValue());
        map.put(3, Piece.NONE.getValue());
        map.put(4, Piece.NONE.getValue());
        map.put(5, Piece.NONE.getValue());
        map.put(6, Piece.NONE.getValue());
        map.put(7, Piece.NONE.getValue());
        map.put(8, Piece.NONE.getValue());
        map.put(9, Piece.NONE.getValue());

        return map;
    }

    private Map<Integer, CellPiece> createCellPieceMap() {
        Map<Integer, CellPiece> map = new HashMap<>(81);
        CellPiece cellPiece = new CellPiece(1, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(1, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(2, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(2, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(3, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(3, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(4, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(4, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(5, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(5, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(6, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(6, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(7, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(7, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(8, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(8, 9);
        map.put(cellPiece.getId(), cellPiece);

        cellPiece = new CellPiece(9, 1);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 2);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 3);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 4);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 5);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 6);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 7);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 8);
        map.put(cellPiece.getId(), cellPiece);
        cellPiece = new CellPiece(9, 9);
        map.put(cellPiece.getId(), cellPiece);

        return map;
    }

    private int generateCellPieceId(int boardNum, int cellNum) {
        return boardNum * 10 + cellNum;
    }

    private boolean isInteractiveBoardVisible() {
        return selectedBoardNumber > 0;
    }

    private boolean isThereATie() {
        int cell1Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 1)).getPieceValue();
        int cell2Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 2)).getPieceValue();
        int cell3Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 3)).getPieceValue();
        int cell4Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 4)).getPieceValue();
        int cell5Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 5)).getPieceValue();
        int cell6Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 6)).getPieceValue();
        int cell7Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 7)).getPieceValue();
        int cell8Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 8)).getPieceValue();
        int cell9Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 9)).getPieceValue();

        return cell1Piece != Piece.NONE.getValue() && cell2Piece != Piece.NONE.getValue() &&
                cell3Piece != Piece.NONE.getValue() && cell4Piece != Piece.NONE.getValue() &&
                cell5Piece != Piece.NONE.getValue() && cell6Piece != Piece.NONE.getValue() &&
                cell7Piece != Piece.NONE.getValue() && cell8Piece != Piece.NONE.getValue() &&
                cell9Piece != Piece.NONE.getValue();
    }

    private boolean isThereAGlobalTie() {
        int board1Piece = unselectableBoardMap.get(1);
        int board2Piece = unselectableBoardMap.get(2);
        int board3Piece = unselectableBoardMap.get(3);
        int board4Piece = unselectableBoardMap.get(4);
        int board5Piece = unselectableBoardMap.get(5);
        int board6Piece = unselectableBoardMap.get(6);
        int board7Piece = unselectableBoardMap.get(7);
        int board8Piece = unselectableBoardMap.get(8);
        int board9Piece = unselectableBoardMap.get(9);

        return board1Piece != Piece.NONE.getValue() && board2Piece != Piece.NONE.getValue() &&
                board3Piece != Piece.NONE.getValue() && board4Piece != Piece.NONE.getValue() &&
                board5Piece != Piece.NONE.getValue() && board6Piece != Piece.NONE.getValue() &&
                board7Piece != Piece.NONE.getValue() && board8Piece != Piece.NONE.getValue() &&
                board9Piece != Piece.NONE.getValue();
    }

    private void setCellPieceValue(int boardNumber, int cellNumber, int value) {
        CellPiece cellPiece = cellPieceMap.get(generateCellPieceId(boardNumber, cellNumber));
        cellPiece.setPieceValue(value);
    }

    private void setCellPieceValuesUnselectableByBoard(int boardNumber) {
        setCellPieceValue(boardNumber, 1, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 2, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 3, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 4, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 5, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 6, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 7, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 8, Piece.UNSELECTABLE.getValue());
        setCellPieceValue(boardNumber, 9, Piece.UNSELECTABLE.getValue());
    }

    private void checkBoardForWinner(int cellNumber) {
        int cell1Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 1)).getPieceValue();
        int cell2Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 2)).getPieceValue();
        int cell3Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 3)).getPieceValue();
        int cell4Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 4)).getPieceValue();
        int cell5Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 5)).getPieceValue();
        int cell6Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 6)).getPieceValue();
        int cell7Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 7)).getPieceValue();
        int cell8Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 8)).getPieceValue();
        int cell9Piece = cellPieceMap.get(generateCellPieceId(selectedBoardNumber, 9)).getPieceValue();

        if (cellNumber == 1) {
            if ((cell1Piece == cell2Piece && cell1Piece == cell3Piece) ||
                    (cell1Piece == cell4Piece && cell1Piece == cell7Piece) ||
                    (cell1Piece == cell5Piece && cell1Piece == cell9Piece)) {
                playerWinsTheBoard(cell1Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 2) {
            if ((cell2Piece == cell1Piece && cell2Piece == cell3Piece) ||
                    (cell2Piece == cell5Piece && cell2Piece == cell8Piece)) {
                playerWinsTheBoard(cell2Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 3) {
            if ((cell3Piece == cell1Piece && cell3Piece == cell2Piece) ||
                    (cell3Piece == cell6Piece && cell3Piece == cell9Piece) ||
                    (cell3Piece == cell5Piece && cell3Piece == cell7Piece)) {
                playerWinsTheBoard(cell3Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 4) {
            if ((cell4Piece == cell1Piece && cell4Piece == cell7Piece) ||
                    (cell4Piece == cell5Piece && cell4Piece == cell6Piece)) {
                playerWinsTheBoard(cell4Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 5) {
            if ((cell5Piece == cell2Piece && cell5Piece == cell8Piece) ||
                    (cell5Piece == cell4Piece && cell5Piece == cell6Piece) ||
                    (cell5Piece == cell1Piece && cell5Piece == cell9Piece) ||
                    (cell5Piece == cell3Piece && cell5Piece == cell7Piece)) {
                playerWinsTheBoard(cell5Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 6) {
            if ((cell6Piece == cell3Piece && cell6Piece == cell9Piece) ||
                    (cell6Piece == cell4Piece && cell6Piece == cell5Piece)) {
                playerWinsTheBoard(cell6Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 7) {
            if ((cell7Piece == cell1Piece && cell7Piece == cell4Piece) ||
                    (cell7Piece == cell8Piece && cell7Piece == cell9Piece) ||
                    (cell7Piece == cell5Piece && cell7Piece == cell3Piece)) {
                playerWinsTheBoard(cell7Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 8) {
            if ((cell8Piece == cell2Piece && cell8Piece == cell5Piece) ||
                    (cell8Piece == cell7Piece && cell8Piece == cell9Piece)) {
                playerWinsTheBoard(cell8Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        } else if (cellNumber == 9) {
            if ((cell9Piece == cell7Piece && cell9Piece == cell8Piece) ||
                    (cell9Piece == cell3Piece && cell9Piece == cell6Piece) ||
                    (cell9Piece == cell5Piece && cell9Piece == cell1Piece)) {
                playerWinsTheBoard(cell9Piece);
            } else if (isThereATie()) {
                playerTiesTheBoard();
            }
        }
    }

    private void playerWinsTheBoard(int cellPieceValue) {
        ImageButton boardButton = (ImageButton) findViewById(boardButtonResourceIdMap.get(selectedBoardNumber));
        if (cellPieceValue == Piece.X.getValue()) {
            boardButton.setImageResource(R.drawable.tictactoex);
            setCellPieceValuesUnselectableByBoard(selectedBoardNumber);
            unselectableBoardMap.put(selectedBoardNumber, Piece.X.getValue());
        }
        else if (cellPieceValue == Piece.O.getValue()) {
            boardButton.setImageResource(R.drawable.tictactoeo);
            setCellPieceValuesUnselectableByBoard(selectedBoardNumber);
            unselectableBoardMap.put(selectedBoardNumber, Piece.O.getValue());
        }

        checkGameForWinner();
    }

    private void playerTiesTheBoard() {
        setCellPieceValuesUnselectableByBoard(selectedBoardNumber);

        //Make board unselectable
        unselectableBoardMap.put(selectedBoardNumber, Piece.UNSELECTABLE.getValue());
    }

    private void checkGameForWinner() {
        boolean winner = false;
        boolean tie = false;
        int board1Piece = unselectableBoardMap.get(1);
        int board2Piece = unselectableBoardMap.get(2);
        int board3Piece = unselectableBoardMap.get(3);
        int board4Piece = unselectableBoardMap.get(4);
        int board5Piece = unselectableBoardMap.get(5);
        int board6Piece = unselectableBoardMap.get(6);
        int board7Piece = unselectableBoardMap.get(7);
        int board8Piece = unselectableBoardMap.get(8);
        int board9Piece = unselectableBoardMap.get(9);

        if (selectedBoardNumber == 1) {
            if ((board1Piece == board2Piece && board1Piece == board3Piece) ||
                    (board1Piece == board4Piece && board1Piece == board7Piece) ||
                    (board1Piece == board5Piece && board1Piece == board9Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 2) {
            if ((board2Piece == board1Piece && board2Piece == board3Piece) ||
                    (board2Piece == board5Piece && board2Piece == board8Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 3) {
            if ((board3Piece == board1Piece && board3Piece == board2Piece) ||
                    (board3Piece == board6Piece && board3Piece == board9Piece) ||
                    (board3Piece == board5Piece && board3Piece == board7Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 4) {
            if ((board4Piece == board1Piece && board4Piece == board7Piece) ||
                    (board4Piece == board5Piece && board4Piece == board6Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 5) {
            if ((board5Piece == board2Piece && board5Piece == board8Piece) ||
                    (board5Piece == board4Piece && board5Piece == board6Piece) ||
                    (board5Piece == board1Piece && board5Piece == board9Piece) ||
                    (board5Piece == board3Piece && board5Piece == board7Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 6) {
            if ((board6Piece == board3Piece && board6Piece == board9Piece) ||
                    (board6Piece == board4Piece && board6Piece == board5Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 7) {
            if ((board7Piece == board1Piece && board7Piece == board4Piece) ||
                    (board7Piece == board8Piece && board7Piece == board9Piece) ||
                    (board7Piece == board5Piece && board7Piece == board3Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 8) {
            if ((board8Piece == board2Piece && board8Piece == board5Piece) ||
                    (board8Piece == board7Piece && board8Piece == board9Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        } else if (selectedBoardNumber == 9) {
            if ((board9Piece == board7Piece && board9Piece == board8Piece) ||
                    (board9Piece == board3Piece && board9Piece == board6Piece) ||
                    (board9Piece == board5Piece && board9Piece == board1Piece)) {
                winner = true;
                setAllBoardsUnselectable();
            } else if (isThereAGlobalTie()) {
                tie = true;
                setAllBoardsUnselectable();
            }
        }

        if (winner) {
            if (isCurrentPlayerX) {
                showPopup(EndGameState.X_WINS);
            }
            else {
                showPopup(EndGameState.O_WINS);
            }
            isGameOver = true;
        }
        else if (tie) {
            showPopup(EndGameState.TIE);
            isGameOver = true;
        }
    }

    private void setAllBoardsUnselectable() {
        unselectableBoardMap.put(1, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(2, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(3, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(4, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(5, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(6, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(7, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(8, Piece.UNSELECTABLE.getValue());
        unselectableBoardMap.put(9, Piece.UNSELECTABLE.getValue());
    }

    private void restart() {
        playerCanSelectBoard = true;
        isCurrentPlayerX = true;
        selectedBoardNumber = 0;
        unselectableBoardMap = createUnselectableBoardMap();
        cellPieceMap = createCellPieceMap();

        //Hide the interactive board
        ImageView interactiveBoardImageView = (ImageView) findViewById(R.id.interactiveBoard);
        interactiveBoardImageView.setImageResource(android.R.color.transparent);

        //Hide the cell pieces within the interactive board
        ImageButton cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton1);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton2);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton3);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton4);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton5);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton6);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton7);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton8);
        cellPieceImageButton.setImageResource(android.R.color.transparent);
        cellPieceImageButton = (ImageButton) findViewById(R.id.cellButton9);
        cellPieceImageButton.setImageResource(android.R.color.transparent);

        for (int boardNum = 1; boardNum <= 9; boardNum++) {
            for (int cellNum = 1; cellNum <= 9; cellNum++) {
                //Set CellPiece values to NONE and clear the image from the image views
                setCellPieceValue(boardNum, cellNum, Piece.NONE.getValue());
                ImageView pieceImageView = (ImageView) findViewById(cellPieceResourceIdMap.get(boardNum).get(cellNum - 1));
                pieceImageView.setImageResource(android.R.color.transparent);
            }

            //Resets the boards
            ImageView boardImageView = (ImageView) findViewById(boardResourceIdMap.get(boardNum));
            boardImageView.setImageResource(R.drawable.tictactoeboard);
            ImageButton boardImageButton = (ImageButton) findViewById(boardButtonResourceIdMap.get(boardNum));
            boardImageButton.setImageResource(android.R.color.transparent);
        }

        //Prompt user to select a board
        TextView gameMessage = (TextView) findViewById(R.id.game_message);
        gameMessage.setText(R.string.player_x_select_board);
    }

    private void showPopup(EndGameState state) {
        ImageView popupWindow = (ImageView) findViewById(R.id.popup);
        popupWindow.setImageResource(R.drawable.popup_window);

        TextView message = (TextView) findViewById(R.id.popup_text);
        if (state == EndGameState.X_WINS) {
            message.setText(R.string.popup_message_winner);
        }
        else if (state == EndGameState.O_WINS) {
            message.setText(R.string.popup_message_loser);
        }
        else if (state == EndGameState.TIE) {
            message.setText(R.string.popup_message_tie);
        }

        ImageButton topButton = (ImageButton) findViewById(R.id.popup_button_top);
        topButton.setImageResource(R.drawable.selection_button);
        ImageButton bottomButton = (ImageButton) findViewById(R.id.popup_button_bottom);
        bottomButton.setImageResource(R.drawable.selection_button);

        TextView topButtonText = (TextView) findViewById(R.id.popup_top_button_text);
        topButtonText.setText(R.string.play_again);
        TextView bottomButtonText = (TextView) findViewById(R.id.popup_bottom_button_text);
        bottomButtonText.setText(R.string.main_menu);
    }

    private void hidePopup() {
        ImageView popupWindow = (ImageView) findViewById(R.id.popup);
        popupWindow.setImageResource(android.R.color.transparent);

        TextView message = (TextView) findViewById(R.id.popup_text);
        message.setText("");

        ImageButton topButton = (ImageButton) findViewById(R.id.popup_button_top);
        topButton.setImageResource(android.R.color.transparent);
        ImageButton bottomButton = (ImageButton) findViewById(R.id.popup_button_bottom);
        bottomButton.setImageResource(android.R.color.transparent);

        TextView topButtonText = (TextView) findViewById(R.id.popup_top_button_text);
        topButtonText.setText("");
        TextView bottomButtonText = (TextView) findViewById(R.id.popup_bottom_button_text);
        bottomButtonText.setText("");
    }

    private int[] generateUnselectableBoardArray() {
        int[] array = new int[unselectableBoardMap.size()];

        for (int i = 1; i <=9; i++) {
            array[i] = unselectableBoardMap.get(i);
        }

        return array;
    }

    private int[] generateCellPieceArray() {
        int[] array = new int[cellPieceMap.size()];
        int index = 0;

        for (int boardNum = 1; boardNum <= 9; boardNum++) {
            for (int cellNum = 1; cellNum <= 9; cellNum++) {
                array[index++] = cellPieceMap.get(generateCellPieceId(boardNum, cellNum)).getPieceValue();
            }
        }

        return array;
    }

    private Map<Integer, Integer> unselectableBoardArrayToMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int key = 1;

        for (int value : array) {
            map.put(key++, value);
        }

        return map;
    }

    private Map<Integer, CellPiece> cellPieceArrayToMap(int[] array) {
        Map<Integer, CellPiece> map = new HashMap<>(array.length);
        int index = 0;

        for (int boardNum = 1; boardNum <= 9; boardNum++) {
            for (int cellNum = 1; cellNum <= 9; cellNum++) {
                CellPiece cellPiece = new CellPiece(boardNum, cellNum);
                cellPiece.setPieceValue(array[index]);
                map.put(generateCellPieceId(boardNum, cellNum), cellPiece);
            }
        }

        return map;
    }
}
