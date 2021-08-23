package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//version 1.0

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView btnKanji = findViewById(R.id.btnKanji);
        loadProfile();
        DataHolder.setBGMMediaPlayer(MainActivity.this,R.raw.bgm);
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
    private void loadProfile() {
        TextView nameText = findViewById(R.id.name);
        TextView noteToSelfText = findViewById(R.id.noteToSelfText);
        ImageView profilePict = findViewById(R.id.profile);
        nameText.setText(DataHolder.getName());
        noteToSelfText.setText(DataHolder.getNoteToSelf());
    }
}