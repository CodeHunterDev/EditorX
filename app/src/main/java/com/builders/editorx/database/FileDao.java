package com.builders.editorx.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.builders.editorx.modal.FileModel;

import java.util.List;

@Dao
public interface FileDao {

    @Insert
    public void insert(FileModel fileModel);

    @Insert
    public void batchInsert(List<FileModel> fileModelList);

    @Delete
    public void delete(FileModel fileModel);

    @Update
    public void update(FileModel fileModel);

    @Query("SELECT * FROM file_table")
    public List<FileModel> getList();

    @Delete
    public void batchDelete(List<FileModel> fileModelList);

    @Query("DELETE FROM file_table")
    public void deleteAll();

}
