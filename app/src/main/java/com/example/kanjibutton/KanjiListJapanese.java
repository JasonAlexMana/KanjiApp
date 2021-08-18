package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KanjiListJapanese extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji_list_japanese);
        View blurScreen = findViewById(R.id.blur);
        ImageView btnBack = findViewById(R.id.btnBack);
        View settingBar = findViewById(R.id.popupSetting);
        TextView Settings = findViewById(R.id.Settings);
        TextView btnDefault = findViewById(R.id.btnDefault);
        TextView btnRomanized = findViewById(R.id.btnRomanized);
        ImageView btnHome = findViewById(R.id.btnHome);
        blurScreen.setVisibility(View.GONE);
        settingBar.setVisibility(View.GONE);
        Settings.setVisibility(View.GONE);
        btnDefault.setVisibility(View.GONE);
        btnRomanized.setVisibility(View.GONE);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(KanjiListJapanese.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
        ImageView btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingBar.setVisibility(View.VISIBLE);
                blurScreen.setVisibility(View.VISIBLE);
                btnDefault.setVisibility(View.VISIBLE);
                Settings.setVisibility(View.VISIBLE);
                btnRomanized.setVisibility(View.VISIBLE);
            }
        });
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(KanjiListJapanese.this, KanjiList.class);
                startActivity(newIntent);
            }
        });
        btnRomanized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(KanjiListJapanese.this, KanjiListRomanized.class);
                startActivity(newIntent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(KanjiListJapanese.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
        blurScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingBar.setVisibility(View.GONE);
                blurScreen.setVisibility(View.GONE);
                btnDefault.setVisibility(View.GONE);
                Settings.setVisibility(View.GONE);
                btnRomanized.setVisibility(View.GONE);
            }
        });
    }
}