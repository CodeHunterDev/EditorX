package com.builders.editorx.constants;

import android.os.Build;

import com.builders.editorx.AppController;
import com.builders.editorx.R;

import java.io.File;

public class PrefConstants {
    public static final String PREF_FILE_NAME = AppController.context.getResources().getString(R.string.app_name) + "PREF";
    public static final String LAST_FILE_URL = "LAST_FILE_URL";
    public static final String CURRENT_FILE_URL = "CURRENT_FILE_URL";
    public static final String CURRENT_FILE_AVAILABLE = "CURRENT_FILE_AVAILABLE";

}
