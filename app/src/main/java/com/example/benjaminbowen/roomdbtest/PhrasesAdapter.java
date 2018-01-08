package com.example.benjaminbowen.roomdbtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjaminbowen on 07/01/2018.
 */

public class PhrasesAdapter extends ArrayAdapter<Phrase> {

    public PhrasesAdapter(Context context, ArrayList<Phrase> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_item, parent, false);
        }


        Phrase currentPhrase = getItem(position);

        TextView listItem = listItemView.findViewById(R.id.list_item);
        listItem.setText(currentPhrase.getWords());

        return listItemView;

    }




}