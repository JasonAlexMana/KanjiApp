package com.example.kanjibutton;

import android.app.Application;

public class DataHolder extends Application {

    private int langSelection;

    public void setLangSelection (int i) {
        langSelection = i;
    }

    public int getLangSelection () {
        return langSelection;
    }
}
