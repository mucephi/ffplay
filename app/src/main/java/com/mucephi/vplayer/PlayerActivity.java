package com.mucephi.vplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import org.libsdl.app.SDLActivity;

public class PlayerActivity extends SDLActivity {

    SharedPreferences settings;
    SharedPreferences.Editor settingsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = PreferenceManager.getDefaultSharedPreferences(this);
        settingsEditor = settings.edit();

        Intent intent = getIntent();

        if (intent != null) {
            String appLinkAction = intent.getAction();
            Uri appLinkData = intent.getData();

            if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
                String cliArguments = appLinkData.getQueryParameter("cliArguments");
                settingsEditor.putString("cliArguments", cliArguments);
                settingsEditor.apply();
                showToast(cliArguments, Toast.LENGTH_LONG, Gravity.CENTER, 0, 0);
            }
        }
    }

    @Override
    protected String[] getArguments() {

        String cliArguments = settings.getString("cliArguments", "");

        if(cliArguments.equals("")) {
            openURL("http://www.mucephi.com/configurator");
        }

        return cliArguments.split(" ");
    }

    protected void showMessage(String message){


        final int[] buttonFlags = {1,2};
        final int[] buttonIds = {0,1};
        final String[] buttonTexts = {"Ok", "Cancel"};

        final Bundle args = new Bundle();

        args.putString("title", "FFPlayer");
        args.putString("message", message);
        args.putIntArray("buttonFlags", buttonFlags);
        args.putIntArray("buttonIds", buttonIds);
        args.putStringArray("buttonTexts", buttonTexts);

        messageboxCreateAndShow(args);

    }
}