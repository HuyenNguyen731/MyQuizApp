package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    private Button btnLevel1, btnLevel2, btnLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        btnLevel1 = findViewById(R.id.btn_level1);
        btnLevel2 = findViewById(R.id.btn_level2);
        btnLevel3 = findViewById(R.id.btn_level3);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, PlayActivity.class);
                intent.putExtra("level", "list_question");
                startActivity(intent);
                LevelActivity.this.finish();
            }
        });

        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, PlayActivity.class);
                intent.putExtra("level", "list_question2");
                startActivity(intent);
                LevelActivity.this.finish();
            }
        });

        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, PlayActivity.class);
                intent.putExtra("level", "list_question3");
                startActivity(intent);
                LevelActivity.this.finish();
            }
        });
    }
}