package com.chaichai.notepad;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean searchClicked = false;
    private EditText etx_search;

    @Override
    public void onClick(View view) {
        if(view instanceof TextView){
            TextView tv=(TextView)view;
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Write.class);
            intent.putExtra("context",tv.getText());
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global gb = (Global)getApplication();

        if(gb.getFirstRun()){
            LinearLayout linearLayout_Top = findViewById(R.id.linearLayout_Top);
            LinearLayout linearLayout_Bottom = findViewById(R.id.linearLayout_Bottom);

            linearLayout_Top.setBackgroundColor(gb.getThemeColor());
            linearLayout_Bottom.setBackgroundColor(gb.getThemeColor());
        }else{
            gb.setThemeColor(R.color.colorThemeOrange);
        }
        gb.setRun();






        Button btn_js = findViewById(R.id.bt_js);
        Button btn_db = findViewById(R.id.bt_db);
        Button btn_dsr = findViewById(R.id.bt_dsr);
        Button btn_wd = findViewById(R.id.bt_wd);
        final ImageButton ibtn_search = findViewById(R.id.ibt_search);
        etx_search = findViewById(R.id.et_search);
        final ImageButton ibtn_write = findViewById(R.id.ibt_write);
        etx_search.setVisibility(View.GONE);

        final LinearLayout layout_js = findViewById(R.id.layout_js);
        LinearLayout layout_C1 = (LinearLayout) layout_js.getChildAt(0);
        LinearLayout layout_C2 = (LinearLayout) layout_js.getChildAt(1);

        for(int i = 0; i< layout_C1.getChildCount(); i++){
            View v = layout_C1.getChildAt(i);
            TextView tv = (TextView) v;
            tv.setOnClickListener(this);
        }
        for(int i = 0; i< layout_C2.getChildCount(); i++){
            View v = layout_C2.getChildAt(i);
            TextView tv = (TextView) v;
            tv.setOnClickListener(this);
        }

        //Toast.makeText(this,"欢迎你",Toast.LENGTH_SHORT).show();


        /*etx_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b)
                    etx_search.setVisibility(View.GONE);
            }
        });*/

        //search OnClick
        ibtn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!searchClicked) {
                    etx_search.setVisibility(View.VISIBLE);
                    searchClicked = !searchClicked;
                }
                else {
                    etx_search.setVisibility(View.GONE);
                    searchClicked = !searchClicked;
                }
            }
        });


        //js OnClick
        btn_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*
                btn_js.setTextSize(17);
                btn_js.setBackgroundColor(getResources().getColor(R.color.BUTTON_COLOR_YELLOW));
                btn_db.setTextSize(14);
                btn_db.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btn_dsr.setTextSize(14);
                btn_dsr.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                */
            }
        });

        //db OnClick
        btn_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                btn_js.setTextSize(14);
                btn_js.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btn_db.setTextSize(17);
                btn_db.setBackgroundColor(getResources().getColor(R.color.BUTTON_COLOR_YELLOW));
                btn_dsr.setTextSize(14);
                btn_dsr.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                */
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,db.class);
                startActivity(intent);
            }
        });

        //dsr OnClick
        btn_dsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                btn_js.setTextSize(14);
                btn_js.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btn_db.setTextSize(14);
                btn_db.setBackgroundColor(getResources().getColor(R.color.colorTransparent));
                btn_dsr.setTextSize(17);
                btn_dsr.setBackgroundColor(getResources().getColor(R.color.BUTTON_COLOR_YELLOW));
                */

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,dsr.class);
                startActivity(intent);
            }
        });

        //wd OnClick
        btn_wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,myinfo.class);
                intent.putExtra("fromPage",1);
                startActivity(intent);
            }
        });

        //write OnClick
        ibtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Write.class);
                startActivity(intent);
            }
        });




    }

}
