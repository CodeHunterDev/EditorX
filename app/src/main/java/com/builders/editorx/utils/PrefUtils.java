package com.builders.editorx.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.builders.editorx.AppController;
import com.builders.editorx.constants.PrefConstants;

public class PrefUtils {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void init() {
        sharedPreferences = AppController.context.getSharedPreferences(PrefConstants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private static void saveString(String key, String value) {
        try {
            if (!key.isEmpty() && !value.isEmpty()) {
                editor.putString(key, value);
                editor.apply();
                editor.commit();
            } else {
                throw new Exception("Key Or Value can not be empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public static void saveCurrentFileUrl(String value) {
        saveString(PrefConstants.PREF_FILE_NAME, value);
    }

    public static String getCurrentFileUrl() {
        return getString(PrefConstants.PREF_FILE_NAME);
    }

    public static boolean isLastFileOpen() {
        String url = getCurrentFileUrl();
        return url.isEmpty() ? false : true;
    }

}
