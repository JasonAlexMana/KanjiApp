package com.example.kanjibutton;

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

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.kanjibutton.helper.BaseActivity;
import com.example.kanjibutton.helper.SessionManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class Step9 extends BaseActivity implements View.OnLongClickListener, View.OnDragListener {
    //    BottomSheetBehavior sheetBehavior;
//    BottomSheetDialog sheetDialog;
//    View bottom_sheet;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    CardView imgCleaning, imgClothes, imgCome, imgDrama, imgInteresting, imgMeeting, imgPlay, imgRest;
    LinearProgressIndicator progressIndicator;
    Integer numCorrent = 0;
    Integer numQuestion = 8;
    TextView progressPercentage;
    TextView txtCleaning, txtClothes, txtCome, txtDrama, txtInteresting, txtMeeting, txtPlay, txtRest;

    @Override
    public void onBackPressed() {
        ExitDialog cdd = new ExitDialog(Step9.this);
        cdd.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step9);

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
                ExitDialog cdd = new ExitDialog(Step9.this);
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

        imgCleaning = (CardView) findViewById(R.id.imgCleaning);
        imgCleaning.setTag("cleaning");
        imgCleaning.setOnLongClickListener(this);
        imgClothes = (CardView) findViewById(R.id.imgClothes);
        imgClothes.setTag("clothes");
        imgClothes.setOnLongClickListener(this);
        imgCome = (CardView) findViewById(R.id.imgCome);
        imgCome.setTag("come");
        imgCome.setOnLongClickListener(this);
        imgDrama = (CardView) findViewById(R.id.imgDrama);
        imgDrama.setTag("drama");
        imgDrama.setOnLongClickListener(this);
        imgInteresting = (CardView) findViewById(R.id.imgInteresting);
        imgInteresting.setTag("interesting");
        imgInteresting.setOnLongClickListener(this);
        imgMeeting = (CardView) findViewById(R.id.imgMeeting);
        imgMeeting.setTag("meeting");
        imgMeeting.setOnLongClickListener(this);
        imgPlay = (CardView) findViewById(R.id.imgPlay);
        imgPlay.setTag("play");
        imgPlay.setOnLongClickListener(this);
        imgRest = (CardView) findViewById(R.id.imgRest);
        imgRest.setTag("rest");
        imgRest.setOnLongClickListener(this);

        LinearLayout layoutCleaning = findViewById(R.id.layoutCleaning);
        layoutCleaning.setTag("cleaning");
        layoutCleaning.setOnDragListener(this);

        LinearLayout layoutClothes = findViewById(R.id.layoutClothes);
        layoutClothes.setTag("clothes");
        layoutClothes.setOnDragListener(this);

        LinearLayout layoutCome = findViewById(R.id.layoutCome);
        layoutCome.setTag("come");
        layoutCome.setOnDragListener(this);

        LinearLayout layoutDrama = findViewById(R.id.layoutDrama);
        layoutDrama.setTag("drama");
        layoutDrama.setOnDragListener(this);

        LinearLayout layoutInteresting = findViewById(R.id.layoutInteresting);
        layoutInteresting.setTag("interesting");
        layoutInteresting.setOnDragListener(this);

        LinearLayout layoutMeeting = findViewById(R.id.layoutMeeting);
        layoutMeeting.setTag("meeting");
        layoutMeeting.setOnDragListener(this);

        LinearLayout layoutPlay = findViewById(R.id.layoutPlay);
        layoutPlay.setTag("play");
        layoutPlay.setOnDragListener(this);

        LinearLayout layoutRest = findViewById(R.id.layoutRest);
        layoutRest.setTag("rest");
        layoutRest.setOnDragListener(this);

        txtCleaning = findViewById(R.id.txtCleaning);
        txtClothes = findViewById(R.id.txtClothes);
        txtCome = findViewById(R.id.txtCome);
        txtDrama = findViewById(R.id.txtDrama);
        txtInteresting = findViewById(R.id.txtInteresting);
        txtMeeting = findViewById(R.id.txtMeeting);
        txtPlay = findViewById(R.id.txtPlay);
        txtRest = findViewById(R.id.txtRest);

        showBottomSheetDialog();
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

                    if (vw.getTag().toString() == "cleaning"){
                        txtCleaning.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "clothes"){
                        txtClothes.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "come"){
                        txtCome.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "drama"){
                        txtDrama.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "interesting"){
                        txtInteresting.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "meeting"){
                        txtMeeting.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "play"){
                        txtPlay.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "rest"){
                        txtRest.setVisibility(View.INVISIBLE);
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
                    if (imgCleaning.getTag() == "done" && imgClothes.getTag() == "done" && imgCome.getTag() == "done" && imgDrama.getTag() == "done" && imgInteresting.getTag() == "done" && imgMeeting.getTag() == "done" && imgPlay.getTag() == "done" && imgRest.getTag() == "done") {
                        Parameter.level9 = true;
                        Parameter.current = 10;
                        session.currentLevel(10);
                        showLevelComplete(9);
//                        showBottomSheetDialog();
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

//    private void showBottomSheetDialog() {
//        View view = getLayoutInflater().inflate(R.layout.finish_bottom_sheet, null);
//
//        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//        }
//
//        TextView title = view.findViewById(R.id.txtTitle);
//        title.setText("Level 9 Complete");
//        TextView subTitle = view.findViewById(R.id.subTitle);
//        subTitle.setText("Congratulations you have completed all levels");
//
//        (view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sheetDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Challenge completed", Toast.LENGTH_SHORT).show();
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
//        sheetDialog.show();
//        sheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                sheetDialog = null;
//            }
//        });
//    }

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
            findViewById(R.id.japan9).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.japan5).setVisibility(View.GONE);
            findViewById(R.id.japan6).setVisibility(View.GONE);
            findViewById(R.id.japan7).setVisibility(View.GONE);
            findViewById(R.id.japan8).setVisibility(View.GONE);
            findViewById(R.id.roman9).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
            findViewById(R.id.roman5).setVisibility(View.GONE);
            findViewById(R.id.roman6).setVisibility(View.GONE);
            findViewById(R.id.roman7).setVisibility(View.GONE);
            findViewById(R.id.roman8).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.JAPANESE)) {
            findViewById(R.id.japan9).setVisibility(View.VISIBLE);
            findViewById(R.id.japan2).setVisibility(View.VISIBLE);
            findViewById(R.id.japan3).setVisibility(View.VISIBLE);
            findViewById(R.id.japan4).setVisibility(View.VISIBLE);
            findViewById(R.id.japan5).setVisibility(View.VISIBLE);
            findViewById(R.id.japan6).setVisibility(View.VISIBLE);
            findViewById(R.id.japan7).setVisibility(View.VISIBLE);
            findViewById(R.id.japan8).setVisibility(View.VISIBLE);
            findViewById(R.id.roman9).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
            findViewById(R.id.roman5).setVisibility(View.GONE);
            findViewById(R.id.roman6).setVisibility(View.GONE);
            findViewById(R.id.roman7).setVisibility(View.GONE);
            findViewById(R.id.roman8).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.ROMANIZED)) {
            findViewById(R.id.japan9).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.japan5).setVisibility(View.GONE);
            findViewById(R.id.japan6).setVisibility(View.GONE);
            findViewById(R.id.japan7).setVisibility(View.GONE);
            findViewById(R.id.japan8).setVisibility(View.GONE);
            findViewById(R.id.roman9).setVisibility(View.VISIBLE);
            findViewById(R.id.roman2).setVisibility(View.VISIBLE);
            findViewById(R.id.roman3).setVisibility(View.VISIBLE);
            findViewById(R.id.roman4).setVisibility(View.VISIBLE);
            findViewById(R.id.roman5).setVisibility(View.VISIBLE);
            findViewById(R.id.roman6).setVisibility(View.VISIBLE);
            findViewById(R.id.roman7).setVisibility(View.VISIBLE);
            findViewById(R.id.roman8).setVisibility(View.VISIBLE);
        }
    }

}