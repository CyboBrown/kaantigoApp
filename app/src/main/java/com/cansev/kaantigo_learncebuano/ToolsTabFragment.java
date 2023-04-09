package com.cansev.kaantigo_learncebuano;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolsTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolsTabFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ToolsTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolsTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolsTabFragment newInstance(String param1, String param2) {
        ToolsTabFragment fragment = new ToolsTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    CardView card_lesson1;

    LinearLayout cardop_lesson1;

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
        View view = inflater.inflate(R.layout.fragment_tools_tab, container, false);

        btn1 = view.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FlashcardsCaseMarkers.class);
                startActivity(intent);
            }
        });

        card_lesson1 = view.findViewById(R.id.card_lesson1);
        card_lesson1.setOnClickListener(this);
        card_lesson1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("Clicked");
        switch (view.getId()) {
            case R.id.card_lesson1:
                cardop_lesson1 = view.findViewById(R.id.cardop_lesson1);
                expand_card = view.findViewById(R.id.expand_card);
                btn1 = btn1.findViewById(R.id.btn1);
//                TransitionManager.beginDelayedTransition(card_lesson1, new AutoTransition());
                if (cardop_lesson1.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(card_lesson1, new AutoTransition());
                    cardop_lesson1.setVisibility(View.VISIBLE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(), R.drawable.ic_expand_less));
                } else {
                    TransitionManager.beginDelayedTransition(card_lesson1, new ChangeClipBounds());
                    cardop_lesson1.setVisibility(View.GONE);
                    expand_card.setImageIcon(Icon.createWithResource(getActivity(), R.drawable.ic_expand_more));
                }
        }
    }
}