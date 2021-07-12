package com.builders.editorx;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.builders.editorx.activities.FileSelectionActivity;
import com.builders.editorx.activities.FileViewerActivity;
import com.builders.editorx.activities.WebViewrActivity;
import com.builders.editorx.callbacks.BottomSheetCallBack;
import com.builders.editorx.customes.FileBottomSheetDialog;
import com.builders.editorx.customes.LineEditText;
import com.builders.editorx.utils.FileUtils;
import com.builders.editorx.utils.PrefUtils;

public class MainActivity extends AppCompatActivity implements BottomSheetCallBack {

    int FILE_SAVING_CODE = 2000;
    LineEditText fileEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        checkForCurrentFile();
    }

    private void checkForCurrentFile() {
        if (!AppController.currentFilePath.isEmpty()) {
            String data = FileUtils.getFileValue(AppController.currentFilePath);
            if (data != null) {
                fileEditText.setText(data);
                updateToolbarName();
                PrefUtils.setCurrentFileOpen(true);
                PrefUtils.saveCurrentFileUrl(AppController.currentFilePath);
            }
        }
    }

    private void initViews() {
        fileEditText = findViewById(R.id.file_edit_text);
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
                handleCodePlay();
            }
            break;
            case R.id.file_new: {
                openNewDocument();
            }
            break;
            case R.id.file_close: {
                closeCurrentFile();
            }
            break;
            case R.id.file_open: {
                openFile();
            }
            break;
            case R.id.file_list: {
                showDialog();
            }
            break;
        }
        return true;
    }

    private void openNewDocument() {
        AppController.currentFilePath = "";
        PrefUtils.setCurrentFileOpen(false);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void closeCurrentFile() {
        PrefUtils.saveLastFileUrl(AppController.currentFilePath);
        PrefUtils.setCurrentFileOpen(false);
        AppController.currentFilePath = "";
        Intent intent = new Intent(this, FileSelectionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void openFile() {
        AppController.currentAction = AppController.ACTION.OPEN_FILE;
        startActivity(new Intent(this, FileViewerActivity.class));
    }

    private void handleCodePlay() {
        if (AppController.isFileNotSaved()) {
            AppController.showToast("Save File First");
            saveFile();
        } else {
            saveFile();
            runtTheCode();
        }
    }

    private void runtTheCode() {
        startActivity(new Intent(this, WebViewrActivity.class));
    }

    private void saveFile() {
        if (AppController.currentFilePath.isEmpty()) {
            startActivityForResult(new Intent(this, FileViewerActivity.class), FILE_SAVING_CODE);
        } else {
            FileUtils.appendFileValue(AppController.currentFilePath, fileEditText.getText().toString());
            PrefUtils.saveCurrentFileUrl(AppController.currentFilePath);
            updateToolbarName();
            AppController.showToast("File Saved");
        }
    }

    private void updateToolbarName() {
        getSupportActionBar().setTitle(FileUtils.getCurrentFileName());
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

    void showDialog() {
        FileBottomSheetDialog fileBottomSheetDialog = FileBottomSheetDialog.newInstance(this);
        fileBottomSheetDialog.show(getSupportFragmentManager(), "");
    }


    @Override
    public void openOtherFile(String url) {
        AppController.currentFilePath = url;
        checkForCurrentFile();
    }
}