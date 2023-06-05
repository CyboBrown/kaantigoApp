package com.cansev.kaantigo_learncebuano.navigation;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.database.DatabaseAdapter;
import com.cansev.kaantigo_learncebuano.database.PreCreateDB;
import com.cansev.kaantigo_learncebuano.database.SearchResultAdapter;
import com.cansev.kaantigo_learncebuano.database.Term;
import com.google.android.material.card.MaterialCardView;
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

    private String selectedTheme;

//    TextView tvTerm;
//    TextView tvTermDef;
//    TextView tvTermTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreCreateDB.copyDB(this.requireContext());

        // Get an instance of SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Retrieve the saved theme value from SharedPreferences
        selectedTheme = prefs.getString("selected_theme", "default");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_tab, container, false);
//        View view2 = inflater.inflate(R.layout.search_item, container, false);
//
//        tvTerm = view2.findViewById(R.id.tvTerm);
//        tvTermDef = view2.findViewById(R.id.tvTermDef);
//        tvTermTrans = view2.findViewById(R.id.tvTermTrans);

        applyTheme(view);

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

    private void applyTheme(View view) {
        TextView search = view.findViewById(R.id.search);
        View divider = view.findViewById(R.id.divider);
        MaterialCardView card_flashcards = view.findViewById(R.id.card_flashcards);
        SearchView searchView = view.findViewById(R.id.searchView);
        // Find the EditText view inside the SearchView
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        TextView options = view.findViewById(R.id.options);
        TextView eng = view.findViewById(R.id.eng);
        TextView sql = view.findViewById(R.id.sql);
        TextView phonetic = view.findViewById(R.id.phonetic);
        RecyclerView rvSearchResults = view.findViewById(R.id.rvSearchResults);


        switch(selectedTheme) {
            case "theme1":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                search.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlack));
                searchEditText.setTextColor(Color.WHITE);
                options.setTextColor(Color.WHITE);
                eng.setTextColor(Color.WHITE);
                sql.setTextColor(Color.WHITE);
                phonetic.setTextColor(Color.WHITE);
//                tvTerm.setTextColor(Color.WHITE);
//                tvTermDef.setTextColor(Color.WHITE);
//                tvTermTrans.setTextColor(Color.WHITE);
                //rvSearchResults.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                break;
            case "theme3":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
                search.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
                searchEditText.setTextColor(Color.WHITE);
                options.setTextColor(Color.WHITE);
                eng.setTextColor(Color.WHITE);
                sql.setTextColor(Color.WHITE);
                phonetic.setTextColor(Color.WHITE);
//                tvTerm.setTextColor(Color.WHITE);
//                tvTermDef.setTextColor(Color.WHITE);
//                tvTermTrans.setTextColor(Color.WHITE);
                //rvSearchResults.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                break;
            case "theme4":
                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
                search.setTextColor(Color.WHITE);
                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                card_flashcards.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
                searchEditText.setTextColor(Color.WHITE);
                options.setTextColor(Color.WHITE);
                eng.setTextColor(Color.WHITE);
                sql.setTextColor(Color.WHITE);
                phonetic.setTextColor(Color.WHITE);
//                tvTerm.setTextColor(Color.WHITE);
//                tvTermDef.setTextColor(Color.WHITE);
//                tvTermTrans.setTextColor(Color.WHITE);
                //rvSearchResults.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.darkBlack));
                break;
//            case "theme3":
//                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenDark));
//                textView.setTextColor(Color.WHITE);
//                search.setTextColor(Color.WHITE);
//                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightGreenLight));
//                break;
//            case "theme4":
//                view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueDark));
//                textView.setTextColor(Color.WHITE);
//                search.setTextColor(Color.WHITE);
//                divider.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lightBlueLight));
//                break;
        }
    }
}