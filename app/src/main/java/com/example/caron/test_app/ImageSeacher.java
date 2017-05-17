package com.example.caron.test_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by CARON on 16/05/2017.
 */

public class ImageSeacher extends AsyncTask<Object, Object, Void> {
//
    private String theme;
    private int x;
    private int y;
    Context context;
    Bitmap bitmap;
    public ImageSeacher(){}
    public ImageSeacher(String theme, int x, int y, Context context)
    {
        this.theme=theme;
        this.x=x;
        this.y=y;
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context.getApplicationContext(), "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Object... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Object... params) {
        String urlString = "http://lorempixel.com/"+this.x+"/"+this.y+"/"+this.theme+"/";
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
             BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            in.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setBitmap(bitmap);

        return null;
    }


    public String getTheme() {
        return theme;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
