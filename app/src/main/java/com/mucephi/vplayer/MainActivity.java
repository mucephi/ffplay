package com.mucephi.vplayer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity {

    SharedPreferences settings;
    SharedPreferences.Editor settingsEditor;
    EditText txtCommandArgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCommandArgs = findViewById(R.id.text_command_args);

        settings = PreferenceManager.getDefaultSharedPreferences(this);
        String cliArguments = settings.getString("cliArguments", "");

        if(!cliArguments.equals("")) {
            txtCommandArgs.setText(cliArguments);
        }

        findViewById(R.id.button_play).setOnClickListener(view -> {

            String newCliArguments = txtCommandArgs.getText().toString();
            settingsEditor = settings.edit();
            settingsEditor.putString("cliArguments", newCliArguments);
            settingsEditor.apply();
            startVideoPlayer();
        });
    }

    public void startVideoPlayer(){
        Intent videoPlayer = new Intent(MainActivity.this, PlayerActivity.class);
        startActivity(videoPlayer);
    }
}