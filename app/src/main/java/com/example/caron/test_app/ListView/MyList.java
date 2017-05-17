package com.example.caron.test_app.ListView;

import android.graphics.Bitmap;

/**
 * Created by CARON on 17/05/2017.
 */

public class MyList {
    private String theme;
    private int x;
    private int y;
    Bitmap myImage;
    //
    public MyList(String theme, int x, int y,Bitmap myImage) {
        this.theme = theme;
        this.x = x;
        this.y = y;
        this.myImage=myImage;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getMyImage() {
        return myImage;
    }

    public void setMyImage(Bitmap myImage) {
        this.myImage = myImage;
    }

}
