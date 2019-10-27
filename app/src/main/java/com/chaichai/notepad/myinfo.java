package com.chaichai.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class myinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);


        final Button btn_sy = findViewById(R.id.bt_sy);

        final int fromPage;
        fromPage=getIntent().getIntExtra("fromPage",1);


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


}
