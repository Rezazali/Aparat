package com.navin.aparat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.navin.aparat.models.Video;

@Database(entities = {Video.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase instance = null;

   /* private AppDatabase() {

    }*/

    public abstract IDAO idao();


    public synchronized static AppDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context, AppDatabase.class, "video.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;

    }


}
