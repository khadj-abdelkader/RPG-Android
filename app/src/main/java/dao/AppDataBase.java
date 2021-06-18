package dao;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import rpg.heros.HeroStorage;

@Database(entities = {HeroStorage.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "heroes-db";

    private static volatile AppDataBase appDataBase;

    public static synchronized AppDataBase getInstance(Context context) {
        if (appDataBase == null) {
            appDataBase = create(context);
        }
        return appDataBase;
    }

    private static AppDataBase create(final Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, AppDataBase.DATABASE_NAME).build();
    }

    public abstract HeroStorageDao heroStorageDao();

}
