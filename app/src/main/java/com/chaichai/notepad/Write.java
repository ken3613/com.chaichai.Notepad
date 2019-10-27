package com.chaichai.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Write extends AppCompatActivity {


    private Button btn_menu;
    private EditText edt_write;
    private ImageButton ibtn_back;
    private ImageButton ibtn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        edt_write = findViewById(R.id.et_write);
        ibtn_menu = findViewById(R.id.ibt_menu);
        ibtn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu();
            }
        });
        ibtn_back = findViewById(R.id.ibt_back);

        String context=getIntent().getStringExtra("context");
        if(!context.isEmpty()){
            edt_write.setText(context);
        }

        //back OnClick
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Write.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showPopupMenu(){
        PopupMenu popupMenu = new PopupMenu(this,ibtn_menu);
        popupMenu.inflate(R.menu.menu_write);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.zstj:
                        int textLen=edt_write.getText().toString().length();
                        Toast.makeText(Write.this,"共："+Integer.toString(textLen)+"字",Toast.LENGTH_SHORT).show();

                        return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

}
