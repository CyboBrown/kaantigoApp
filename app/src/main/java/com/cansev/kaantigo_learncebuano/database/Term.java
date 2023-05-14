package com.cansev.kaantigo_learncebuano.database;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

public class Term implements Serializable {
    private String word_ceb;
    private String written_form;
    private String affixed_form;
    private String word_en;
    private String pos;
    private String category;

    public Term(String written_form, String word_en) {
        this.written_form = written_form;
        this.word_en = word_en;
    }

    public Term(String word_ceb, String written_form, String affixed_form, String word_en, String pos, String category) {
        this.word_ceb = word_ceb;
        this.written_form = written_form;
        this.affixed_form = affixed_form;
        this.word_en = word_en;
        this.pos = pos;
        this.category = category;
    }

    public String getWord_ceb() {
        return word_ceb;
    }

    public String getWritten_form() {
        return written_form;
    }

    public String getAffixed_form() {
        return affixed_form;
    }

    public String getWord_en() {
        return word_en;
    }

    public String getPos() {
        return pos;
    }

    public String getCategory() {
        return category;
    }

    @NonNull
    @Override
    public String toString() {
        return word_ceb + " " + written_form + " " + affixed_form;
    }
}

//class Noun extends Term {
//
//}
//
//class Adjective extends Term {
//
//}
//
//class Special extends Term {
//
//}

//interface Conjugatable {
//    // TRIGGERS
//    int TRGR_AGENT = 0;
//    int TRGR_PATIENT = 1;
//    int TRGR_CIRCUMSTANTIAL = 2;
//    int TRGR_INSTRUMENTAL = 3;
//    // MOODS
//    int MOOD_PUNCTUAL = 0;
//    int MOOD_DURATIVE = 1;
//    int MOOD_POTENTIAL = 2;
//    // ASPECTS
//    int ASPT_ACTUAL = 0;
//    int ASPT_CONTINGENT = 1;
//    int ASPT_ADVERBIAL = 2;
//    int ASPT_IMPERATIVE = 3;
//}
