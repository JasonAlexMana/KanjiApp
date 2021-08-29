package com.example.kanjibutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kanjibutton.helper.BaseActivity;

public class MenuPage extends BaseActivity {
    ImageView start, library;
    View bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12;
//    BottomSheetDialog sheetDialog;
//    BottomSheetBehavior sheetBehavior;
    View bottom_sheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        bottom_sheet = findViewById(R.id.bottom_sheet);
//        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        ImageView settings = (ImageView) findViewById(R.id.settings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingDialog();
//                sheetDialog.show();
            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MenuPage.this, MainActivity.class);
                startActivity(newIntent);
            }
        });

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MenuPage.this, MainActivity.class);
                startActivity(newIntent);
            }
        });

        ImageView library = findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MenuPage.this, KanjiList.class);
                startActivity(newIntent);
            }
        });

        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() == 1) {
                    startActivity(new Intent(MenuPage.this, MainActivity2.class));
                    finish();
                } else if (session.currentLevel() == 2) {
                    startActivity(new Intent(MenuPage.this, Step2.class));
                    finish();
                } else if (session.currentLevel() == 3) {
                    startActivity(new Intent(MenuPage.this, Step3.class));
                    finish();
                } else if (session.currentLevel() == 4) {
                    startActivity(new Intent(MenuPage.this, Step4.class));
                    finish();
                } else if (session.currentLevel() == 5) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 6) {
                    startActivity(new Intent(MenuPage.this, com.example.kanjibutton.Step6.class));
                    finish();
                } else if (session.currentLevel() == 7) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 8) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 9) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 10) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 11) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else if (session.currentLevel() == 12) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                }
            }
        });

        bt1 = findViewById(R.id.bt1);
        if (session.currentLevel() >= 1) {
            bt1.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPage.this, MainActivity2.class));
                finish();
            }
        });
        bt2 = findViewById(R.id.bt2);
        if (session.currentLevel() >= 2) {
            bt2.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  2) {
                    startActivity(new Intent(MenuPage.this, Step2.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt3 = findViewById(R.id.bt3);
        if (session.currentLevel() >= 3) {
            bt3.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  3) {
                    startActivity(new Intent(MenuPage.this, Step3.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt4 = findViewById(R.id.bt4);
        if (session.currentLevel() >= 4) {
            bt4.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >= 4) {
                    startActivity(new Intent(MenuPage.this, Step4.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt5 = findViewById(R.id.bt5);
        if (session.currentLevel() >= 5) {
            bt5.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  5) {
                    startActivity(new Intent(MenuPage.this, Step5.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt6 = findViewById(R.id.bt6);
        if (session.currentLevel() >= 6) {
            bt6.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  6) {
                    startActivity(new Intent(MenuPage.this, com.example.kanjibutton.Step6.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt7 = findViewById(R.id.bt7);
        if (session.currentLevel() >= 7) {
            bt7.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  7) {
                    startActivity(new Intent(MenuPage.this, Step7.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt8 = findViewById(R.id.bt8);
        if (session.currentLevel() >= 8) {
            bt8.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >=  8) {
                    startActivity(new Intent(MenuPage.this, Step8.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt9 = findViewById(R.id.bt9);
        if (session.currentLevel() >= 9) {
            bt9.setBackground(getDrawable(R.drawable.item_dot_circle_yellow));
        }
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.currentLevel() >= 9) {
                    startActivity(new Intent(MenuPage.this, com.example.kanjibutton.Step9.class));
                    finish();
                } else {
                    Toast.makeText(MenuPage.this, "You haven't completed the previous challenge", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (session.currentLevel() == 1) {
            bt1.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 2) {
            bt2.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 3) {
            bt3.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 4) {
            bt4.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 5) {
            bt5.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 6) {
            bt6.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 7) {
            bt7.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 8) {
            bt8.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        } else if (session.currentLevel() == 9) {
            bt9.setBackground(getDrawable(R.drawable.item_dot_circle_current));
        }
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
}