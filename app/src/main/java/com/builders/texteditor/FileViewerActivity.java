package com.builders.texteditor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileViewerActivity extends AppCompatActivity {

    private static final String TAG = "FileActivity";

    TextView toolbarTitle;
    LinearLayout bottomBarLL;
    LinearLayout confirmationControllerLL;
    LinearLayout actionControllerLL;
    LinearLayout noFileLayoutLL;
    ImageView backArrow;
    ImageView createNewFolder;
    AppCompatImageView deleteIv;
    AppCompatImageView copyIv;
    AppCompatImageView cutIv;
    AppCompatImageView shareIv;
    AppCompatImageView moreIv;
    AppCompatImageView cancelIv;
    AppCompatImageView pasteIV;


    RecyclerView fileRecyclerView;
    FileAdapter fileAdapter;

    List<File> fileList;
    List<File> copyOrMoveFileList = new ArrayList<>();

    boolean[] selectedPositions;
    ACTION copyOrCutAction = ACTION.NONE;

    private String currentPath = FileConstants.HOME_DIRECTORY;
    private final int STORAGE_PERMISSION_CODE = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_viewer);
    }
}