package com.cansev.kaantigo_learncebuano.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");

        applyTheme();

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
                    card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wrongAnswer));
                    option1.setTextColor(Color.WHITE);
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
                    card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wrongAnswer));
                    option2.setTextColor(Color.WHITE);
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
                    card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wrongAnswer));
                    option3.setTextColor(Color.WHITE);
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
                    card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wrongAnswer));
                    option4.setTextColor(Color.WHITE);
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

            if(selectedTheme.equals("theme1")) {
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                option1.setTextColor(Color.WHITE);

                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                option2.setTextColor(Color.WHITE);

                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                option3.setTextColor(Color.WHITE);

                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                option4.setTextColor(Color.WHITE);
            } else if(selectedTheme.equals("theme3")) {
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                option1.setTextColor(Color.WHITE);

                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                option2.setTextColor(Color.WHITE);

                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                option3.setTextColor(Color.WHITE);

                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                option4.setTextColor(Color.WHITE);
            } else if(selectedTheme.equals("theme4")) {
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                option1.setTextColor(Color.WHITE);

                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                option2.setTextColor(Color.WHITE);

                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                option3.setTextColor(Color.WHITE);

                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                option4.setTextColor(Color.WHITE);
            }else {
                card_option1.setCardBackgroundColor(Color.WHITE);
                option1.setTextColor(Color.BLACK);

                card_option2.setCardBackgroundColor(Color.WHITE);
                option2.setTextColor(Color.BLACK);

                card_option3.setCardBackgroundColor(Color.WHITE);
                option3.setTextColor(Color.BLACK);

                card_option4.setCardBackgroundColor(Color.WHITE);
                option4.setTextColor(Color.BLACK);
            }


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
            card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.correctAnswer));
            option1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAnswer)) {
            card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.correctAnswer));
            option2.setTextColor(Color.WHITE);
        } else if(option3.getText().toString().equals(getAnswer)) {
            card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.correctAnswer));
            option3.setTextColor(Color.WHITE);
        } else if(option4.getText().toString().equals(getAnswer)) {
            card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.correctAnswer));
            option4.setTextColor(Color.WHITE);
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
        // Save the progress using SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();

        // If it is case markers

        if(getCorrectAnswers() == questionSets.size()) {
            editor.putBoolean("isQuizCaseMarkersPerfect", true);
            editor.apply();
            finish();
        }

        editor.putBoolean("isQuizCaseMarkersCompleted", true);
        editor.apply();

        finish();
    }

    private String selectedTheme;
    private void applyTheme() {
        RelativeLayout quiz_background = findViewById(R.id.quiz_background);
        TextView quiz_title = findViewById(R.id.quiz_title);
        TextView timer = findViewById(R.id.timer);
        LinearLayout quizPage = findViewById(R.id.quizPage);
        ProgressBar pb_quiz_active = findViewById(R.id.pb_quiz_active);
        MaterialCardView card_question = findViewById(R.id.card_question);
        TextView description = findViewById(R.id.description);
        TextView question = findViewById(R.id.question);

        MaterialCardView card_option1 = findViewById(R.id.card_option1);
        MaterialCardView card_option2 = findViewById(R.id.card_option2);
        MaterialCardView card_option3 = findViewById(R.id.card_option3);
        MaterialCardView card_option4 = findViewById(R.id.card_option4);
        MaterialCardView card_next_btn = findViewById(R.id.card_next_btn);

        TextView option1 = findViewById(R.id.option1);
        TextView option2 = findViewById(R.id.option2);
        TextView option3 = findViewById(R.id.option3);
        TextView option4 = findViewById(R.id.option4);
        TextView next_btn = findViewById(R.id.next_btn);

        ImageView quiz_back = findViewById(R.id.quiz_back);
        ImageView timerLogo = findViewById(R.id.timerLogo);

        switch (selectedTheme) {
            case "theme1":
                quiz_background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                quiz_title.setTextColor(Color.WHITE);
                timer.setTextColor(Color.WHITE);
                quizPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkBlack));
                pb_quiz_active.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

                card_question.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                description.setTextColor(Color.WHITE);
                question.setTextColor(Color.WHITE);
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));
                card_next_btn.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlack));

                option1.setTextColor(Color.WHITE);
                option2.setTextColor(Color.WHITE);
                option3.setTextColor(Color.WHITE);
                option4.setTextColor(Color.WHITE);
                next_btn.setTextColor(Color.WHITE);
                quiz_back.setColorFilter(Color.WHITE);
                timerLogo.setColorFilter(Color.WHITE);

                break;
            case "theme3":
                quiz_background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                quiz_title.setTextColor(Color.WHITE);
                timer.setTextColor(Color.WHITE);
                quizPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenDark));
                pb_quiz_active.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

                card_question.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                description.setTextColor(Color.WHITE);
                question.setTextColor(Color.WHITE);
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));
                card_next_btn.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightGreenLight));

                option1.setTextColor(Color.WHITE);
                option2.setTextColor(Color.WHITE);
                option3.setTextColor(Color.WHITE);
                option4.setTextColor(Color.WHITE);
                next_btn.setTextColor(Color.WHITE);
                quiz_back.setColorFilter(Color.WHITE);
                timerLogo.setColorFilter(Color.WHITE);

                break;
            case "theme4":
                quiz_background.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                quiz_title.setTextColor(Color.WHITE);
                timer.setTextColor(Color.WHITE);
                quizPage.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueDark));
                pb_quiz_active.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

                card_question.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                description.setTextColor(Color.WHITE);
                question.setTextColor(Color.WHITE);
                card_option1.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_option2.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_option3.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_option4.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));
                card_next_btn.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightBlueLight));

                option1.setTextColor(Color.WHITE);
                option2.setTextColor(Color.WHITE);
                option3.setTextColor(Color.WHITE);
                option4.setTextColor(Color.WHITE);
                next_btn.setTextColor(Color.WHITE);
                quiz_back.setColorFilter(Color.WHITE);
                timerLogo.setColorFilter(Color.WHITE);

                break;
        }
    }
}