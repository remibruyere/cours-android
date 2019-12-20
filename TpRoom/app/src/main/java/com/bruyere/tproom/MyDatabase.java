package com.bruyere.tproom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public static MyDatabase INSTANCE;

    public synchronized static MyDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, MyDatabase.class, "my_database").build();
        }
        return INSTANCE;
    }

    public abstract StudentDAO studentDAO();
}
