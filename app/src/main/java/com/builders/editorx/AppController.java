package com.builders.editorx;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import com.builders.editorx.FileUtils.FileOperations;
import com.builders.editorx.activities.FileSelectionActivity;
import com.builders.editorx.database.FileDatabase;
import com.builders.editorx.modal.FileModel;
import com.builders.editorx.utils.FileUtils;
import com.builders.editorx.utils.PrefUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppController extends Application {

    public static enum ACTION {OPEN_FILE, CREATE_FILE, NONE}

    public static ACTION currentAction = ACTION.NONE;

    public static Context context;
    public static String currentFilePath = "";
    public static List<FileModel> currentFileList = new ArrayList<>();
    private static FileDatabase fileDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PrefUtils.init();
        initDb();
    }

    private void initDb() {
        fileDatabase = FileDatabase.getInstance();
        currentFileList = fileDatabase.getDao().getList();
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

        updateOnDb();
    }

    private static void updateOnDb() {
        fileDatabase.getDao().deleteAll();
        fileDatabase.getDao().batchInsert(currentFileList);
    }

    public static boolean removeFile(String path) {
        boolean isUpdate = true;
        int position = -1;

        for (int i = 0; i < currentFileList.size(); i++) {
            FileModel singleModel = currentFileList.get(i);
            if (singleModel.getFileUrl().equals(path)) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            currentFileList.remove(position);
        }

        if (path.equals(currentFilePath)) {
            if (currentFileList.size() > 0) {
                currentFilePath = currentFileList.get(0).getFileUrl();
                isUpdate = true;
            } else {
                PrefUtils.setCurrentFileOpen(false);
                PrefUtils.saveLastFileUrl(path);
                Intent intent = new Intent(context, FileSelectionActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
                isUpdate = false;
            }
        }
        updateOnDb();
        return isUpdate;
    }

    public static boolean isValidFileFormat(String path) {
        boolean isValid = false;
        String extension = FileOperations.getFileExtension(path);
        if (extension.equals(".html"))
            isValid = true;
        if (extension.equals(".css"))
            isValid = true;
        if (extension.equals(".js"))
            isValid = true;
        return isValid;
    }
}