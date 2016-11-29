package com.example.steven.hireu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.steven.hireu.Model.Tutor;
import com.example.steven.hireu.Model.UserManager;

public class ProfileActivity extends AppCompatActivity {

    Tutor currentTutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        currentTutor = (Tutor) UserManager.getInstance().getCurrentUser();
        TextView name = (TextView)findViewById(R.id.textView);
        TextView major = (TextView)findViewById(R.id.textView2);

        name.setText("Name: "+currentTutor.getName());
        major.setText("Major: "+currentTutor.getMajor());

    }
}
