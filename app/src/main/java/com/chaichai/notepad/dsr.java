package com.chaichai.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dsr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsr);

        final Button btn_js = findViewById(R.id.bt_js);
        final Button btn_db = findViewById(R.id.bt_db);
        final Button btn_wd = findViewById(R.id.bt_wd);



        //js OnClick
        btn_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(dsr.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //db OnClick
        btn_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(dsr.this,db.class);
                startActivity(intent);
            }
        });

        //wd OnClick
        btn_wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(dsr.this,myinfo.class);
                intent.putExtra("fromPage",3);
                startActivity(intent);
            }
        });
    }
}
