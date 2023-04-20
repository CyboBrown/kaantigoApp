package com.cansev.kaantigo_learncebuano;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowTerm extends Activity {
    public ShowTerm() {
        // Required empty public constructor
    }
    DatabaseAdapter databaseAdapter;
    RecyclerView rvTerms;
    TermAdapter termAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Term> termList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_term);
        String termStartsWith = getIntent().getStringExtra("termStartsWith");
        databaseAdapter = new DatabaseAdapter(this);
        termList = databaseAdapter.getSomeTerms(termStartsWith);
        rvTerms = findViewById(R.id.rvTerms);
        rvTerms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvTerms.setLayoutManager(layoutManager);
        termAdapter = new TermAdapter(this, termList, rvTerms);
        rvTerms.setAdapter(termAdapter);
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        String termStartsWith = getActivity().getIntent().getStringExtra("termStartsWith");
//        databaseAdapter = new DatabaseAdapter(getContext());
//        termList = databaseAdapter.getSomeTerms(termStartsWith);
//        layoutManager = new LinearLayoutManager(getContext());
//        rvTerms.setLayoutManager(layoutManager);
//        termAdapter = new TermAdapter(getContext(), termList, rvTerms);
//        rvTerms.setAdapter(termAdapter);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.show_term, container, false);
//        rvTerms = view.findViewById(R.id.rvTerms);
//        rvTerms.setHasFixedSize(true);
//        return view;
//    }
}
