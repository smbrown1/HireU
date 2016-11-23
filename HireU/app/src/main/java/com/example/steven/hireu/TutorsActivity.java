package com.example.steven.hireu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class TutorsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutors);
        searchText = (EditText) findViewById(R.id.searchEdit);
        mRecyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
        searchText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                String searchString = searchText.getText().toString();
               /* String[] relatives = Person.SINGLETON.getSearchRelatives(searchString);
                String[] events = Person.SINGLETON.getSearchEvents(searchString);
                mAdapter = new OtherAdapter(relatives, events, getBaseContext());
                mRecyclerView.setAdapter(mAdapter);*/
            }
        });

    }
}
