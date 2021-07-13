package com.builders.editorx.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.builders.editorx.AppController;
import com.builders.editorx.MainActivity;
import com.builders.editorx.R;
import com.builders.editorx.utils.PrefUtils;

public class FileSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private final int STORAGE_CODE = 1000;
    LinearLayout newDocumentLL;
    LinearLayout openFromStorageLL;
    LinearLayout openLastEditedLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_selection);
        initViews();
        checkPermission();
        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().hide();
    }

    private void initViews() {
        newDocumentLL = findViewById(R.id.new_document_ll);
        openFromStorageLL = findViewById(R.id.open_storage_ll);
        openLastEditedLL = findViewById(R.id.last_edited_ll);

        newDocumentLL.setOnClickListener(this);
        openFromStorageLL.setOnClickListener(this);
        openLastEditedLL.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_document_ll: {
                openNewDocument();
            }
            break;
            case R.id.open_storage_ll: {
                selectFromStorageDocument();
            }
            break;
            case R.id.last_edited_ll: {
                openLastEditedFiles();
            }
            break;
        }
    }

    private void openLastEditedFiles() {
        boolean value = PrefUtils.isLastFileAvailable();
        if (value) {
            AppController.currentFilePath = PrefUtils.getLastFileUrl();
            AppController.addFile(AppController.currentFilePath);
            Intent intent = new Intent(this , MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            AppController.showToast("No last file available");
        }

    }

    private void selectFromStorageDocument() {
        AppController.currentAction = AppController.ACTION.OPEN_FILE;
        startActivity(new Intent(this, FileViewerActivity.class));
    }

    private void openNewDocument() {
        AppController.currentFilePath = "";
        Intent intent = new Intent(this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void checkPermission() {
        if (!isPermissionAvailable()) {
            String permission[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permission, STORAGE_CODE);
        }
    }

    private boolean isPermissionAvailable() {
        boolean isAvailable = true;
        if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED))
            isAvailable = false;
        if (!(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED))
            isAvailable = false;
        return isAvailable;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_CODE) {
            if (!isPermissionAvailable()) {
                AppController.showToast(getResources().getString(R.string.access_denied));
                finish();
            }
        }
    }

}