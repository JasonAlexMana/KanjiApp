package com.example.kanjibutton;

import android.app.Application;

public class DataHolder extends Application {

    private static boolean isVolumeOpen = false;

    public static void setIsVolumeOpen (boolean i) {
        isVolumeOpen = i;
    }

    public static boolean getIsVolumeOpen () {
        return isVolumeOpen;
    }
}
