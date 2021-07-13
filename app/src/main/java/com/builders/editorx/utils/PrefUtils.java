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
            if (!key.isEmpty()) {
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

    private static void saveBoolean(String key, boolean value) {
        try {
            if (!key.isEmpty()) {
                editor.putBoolean(key, value);
                editor.apply();
                editor.commit();
            } else {
                throw new Exception("Key Or Value can not be empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static void saveCurrentFileUrl(String value) {
        saveString(PrefConstants.CURRENT_FILE_URL, value);
    }

    public static String getCurrentFileUrl() {
        return getString(PrefConstants.CURRENT_FILE_URL);
    }

    public static void saveLastFileUrl(String value) {
        saveString(PrefConstants.LAST_FILE_URL, value);
    }

    public static String getLastFileUrl() {
        return getString(PrefConstants.LAST_FILE_URL);
    }

    public static boolean isCurrentFileOpen() {
        return getBoolean(PrefConstants.CURRENT_FILE_AVAILABLE);
    }

    public static void setCurrentFileOpen(boolean value) {
        saveBoolean(PrefConstants.CURRENT_FILE_AVAILABLE, value);
    }

    public static void setLastFileAvailable(boolean value) {
        saveBoolean(PrefConstants.LAST_FILE_AVAILABLE, value);
    }

    public static boolean getLastFileAvailable() {
        return getBoolean(PrefConstants.LAST_FILE_AVAILABLE);
    }

    public static boolean isLastFileAvailable() {
        String url = getLastFileUrl();
        return url.isEmpty() ? false : true;
    }
}
