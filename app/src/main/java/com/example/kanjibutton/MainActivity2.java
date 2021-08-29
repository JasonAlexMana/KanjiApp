package com.example.kanjibutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.kanjibutton.helper.BaseActivity;
import com.example.kanjibutton.helper.SessionManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class MainActivity2 extends BaseActivity implements View.OnLongClickListener, View.OnDragListener {

    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    CardView imgvw1, imgvw2, imgvw3, imgvw4;
    LinearProgressIndicator progressIndicator;
    Integer numCorrent = 0;
    Integer numQuestion = 4;
    TextView progressPercentage;

    TextView txtTag1, txtTag2, txtTag3, txtTag4;

    @Override
    public void onBackPressed() {
        ExitDialog cdd = new ExitDialog(MainActivity2.this);
        cdd.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        bottom_sheet = findViewById(R.id.bottom_sheet);
//        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);

        mBottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout);

        ImageView back = (ImageView) findViewById(R.id.back);
        progressIndicator = findViewById(R.id.progress);
        progressPercentage = findViewById(R.id.progressPercentage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitDialog cdd = new ExitDialog(MainActivity2.this);
                cdd.show();
            }
        });

        ImageView settings = (ImageView) findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showBottomSheetSettingsDialog();
//                sheetDialog.show();
                showSettingDialog();
            }
        });

        imgvw1 = findViewById(R.id.imgvw1);
        imgvw1.setTag("tag1");
        imgvw1.setOnLongClickListener(this);
        imgvw2 = findViewById(R.id.imgvw2);
        imgvw2.setTag("tag3");
        imgvw2.setOnLongClickListener(this);
        imgvw3 = findViewById(R.id.imgvw3);
        imgvw3.setTag("tag2");
        imgvw3.setOnLongClickListener(this);
        imgvw4 = findViewById(R.id.imgvw4);
        imgvw4.setTag("tag4");
        imgvw4.setOnLongClickListener(this);


        LinearLayout ll1 = findViewById(R.id.layout1);
        ll1.setTag("tag1");
        ll1.setOnDragListener(this);
        LinearLayout ll2 = findViewById(R.id.layout2);
        ll2.setTag("tag3");
        ll2.setOnDragListener(this);
        LinearLayout ll3 = findViewById(R.id.layout3);
        ll3.setTag("tag2");
        ll3.setOnDragListener(this);
        LinearLayout ll4 = findViewById(R.id.layout4);
        ll4.setTag("tag4");
        ll4.setOnDragListener(this);

        txtTag1 = findViewById(R.id.txttag1);
        txtTag2 = findViewById(R.id.txttag2);
        txtTag3 = findViewById(R.id.txttag3);
        txtTag4 = findViewById(R.id.txttag4);

        showBottomSheetDialog();
    }

    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);
        v.startDrag(data
                , dragshadow
                , v
                , 0
        );
        return true;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    return true;
                }
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                v.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                v.getBackground().clearColorFilter();
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:
                ClipData.Item item = event.getClipData().getItemAt(0);
                v.getBackground().clearColorFilter();
                v.invalidate();

                LinearLayout container = (LinearLayout) v;
                View vw = (View) event.getLocalState();
                if (vw.getTag() == container.getTag()) {

                    //todo play corrent sound
                    playSound(R.raw.correct_answer);

                    if (vw.getTag().toString() == "tag1"){
                        txtTag1.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "tag2"){
                        txtTag3.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "tag3"){
                        txtTag2.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "tag4"){
                        txtTag4.setVisibility(View.INVISIBLE);
                    }

                    numCorrent = numCorrent + 1;
                    Integer progress = (100 * numCorrent) / numQuestion;
                    progressIndicator.setProgress(progress);
                    progressPercentage.setText(progress + " %");
//                    Toast.makeText(this, "progress "+progress, Toast.LENGTH_LONG).show();

                    ViewGroup owner = (ViewGroup) vw.getParent();
                    owner.removeView(vw);
                    container.removeViewAt(0);
                    container.addView(vw, 0);
                    vw.setVisibility(View.VISIBLE);
                    vw.setOnLongClickListener(null);
                    vw.setTag("done");
                    if (imgvw1.getTag() == "done" && imgvw2.getTag() == "done" && imgvw3.getTag() == "done" && imgvw4.getTag() == "done") {
                        Parameter.level1 = true;
                        Parameter.current = 2;
                        session.currentLevel(2);
                        showLevelComplete(4);
//                        showBottomSheetDialog();
//                        sheetDialog.show();
                    }
                } else {
//                    Toast.makeText(this, "Upss! Wrong place", Toast.LENGTH_SHORT).show();
                    //todo play corrent sound
                    playSound(R.raw.wrong_answer);
                }
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                v.getBackground().clearColorFilter();
                v.invalidate();
                return true;
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    private void showBottomSheetDialog() {
        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

//                header_Arrow_Image.setRotation(slideOffset * 180);
            }
        });
    }

//    private void showBottomSheetSettingsDialog() {
//        View view = getLayoutInflater().inflate(R.layout.setting_bottom_sheet, null);
//
//        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//        }
//
//        (view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sheetDialog.dismiss();
//            }
//        });
//
//        sheetDialog = new BottomSheetDialog(this);
//        sheetDialog.setCancelable(false);
//        sheetDialog.setContentView(view);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            sheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//
//        sheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                sheetDialog = null;
//            }
//        });
//    }

    @Override
    protected void onResume() {
        super.onResume();

        // cek for subtitle
        if (!session.subtitleOn()) {
            findViewById(R.id.japan1).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.roman1).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.JAPANESE)) {
            findViewById(R.id.japan1).setVisibility(View.VISIBLE);
            findViewById(R.id.japan2).setVisibility(View.VISIBLE);
            findViewById(R.id.japan3).setVisibility(View.VISIBLE);
            findViewById(R.id.japan4).setVisibility(View.VISIBLE);
            findViewById(R.id.roman1).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.ROMANIZED)) {
            findViewById(R.id.japan1).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.roman1).setVisibility(View.VISIBLE);
            findViewById(R.id.roman2).setVisibility(View.VISIBLE);
            findViewById(R.id.roman3).setVisibility(View.VISIBLE);
            findViewById(R.id.roman4).setVisibility(View.VISIBLE);
        }
    }

}