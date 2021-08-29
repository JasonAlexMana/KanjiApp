package com.example.kanjibutton.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static String TAG = "rikoru_preff";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static final String JAPANESE = "japanese";
    public static final String ROMANIZED = "romanized";

    public SessionManager(Context context) {
        if (sharedPreferences == null || editor == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public Integer currentLevel() {
        return sharedPreferences.getInt("current_level", 1);
    }

    public void currentLevel(Integer integer) {
        editor.putInt("current_level", integer).apply();
    }

    public String subtitle(){
        return  sharedPreferences.getString("subtitle", JAPANESE);
    }

    public void subtitle(String subs){
        editor.putString("subtitle", subs).apply();
    }

    public Boolean subtitleOn(){
       return sharedPreferences.getBoolean("subtitle_on", false);
    }

    public void subtitleOn(Boolean bol){
        editor.putBoolean("subtitle_on", bol).apply();
    }


    public void volumeMusic(Integer value){
        editor.putInt("volume_music", value).apply();
    }

    public void volumeEffect(Integer value){
        editor.putInt("volume_effect", value).apply();
    }

    public Integer voluemMusic(){
        return  sharedPreferences.getInt("volume_music",50);
    }

    public Integer volumeEffect(){
        return  sharedPreferences.getInt("volume_effect", 50);
    }

}