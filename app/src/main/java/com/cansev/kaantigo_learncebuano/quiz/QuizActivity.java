package com.cansev.kaantigo_learncebuano.quiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    private TextView description, question;

    MaterialCardView card_option1, card_option2, card_option3, card_option4;
    MaterialCardView card_next_btn;

    TextView option1, option2, option3, option4, next_btn;

    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private ColorStateList textColorDefaultCd;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    private List<QuestionSet> questionSets;

    private ProgressBar progressBar;
    private int progressBarMax;

    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView timer = findViewById(R.id.timer);

        description = findViewById(R.id.description);
        question = findViewById(R.id.question);

        card_option1 = findViewById(R.id.card_option1);
        card_option2 = findViewById(R.id.card_option2);
        card_option3 = findViewById(R.id.card_option3);
        card_option4 = findViewById(R.id.card_option4);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        card_next_btn = findViewById(R.id.card_next_btn);
        next_btn = card_next_btn.findViewById(R.id.next_btn);

        timerTextView = findViewById(R.id.timer);
        timeLeftInMillis = 20000; // 20 seconds

        ImageView quiz_back = findViewById(R.id.quiz_back);
        quiz_back.setOnClickListener(view -> {
            finish();
        });

        // Get questions list based on selectedTopicName
        questionSets = QuestionsBank.getQuestions("caseMarkers");


        progressBar = findViewById(R.id.pb_quiz_active);
        progressBarMax = questionSets.size() * 10;
        progressBar.setMax(progressBarMax);

        startTimer();
        description.setText(questionSets.get(0).getDescription());
        question.setText(questionSets.get(0).getQuestion());
        if(questionSets.get(0) instanceof MultipleChoice) {
            option1.setText(((MultipleChoice) questionSets.get(0)).getOption1());
            option2.setText(((MultipleChoice) questionSets.get(0)).getOption2());
            option3.setText(((MultipleChoice) questionSets.get(0)).getOption3());
            option4.setText(((MultipleChoice) questionSets.get(0)).getOption4());
        }

        card_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option1.getText().toString();
                    option1.setTextColor(Color.RED);
                    revealAnswer();
                    ((MultipleChoice) questionSets.get(currentQuestionPosition)).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        card_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option2.getText().toString();
                    option2.setTextColor(Color.RED);
                    revealAnswer();
                    ((MultipleChoice) questionSets.get(currentQuestionPosition)).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        card_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option3.getText().toString();
                    option3.setTextColor(Color.RED);
                    revealAnswer();
                    ((MultipleChoice) questionSets.get(currentQuestionPosition)).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        card_option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option4.getText().toString();
                    option4.setTextColor(Color.RED);
                    revealAnswer();
                    ((MultipleChoice) questionSets.get(currentQuestionPosition)).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        card_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    changeNextQuestion();
                }
            }
        });
    }

    private void changeNextQuestion() {
        progressBar.setProgress(progressBar.getProgress() + 10);
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionSets.size()) {
            next_btn.setText("Submit");
        }

        if(currentQuestionPosition < questionSets.size()) {
            selectedOptionByUser = "";

            option1.setTextColor(Color.BLACK);
            option2.setTextColor(Color.BLACK);
            option3.setTextColor(Color.BLACK);
            option4.setTextColor(Color.BLACK);

            description.setText(questionSets.get(currentQuestionPosition).getDescription());
            question.setText(questionSets.get(currentQuestionPosition).getQuestion());
            if(questionSets.get(currentQuestionPosition) instanceof MultipleChoice) {
                option1.setText(((MultipleChoice) questionSets.get(currentQuestionPosition)).getOption1());
                option2.setText(((MultipleChoice) questionSets.get(currentQuestionPosition)).getOption2());
                option3.setText(((MultipleChoice) questionSets.get(currentQuestionPosition)).getOption3());
                option4.setText(((MultipleChoice) questionSets.get(currentQuestionPosition)).getOption4());
            }
        } else {
            submit();
        }
    }

    private int getCorrectAnswers() {
        int correctAnswers = 0;

        for(int i = 0; i < questionSets.size(); i++) {
            final String getUserSelectedAnswer = ((MultipleChoice) questionSets.get(i)).getUserSelectedAnswer();
            final String getAnswer = questionSets.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    private int getInCorrectAnswers() {
        int incorrectAnswers = 0;

        for(int i = 0; i < questionSets.size(); i++) {
            final String getUserSelectedAnswer = ((MultipleChoice) questionSets.get(i)).getUserSelectedAnswer();
            final String getAnswer = questionSets.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)) {
                incorrectAnswers++;
            }
        }

        return incorrectAnswers;
    }

    private void revealAnswer() {
        final String getAnswer = questionSets.get(currentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)) {
            option1.setTextColor(Color.GREEN);
        } else if (option2.getText().toString().equals(getAnswer)) {
            option2.setTextColor(Color.GREEN);
        } else if(option3.getText().toString().equals(getAnswer)) {
            option3.setTextColor(Color.GREEN);
        } else if(option4.getText().toString().equals(getAnswer)) {
            option4.setTextColor(Color.GREEN);
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateTimer();
                submit();
            }
        }.start();
    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        if (timeLeftInMillis < 10000) {
            timerTextView.setTextColor(Color.RED);
        }

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void submit() {
        Intent intent = new Intent(QuizActivity.this, QuizResults.class);
        intent.putExtra("correct", getCorrectAnswers());
        intent.putExtra("incorrect", getInCorrectAnswers());
        startActivity(intent);
        finish();
    }
}