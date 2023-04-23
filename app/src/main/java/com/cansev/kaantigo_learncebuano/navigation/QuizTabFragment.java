package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.quiz.QuizActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizTabFragment extends Fragment implements View.OnClickListener  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizTabFragment newInstance(String param1, String param2) {
        QuizTabFragment fragment = new QuizTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    CardView card_quiz1;

    LinearLayout cardop_quiz1;

    ImageView expand_card;

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_tab, container, false);

        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);

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
        System.out.println("Clicked");
        switch (view.getId()) {
            case R.id.card_quiz1:
                cardop_quiz1 = view.findViewById(R.id.cardop_lesson1);
                expand_card = view.findViewById(R.id.expand_card);
                btn1 = btn1.findViewById(R.id.btn1);
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
}