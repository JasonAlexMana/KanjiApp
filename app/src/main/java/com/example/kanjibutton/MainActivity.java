package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//version 1.0

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnKanji = findViewById(R.id.btnKanji);
        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.bgm);
        music.setLooping(true);
        music.start();
        btnKanji.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, KanjiList.class);
                startActivity(newIntent);
            }
        });

        ImageView btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, Setting.class);
                startActivity(newIntent);
            }
        });
    }
}