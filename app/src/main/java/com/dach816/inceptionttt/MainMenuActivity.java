package com.dach816.inceptionttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {
    private boolean previouslySavedSinglePlayerGame = false;
    private boolean previouslySavedMultiplayerGame = false;

    public static final String EXTRA_GAME_OVER = "Game Over";
    public static final String EXTRA_IS_SINGLE_PLAYER = "Is Single Player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Intent intent = getIntent();

        if (!intent.getBooleanExtra(EXTRA_GAME_OVER, false)) {
            if (intent.getBooleanExtra(EXTRA_IS_SINGLE_PLAYER, false)) {
                previouslySavedSinglePlayerGame = true;
            }
            else {
                previouslySavedMultiplayerGame = true;
            }
        }
    }

    public void selectSinglePlayer(View view) {
        previouslySavedSinglePlayerGame = false;
        previouslySavedMultiplayerGame = false;

        Intent intent = new Intent(this, InceptionGameActivity.class);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_TYPE, true);
        startActivity(intent);
    }

    public void selectMultiplayer(View view) {
        previouslySavedSinglePlayerGame = false;
        previouslySavedMultiplayerGame = false;

        Intent intent = new Intent(this, InceptionGameActivity.class);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_TYPE, false);
        startActivity(intent);
    }
}
