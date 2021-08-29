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

public class Step8 extends BaseActivity implements View.OnLongClickListener, View.OnDragListener {
    //    BottomSheetBehavior sheetBehavior;
//    BottomSheetDialog sheetDialog;
//    View bottom_sheet;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    CardView imgBuy, imgFlower, imgHat, imgPostCard, imgSouvenir, imgUmbrella, imgWallet, imgYen;
    LinearProgressIndicator progressIndicator;
    Integer numCorrent = 0;
    Integer numQuestion = 8;
    TextView progressPercentage;
    TextView txtBuy, txtFlower, txtHat, txtPostCard, txtSouvenir, txtUmbrella, txtWallet, txtYen;

    @Override
    public void onBackPressed() {
        com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step8.this);
        cdd.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step8);

//        bottom_sheet        = findViewById(R.id.bottom_sheet);
//        sheetBehavior       = BottomSheetBehavior.from(bottom_sheet);
        mBottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout);

        ImageView back = (ImageView) findViewById(R.id.back);
        progressIndicator = findViewById(R.id.progress);
        progressPercentage = findViewById(R.id.progressPercentage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step8.this);
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

        imgBuy = (CardView) findViewById(R.id.imgBuy);
        imgBuy.setTag("buy");
        imgBuy.setOnLongClickListener(this);
        imgFlower = (CardView) findViewById(R.id.imgFlower);
        imgFlower.setTag("flower");
        imgFlower.setOnLongClickListener(this);
        imgHat = (CardView) findViewById(R.id.imgHat);
        imgHat.setTag("hat");
        imgHat.setOnLongClickListener(this);
        imgPostCard = (CardView) findViewById(R.id.imgPostCard);
        imgPostCard.setTag("postcard");
        imgPostCard.setOnLongClickListener(this);
        imgSouvenir = (CardView) findViewById(R.id.imgSouvenir);
        imgSouvenir.setTag("souvenir");
        imgSouvenir.setOnLongClickListener(this);
        imgUmbrella = (CardView) findViewById(R.id.imgUmbrella);
        imgUmbrella.setTag("umbrella");
        imgUmbrella.setOnLongClickListener(this);
        imgWallet = (CardView) findViewById(R.id.imgWallet);
        imgWallet.setTag("wallet");
        imgWallet.setOnLongClickListener(this);
        imgYen = (CardView) findViewById(R.id.imgYen);
        imgYen.setTag("yen");
        imgYen.setOnLongClickListener(this);

        LinearLayout layoutBuy = findViewById(R.id.layoutBuy);
        layoutBuy.setTag("buy");
        layoutBuy.setOnDragListener(this);

        LinearLayout layoutFlower = findViewById(R.id.layoutFlower);
        layoutFlower.setTag("flower");
        layoutFlower.setOnDragListener(this);

        LinearLayout layoutHat = findViewById(R.id.layoutHat);
        layoutHat.setTag("hat");
        layoutHat.setOnDragListener(this);

        LinearLayout layoutPostCard = findViewById(R.id.layoutPostCard);
        layoutPostCard.setTag("postcard");
        layoutPostCard.setOnDragListener(this);

        LinearLayout layoutSouvenir = findViewById(R.id.layoutSouvenir);
        layoutSouvenir.setTag("souvenir");
        layoutSouvenir.setOnDragListener(this);

        LinearLayout layoutUmbrella = findViewById(R.id.layoutUmbrella);
        layoutUmbrella.setTag("umbrella");
        layoutUmbrella.setOnDragListener(this);

        LinearLayout layoutWallet = findViewById(R.id.layoutWallet);
        layoutWallet.setTag("wallet");
        layoutWallet.setOnDragListener(this);

        LinearLayout layoutYen = findViewById(R.id.layoutYen);
        layoutYen.setTag("yen");
        layoutYen.setOnDragListener(this);

        txtBuy = findViewById(R.id.txtBuy);
        txtFlower = findViewById(R.id.txtFlower);
        txtHat = findViewById(R.id.txtHat);
        txtPostCard = findViewById(R.id.txtPostCard);
        txtSouvenir = findViewById(R.id.txtSouvenir);
        txtUmbrella = findViewById(R.id.txtUmbrella);
        txtWallet = findViewById(R.id.txtWallet);
        txtYen = findViewById(R.id.txtYen);

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

                    if (vw.getTag().toString() == "buy"){
                        txtBuy.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "flower"){
                        txtFlower.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "hat"){
                        txtHat.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "postcard"){
                        txtPostCard.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "souvenir"){
                        txtSouvenir.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "wallet"){
                        txtWallet.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "yen"){
                        txtYen.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "umbrella"){
                        txtUmbrella.setVisibility(View.INVISIBLE);
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
                    if (imgBuy.getTag() == "done" && imgFlower.getTag() == "done" && imgHat.getTag() == "done" && imgPostCard.getTag() == "done" && imgSouvenir.getTag() == "done" && imgUmbrella.getTag() == "done" && imgWallet.getTag() == "done" && imgYen.getTag() == "done") {
                        Parameter.level8 = true;
                        Parameter.current = 9;
                        session.currentLevel(9);
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
//        title.setText("Level 8 Complete");
//        TextView subTitle = view.findViewById(R.id.subTitle);
//        subTitle.setText("You have learnt 8 new kanji. Keep up the good work!");
//
//        (view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sheetDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Level 9", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Step8.this, Step9.class);
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