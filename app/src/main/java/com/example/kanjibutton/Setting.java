package com.example.kanjibutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ImageView btnBack = findViewById(R.id.btnBack);
        TextView smpl = findViewById(R.id.test);
        smpl.setVisibility(View.GONE);
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
                    smpl.setVisibility(View.VISIBLE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.test, ConstraintSet.BOTTOM, 5);
                }
                else {
                    smpl.setVisibility(View.GONE);
                    constraintSet.clone(constraintLayout);
                    constraintSet.connect(R.id.profileGroup, ConstraintSet.TOP, R.id.volumeGroup, ConstraintSet.BOTTOM, 5);
                }
                constraintSet.applyTo(constraintLayout);
                DataHolder.setIsVolumeOpen(!DataHolder.getIsVolumeOpen());
            }
        });
    }
}