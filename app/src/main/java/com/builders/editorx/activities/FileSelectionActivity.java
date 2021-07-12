package com.builders.editorx.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.builders.editorx.R;

public class FileSelectionActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout newDocumentLL;
    LinearLayout openFromStorageLL;
    LinearLayout openLastEditedLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_selection);
        initViews();
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

    }

    private void selectFromStorageDocument() {

    }

    private void openNewDocument() {

    }
}