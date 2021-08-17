package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class KanjiList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji_list);
        View blurScreen = findViewById(R.id.blur);
        ImageView btnBack = findViewById(R.id.btnBack);
        View settingBar = findViewById(R.id.popupSetting);
        blurScreen.setVisibility(View.GONE);
        settingBar.setVisibility(View.GONE);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(KanjiList.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
        ImageView btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settingBar.setVisibility(View.VISIBLE);
                blurScreen.setVisibility(View.VISIBLE);
            }
        });
        blurScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingBar.setVisibility(View.GONE);
                blurScreen.setVisibility(View.GONE);
            }
        });
    }
}