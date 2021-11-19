package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnPlayAgain, btnRank;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initUi();

        Intent intent = getIntent();
        String noiDung = intent.getStringExtra("Score");
        score.setText(noiDung);

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, LevelActivity.class);
                startActivity(intent);
                ResultActivity.this.finish();
            }
        });

        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initUi() {
        btnPlayAgain = findViewById(R.id.btn_playagain);
        btnRank      = findViewById(R.id.btn_Rank);
        score        = findViewById(R.id.tv_diem);
    }
}