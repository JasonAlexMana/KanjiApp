package com.example.kanjibutton;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import java.io.File;

public class DataHolder extends Application {

    private static boolean isVolumeOpen = false;
    private static boolean isProfileOpen = false;
    private static boolean isCreditOpen = false;
    private static boolean musicOn = false;
    private static MediaPlayer music;
    private static String name = "Name";
    private static String noteToSelf = "";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    //private static File profilePict = ;

    public static void setBGMMediaPlayer(Context context, int id){
        if(musicOn == false){
            music = MediaPlayer.create(context,id);
            music.setLooping(true);
            music.start();
            musicOn = true;
        }
    }

    public static void setBGMVolume(int leftVolume, int rightVolume){
        music.setVolume(leftVolume*0.01f,rightVolume*0.01f);
    }

    public DataHolder(Context context) {
        if (sharedPreferences == null || editor == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public static void setIsVolumeOpen (boolean i) {
        isVolumeOpen = i;
    }

    public static boolean getIsVolumeOpen () {
        return isVolumeOpen;
    }

    public static void setIsProfileOpen (boolean i) {
        isProfileOpen = i;
    }

    public static boolean getIsProfileOpen () {
        return isProfileOpen;
    }

    public static void setIsCreditOpen (boolean i) {
        isCreditOpen = i;
    }

    public static boolean getIsCreditOpen () {
        return isCreditOpen;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        DataHolder.name = name;
    }

    public static String getNoteToSelf() {
        return noteToSelf;
    }

    public static void setNoteToSelf(String noteToSelf) {
        DataHolder.noteToSelf = noteToSelf;
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

//    public static File getProfilePict() {
//        return profilePict;
//    }
//
//    public static void setProfilePict(File profilePict) {
//        DataHolder.profilePict = profilePict;
//    }
}
