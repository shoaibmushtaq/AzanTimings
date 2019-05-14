package com.example.muhammadshoaib.azantimings;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfig {

    //Declaring sharedpreferences , context and key varriables
    private SharedPreferences sharedPreferences;
    private Context context;
    public static String PREFERENCE_KEY = "pref_key";
    public static String WRITE_PREFERENCE_KEY = "write_pref_key";


    //this constructor will get context from calling class and initialize sharedpreferences
    public SharedPreferencesConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY,Context.MODE_PRIVATE);
    }

    //this method will write sharedpreferences
    public void writeFormat(int format){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(WRITE_PREFERENCE_KEY,format);
        editor.apply();
    }

    //this method will get data from shared preferences and return it
    public int readFormat(){

        int format;

        format = sharedPreferences.getInt(WRITE_PREFERENCE_KEY,24);

        return format;
    }
}
