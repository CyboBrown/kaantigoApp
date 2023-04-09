package com.cansev.kaantigo_learncebuano;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    CardView card_flashcards;

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

        card_flashcards = view.findViewById(R.id.card_flashcards);
        card_flashcards.setOnClickListener(this);
        card_flashcards.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("Clicked");
        switch (view.getId()) {
            case R.id.card_flashcards:
                Intent intent = new Intent(getActivity(), FlashcardsActivity.class);
                startActivity(intent);
//            case R.id.card_sentence_constructor:
//                Intent intent = new Intent(getActivity(), SentenceConstructorActivity.class);
//                startActivity(intent);
        }
    }
}