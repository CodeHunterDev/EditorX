package com.builders.texteditor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.builders.texteditor.activities.FileViewerActivity;
import com.builders.texteditor.activities.WebViewrActivity;
import com.builders.texteditor.customes.LineEditText;
import com.builders.texteditor.utils.FileUtils;

public class MainActivity extends AppCompatActivity {

    int STORAGE_CODE = 1000;
    int FILE_SAVING_CODE = 2000;
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
            case R.id.play_code: {
                if (AppController.isFileNotSaved()) {
                    AppController.showToast("Save File First");
                    saveFile();
                } else {
                    saveFile();
                    runtTheCode();
                }
            }
            break;
        }
        return true;
    }

    private void runtTheCode() {
        startActivity(new Intent(this, WebViewrActivity.class));
    }

    private void saveFile() {
        if (AppController.currentFilePath.isEmpty()) {
            startActivityForResult(new Intent(this, FileViewerActivity.class), FILE_SAVING_CODE);
        } else {
            FileUtils.appendFileValue(AppController.currentFilePath, fileEditText.getText().toString());
            getSupportActionBar().setTitle(FileUtils.getCurrentFileName());
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_SAVING_CODE) {
            if (resultCode == RESULT_OK) {
                AppController.currentFilePath = data.getStringExtra(FileViewerActivity.SELECTED_FILE_PATH);
                saveFile();
            } else {
                AppController.showToast("Your data are not saved");
            }
        }
    }

}