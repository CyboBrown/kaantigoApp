package com.cansev.kaantigo_learncebuano.database;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;
import com.cansev.kaantigo_learncebuano.database.Term;

public class TermDetail extends AppCompatActivity {

    Term termSelected;
    int itemPosition;
    TextView tvCeb, tvPOS, tvPron, tvEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.term_detail);
        termSelected = (Term) getIntent().getSerializableExtra("termSelected");
        itemPosition = getIntent().getIntExtra("itemPosition", 1);
        tvCeb = findViewById(R.id.tvCebuanoWord);
        tvPOS = findViewById(R.id.tvPOS);
        tvPron = findViewById(R.id.tvPronunciation);
        tvEng = findViewById(R.id.tvEnglishWord);
        tvCeb.setText(termSelected.getWritten_form());
        tvPOS.setText(termSelected.getPos());
        tvPron.setText(termSelected.getWord_ceb());
        tvEng.setText(termSelected.getWord_en());
    }
}
