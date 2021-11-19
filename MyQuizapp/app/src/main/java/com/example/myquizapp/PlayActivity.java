package com.example.myquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvNumberQuestion;
    private TextView tvContentQuestion;
    private TextView tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private TextView timer;
    private CountDownTimer countDown;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private int counter = 0;
    private int correctAns;
    private List<Question> mListQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        initUi();

        getListQuestionFromFirebase();
    }

    private void initUi() {
        tvNumberQuestion  = findViewById(R.id.tv_number_question);
        tvContentQuestion = findViewById(R.id.tv_content_question);
        tvAnswer1         = findViewById(R.id.tv_answer1);
        tvAnswer2         = findViewById(R.id.tv_answer2);
        tvAnswer3         = findViewById(R.id.tv_answer3);
        tvAnswer4         = findViewById(R.id.tv_answer4);
        timer             = findViewById(R.id.tv_timer);
    }

    private void setDataQuestion() {
            timer.setText(String.valueOf(10));
            Question currentQuestion = mListQuestion.get(currentQuestionIndex);
            if (currentQuestion == null) {
                return;
            }

            correctAns = currentQuestion.getCorrectAnswer();

            tvAnswer1.setBackgroundResource(R.drawable.bg_blue_conner_30);
            tvAnswer2.setBackgroundResource(R.drawable.bg_blue_conner_30);
            tvAnswer3.setBackgroundResource(R.drawable.bg_blue_conner_30);
            tvAnswer4.setBackgroundResource(R.drawable.bg_blue_conner_30);

            tvNumberQuestion.setText("Question " + Integer.toString(currentQuestion.getNumber()));
            tvContentQuestion.setText(currentQuestion.getQuestion());
            tvAnswer1.setText(currentQuestion.getAnswer1());
            tvAnswer2.setText(currentQuestion.getAnswer2());
            tvAnswer3.setText(currentQuestion.getAnswer3());
            tvAnswer4.setText(currentQuestion.getAnswer4());

            tvAnswer1.setOnClickListener(this);
            tvAnswer2.setOnClickListener(this);
            tvAnswer3.setOnClickListener(this);
            tvAnswer4.setOnClickListener(this);

            startTimer();
    }

    private void startTimer() {
         countDown = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 10000)
                timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                nextQuestion();
            }
        };

        countDown.start();
    }

    public void getListQuestionFromFirebase() {

        Intent intent = getIntent();
        String level = intent.getStringExtra("level");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(level);
        ArrayList<Question> listQuestion = new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Question question = dataSnapshot.getValue(Question.class);
                    listQuestion.add(question);
                }
                mListQuestion = listQuestion;
                setDataQuestion();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_answer1:
                tvAnswer1.setBackgroundResource(R.drawable.bg_orange_conner_30);
                int posA = 1;
                correctAns(tvAnswer1, posA);
                break;

            case R.id.tv_answer2:
                tvAnswer2.setBackgroundResource(R.drawable.bg_orange_conner_30);
                int posB = 2;
                correctAns(tvAnswer2, posB);
                break;

            case R.id.tv_answer3:
                tvAnswer3.setBackgroundResource(R.drawable.bg_orange_conner_30);
                int posC = 3;
                correctAns(tvAnswer3, posC);
                break;

            case R.id.tv_answer4:
                tvAnswer4.setBackgroundResource(R.drawable.bg_orange_conner_30);
                int posD = 4;
                correctAns(tvAnswer4, posD);
                break;
        }
        countDown.cancel();
    }

    private void correctAns(TextView textView, int pos) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pos == correctAns) {
                    textView.setBackgroundResource(R.drawable.bg_green_conner_30);
                    score++;

                    nextQuestion();
                } else {
                    textView.setBackgroundResource(R.drawable.bg_red_conner_30);
                    showAnswerCorrect();

                    nextQuestion();
                }
            }
        }, 1000);
    }

    private void showAnswerCorrect() {
        if (1 == correctAns) {
            tvAnswer1.setBackgroundResource(R.drawable.bg_green_conner_30);
        } else if (2 == correctAns) {
            tvAnswer2.setBackgroundResource(R.drawable.bg_green_conner_30);
        } else if (3 == correctAns) {
            tvAnswer3.setBackgroundResource(R.drawable.bg_green_conner_30);
        } else if (4 == correctAns) {
            tvAnswer4.setBackgroundResource(R.drawable.bg_green_conner_30);
        }
    }

    private void nextQuestion() {
        if (currentQuestionIndex == mListQuestion.size() - 1) {
             Intent intent = new Intent(PlayActivity.this, ResultActivity.class);
             intent.putExtra("Score", String.valueOf(score));
             startActivity(intent);
             PlayActivity.this.finish();

        } else {
            currentQuestionIndex++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion();
                }
            }, 1000);
        }
    }

}