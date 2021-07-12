package com.builders.editorx.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.builders.editorx.BuildConfig;
import com.builders.editorx.FileUtils.FileConstants;
import com.builders.editorx.FileUtils.FileOperations;
import com.builders.editorx.callbacks.OnClick;
import com.builders.editorx.R;
import com.builders.editorx.adapters.FileAdapter;
import com.builders.editorx.customes.CreateFolderDialog;

import java.io.File;
import java.util.List;

public class FileViewerActivity extends AppCompatActivity implements OnClick, View.OnClickListener, CreateFolderDialog.DialogClick {


    public static String SELECTED_FILE_PATH = "SELECTED_FILE_PATH";

    public enum ACTION {COPY, MOVE, NONE}

    private static final String TAG = "FileActivity";

    TextView toolbarTitle;
    LinearLayout noFileLayoutLL;
    ImageView backArrow;
    ImageView createNewFolder;
    ImageView selectPathIv;

    RecyclerView fileRecyclerView;
    FileAdapter fileAdapter;

    List<File> fileList;

    boolean[] selectedPositions;

    private String currentPath = FileConstants.HOME_DIRECTORY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_viewer);
        getSupportActionBar().hide();
        init();
        initializeFileManager(FileConstants.HOME_DIRECTORY);
    }


    private void init() {
        fileRecyclerView = findViewById(R.id.file_recyclerview);
        toolbarTitle = findViewById(R.id.toolbar_title_tv);
        backArrow = findViewById(R.id.back_arrow_iv);
        createNewFolder = findViewById(R.id.create_folder_iv);
        noFileLayoutLL = findViewById(R.id.no_file_layout_ll);
        selectPathIv = findViewById(R.id.select_iv);

        backArrow.setOnClickListener(this);
        createNewFolder.setOnClickListener(this);
        selectPathIv.setOnClickListener(this);


        setRecyclerView();
        setToolbar();
    }

    private void hideList() {
        fileRecyclerView.setVisibility(View.GONE);
        noFileLayoutLL.setVisibility(View.VISIBLE);
    }

    private void showList() {
        noFileLayoutLL.setVisibility(View.GONE);
        fileRecyclerView.setVisibility(View.VISIBLE);
    }

    private void setToolbar() {
        if (currentPath.equals(FileConstants.HOME_DIRECTORY)) {
            toolbarTitle.setText(getResources().getString(R.string.home));
        } else {
            toolbarTitle.setText(FileOperations.getFileName(currentPath));
        }
    }

    private void setRecyclerView() {
        fileRecyclerView.setHasFixedSize(true);
        fileRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeFileManager(String path) {
        fileList = FileOperations.getFiles(path);
        if (fileList != null && fileList.size() > 0) {
            setFileSelection();
            fileAdapter = new FileAdapter(fileList, this, this, selectedPositions);
            fileRecyclerView.setAdapter(fileAdapter);
            showList();
        } else {
            hideList();
        }
    }

    private void setFileSelection() {
        selectedPositions = new boolean[fileList.size()];
        for (int i = 0; i < fileList.size(); i++)
            selectedPositions[i] = false;
    }

    @Override
    public void OnItemClick(int position) {
        if (fileList.get(position).isDirectory()) {
            currentPath = FileOperations.goToNextFolder(fileList.get(position), currentPath);
            initializeFileManager(currentPath);
            setToolbar();
        } else {
            openFile(fileList.get(position));
        }
    }

    private void openFile(File file) {
        Uri uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, file);
        String mime = getContentResolver().getType(uri);

        // Open file with user selected app
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, mime);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    @Override
    public void OnItemLongClick(boolean[] selectedPositions) {
        this.selectedPositions = selectedPositions;
        checkForSelection();
    }

    private void checkForSelection() {
        boolean isSelected = false;
        for (int i = 0; i < selectedPositions.length; i++) {
            if (selectedPositions[i]) {
                isSelected = true;
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_arrow_iv: {
                handleOnBackPressed();
            }
            break;
            case R.id.create_folder_iv: {
                createFolder();
            }
            break;
            case R.id.select_iv: {
                addFileToCurrentPath();
            }
            break;
        }
    }

    private void addFileToCurrentPath() {
        CreateFolderDialog createFolderDialog = new CreateFolderDialog(this, this, true);
        createFolderDialog.show();
    }


    private void createFolder() {
        CreateFolderDialog createFolderDialog = new CreateFolderDialog(this, this, false);
        createFolderDialog.show();
    }

    private void handleOnBackPressed() {
        if (currentPath.equals(FileConstants.HOME_DIRECTORY)) {
            setResult(Activity.RESULT_CANCELED);
            super.onBackPressed();
        } else {
            currentPath = FileOperations.goToBackFolder(currentPath);
            setFileSelection();
            initializeFileManager(currentPath);
            setToolbar();
        }
    }

    @Override
    public void onBackPressed() {
        handleOnBackPressed();
    }

    @Override
    public void onCreateClick(String fileName, boolean isFile) {
        if (isFile) {
            Intent intent = new Intent();
            intent.putExtra(SELECTED_FILE_PATH, currentPath + File.separator + fileName);
            setResult(Activity.RESULT_OK , intent);
            finish();
        } else {
            FileOperations.createNewFolder(currentPath, fileName);
            initializeFileManager(currentPath);
        }
    }

}