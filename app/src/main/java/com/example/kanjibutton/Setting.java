package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageView btnBack = findViewById(R.id.btnBack);
        TextView bgmText = findViewById(R.id.backgroundbgm);
        TextView sfxText = findViewById(R.id.backgroundsfx);
        SeekBar seekBarBGM = findViewById(R.id.seekBarBGM);
        SeekBar seekBarSFX = findViewById(R.id.seekBarSFX);
        ImageView profileSetting = findViewById(R.id.profileSetting);
        TextView changeAvatar = findViewById(R.id.changeAvatar);
        TextView username = findViewById(R.id.username);
        TextView noteToself = findViewById(R.id.noteToself);
        TextView thumbnail1 = findViewById(R.id.thumbnail1);
        TextView thumbnail2 = findViewById(R.id.thumbnail2);
        TextView thumbnail3 = findViewById(R.id.thumbnail3);
        TextView thumbnail4 = findViewById(R.id.thumbnail4);
        ImageView video1 = findViewById(R.id.video1);
        ImageView video2 = findViewById(R.id.video2);
        ImageView video3 = findViewById(R.id.video3);
        ImageView video4 = findViewById(R.id.video4);
        EditText usernameText = findViewById(R.id.editUsername);
        EditText noteText = findViewById(R.id.editNoteToSelf);
        loadProfileEdit();
        bindProfileSetting();
        profileSetting.setVisibility(View.GONE);
        changeAvatar.setVisibility(View.GONE);
        username.setVisibility(View.GONE);
        noteToself.setVisibility(View.GONE);
        thumbnail1.setVisibility(View.GONE);
        thumbnail2.setVisibility(View.GONE);
        thumbnail3.setVisibility(View.GONE);
        thumbnail4.setVisibility(View.GONE);
        video1.setVisibility(View.GONE);
        video2.setVisibility(View.GONE);
        video3.setVisibility(View.GONE);
        video4.setVisibility(View.GONE);
        bgmText.setVisibility(View.GONE);
        sfxText.setVisibility(View.GONE);
        seekBarBGM.setVisibility(View.GONE);
        seekBarSFX.setVisibility(View.GONE);
        usernameText.setVisibility(View.GONE);
        noteText.setVisibility(View.GONE);
        seekBarBGM.setMax(100);
        seekBarBGM.setProgress(50);

        seekBarBGM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                refreshMusicVolume();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Intent newIntent = new Intent(Setting.this, MainActivity.class);
               startActivity(newIntent);
                }
            }
        );
        View volumeGrp = findViewById(R.id.volumeGroup);
        View profileGrp = findViewById(R.id.profileGroup);
        View creditGrp = findViewById(R.id.creditsGroup);
        volumeGrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
                ConstraintSet constraintSet = new ConstraintSet();
                if(!DataHolder.getIsVolumeOpen()) {
                    seekBarBGM.setVisibility(View.VISIBLE);
                    seekBarSFX.setVisibility(View.VISIBLE);
                    bgmText.setVisibility(View.VISIBLE);
                    sfxText.setVisibility(View.VISIBLE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.seekBarSFX, ConstraintSet.BOTTOM, 5);
                }
                else {
                    seekBarBGM.setVisibility(View.GONE);
                    seekBarSFX.setVisibility(View.GONE);
                    bgmText.setVisibility(View.GONE);
                    sfxText.setVisibility(View.GONE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.volumeGroup, ConstraintSet.BOTTOM, 5);
                }
                constraintSet.applyTo(constraintLayout);
                DataHolder.setIsVolumeOpen(!DataHolder.getIsVolumeOpen());
            }
        });
        profileGrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
                ConstraintSet constraintSet = new ConstraintSet();
                if(!DataHolder.getIsProfileOpen()) {
                    profileSetting.setVisibility(View.VISIBLE);
                    changeAvatar.setVisibility(View.VISIBLE);
                    username.setVisibility(View.VISIBLE);
                    noteToself.setVisibility(View.VISIBLE);
                    noteText.setVisibility(View.VISIBLE);
                    usernameText.setVisibility(View.VISIBLE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.seekBarSFX, ConstraintSet.BOTTOM, 5);
                }
                else {
                    profileSetting.setVisibility(View.GONE);
                    changeAvatar.setVisibility(View.GONE);
                    username.setVisibility(View.GONE);
                    noteToself.setVisibility(View.GONE);
                    noteText.setVisibility(View.GONE);
                    usernameText.setVisibility(View.GONE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.profileGroup, ConstraintSet.BOTTOM, 5);
                }
                constraintSet.applyTo(constraintLayout);
                DataHolder.setIsProfileOpen(!DataHolder.getIsProfileOpen());
            }
        });
        creditGrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
                ConstraintSet constraintSet = new ConstraintSet();
                if(!DataHolder.getIsCreditOpen()) {
                    thumbnail1.setVisibility(View.VISIBLE);
                    thumbnail2.setVisibility(View.VISIBLE);
                    thumbnail3.setVisibility(View.VISIBLE);
                    thumbnail4.setVisibility(View.VISIBLE);
                    video1.setVisibility(View.VISIBLE);
                    video2.setVisibility(View.VISIBLE);
                    video3.setVisibility(View.VISIBLE);
                    video4.setVisibility(View.VISIBLE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.seekBarSFX, ConstraintSet.BOTTOM, 5);
                }
                else {
                    thumbnail1.setVisibility(View.GONE);
                    thumbnail2.setVisibility(View.GONE);
                    thumbnail3.setVisibility(View.GONE);
                    thumbnail4.setVisibility(View.GONE);
                    video1.setVisibility(View.GONE);
                    video2.setVisibility(View.GONE);
                    video3.setVisibility(View.GONE);
                    video4.setVisibility(View.GONE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.creditsGroup, ConstraintSet.BOTTOM, 5);
                }
                constraintSet.applyTo(constraintLayout);
                DataHolder.setIsCreditOpen(!DataHolder.getIsCreditOpen());
            }
        });
        video1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=JIZ0GgzJSwQ");
                Intent newIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(newIntent);
            }
        });
        video2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=tPBwg9IjBLk");
                Intent newIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(newIntent);
            }
        });
        video3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=-UtOrWmaZSg");
                Intent newIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(newIntent);
            }
        });
        video4.setOnClickListener(new View.OnClickListener(){
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=5EfBLzWP-6A");
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(newIntent);
            }
        });
    }
    private void refreshMusicVolume(){
        SeekBar seekBarBGM = findViewById(R.id.seekBarBGM);
        DataHolder.setBGMVolume(seekBarBGM.getProgress(),seekBarBGM.getProgress());
    }
    private void loadProfileEdit() {
        EditText usernameText = findViewById(R.id.editUsername);
        EditText noteText = findViewById(R.id.editNoteToSelf);
        usernameText.setText(DataHolder.getName());
        noteText.setText(DataHolder.getNoteToSelf());
    }
    private void bindProfileSetting() {
        EditText usernameText = findViewById(R.id.editUsername);
        EditText noteText = findViewById(R.id.editNoteToSelf);
        usernameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DataHolder.setName(s.toString());
            }
        });
        noteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                DataHolder.setNoteToSelf(s.toString());
            }
        });
    }
}