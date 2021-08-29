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

public class Step7 extends BaseActivity implements View.OnLongClickListener, View.OnDragListener {
    //    BottomSheetBehavior sheetBehavior;
//    BottomSheetDialog sheetDialog;
//    View bottom_sheet;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    CardView imgAirPlane, imgBicycle, imgBusShelter, imgCar, imgDriver, imgSubway, imgTrainStation, imgTrain;
    LinearProgressIndicator progressIndicator;
    Integer numCorrent = 0;
    Integer numQuestion = 8;
    TextView progressPercentage;
    TextView txtTrain, txtSubway, txtAirPlane, txtTrainStation, txtBusShelter, txtBicycle, txtCar, txtDriver;

    @Override
    public void onBackPressed() {
        com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step7.this);
        cdd.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step7);
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
                com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step7.this);
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

        imgAirPlane = (CardView) findViewById(R.id.imgAirPlane);
        imgAirPlane.setTag("airplane");
        imgAirPlane.setOnLongClickListener(this);

        imgBicycle = (CardView) findViewById(R.id.imgBicycle);
        imgBicycle.setTag("bicycle");
        imgBicycle.setOnLongClickListener(this);

        imgBusShelter = (CardView) findViewById(R.id.imgBusShelter);
        imgBusShelter.setTag("busshelter");
        imgBusShelter.setOnLongClickListener(this);

        imgCar = (CardView) findViewById(R.id.imgCar);
        imgCar.setTag("car");
        imgCar.setOnLongClickListener(this);

        imgDriver = (CardView) findViewById(R.id.imgDriver);
        imgDriver.setTag("driver");
        imgDriver.setOnLongClickListener(this);

        imgSubway = (CardView) findViewById(R.id.imgSubway);
        imgSubway.setTag("subway");
        imgSubway.setOnLongClickListener(this);

        imgTrainStation = (CardView) findViewById(R.id.imgTrainStation);
        imgTrainStation.setTag("trainstation");
        imgTrainStation.setOnLongClickListener(this);

        imgTrain = (CardView) findViewById(R.id.imgTrain);
        imgTrain.setTag("train");
        imgTrain.setOnLongClickListener(this);

        LinearLayout layoutTrain = findViewById(R.id.layoutTrain);
        layoutTrain.setTag("train");
        layoutTrain.setOnDragListener(this);

        LinearLayout layoutSubway = findViewById(R.id.layoutSubway);
        layoutSubway.setTag("subway");
        layoutSubway.setOnDragListener(this);

        LinearLayout layoutAirPlane = findViewById(R.id.layoutAirPlane);
        layoutAirPlane.setTag("airplane");
        layoutAirPlane.setOnDragListener(this);

        LinearLayout layoutTrainStation = findViewById(R.id.layoutTrainStation);
        layoutTrainStation.setTag("trainstation");
        layoutTrainStation.setOnDragListener(this);

        LinearLayout layoutBusShelter = findViewById(R.id.layoutBusShelter);
        layoutBusShelter.setTag("busshelter");
        layoutBusShelter.setOnDragListener(this);

        LinearLayout layoutBicycle = findViewById(R.id.layoutBicycle);
        layoutBicycle.setTag("bicycle");
        layoutBicycle.setOnDragListener(this);

        LinearLayout layoutCar = findViewById(R.id.layoutCar);
        layoutCar.setTag("car");
        layoutCar.setOnDragListener(this);

        LinearLayout layoutDriver = findViewById(R.id.layoutDriver);
        layoutDriver.setTag("driver");
        layoutDriver.setOnDragListener(this);

        txtTrain = findViewById(R.id.txtTrain);
        txtSubway = findViewById(R.id.txtSubway);
        txtAirPlane = findViewById(R.id.txtAirPlane);
        txtTrainStation = findViewById(R.id.txtTrainStation);
        txtBusShelter = findViewById(R.id.txtBusShelter);
        txtBicycle = findViewById(R.id.txtBicycle);
        txtCar = findViewById(R.id.txtCar);
        txtDriver = findViewById(R.id.txtDriver);

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

                    if (vw.getTag().toString() == "train"){
                        txtTrain.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "trainstation"){
                        txtTrainStation.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "subway"){
                        txtSubway.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "airplane"){
                        txtAirPlane.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "busshelter"){
                        txtBusShelter.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "bicycle"){
                        txtBicycle.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "car"){
                        txtCar.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "driver"){
                        txtDriver.setVisibility(View.INVISIBLE);
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
                    if (imgAirPlane.getTag() == "done" && imgBicycle.getTag() == "done" && imgBusShelter.getTag() == "done" && imgCar.getTag() == "done" && imgDriver.getTag() == "done" && imgSubway.getTag() == "done" && imgTrainStation.getTag() == "done" && imgTrain.getTag() == "done") {
                        Parameter.level7 = true;
                        Parameter.current = 8;
                        session.currentLevel(8);
                        showLevelComplete(8);
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
//        title.setText("Level 7 Complete");
//        TextView subTitle = view.findViewById(R.id.subTitle);
//        subTitle.setText("You have learnt 8 new kanji. Keep up the good work!");
//
//        (view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sheetDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Level 8", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Step7.this, Step8.class);
//                startActivity(intent);
//                finish();
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