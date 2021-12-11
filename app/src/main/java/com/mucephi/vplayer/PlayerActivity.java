package com.mucephi.vplayer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import org.libsdl.app.SDLActivity;

import java.util.ArrayList;

public class PlayerActivity extends SDLActivity
{
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected String[] getArguments() {

        String[] arguments = settings.getString("cliArguments", "").replaceAll("[\n\r]", " ").split(" ");
        ArrayList<String> listArguments = new ArrayList<String>();

        for (String arg : arguments) {
            if(!arg.trim().isEmpty()){
                listArguments.add(arg.trim());
            }
        }

        return  (String[])listArguments.toArray(new String[listArguments.size()]);
    }
}
