package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by benjaminbowen on 07/01/2018.
 */


@Entity(tableName = "phrases")
public class Phrase {





    public Phrase(String words) {this.words = words;}

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "words")
    private String words;


    public int getId() {
        return id;
    }

    public void setId(int uid) {
        this.id = uid;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
