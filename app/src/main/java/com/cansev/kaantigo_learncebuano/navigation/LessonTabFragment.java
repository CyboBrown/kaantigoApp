package com.cansev.kaantigo_learncebuano.navigation;

import android.animation.LayoutTransition;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.lesson.LessonFragment;
import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.lesson.DemonstrativePronounTableFragment;
import com.cansev.kaantigo_learncebuano.lesson.PersonalPronounTableFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

import org.w3c.dom.Text;

public class LessonTabFragment extends Fragment implements View.OnClickListener {

    public LessonTabFragment() {
        // Required empty public constructor
    }

    CardView card_lesson1;
    Chip chip_personal_pronouns;
    Chip chip_demonstrative_pronouns;
    Button btn_basic1;
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

        applyTheme(view);

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

    private void applyTheme(View view) {
        // Use the saved theme value to update colors
        MaterialCardView materialCardView = view.findViewById(R.id.card_flashcards);
        TextView home = view.findViewById(R.id.home);
        TextView topic = view.findViewById(R.id.topic);
        TextView secondary = view.findViewById(R.id.secondary);
        MaterialButton focusCase = view.findViewById(R.id.btn_pref_themes);
        MaterialButton pronouns = view.findViewById(R.id.btn_pref_achievements);
        MaterialButton nonFocusCases = view.findViewById(R.id.btn_pref_notifications);
        ProgressBar progressBar = view.findViewById(R.id.pb_lesson1);
        View divider = view.findViewById(R.id.divider);
        ImageView expand_card = view.findViewById(R.id.expand_card);

        // Get the drawable for the icon
        Drawable circleCheck = ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_check);
        Drawable circleUncheck = ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_uncheck);
        Drawable current = ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_current);

        switch(selectedTheme) {
            case "theme1":
                // Set colors for theme1
                // ...
                home.setTextColor(Color.WHITE);
                topic.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                focusCase.setTextColor(Color.WHITE);
                pronouns.setTextColor(Color.WHITE);
                nonFocusCases.setTextColor(Color.WHITE);
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                materialCardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                expand_card.setColorFilter(Color.WHITE);

                // Set the desired color on the icon drawable
                int desiredColor = Color.WHITE;
                circleCheck.setColorFilter(desiredColor, PorterDuff.Mode.SRC_IN);
                circleUncheck.setColorFilter(desiredColor, PorterDuff.Mode.SRC_IN);
                current.setColorFilter(desiredColor, PorterDuff.Mode.SRC_IN);


                // Set the modified drawable as the button's icon
                focusCase.setIcon(circleCheck);

                break;

            case "theme3":
                // Set colors for theme1
                // ...
                home.setTextColor(Color.WHITE);
                topic.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                focusCase.setTextColor(Color.WHITE);
                pronouns.setTextColor(Color.WHITE);
                nonFocusCases.setTextColor(Color.WHITE);
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                materialCardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                expand_card.setColorFilter(Color.WHITE);

                // Set the desired color on the icon drawable
                int desiredColor1 = Color.WHITE;
                circleCheck.setColorFilter(desiredColor1, PorterDuff.Mode.SRC_IN);
                circleUncheck.setColorFilter(desiredColor1, PorterDuff.Mode.SRC_IN);
                current.setColorFilter(desiredColor1, PorterDuff.Mode.SRC_IN);


                // Set the modified drawable as the button's icon
                focusCase.setIcon(circleCheck);

                break;

            case "theme4":
                // Set colors for theme1
                // ...
                home.setTextColor(Color.WHITE);
                topic.setTextColor(Color.WHITE);
                secondary.setTextColor(Color.WHITE);
                focusCase.setTextColor(Color.WHITE);
                pronouns.setTextColor(Color.WHITE);
                nonFocusCases.setTextColor(Color.WHITE);
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                materialCardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                expand_card.setColorFilter(Color.WHITE);

                // Set the desired color on the icon drawable
                int desiredColor2 = Color.WHITE;
                circleCheck.setColorFilter(desiredColor2, PorterDuff.Mode.SRC_IN);
                circleUncheck.setColorFilter(desiredColor2, PorterDuff.Mode.SRC_IN);
                current.setColorFilter(desiredColor2, PorterDuff.Mode.SRC_IN);


                // Set the modified drawable as the button's icon
                focusCase.setIcon(circleCheck);

                break;
        }

    }
}