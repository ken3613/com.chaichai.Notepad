package com.chaichai.notepad;

import android.app.Application;

public class Global extends Application {
    private int themeColor;
    private boolean firstRun=false;

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
