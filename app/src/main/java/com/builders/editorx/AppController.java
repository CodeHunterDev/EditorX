package com.builders.editorx;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.builders.editorx.modal.FileModel;
import com.builders.editorx.utils.FileUtils;
import com.builders.editorx.utils.PrefUtils;

import java.util.ArrayList;
import java.util.List;

public class AppController extends Application {

    public static enum ACTION {OPEN_FILE, CREATE_FILE, NONE}

    public static ACTION currentAction = ACTION.NONE;

    public static Context context;
    public static String currentFilePath = "";
    public static List<FileModel> currentFileList = new ArrayList<>();

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

    public static void addFile(String path) {
        boolean isAvailable = false;

        for (FileModel singleFile : currentFileList) {
            if (singleFile.getFileUrl().equals(path)) {
                isAvailable = true;
            }
        }

        if (!isAvailable) {
            FileModel newFile = new FileModel();
            newFile.setFileName(FileUtils.getFileName(path));
            newFile.setFileUrl(path);
            currentFileList.add(newFile);
        }
    }
}