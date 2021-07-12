package com.builders.editorx.database;



import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.builders.editorx.AppController;
import com.builders.editorx.modal.FileModel;

@Database(entities = {FileModel.class}, version = 1)
abstract public class FileDatabase extends RoomDatabase {

    public abstract FileDao getDao();

    private static FileDatabase instance;

    public static FileDatabase getInstance() {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(AppController.context, FileDatabase.class, "com.builders.editorx")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
