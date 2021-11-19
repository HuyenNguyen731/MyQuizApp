package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText edtHo, edtTen,edtGmail, edtPass, edtRePass;
    Button btnDangKy;
    TextView txt_dang_ky_3;
//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mapping();

        txt_dang_ky_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void mapping(){
        edtHo= (EditText) findViewById(R.id.edtHo);
        edtTen= (EditText) findViewById(R.id.edtTen);
        edtGmail= (EditText) findViewById(R.id.edtGmail);
        edtPass= (EditText) findViewById(R.id.edtPass);
        edtRePass= (EditText) findViewById(R.id.edtRePass);
        btnDangKy= (Button) findViewById(R.id.btnDangKy);
        txt_dang_ky_3= (TextView) findViewById(R.id.txt_dang_ky_3);
    }
}