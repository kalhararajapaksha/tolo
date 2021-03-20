package com.example.tolo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {

     EditText username1,password1;
     Button signinbtn,gsigninbutton,signupbtn;
     CheckBox checkBox1;
     FirebaseAuth mfirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mfirebaseAuth = FirebaseAuth.getInstance();
        username1= findViewById(R.id.username);
        password1= findViewById(R.id.password);
        signinbtn= findViewById(R.id.signinbtn);
        gsigninbutton= findViewById(R.id.gsigninbutton);
        signupbtn= findViewById(R.id.signupbtn);
        checkBox1= findViewById(R.id.checkBox);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username1.getText().toString();
                String password = password1.getText().toString();
                if ((username.isEmpty())){
                    username1.setError("Please enter Username");
                    username1.requestFocus();
                }
                else if (password.isEmpty()){
                    password1.setError("Please enter password");
                    password1.requestFocus();
                }
                else if(username.isEmpty() && password.isEmpty()) {
                    Toast.makeText(signin.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(username.isEmpty() && password.isEmpty())) {
                    mfirebaseAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(signin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(signin.this, "SignIn Unsusseccfull!, PleaseTryAgain", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(signin.this,MainActivity.class));
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(signin.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}