package com.builders.editorx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.builders.editorx.R;
import com.builders.editorx.callbacks.BottomSheetAdapterCallBack;
import com.builders.editorx.modal.FileModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BottomSheetDialogAdapter extends RecyclerView.Adapter<BottomSheetDialogAdapter.ViewHolder> {

    Context context;
    List<FileModel> fileModelList;
    BottomSheetAdapterCallBack bottomSheetAdapterCallBack;

    public BottomSheetDialogAdapter(Context context, List<FileModel> fileModelList, BottomSheetAdapterCallBack bottomSheetAdapterCallBack) {
        this.context = context;
        this.fileModelList = fileModelList;
        this.bottomSheetAdapterCallBack = bottomSheetAdapterCallBack;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_dialog_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BottomSheetDialogAdapter.ViewHolder holder, int position) {
        FileModel singleFile = fileModelList.get(position);
        holder.filePath.setText(singleFile.getFileUrl());
        holder.fileName.setText(singleFile.getFileName());
        holder.itemView.setOnClickListener(v -> {
            bottomSheetAdapterCallBack.onFileSelected(singleFile.getFileUrl());
        });
    }

    @Override
    public int getItemCount() {
        return fileModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fileName;
        TextView filePath;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.file_name_tv);
            filePath = itemView.findViewById(R.id.file_path_tv);
        }
    }
}
