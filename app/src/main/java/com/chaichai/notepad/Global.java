package com.chaichai.notepad;

import android.app.Application;
import android.graphics.Color;

public class Global extends Application {
    private int themeColor;
    private boolean firstRun=false;

    @Override
    public void onCreate() {
        super.onCreate();
        setThemeColor(Color.rgb(244,164,96));
    }

    public void setRun(){
        this.firstRun=true;
    }
    public boolean getFirstRun(){
        return this.firstRun;
    }
    public int getThemeColor(){
        return this.themeColor;
    }
    public void setThemeColor(int colorId){
        this.themeColor=colorId;
    }
}
