package com.builders.editorx;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.builders.editorx.utils.PrefUtils;

public class AppController extends Application {

    public static enum ACTION {OPEN_FILE, CREATE_FILE, NONE}

    public static ACTION currentAction = ACTION.NONE;

    public static Context context;
    public static String currentFilePath = "";

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PrefUtils.init();
    }

    public static void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isFileNotSaved() {
        return currentFilePath.isEmpty();
    }

    public static String getWebUrl() {
        return "file://" + currentFilePath;
    }

}
