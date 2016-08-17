package com.dach816.inceptionttt;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity {
    private GameDifficulty difficulty;

    public static final String DIFFICULTY_EXTRA = "Difficulty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        difficulty = GameDifficulty.getDifficulty(getIntent().getIntExtra(DIFFICULTY_EXTRA, 0));
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = SP.edit();
        editor.putString("difficulty", difficulty.getString());
        editor.commit();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

    public static class SettingsFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
