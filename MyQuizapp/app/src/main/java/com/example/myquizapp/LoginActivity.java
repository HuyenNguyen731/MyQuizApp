package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edtGmailLogin, edtPassLogin;
    Button btnDangNhap;
    TextView txt_chua_co_tai_khoan;
//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mapping();

        txt_chua_co_tai_khoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping(){
        edtGmailLogin= (EditText) findViewById(R.id.edtGmailLogin);
        edtPassLogin= (EditText) findViewById(R.id.edtPassLogin);
        btnDangNhap= (Button) findViewById(R.id.btnDangNhap);
        txt_chua_co_tai_khoan= (TextView) findViewById(R.id.txt_chua_co_tai_khoan);
    }

}