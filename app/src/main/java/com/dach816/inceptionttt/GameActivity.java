package com.dach816.inceptionttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private int cell1Piece;
    private int cell2Piece;
    private int cell3Piece;
    private int cell4Piece;
    private int cell5Piece;
    private int cell6Piece;
    private int cell7Piece;
    private int cell8Piece;
    private int cell9Piece;

    //X always goes first
    boolean currentPlayerX = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void placePieceCell1(View view) {
        final ImageButton cell1 = (ImageButton) findViewById(R.id.cell1);

        //Place X or O if cell is empty
        if (cell1Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell1.setImageResource(R.drawable.tictactoex);
                cell1Piece = Piece.X.getValue();
            } else {
                cell1.setImageResource(R.drawable.tictactoeo);
                cell1Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell1Piece == cell2Piece && cell1Piece == cell3Piece) ||
                    (cell1Piece == cell4Piece && cell1Piece == cell7Piece) ||
                    (cell1Piece == cell5Piece && cell1Piece == cell9Piece)) {
                if (cell1Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell2(View view) {
        final ImageButton cell2 = (ImageButton) findViewById(R.id.cell2);

        if (cell2Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell2.setImageResource(R.drawable.tictactoex);
                cell2Piece = Piece.X.getValue();
            }
            else {
                cell2.setImageResource(R.drawable.tictactoeo);
                cell2Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell2Piece == cell1Piece && cell2Piece == cell3Piece) ||
                    (cell2Piece == cell5Piece && cell2Piece == cell8Piece)) {
                if (cell2Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell3(View view) {
        final ImageButton cell3 = (ImageButton) findViewById(R.id.cell3);

        if (cell3Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell3.setImageResource(R.drawable.tictactoex);
                cell3Piece = Piece.X.getValue();
            }
            else {
                cell3.setImageResource(R.drawable.tictactoeo);
                cell3Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell3Piece == cell1Piece && cell3Piece == cell2Piece) ||
                    (cell3Piece == cell6Piece && cell3Piece == cell9Piece) ||
                    (cell3Piece == cell5Piece && cell3Piece == cell7Piece)) {
                if (cell3Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell4(View view) {
        final ImageButton cell4 = (ImageButton) findViewById(R.id.cell4);

        if (cell4Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell4.setImageResource(R.drawable.tictactoex);
                cell4Piece = Piece.X.getValue();
            }
            else {
                cell4.setImageResource(R.drawable.tictactoeo);
                cell4Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell4Piece == cell1Piece && cell4Piece == cell7Piece) ||
                    (cell4Piece == cell5Piece && cell4Piece == cell6Piece)) {
                if (cell4Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell5(View view) {
        final ImageButton cell5 = (ImageButton) findViewById(R.id.cell5);

        if (cell5Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell5.setImageResource(R.drawable.tictactoex);
                cell5Piece = Piece.X.getValue();
            }
            else {
                cell5.setImageResource(R.drawable.tictactoeo);
                cell5Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell5Piece == cell2Piece && cell5Piece == cell8Piece) ||
                    (cell5Piece == cell4Piece && cell5Piece == cell6Piece) ||
                    (cell5Piece == cell1Piece && cell5Piece == cell9Piece) ||
                    (cell5Piece == cell3Piece && cell5Piece == cell7Piece)) {
                if (cell5Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell6(View view) {
        final ImageButton cell6 = (ImageButton) findViewById(R.id.cell6);

        if (cell6Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell6.setImageResource(R.drawable.tictactoex);
                cell6Piece = Piece.X.getValue();
            }
            else {
                cell6.setImageResource(R.drawable.tictactoeo);
                cell6Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell6Piece == cell3Piece && cell6Piece == cell9Piece) ||
                    (cell6Piece == cell4Piece && cell6Piece == cell5Piece)) {
                if (cell6Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell7(View view) {
        final ImageButton cell7 = (ImageButton) findViewById(R.id.cell7);

        if (cell7Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell7.setImageResource(R.drawable.tictactoex);
                cell7Piece = Piece.X.getValue();
            }
            else {
                cell7.setImageResource(R.drawable.tictactoeo);
                cell7Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell7Piece == cell1Piece && cell7Piece == cell4Piece) ||
                    (cell7Piece == cell8Piece && cell7Piece == cell9Piece) ||
                    (cell7Piece == cell5Piece && cell7Piece == cell3Piece)) {
                if (cell7Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell8(View view) {
        final ImageButton cell8 = (ImageButton) findViewById(R.id.cell8);

        if (cell8Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell8.setImageResource(R.drawable.tictactoex);
                cell8Piece = Piece.X.getValue();
            }
            else {
                cell8.setImageResource(R.drawable.tictactoeo);
                cell8Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell8Piece == cell2Piece && cell8Piece == cell5Piece) ||
                    (cell8Piece == cell7Piece && cell8Piece == cell9Piece)) {
                if (cell8Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void placePieceCell9(View view) {
        final ImageButton cell9 = (ImageButton) findViewById(R.id.cell9);

        if (cell9Piece == Piece.NONE.getValue()) {
            if (currentPlayerX) {
                cell9.setImageResource(R.drawable.tictactoex);
                cell9Piece = Piece.X.getValue();
            }
            else {
                cell9.setImageResource(R.drawable.tictactoeo);
                cell9Piece = Piece.O.getValue();
            }

            currentPlayerX = !currentPlayerX;

            //Check for winner
            TextView textView = (TextView) findViewById(R.id.text_view);
            if ((cell9Piece == cell7Piece && cell9Piece == cell8Piece) ||
                    (cell9Piece == cell3Piece && cell9Piece == cell6Piece) ||
                    (cell9Piece == cell5Piece && cell9Piece == cell1Piece)) {
                if (cell9Piece == Piece.X.getValue()) {
                    textView.setText(R.string.player_x_wins);
                } else {
                    textView.setText(R.string.player_o_wins);
                }

                endGame();
            }
        }
    }

    public void restart(View view) {
        cell1Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell1)).setImageResource(android.R.color.transparent);
        cell2Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell2)).setImageResource(android.R.color.transparent);
        cell3Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell3)).setImageResource(android.R.color.transparent);
        cell4Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell4)).setImageResource(android.R.color.transparent);
        cell5Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell5)).setImageResource(android.R.color.transparent);
        cell6Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell6)).setImageResource(android.R.color.transparent);
        cell7Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell7)).setImageResource(android.R.color.transparent);
        cell8Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell8)).setImageResource(android.R.color.transparent);
        cell9Piece = Piece.NONE.getValue();
        ((ImageButton) findViewById(R.id.cell9)).setImageResource(android.R.color.transparent);

        ((TextView) findViewById(R.id.text_view)).setText("");
        currentPlayerX = true;
    }

    private void endGame() {
        cell1Piece = -1;
        cell2Piece = -1;
        cell3Piece = -1;
        cell4Piece = -1;
        cell5Piece = -1;
        cell6Piece = -1;
        cell7Piece = -1;
        cell8Piece = -1;
        cell9Piece = -1;
    }
}
