package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
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
        bgmText.setVisibility(View.GONE);
        sfxText.setVisibility(View.GONE);
        seekBarBGM.setVisibility(View.GONE);
        seekBarSFX.setVisibility(View.GONE);
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
        });
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
    }
    private void refreshMusicVolume(){
        SeekBar seekBarBGM = findViewById(R.id.seekBarBGM);
        DataHolder.setBGMVolume(seekBarBGM.getProgress(),seekBarBGM.getProgress());
    }

}