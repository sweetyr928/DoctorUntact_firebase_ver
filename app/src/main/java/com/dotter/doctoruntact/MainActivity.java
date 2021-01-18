package com.dotter.doctoruntact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //check if user is null

        if (firebaseUser != null) {
            Intent intent = new Intent(com.dotter.doctoruntact.MainActivity.this, com.dotter.doctoruntact.StartActivity.class);
            startActivity(intent);
            finish();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.lgn);
        register = findViewById(R.id.reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.dotter.doctoruntact.MainActivity.this, com.dotter.doctoruntact.LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.dotter.doctoruntact.MainActivity.this, com.dotter.doctoruntact.RegisterActivity.class));
            }
        });
    }
    //메인메뉴(버튼 두개)
}
