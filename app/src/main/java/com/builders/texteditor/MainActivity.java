package com.builders.texteditor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.builders.texteditor.customes.LineEditText;
import com.builders.texteditor.utils.FileUtils;

public class MainActivity extends AppCompatActivity {

    int STORAGE_CODE = 1000;
    LineEditText fileEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        initViews();
    }

    private void initViews() {
        fileEditText = findViewById(R.id.file_edit_text);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.file_save: {
                saveFile();
            }
            break;
        }
        return true;
    }

    private void saveFile() {
//        FileUtils.setFileValue("/storage/emulated/0/Download/Testing.html", fileEditText.getText().toString());
//        AppController.showToast("File Saved");


    }
}