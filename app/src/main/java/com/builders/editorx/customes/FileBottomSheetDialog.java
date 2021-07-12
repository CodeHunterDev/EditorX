package com.builders.editorx.customes;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.builders.editorx.AppController;
import com.builders.editorx.R;
import com.builders.editorx.adapters.BottomSheetDialogAdapter;
import com.builders.editorx.callbacks.BottomSheetAdapterCallBack;
import com.builders.editorx.callbacks.BottomSheetCallBack;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FileBottomSheetDialog extends BottomSheetDialogFragment {

    CardView createNewFile;
    RecyclerView recyclerView;
    BottomSheetDialogAdapter bottomSheetDialogAdapter;

    BottomSheetCallBack bottomSheetCallBack;

    public FileBottomSheetDialog(BottomSheetCallBack bottomSheetCallBack) {
        this.bottomSheetCallBack = bottomSheetCallBack;
    }

    public static FileBottomSheetDialog newInstance(BottomSheetCallBack bottomSheetCallBack) {
        FileBottomSheetDialog fragment = new FileBottomSheetDialog(bottomSheetCallBack);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.bottom_dialog_layout, null);
        dialog.setContentView(contentView);
        initView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    private void initView(View contentView) {
        createNewFile = contentView.findViewById(R.id.new_document_cv);
        recyclerView = contentView.findViewById(R.id.recyclerview);
        setRecyclerView();
    }


    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AppController.context));
        bottomSheetDialogAdapter = new BottomSheetDialogAdapter(AppController.context, AppController.currentFileList, new BottomSheetAdapterCallBack() {
            @Override
            public void onFileSelected(String fileUrl) {
                bottomSheetCallBack.openOtherFile(fileUrl);
                dismiss();
            }
        });
        recyclerView.setAdapter(bottomSheetDialogAdapter);
    }
}
