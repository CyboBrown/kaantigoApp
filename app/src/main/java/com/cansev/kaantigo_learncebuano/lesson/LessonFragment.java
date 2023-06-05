package com.cansev.kaantigo_learncebuano.lesson;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.R;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LessonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LessonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LessonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LessonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LessonFragment newInstance(String param1, String param2) {
        LessonFragment fragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    MaterialCardView btn_finish;

    private String selectedTheme;

    private boolean isCompleted;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        applyTheme(view);
        btn_finish = view.findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(view1 -> {
            getParentFragmentManager().popBackStack();
            //TODO: unlock other lesson and quiz
            SharedPreferences.Editor editor = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
            editor.putBoolean("isLessonCaseMarkersCompleted", true);
            editor.apply();
        });
        return view;
    }

    private void applyTheme(View view) {
        TextView topicName = view.findViewById(R.id.topicName);
        FrameLayout frameLayout = view.findViewById(R.id.frameLayout);
        TextView tvLessonTitle1 = view.findViewById(R.id.tvLessonTitle1);
        TextView tvLessonBody1 = view.findViewById(R.id.tvLessonBody1);
        TableRow tableRow1 = view.findViewById(R.id.tableRow1);

        TextView tvLessonTitle2 = view.findViewById(R.id.tvLessonTitle2);
        TextView tvLessonBody2 = view.findViewById(R.id.tvLessonBody2);
        TableRow tableRow2 = view.findViewById(R.id.tableRow2);

        TextView tvLessonTitle3 = view.findViewById(R.id.tvLessonTitle3);
        TextView tvLessonBody3 = view.findViewById(R.id.tvLessonBody3);
        TableRow tableRow3 = view.findViewById(R.id.tableRow3);

        View divider = view.findViewById(R.id.divider);

        MaterialCardView btn_finish = view.findViewById(R.id.btn_finish);
        TextView txtFinish = view.findViewById(R.id.txtFinish);

        switch (selectedTheme) {
            case "theme1":
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));

                topicName.setTextColor(Color.WHITE);
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));

                tvLessonTitle1.setTextColor(Color.WHITE);
                tvLessonBody1.setTextColor(Color.WHITE);
                tableRow1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));

                tvLessonTitle2.setTextColor(Color.WHITE);
                tvLessonBody2.setTextColor(Color.WHITE);
                tableRow2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));

                tvLessonTitle3.setTextColor(Color.WHITE);
                tvLessonBody3.setTextColor(Color.WHITE);
                tableRow3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));

                btn_finish.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                txtFinish.setTextColor(Color.WHITE);
                break;
            case "theme3":
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));

                topicName.setTextColor(Color.WHITE);
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));

                tvLessonTitle1.setTextColor(Color.WHITE);
                tvLessonBody1.setTextColor(Color.WHITE);
                tableRow1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));

                tvLessonTitle2.setTextColor(Color.WHITE);
                tvLessonBody2.setTextColor(Color.WHITE);
                tableRow2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));

                tvLessonTitle3.setTextColor(Color.WHITE);
                tvLessonBody3.setTextColor(Color.WHITE);
                tableRow3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));

                btn_finish.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                txtFinish.setTextColor(Color.WHITE);
                break;
            case "theme4":
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));

                topicName.setTextColor(Color.WHITE);
                frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));

                tvLessonTitle1.setTextColor(Color.WHITE);
                tvLessonBody1.setTextColor(Color.WHITE);
                tableRow1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));

                tvLessonTitle2.setTextColor(Color.WHITE);
                tvLessonBody2.setTextColor(Color.WHITE);
                tableRow2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));

                tvLessonTitle3.setTextColor(Color.WHITE);
                tvLessonBody3.setTextColor(Color.WHITE);
                tableRow3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));

                btn_finish.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                txtFinish.setTextColor(Color.WHITE);
                break;
        }
    }
}