package com.hfad.inceptionttt;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class InceptionGameActivity extends AppCompatActivity {
    private int selectedBoardNumber;
    private Map<Integer, Integer> boardIdMap = createBoardIdMap();

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

    private void selectBoard(int boardNumber, int boardImageId) {
        ImageView board = (ImageView) findViewById(boardImageId);
        ImageView interactiveBoard = (ImageView) findViewById(R.id.interactiveBoard);

        //Unselect the previously selected board
        if (selectedBoardNumber > 0 && selectedBoardNumber != boardNumber) {
            ImageView prevSelectedBoard = (ImageView) findViewById(boardIdMap.get(selectedBoardNumber));
            prevSelectedBoard.setImageResource(R.drawable.tictactoeboard);
        }
        //Create the interactive board at the bottom if not previously there
        else if (selectedBoardNumber == 0) {
            interactiveBoard.setImageResource(R.drawable.tictactoeboardgoldoutlined);
        }

        //Select the new board
        selectedBoardNumber = boardNumber;
        board.setImageResource(R.drawable.tictactoeboardgold);
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
}
