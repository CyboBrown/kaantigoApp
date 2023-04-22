package com.cansev.kaantigo_learncebuano;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Term implements Serializable {
    private String word_ceb;
    private String written_form;
    private String affixed_form;
    private String word_en;
    private String verb_type;

//    public Term(String word_ceb, String written_form, String affixed_form) {
//        this.word_ceb = word_ceb;
//        this.written_form = written_form;
//        this.affixed_form = affixed_form;
//    }

    public Term(String word_ceb, String written_form, String affixed_form, String word_en, String verb_type) {
        this.word_ceb = word_ceb;
        this.written_form = written_form;
        this.affixed_form = affixed_form;
        this.word_en = word_en;
        this.verb_type = verb_type;
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

    public String getVerb_type() {
        return verb_type;
    }

    @NonNull
    @Override
    public String toString() {
        return word_ceb + " " + written_form + " " + affixed_form;
    }
}
