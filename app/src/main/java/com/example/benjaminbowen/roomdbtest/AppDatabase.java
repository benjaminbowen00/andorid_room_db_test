package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by benjaminbowen on 07/01/2018.
 */




@Database(entities = {Phrase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PhraseDao phraseDao();
}