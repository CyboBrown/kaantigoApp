package com.cansev.kaantigo_learncebuano.navigation;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.database.DatabaseAdapter;
import com.cansev.kaantigo_learncebuano.database.PreCreateDB;
import com.cansev.kaantigo_learncebuano.database.SearchResultAdapter;
import com.cansev.kaantigo_learncebuano.database.Term;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class SearchTabFragment extends Fragment {

    public SearchTabFragment() {
        // Required empty public constructor
    }

    SearchView searchView;
    RecyclerView rvSearchResults;
    SearchResultAdapter adapter;
    ArrayList<Term> data;
    DatabaseAdapter databaseAdapter;
    SwitchMaterial swEnglish, swSQL, swPhonetic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreCreateDB.copyDB(this.requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);

        databaseAdapter = new DatabaseAdapter(getContext());
        data = new ArrayList<>();
        searchView = view.findViewById(R.id.searchView);
        swEnglish = view.findViewById(R.id.switchEnglish);
        swSQL = view.findViewById(R.id.switchSQL);
        swPhonetic = view.findViewById(R.id.switchPhonetic);
        rvSearchResults = view.findViewById(R.id.rvSearchResults);
        rvSearchResults.setHasFixedSize(true);
        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SearchResultAdapter(getContext(), rvSearchResults);
        rvSearchResults.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                data = databaseAdapter.getSearchResults(query, swEnglish.isChecked(), swSQL.isChecked(), swPhonetic.isChecked());
                adapter.setData(data);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    data.clear();
                } else {
                    data = databaseAdapter.getSearchResults(newText, swEnglish.isChecked(), swSQL.isChecked(), swPhonetic.isChecked());
                    adapter.setData(data);
                }
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        return view;
    }
}