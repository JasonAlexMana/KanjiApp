package com.example.kanjibutton;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;

import java.io.File;

public class DataHolder extends Application {

    private static boolean isVolumeOpen = false;
    private static boolean musicOn = false;
    private static MediaPlayer music;

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
}
