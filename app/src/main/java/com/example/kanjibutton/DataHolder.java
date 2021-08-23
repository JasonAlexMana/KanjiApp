package com.example.kanjibutton;

import android.app.Application;
import android.content.Context;
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

//    public static File getProfilePict() {
//        return profilePict;
//    }
//
//    public static void setProfilePict(File profilePict) {
//        DataHolder.profilePict = profilePict;
//    }
}
