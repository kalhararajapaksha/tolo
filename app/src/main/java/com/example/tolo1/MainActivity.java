package com.example.tolo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private androidx.appcompat.widget.AppCompatButton signin;
    private Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin=(androidx.appcompat.widget.AppCompatButton) findViewById(R.id.signin);
        signupbtn =(Button) findViewById(R.id.signupbtn);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this,signin.class);
                startActivity(i);
                finish();
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this,signup.class);
                startActivity(i);
            }
        });


}