package com.example.benjaminbowen.roomdbtest;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outputPhrase;
    Button enterButton;
    EditText enterPhrase;
    Button outputButton;
    Button seeAllButton;
    AppDatabase db;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = findViewById(R.id.enter_button);
        enterPhrase = findViewById(R.id.enter_phrase);
        outputPhrase = findViewById(R.id.output_phrase);
        outputButton = findViewById(R.id.output_button);
        seeAllButton = findViewById(R.id.see_all_button);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "phrases")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: phrase is " + enterPhrase.getText().toString());
                Phrase phrase = new Phrase(enterPhrase.getText().toString());
                db.phraseDao().insertAll(phrase);

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                enterPhrase.getText().clear();
            }
        });

        outputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastPhrase = db.phraseDao().getLastWord().getWords();
                Log.d(TAG, "onClick: output: " + lastPhrase);
                outputPhrase.setText(lastPhrase);
            }
        });
    }

    public void seeAllList(View view){

        Intent intent = new Intent(this, FullListActivity.class);
        startActivity(intent);
    }
}
