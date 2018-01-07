package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by benjaminbowen on 07/01/2018.
 */

@Dao
public interface PhraseDao {

    @Query("SELECT * FROM phrases ORDER BY words COLLATE NOCASE DESC LIMIT 1")
    Phrase getLastWord();


    @Insert
    void insertAll(Phrase... phrases);


}
