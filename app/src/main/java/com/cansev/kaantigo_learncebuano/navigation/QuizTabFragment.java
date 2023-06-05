package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.transition.AutoTransition;
import android.transition.ChangeClipBounds;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.quiz.QuizActivity;
import com.google.android.material.card.MaterialCardView;

public class QuizTabFragment extends Fragment implements View.OnClickListener  {


    public QuizTabFragment() {
        // Required empty public constructor
    }

    CardView card_quiz1;

    LinearLayout cardop_quiz1;

    ImageView expand_card;

    Button btn1;
    Button btn2;
    Button btn3;
    private String selectedTheme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_tab, container, false);
        applyTheme(view);
        btn1 = view.findViewById(R.id.btn_pref_themes);
        btn2 = view.findViewById(R.id.btn_pref_achievements);
        btn3 = view.findViewById(R.id.btn_pref_notifications);

        btn1.setOnClickListener(view1 -> {
            Intent intent1 = new Intent(getActivity(), QuizActivity.class);
            startActivity(intent1);
        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String selectedTopicName = "personalPronouns";
//                Intent intent = new Intent(getActivity(), QuizActivity.class);
//                intent.putExtra("SELECTED_TOPIC_NAME", selectedTopicName);
//                startActivity(intent);
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String selectedTopicName = "demonstrativePronouns";
//                Intent intent = new Intent(getActivity(), QuizActivity.class);
//                intent.putExtra("SELECTED_TOPIC_NAME", selectedTopicName);
//                startActivity(intent);
//            }
//        });

        card_quiz1 = view.findViewById(R.id.card_quiz1);
        card_quiz1.setOnClickListener(this);
        card_quiz1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        ProgressBar pb_quiz1 = view.findViewById(R.id.pb_quiz1);
        pb_quiz1.setProgress(25, true);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_quiz1:
                cardop_quiz1 = view.findViewById(R.id.cardop_lesson1);
                expand_card = view.findViewById(R.id.expand_card);
                btn1 = btn1.findViewById(R.id.btn_pref_themes);
//                TransitionManager.beginDelayedTransition(card_lesson1, new AutoTransition());
                if (cardop_quiz1.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(card_quiz1, new AutoTransition());
                    cardop_quiz1.setVisibility(View.VISIBLE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(), R.drawable.ic_expand_less));
                } else {
                    TransitionManager.beginDelayedTransition(card_quiz1, new ChangeClipBounds());
                    cardop_quiz1.setVisibility(View.GONE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(), R.drawable.ic_expand_more));
                }
        }
    }

    private void applyTheme(View view) {
        TextView quizTab = view.findViewById(R.id.quizTab);
        TextView topicName = view.findViewById(R.id.topicName);
        TextView secondary = view.findViewById(R.id.secondary);
        MaterialCardView card_quiz = view.findViewById(R.id.card_quiz1);
        Button caseMarkers = view.findViewById(R.id.btn_pref_themes);
        Button personalPronouns = view.findViewById(R.id.btn_pref_achievements);
        Button demonstrativePronouns = view.findViewById(R.id.btn_pref_notifications);
        ProgressBar pb_quiz1 = view.findViewById(R.id.pb_quiz1);
        View divider = view.findViewById(R.id.divider);
        ImageView expand_card = view.findViewById(R.id.expand_card);

        switch (selectedTheme) {
            case "theme1":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                quizTab.setTextColor(Color.WHITE);
                topicName.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                card_quiz.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                caseMarkers.setTextColor(Color.WHITE);
                personalPronouns.setTextColor(Color.WHITE);
                demonstrativePronouns.setTextColor(Color.WHITE);
                pb_quiz1.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                expand_card.setColorFilter(Color.WHITE);
                break;
            case "theme3":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                quizTab.setTextColor(Color.WHITE);
                topicName.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                card_quiz.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                caseMarkers.setTextColor(Color.WHITE);
                personalPronouns.setTextColor(Color.WHITE);
                demonstrativePronouns.setTextColor(Color.WHITE);
                pb_quiz1.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                expand_card.setColorFilter(Color.WHITE);
                break;
            case "theme4":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                quizTab.setTextColor(Color.WHITE);
                topicName.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                card_quiz.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                caseMarkers.setTextColor(Color.WHITE);
                personalPronouns.setTextColor(Color.WHITE);
                demonstrativePronouns.setTextColor(Color.WHITE);
                pb_quiz1.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                expand_card.setColorFilter(Color.WHITE);
                break;
        }
    }
}