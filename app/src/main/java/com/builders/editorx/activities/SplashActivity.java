package com.builders.editorx.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.builders.editorx.AppController;
import com.builders.editorx.MainActivity;
import com.builders.editorx.R;
import com.builders.editorx.utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        setRunnable();
    }

    private void setRunnable() {
        new Handler().postDelayed(() -> {
            handleNextScreen();
        }, 3000);
    }

    private void handleNextScreen() {
        boolean currentFileOpen = PrefUtils.isCurrentFileOpen();
        Intent intent;
        if (currentFileOpen) {
            AppController.currentFilePath = PrefUtils.getCurrentFileUrl();
            AppController.addFile(AppController.currentFilePath);
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, FileSelectionActivity.class);
        }
        startActivity(intent);
        finish();
    }
}