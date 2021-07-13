package com.builders.editorx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.builders.editorx.activities.FileSelectionActivity;
import com.builders.editorx.activities.FileViewerActivity;
import com.builders.editorx.activities.WebViewrActivity;
import com.builders.editorx.callbacks.BottomSheetCallBack;
import com.builders.editorx.constants.CodeConstants;
import com.builders.editorx.customes.FileBottomSheetDialog;
import com.builders.editorx.customes.LineEditText;
import com.builders.editorx.modal.TagModel;
import com.builders.editorx.utils.FileUtils;
import com.builders.editorx.utils.PrefUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements BottomSheetCallBack {

    int FILE_SAVING_CODE = 2000;
    LineEditText fileEditText;
    FileBottomSheetDialog fileBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        checkForCurrentFile();
        changeTheColor();
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

    private void changeTheColor() {
        fileEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Spannable inputStr = (Spannable) s;
                for (TagModel tag : CodeConstants.tagList) {
                    final Pattern p = Pattern.compile(tag.getTag());
                    final Matcher matcher = p.matcher(inputStr);
                    while (matcher.find())
                        inputStr.setSpan(new ForegroundColorSpan(tag.getColor()), matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fileEditText.setText(fileEditText.getText().toString() + "");
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
        AppController.removeFile(AppController.currentFilePath);
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
        fileBottomSheetDialog = FileBottomSheetDialog.newInstance(this);
        fileBottomSheetDialog.show(getSupportFragmentManager(), "");
    }

    @Override
    public void openOtherFile(String url) {
        AppController.currentFilePath = url;
        checkForCurrentFile();
    }

    @Override
    public void removeFile(String url) {
        if (AppController.removeFile(url)) {
            fileBottomSheetDialog.dismiss();
            checkForCurrentFile();
        }
    }

    public void setHighLightedText(EditText editText, String textToHighlight) {
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(getResources().getColor(android.R.color.holo_red_dark));
        String tvt = editText.getText().toString();
        int ofe = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(editText.getText());

        for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {
            ofe = tvt.indexOf(textToHighlight, ofs);
            if (ofe == -1)
                break;
            else {
                spannableStringBuilder.setSpan(colorSpan, ofe, ofe + textToHighlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

    }
}