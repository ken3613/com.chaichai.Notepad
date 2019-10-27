package com.chaichai.notepad;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class myinfo extends AppCompatActivity implements View.OnClickListener {

    private Global gb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        gb = (Global)getApplication();



        Button btn_sy = findViewById(R.id.bt_sy);
        ConstraintLayout layoutMain = findViewById(R.id.myInfo_layout_main);
        for (int i=0;i<layoutMain.getChildCount();i++){
            View v = layoutMain.getChildAt(i);
            if(v instanceof Button){
                Button bt = (Button)v;
                bt.setOnClickListener(this);
            }
        }


        final int fromPage;
        fromPage=getIntent().getIntExtra("fromPage",1);

            int themeColor = gb.getThemeColor();
            LinearLayout linearLayout_Bottom = findViewById(R.id.linearLayout_Bottom);
            linearLayout_Bottom.setBackgroundColor(themeColor);
            TextView myinfo_tv_Top = findViewById(R.id.myinfo_textView_Top);
            myinfo_tv_Top.setBackgroundColor(themeColor);


        //sy OnClick
        btn_sy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch(fromPage){
                    case 1:{
                        intent.setClass(myinfo.this,MainActivity.class);
                        break;
                    }
                    case 2:{
                        intent.setClass(myinfo.this,db.class);
                        break;
                    }
                    case 3:{
                        intent.setClass(myinfo.this,dsr.class);
                    }
                }
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {
        Button bt = (Button)view;
        ColorDrawable colorDrawable = (ColorDrawable) bt.getBackground();
        int color = colorDrawable.getColor();
        gb.setThemeColor(color);
        this.recreate();

    }
}
