package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjaminbowen on 07/01/2018.
 */

@Dao
public interface PhraseDao {

    @Query("SELECT * FROM phrases ORDER BY words COLLATE NOCASE DESC LIMIT 1")
    Phrase getLastWord();

    @Query("SELECT * FROM phrases ORDER BY words")
    List<Phrase> getAllPhrases();


    @Insert
    void insertAll(Phrase... phrases);


}
