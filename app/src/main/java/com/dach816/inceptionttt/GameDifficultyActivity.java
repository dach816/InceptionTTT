package com.dach816.inceptionttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameDifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_difficulty);
    }

    public void selectEasyDifficulty(View view) {
        Intent intent = new Intent(this, InceptionGameActivity.class);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_TYPE, true);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_DIFFICULTY, GameDifficulty.EASY.getValue());
        startActivity(intent);
    }
    public void selectMediumDifficulty(View view) {
        Intent intent = new Intent(this, InceptionGameActivity.class);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_TYPE, true);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_DIFFICULTY, GameDifficulty.MEDIUM.getValue());
        startActivity(intent);
    }
    public void selectHardDifficulty(View view) {
        Intent intent = new Intent(this, InceptionGameActivity.class);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_TYPE, true);
        intent.putExtra(InceptionGameActivity.EXTRA_GAME_DIFFICULTY, GameDifficulty.HARD.getValue());
        startActivity(intent);
    }
}
