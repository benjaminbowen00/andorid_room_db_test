package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FullListActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_list);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"phrases")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        List<Phrase> phrasesList = db.phraseDao().getAllPhrases();

        ArrayList<Phrase> phrases = (ArrayList)phrasesList;


        PhrasesAdapter phrasesAdapter = new PhrasesAdapter(this, phrases);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(phrasesAdapter);


    }
}
