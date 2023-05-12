package com.cansev.kaantigo_learncebuano.database;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cansev.kaantigo_learncebuano.R;

import java.util.Objects;

public class TermDetailActivity extends AppCompatActivity {

    Term termSelected;
    int itemPosition;
    int aspectCount = 0;
    TextView tvCeb, tvPOS, tvPron, tvEng;
    TableLayout tblConjugation;
    TextView tvTableTitle;
    ImageView aspectNext, aspectPrev;
    TextView tvR0C0, tvR0C1, tvR0C2,
            tvR1C0, tvR1C1, tvR1C2,
            tvR2C0, tvR2C1, tvR2C2,
            tvR3C0, tvR3C1, tvR3C2,
            tvR4C0, tvR4C1, tvR4C2,
            tvR5C0, tvR5C1, tvR5C2,
            tvR6C0, tvR6C1, tvR6C2,
            tvR7C0, tvR7C1, tvR7C2,
            tvR8C0, tvR8C1, tvR8C2,
            tvR9C0, tvR9C1, tvR9C2,
            tvR10C0, tvR10C1, tvR10C2,
            tvR11C0, tvR11C1, tvR11C2,
            tvR12C0, tvR12C1, tvR12C2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
        termSelected = (Term) getIntent().getSerializableExtra("termSelected");
        itemPosition = getIntent().getIntExtra("itemPosition", 1);

        tvCeb = findViewById(R.id.tvCebuanoWord);
        tvPOS = findViewById(R.id.tvPOS);
        tvPron = findViewById(R.id.tvPronunciation);
        tvEng = findViewById(R.id.tvEnglishWord);

        tblConjugation = findViewById(R.id.tblConjugation);
        tvTableTitle = findViewById(R.id.tvTableTitle);

        aspectPrev = findViewById(R.id.aspectPrev);
        aspectNext = findViewById(R.id.aspectNext);

        tvR0C0 = findViewById(R.id.tvR0C0); tvR0C1 = findViewById(R.id.tvR0C1); tvR0C2 = findViewById(R.id.tvR0C2);
        tvR1C0 = findViewById(R.id.tvR1C0); tvR1C1 = findViewById(R.id.tvR1C1); tvR1C2 = findViewById(R.id.tvR1C2);
        tvR2C0 = findViewById(R.id.tvR2C0); tvR2C1 = findViewById(R.id.tvR2C1); tvR2C2 = findViewById(R.id.tvR2C2);
        tvR3C0 = findViewById(R.id.tvR3C0); tvR3C1 = findViewById(R.id.tvR3C1); tvR3C2 = findViewById(R.id.tvR3C2);
        tvR4C0 = findViewById(R.id.tvR4C0); tvR4C1 = findViewById(R.id.tvR4C1); tvR4C2 = findViewById(R.id.tvR4C2);
        tvR5C0 = findViewById(R.id.tvR5C0); tvR5C1 = findViewById(R.id.tvR5C1); tvR5C2 = findViewById(R.id.tvR5C2);
        tvR6C0 = findViewById(R.id.tvR6C0); tvR6C1 = findViewById(R.id.tvR6C1); tvR6C2 = findViewById(R.id.tvR6C2);
        tvR7C0 = findViewById(R.id.tvR7C0); tvR7C1 = findViewById(R.id.tvR7C1); tvR7C2 = findViewById(R.id.tvR7C2);
        tvR8C0 = findViewById(R.id.tvR8C0); tvR8C1 = findViewById(R.id.tvR8C1); tvR8C2 = findViewById(R.id.tvR8C2);
        tvR9C0 = findViewById(R.id.tvR9C0); tvR9C1 = findViewById(R.id.tvR9C1); tvR9C2 = findViewById(R.id.tvR9C2);
        tvR10C0 = findViewById(R.id.tvR10C0); tvR10C1 = findViewById(R.id.tvR10C1); tvR10C2 = findViewById(R.id.tvR10C2);
        tvR11C0 = findViewById(R.id.tvR11C0); tvR11C1 = findViewById(R.id.tvR11C1); tvR11C2 = findViewById(R.id.tvR11C2);
        tvR12C0 = findViewById(R.id.tvR12C0); tvR12C1 = findViewById(R.id.tvR12C1); tvR12C2 = findViewById(R.id.tvR12C2);

        String written_form = termSelected.getWritten_form();
        String affixed_form = Objects.equals(termSelected.getAffixed_form(), "*") ? written_form : termSelected.getAffixed_form();
        String pos = termSelected.getPos();

        tvCeb.setText(written_form);
        tvPOS.setText(pos);
        tvPron.setText("[" + termSelected.getWord_ceb() + "]");
        tvEng.setText(termSelected.getWord_en());

        if(Objects.equals(pos, "verb")) {
            String verb_type = termSelected.getCategory();
            tvR0C2.setText("Actual");
            aspectPrev.setEnabled(false);
            aspectPrev.setVisibility(View.INVISIBLE);
            if(Objects.equals(verb_type, "stative")) {
                tvR1C2.setText("na" + written_form);
                tvR2C2.setText("-");
                tvR3C2.setText("-");
                tvR4C2.setText("gika" + written_form);
                tvR5C2.setText("-");
                tvR6C2.setText("-");
                tvR7C2.setText("gika" + affixed_form + "an");
                tvR8C2.setText("-");
                tvR9C2.setText("-");
                tvR10C2.setText("gika" + written_form);
                tvR11C2.setText("-");
                tvR12C2.setText("-");
            } else if(Objects.equals(verb_type, "distributive")) {
                tvR1C2.setText("n" + written_form.substring(1));
                tvR2C2.setText("nag" + written_form);
                tvR3C2.setText("naka" + written_form);
                tvR4C2.setText("gi" + written_form);
                tvR5C2.setText("gina" + written_form);
                tvR6C2.setText("na" + written_form);
                tvR7C2.setText("gi" + affixed_form + "an");
                tvR8C2.setText("gina" + affixed_form + "an");
                tvR9C2.setText("na" + affixed_form + "an");
                tvR10C2.setText("gi" + written_form);
                tvR11C2.setText("gina" + written_form);
                tvR12C2.setText("na" + written_form);
            } else {
                tvR1C2.setText("mi" + written_form);
                tvR2C2.setText("nag" + written_form);
                tvR3C2.setText("naka" + written_form);
                tvR4C2.setText("gi" + written_form);
                tvR5C2.setText("gina" + written_form);
                tvR6C2.setText("na" + written_form);
                tvR7C2.setText("gi" + affixed_form + "an");
                tvR8C2.setText("gina" + affixed_form + "an");
                tvR9C2.setText("na" + affixed_form + "an");
                tvR10C2.setText("gi" + written_form);
                tvR11C2.setText("gina" + written_form);
                tvR12C2.setText("na" + written_form);
            }
        } else {
            tvTableTitle.setVisibility(View.GONE);
            tblConjugation.setVisibility(View.GONE);
        }

        aspectPrev.setOnClickListener(view -> {
            if(aspectCount > 0) {
                aspectCount--;
                switchToAspect(aspectCount);
            }
        });

        aspectNext.setOnClickListener(view -> {
            if(aspectCount < 3) {
                aspectCount++;
                switchToAspect(aspectCount);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void switchToAspect(int aspectCount) {
        String written_form = termSelected.getWritten_form();
        String affixed_form = Objects.equals(termSelected.getAffixed_form(), "*") ? written_form : termSelected.getAffixed_form();
        String verb_type = termSelected.getCategory();
        switch (aspectCount) {
            case 0:
                tvR0C2.setText("Actual");
                aspectPrev.setEnabled(false);
                aspectPrev.setVisibility(View.INVISIBLE);
                if(Objects.equals(verb_type, "stative")) {
                    tvR1C2.setText("na" + written_form);
                    tvR2C2.setText("-");
                    tvR3C2.setText("-");
                    tvR4C2.setText("gika" + written_form);
                    tvR5C2.setText("-");
                    tvR6C2.setText("-");
                    tvR7C2.setText("gika" + affixed_form + "an");
                    tvR8C2.setText("-");
                    tvR9C2.setText("-");
                    tvR10C2.setText("gika" + written_form);
                    tvR11C2.setText("-");
                    tvR12C2.setText("-");
                } else if(Objects.equals(verb_type, "distributive")) {
                    tvR1C2.setText("n" + written_form.substring(1));
                    tvR2C2.setText("nag" + written_form);
                    tvR3C2.setText("naka" + written_form);
                    tvR4C2.setText("gi" + written_form);
                    tvR5C2.setText("gina" + written_form);
                    tvR6C2.setText("na" + written_form);
                    tvR7C2.setText("gi" + affixed_form + "an");
                    tvR8C2.setText("gina" + affixed_form + "an");
                    tvR9C2.setText("na" + affixed_form + "an");
                    tvR10C2.setText("gi" + written_form);
                    tvR11C2.setText("gina" + written_form);
                    tvR12C2.setText("na" + written_form);
                } else {
                    tvR1C2.setText("mi" + written_form);
                    tvR2C2.setText("nag" + written_form);
                    tvR3C2.setText("naka" + written_form);
                    tvR4C2.setText("gi" + written_form);
                    tvR5C2.setText("gina" + written_form);
                    tvR6C2.setText("na" + written_form);
                    tvR7C2.setText("gi" + affixed_form + "an");
                    tvR8C2.setText("gina" + affixed_form + "an");
                    tvR9C2.setText("na" + affixed_form + "an");
                    tvR10C2.setText("gi" + written_form);
                    tvR11C2.setText("gina" + written_form);
                    tvR12C2.setText("na" + written_form);
                }
                break;
            case 1:
                tvR0C2.setText("Contingent");
                aspectPrev.setEnabled(true);
                aspectPrev.setVisibility(View.VISIBLE);
                if(Objects.equals(verb_type, "stative")) {
                    tvR1C2.setText("ma" + written_form);
                    tvR2C2.setText("-");
                    tvR3C2.setText("-");
                    tvR4C2.setText("ka" + affixed_form + "on");
                    tvR5C2.setText("-");
                    tvR6C2.setText("-");
                    tvR7C2.setText("ka" + affixed_form + "an");
                    tvR8C2.setText("-");
                    tvR9C2.setText("-");
                    tvR10C2.setText("ika" + written_form);
                    tvR11C2.setText("-");
                    tvR12C2.setText("-");
                } else if(Objects.equals(verb_type, "distributive")) {
                    tvR1C2.setText("m" + written_form.substring(1));
                    tvR2C2.setText("mag" + written_form);
                    tvR3C2.setText("maka" + written_form);
                    tvR4C2.setText(affixed_form + "on");
                    tvR5C2.setText("paga" + affixed_form + "on");
                    tvR6C2.setText("ma" + written_form);
                    tvR7C2.setText(affixed_form + "an");
                    tvR8C2.setText("paga" + affixed_form + "an");
                    tvR9C2.setText("ma" + affixed_form + "an");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("ma" + written_form);
                } else {
                    tvR1C2.setText("mo" + written_form);
                    tvR2C2.setText("mag" + written_form);
                    tvR3C2.setText("maka" + written_form);
                    tvR4C2.setText(affixed_form + "on");
                    tvR5C2.setText("paga" + affixed_form + "on");
                    tvR6C2.setText("ma" + written_form);
                    tvR7C2.setText(affixed_form + "an");
                    tvR8C2.setText("paga" + affixed_form + "an");
                    tvR9C2.setText("ma" + affixed_form + "an");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("ma" + written_form);
                }
                break;
            case 2:
                tvR0C2.setText("Particular");
                aspectNext.setEnabled(true);
                aspectNext.setVisibility(View.VISIBLE);
                if(Objects.equals(verb_type, "stative")) {
                    tvR1C2.setText("ma" + written_form);
                    tvR2C2.setText("-");
                    tvR3C2.setText("-");
                    tvR4C2.setText("ka" + affixed_form + "a");
                    tvR5C2.setText("-");
                    tvR6C2.setText("-");
                    tvR7C2.setText("ka" + affixed_form + "i");
                    tvR8C2.setText("-");
                    tvR9C2.setText("-");
                    tvR10C2.setText("ika" + written_form);
                    tvR11C2.setText("-");
                    tvR12C2.setText("-");
                } else if(Objects.equals(verb_type, "distributive")) {
                    tvR1C2.setText("m" + written_form.substring(1));
                    tvR2C2.setText("mag" + written_form);
                    tvR3C2.setText("maka" + written_form);
                    tvR4C2.setText(affixed_form + "a");
                    tvR5C2.setText("paga" + affixed_form + "a");
                    tvR6C2.setText("ma" + affixed_form + "a");
                    tvR7C2.setText(affixed_form + "i");
                    tvR8C2.setText("paga" + affixed_form + "i");
                    tvR9C2.setText("ma" + affixed_form + "i");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("ma" + written_form);
                } else {
                    tvR1C2.setText("mo" + written_form);
                    tvR2C2.setText("mag" + written_form);
                    tvR3C2.setText("maka" + written_form);
                    tvR4C2.setText(affixed_form + "a");
                    tvR5C2.setText("paga" + affixed_form + "a");
                    tvR6C2.setText("ma" + written_form);
                    tvR7C2.setText(affixed_form + "i");
                    tvR8C2.setText("paga" + affixed_form + "i");
                    tvR9C2.setText("ma" + affixed_form + "i");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("ma" + written_form);
                }
                break;
            case 3:
                tvR0C2.setText("Imperative");
                aspectNext.setEnabled(false);
                aspectNext.setVisibility(View.INVISIBLE);
                if(Objects.equals(verb_type, "stative")) {
                    tvR1C2.setText("ka" + written_form);
                    tvR2C2.setText("-");
                    tvR3C2.setText("-");
                    tvR4C2.setText("ka" + affixed_form + "a");
                    tvR5C2.setText("-");
                    tvR6C2.setText("-");
                    tvR7C2.setText("ka" + affixed_form + "i");
                    tvR8C2.setText("-");
                    tvR9C2.setText("-");
                    tvR10C2.setText("ika" + written_form);
                    tvR11C2.setText("-");
                    tvR12C2.setText("-");
                } else if(Objects.equals(verb_type, "distributive")) {
                    tvR1C2.setText(written_form);
                    tvR2C2.setText("pag" + written_form);
                    tvR3C2.setText("-");
                    tvR4C2.setText(affixed_form + "a");
                    tvR5C2.setText("paga" + affixed_form + "a");
                    tvR6C2.setText("-");
                    tvR7C2.setText(affixed_form + "i");
                    tvR8C2.setText("paga" + affixed_form + "i");
                    tvR9C2.setText("-");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("-");
                } else {
                    tvR1C2.setText(written_form);
                    tvR2C2.setText("pag" + written_form);
                    tvR3C2.setText("-");
                    tvR4C2.setText(affixed_form + "a");
                    tvR5C2.setText("paga" + affixed_form + "a");
                    tvR6C2.setText("-");
                    tvR7C2.setText(affixed_form + "i");
                    tvR8C2.setText("paga" + affixed_form + "i");
                    tvR9C2.setText("-");
                    tvR10C2.setText("i" + written_form);
                    tvR11C2.setText("iga" + written_form);
                    tvR12C2.setText("-");
                }
                break;
        }
    }
}
