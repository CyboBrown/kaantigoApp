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
import com.cansev.kaantigo_learncebuano.database.Term;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchTabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchTabFragment newInstance(String param1, String param2) {
        SearchTabFragment fragment = new SearchTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    SearchView searchView;
    RecyclerView rvSearchResults;
    SearchResultAdapter adapter;
    List<Term> data;
    DatabaseAdapter databaseAdapter;
    SwitchMaterial swEnglish, swSQL, swPhonetic;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        adapter = new SearchResultAdapter();
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
                    adapter.notifyDataSetChanged();
                }
                return true;
            }
        });

        return view;
    }
}