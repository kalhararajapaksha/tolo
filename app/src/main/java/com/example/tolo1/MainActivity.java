package com.example.tolo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private androidx.appcompat.widget.AppCompatButton signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin=(androidx.appcompat.widget.AppCompatButton) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                opensignin();
            }
        });
    }
    public void opensignin(){
        Intent intent = new Intent(this,signin.class);
        this.startActivity(intent);
    }


}