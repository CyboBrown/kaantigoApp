package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
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

import com.cansev.kaantigo_learncebuano.lesson.LessonFragment;
import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.lesson.DemonstrativePronounTableFragment;
import com.cansev.kaantigo_learncebuano.lesson.PersonalPronounTableFragment;
import com.google.android.material.chip.Chip;

public class LessonTabFragment extends Fragment implements View.OnClickListener {

    public LessonTabFragment() {
        // Required empty public constructor
    }

    CardView card_lesson1;
    Chip chip_personal_pronouns;
    Chip chip_demonstrative_pronouns;
    Button btn_basic1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson_tab, container, false);

        card_lesson1 = view.findViewById(R.id.card_flashcards);
        chip_personal_pronouns = view.findViewById(R.id.chip_personal_pronouns);
        chip_demonstrative_pronouns = view.findViewById(R.id.chip_demonstrative_pronouns);
        btn_basic1 = view.findViewById(R.id.btn_pref_themes);

        card_lesson1.setOnClickListener(this);
        chip_personal_pronouns.setOnClickListener(this);
        chip_demonstrative_pronouns.setOnClickListener(this);
        btn_basic1.setOnClickListener(this);

        card_lesson1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        ProgressBar pb_lesson1 = view.findViewById(R.id.pb_lesson1);
        pb_lesson1.setProgress(50, true);
        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("Clicked");
        switch (view.getId()) {
            case R.id.card_flashcards:
                LinearLayout cardop_lesson1 = view.findViewById(R.id.cardop_lesson1);
                ImageView expand_card = view.findViewById(R.id.expand_card);
                if (cardop_lesson1.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(card_lesson1, new AutoTransition());
                    cardop_lesson1.setVisibility(View.VISIBLE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(),R.drawable.ic_expand_less));
                } else {
                    TransitionManager.beginDelayedTransition(card_lesson1, new ChangeClipBounds());
                    cardop_lesson1.setVisibility(View.GONE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(),R.drawable.ic_expand_more));
                }
                break;
            case R.id.chip_personal_pronouns:
                getParentFragmentManager().beginTransaction().replace(R.id.container, new PersonalPronounTableFragment()).addToBackStack(null).commit();
                break;
            case R.id.chip_demonstrative_pronouns:
                getParentFragmentManager().beginTransaction().replace(R.id.container, new DemonstrativePronounTableFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_pref_themes:
                getParentFragmentManager().beginTransaction().replace(R.id.container, new LessonFragment()).addToBackStack(null).commit();
                break;
        }
    }
}