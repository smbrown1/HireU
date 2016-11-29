package com.example.steven.hireu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steven.hireu.Model.Tutor;
import com.example.steven.hireu.Model.UserManager;
import com.example.steven.hireu.Model.UserTypes;

public class TutorRegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText passwordRepeat;
    private EditText major;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_register);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        passwordRepeat = (EditText)findViewById(R.id.passwordRepeat);
        major = (EditText)findViewById(R.id.major);
        name = (EditText)findViewById(R.id.name);
        Button register = (Button)findViewById(R.id.email_sign_in_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().toLowerCase().contains("byu"))
                {
                    Toast.makeText(TutorRegisterActivity.this,"Not a valid university email",Toast.LENGTH_SHORT).show();
                }
                if(passwordRepeat.getText().toString().equals(password.getText().toString())) {
                    Tutor t = new Tutor(email.getText().toString(),
                            name.getText().toString(),
                            password.getText().toString(),
                            UserTypes.TypeOfUser.TUTOR,
                            major.getText().toString());
                    if(UserManager.getInstance().registerTutor(t))
                    {
                        Intent i = new Intent(TutorRegisterActivity.this, ProfileActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(TutorRegisterActivity.this, "Invalid Registration",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(TutorRegisterActivity.this, "Passwords Don't Match",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
