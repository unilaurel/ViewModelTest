package com.example.roomdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 3, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;

    public static synchronized WordDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
//            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_data").allowMainThreadQueries().build();
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_data")
//                    .fallbackToDestructiveMigration() //破坏式的
                    .addMigrations(MIGRATION_2_3)
                    .build();
        }
        return INSTANCE;
    }

    public abstract WordDao getWordDao();

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTERGER NOT NULL DEFAULT 1");
        }
    };
}
