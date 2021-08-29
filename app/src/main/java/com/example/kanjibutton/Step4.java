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

public class Step4 extends BaseActivity implements View.OnLongClickListener, View.OnDragListener {
    //    BottomSheetBehavior sheetBehavior;
//    BottomSheetDialog sheetDialog;
//    View bottom_sheet;
    private LinearLayout mBottomSheetLayout;
    private BottomSheetBehavior sheetBehavior;

    CardView imgShelf, imgPicture, imgKitchen, imgHouse, imgBook, imgBedroom;
    LinearProgressIndicator progressIndicator;
    Integer numCorrent = 0;
    Integer numQuestion = 6;
    TextView progressPercentage;
    TextView txtShelf, txtPicture, txtKitchen, txtHouse, txtBook, txtBedrrom;

    @Override
    public void onBackPressed() {
        com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step4.this);
        cdd.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);

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
                com.example.kanjibutton.ExitDialog cdd = new com.example.kanjibutton.ExitDialog(Step4.this);
                cdd.show();
            }
        });

        ImageView settings = (ImageView) findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingDialog();
//                sheetDialog.show();
            }
        });

        imgShelf = (CardView) findViewById(R.id.imgShelf);
        imgShelf.setTag("shelf");
        imgShelf.setOnLongClickListener(this);
        imgPicture = (CardView) findViewById(R.id.imgPicture);
        imgPicture.setTag("picture");
        imgPicture.setOnLongClickListener(this);
        imgKitchen = (CardView) findViewById(R.id.imgKicthen);
        imgKitchen.setTag("kitchen");
        imgKitchen.setOnLongClickListener(this);
        imgHouse = (CardView) findViewById(R.id.imgHouse);
        imgHouse.setTag("house");
        imgHouse.setOnLongClickListener(this);
        imgBook = (CardView) findViewById(R.id.imgBook);
        imgBook.setTag("book");
        imgBook.setOnLongClickListener(this);
        imgBedroom = (CardView) findViewById(R.id.imgBedroom);
        imgBedroom.setTag("bedroom");
        imgBedroom.setOnLongClickListener(this);

        LinearLayout layoutHouse = findViewById(R.id.layoutHouse);
        layoutHouse.setTag("house");
        layoutHouse.setOnDragListener(this);

        LinearLayout layoutBedroom = findViewById(R.id.layoutBedroom);
        layoutBedroom.setTag("bedroom");
        layoutBedroom.setOnDragListener(this);

        LinearLayout layoutShelf = findViewById(R.id.layoutShelf);
        layoutShelf.setTag("shelf");
        layoutShelf.setOnDragListener(this);

        LinearLayout layoutKitchen = findViewById(R.id.layoutKitchen);
        layoutKitchen.setTag("kitchen");
        layoutKitchen.setOnDragListener(this);

        LinearLayout layoutPicture = findViewById(R.id.layoutPicture);
        layoutPicture.setTag("picture");
        layoutPicture.setOnDragListener(this);

        LinearLayout layoutBook = findViewById(R.id.layoutBook);
        layoutBook.setTag("book");
        layoutBook.setOnDragListener(this);

        txtShelf = findViewById(R.id.txtShelf);
        txtPicture = findViewById(R.id.txtPicture);
        txtKitchen = findViewById(R.id.txtKitchen);
        txtHouse = findViewById(R.id.txtHouse);
        txtBook = findViewById(R.id.txtBook);
        txtBedrrom = findViewById(R.id.txtBedroom);

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

//                Toast.makeText(this, "tag "+vw.getTag().toString(), Toast.LENGTH_SHORT).show();

                if (vw.getTag() == container.getTag()) {

                    //todo play corrent sound
                    playSound(R.raw.correct_answer);

                    if (vw.getTag().toString() == "house"){
                        txtHouse.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "bedroom"){
                        txtBedrrom.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "shelf"){
                        txtShelf.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "kitchen"){
                        txtKitchen.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "picture"){
                        txtPicture.setVisibility(View.INVISIBLE);
                    }else if (vw.getTag().toString() == "book"){
                        txtBook.setVisibility(View.INVISIBLE);
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
                    if (imgShelf.getTag() == "done" && imgPicture.getTag() == "done" && imgKitchen.getTag() == "done" && imgHouse.getTag() == "done" && imgBook.getTag() == "done" && imgBedroom.getTag() == "done") {
                        Parameter.level4 = true;
                        Parameter.current = 5;
                        session.currentLevel(5);
                        showLevelComplete(6);
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
//        title.setText("Level 4 Complete");
//        TextView subTitle = view.findViewById(R.id.subTitle);
//        subTitle.setText("You have learnt 6 new kanji. Keep up the good work!");
//
//        (view.findViewById(R.id.btn_yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sheetDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Level 5", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Step4.this, Step5.class);
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
            findViewById(R.id.japan7).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.japan5).setVisibility(View.GONE);
            findViewById(R.id.japan6).setVisibility(View.GONE);
            findViewById(R.id.roman7).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
            findViewById(R.id.roman5).setVisibility(View.GONE);
            findViewById(R.id.roman6).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.JAPANESE)) {
            findViewById(R.id.japan7).setVisibility(View.VISIBLE);
            findViewById(R.id.japan2).setVisibility(View.VISIBLE);
            findViewById(R.id.japan3).setVisibility(View.VISIBLE);
            findViewById(R.id.japan4).setVisibility(View.VISIBLE);
            findViewById(R.id.japan5).setVisibility(View.VISIBLE);
            findViewById(R.id.japan6).setVisibility(View.VISIBLE);
            findViewById(R.id.roman7).setVisibility(View.GONE);
            findViewById(R.id.roman2).setVisibility(View.GONE);
            findViewById(R.id.roman3).setVisibility(View.GONE);
            findViewById(R.id.roman4).setVisibility(View.GONE);
            findViewById(R.id.roman5).setVisibility(View.GONE);
            findViewById(R.id.roman6).setVisibility(View.GONE);
        } else if (session.subtitle().equalsIgnoreCase(SessionManager.ROMANIZED)) {
            findViewById(R.id.japan7).setVisibility(View.GONE);
            findViewById(R.id.japan2).setVisibility(View.GONE);
            findViewById(R.id.japan3).setVisibility(View.GONE);
            findViewById(R.id.japan4).setVisibility(View.GONE);
            findViewById(R.id.japan5).setVisibility(View.GONE);
            findViewById(R.id.japan6).setVisibility(View.GONE);
            findViewById(R.id.roman7).setVisibility(View.VISIBLE);
            findViewById(R.id.roman2).setVisibility(View.VISIBLE);
            findViewById(R.id.roman3).setVisibility(View.VISIBLE);
            findViewById(R.id.roman4).setVisibility(View.VISIBLE);
            findViewById(R.id.roman5).setVisibility(View.VISIBLE);
            findViewById(R.id.roman6).setVisibility(View.VISIBLE);
        }
    }
}