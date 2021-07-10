package com.builders.texteditor;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class AppController extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
