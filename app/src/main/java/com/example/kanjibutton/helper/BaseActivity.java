package com.example.kanjibutton.helper;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.SwitchCompat;

import com.example.kanjibutton.MainActivity;
import com.example.kanjibutton.MenuPage;
import com.example.kanjibutton.R;
import com.example.kanjibutton.Step2;
import com.example.kanjibutton.Step3;
import com.example.kanjibutton.Step4;
import com.example.kanjibutton.Step5;
import com.example.kanjibutton.Step6;
import com.example.kanjibutton.Step7;
import com.example.kanjibutton.Step8;
import com.example.kanjibutton.Step9;

public class BaseActivity extends AppCompatActivity {

    public SessionManager session;
    private Dialog customDialog;
    private Dialog settingDialog;
    private ImageView imgRomanized, imgJapanese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new SessionManager(this);
    }

    public void showLevelComplete(Integer kanji) {
        customDialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(R.layout.activity_dialog);
        customDialog.setCancelable(false);

        customDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_black);

        TextView txtLevelComplete = customDialog.findViewById(R.id.txtLevelComplete);
        TextView txtNumberKanji = customDialog.findViewById(R.id.txtNumberKanji);

        txtLevelComplete.setText(getResources().getString(R.string.level_complete, session.currentLevel() - 1));
        txtNumberKanji.setText(getResources().getString(R.string.you_have_learnt_new_kanji, kanji));


        ImageView btnHome = customDialog.findViewById(R.id.btn_home);
        btnHome.setOnClickListener(v -> {
            customDialog.dismiss();
            startActivity(new Intent(this, MenuPage.class));
            finish();
        });

        ImageView btnReplay = customDialog.findViewById(R.id.btn_replay);
        btnReplay.setOnClickListener(v -> {
            openQuiz(session.currentLevel() - 1);
            customDialog.dismiss();
        });

        ImageView btnContinue = customDialog.findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(v -> {
            customDialog.dismiss();
            openQuiz(session.currentLevel());
        });

        customDialog.show();
    }

    private void openQuiz(Integer level) {
        Intent quizIntent = new Intent();
        switch (level) {
            case 1:
                quizIntent = new Intent(this, MainActivity.class);
                break;
            case 2:
                quizIntent = new Intent(this, Step2.class);
                break;
            case 3:
                quizIntent = new Intent(this, Step3.class);
                break;
            case 4:
                quizIntent = new Intent(this, Step4.class);
                break;
            case 5:
                quizIntent = new Intent(this, Step5.class);
                break;
            case 6:
                quizIntent = new Intent(this, Step6.class);
                break;
            case 7:
                quizIntent = new Intent(this, Step7.class);
                break;
            case 8:
                quizIntent = new Intent(this, Step8.class);
                break;
            case 9:
                quizIntent = new Intent(this, Step9.class);
                break;
            default:
                quizIntent = new Intent(this, MenuPage.class);
                break;
        }
        startActivity(quizIntent);
        finish();
    }

    public void showSettingDialog() {
        showSettingsDialog();
    }

    private void showSettingsDialog() {
        settingDialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        settingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        settingDialog.setContentView(R.layout.setting_bottom_sheet);
        settingDialog.setCancelable(false);

        settingDialog.getWindow().setBackgroundDrawableResource(R.color.translucent_black);

        imgRomanized = settingDialog.findViewById(R.id.img_romanized);
        imgJapanese = settingDialog.findViewById(R.id.img_japanese);

        /**
         * switch on/off subtitle
         **/
        SwitchCompat switchCompat = settingDialog.findViewById(R.id.switchSubtitle);
        switchCompat.setChecked(session.subtitleOn());
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {

            session.subtitleOn(buttonView.isChecked());

            if (buttonView.isChecked())
                setSubtitleImage();
            else {
                imgRomanized.setImageResource(R.drawable.sub_romanized_gray);
                imgJapanese.setImageResource(R.drawable.sub_japanese_gray);
            }

//            Toast.makeText(BaseActivity.this, "switch is " + buttonView.isChecked(), Toast.LENGTH_LONG).show();
        });

        AppCompatSeekBar musicSeeker = settingDialog.findViewById(R.id.musicSeeker);
        TextView musicPercentage = settingDialog.findViewById(R.id.musicPercentage);

        /**
         * seeker music background
         **/
        musicSeeker.setProgress(session.voluemMusic());
        musicPercentage.setText(session.voluemMusic() + "%");
        musicSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                musicPercentage.setText(progressChangedValue + "%");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(BaseActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
                session.volumeMusic(progressChangedValue);
            }
        });

        /**
         * seeker sound effect
         **/
        AppCompatSeekBar effectSeeker = settingDialog.findViewById(R.id.effekSeeker);
        TextView effectPercentage = settingDialog.findViewById(R.id.effectPercentage);

        effectSeeker.setProgress(session.volumeEffect());
        effectPercentage.setText(session.volumeEffect() + "%");
        effectSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                effectPercentage.setText(progressChangedValue + "%");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(BaseActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
                session.volumeEffect(progressChangedValue);
            }
        });

        settingDialog.findViewById(R.id.btn_yes).setOnClickListener(v -> {
            settingDialog.dismiss();
            this.onResume();
        });


        imgJapanese.setOnClickListener(v -> {
            if (session.subtitleOn()) {
                session.subtitle(SessionManager.JAPANESE);
                setSubtitleImage();
//                Toast.makeText(BaseActivity.this, "subtitle : " + session.subtitleOn() +" "+ session.subtitle(), Toast.LENGTH_SHORT).show();
            }
        });

        imgRomanized.setOnClickListener(v -> {
            if (session.subtitleOn()) {
                session.subtitle(SessionManager.ROMANIZED);
                setSubtitleImage();
//                Toast.makeText(BaseActivity.this, "subtitle : " + session.subtitleOn() +" "+ session.subtitle(), Toast.LENGTH_SHORT).show();
            }
        });

        if (session.subtitleOn()) setSubtitleImage();

        settingDialog.show();

    }

    private void setSubtitleImage() {
        if (session.subtitle().equalsIgnoreCase(SessionManager.JAPANESE)) {
            imgJapanese.setImageResource(R.drawable.sub_japanese_merah);
        } else {
            imgJapanese.setImageResource(R.drawable.sub_japanese_gray);
        }

        if (session.subtitle().equalsIgnoreCase(SessionManager.ROMANIZED)) {
            imgRomanized.setImageResource(R.drawable.sub_romanized_merah);
        } else {
            imgRomanized.setImageResource(R.drawable.sub_romanized_gray);
        }
    }

    public void playSound(Integer sound) {
        final MediaPlayer mp = MediaPlayer.create(this, sound);
        float volume = (float) session.volumeEffect() / 100;
//        Toast.makeText(this, "MP volume : "+volume, Toast.LENGTH_SHORT).show();
        mp.setVolume(volume, volume);
        mp.start();
    }
}
