package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button btnPlay, btnRank, btnExit;
    TextView tvRegister, tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUi();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });

        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(intent);
                HomeActivity.this.finish();
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                HomeActivity.this.finish();
            }
        });
    }

    public void initUi() {
        btnPlay     = findViewById(R.id.btn_play);
        btnRank     = findViewById(R.id.btn_rank);
        btnExit      = findViewById(R.id.btn_exit);
        tvRegister  = findViewById(R.id.tv_Register);
        tvLogin     = findViewById(R.id.tv_Login);
    }
}