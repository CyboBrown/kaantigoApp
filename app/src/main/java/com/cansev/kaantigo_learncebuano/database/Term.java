package com.cansev.kaantigo_learncebuano.database;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Term implements Serializable {
    private String word_ceb;
    private String written_form;
    private String affixed_form;
    private String word_en;
    private String pos;

    public Term(String word_ceb, String written_form, String affixed_form, String word_en, String pos) {
        this.word_ceb = word_ceb;
        this.written_form = written_form;
        this.affixed_form = affixed_form;
        this.word_en = word_en;
        this.pos = pos;
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

    @NonNull
    @Override
    public String toString() {
        return word_ceb + " " + written_form + " " + affixed_form;
    }
}

class Verb extends Term {
    private String verb_type;

    public Verb(String word_ceb, String written_form, String affixed_form, String word_en, String pos, String verb_type) {
        super(word_ceb, written_form, affixed_form, word_en, pos);
        this.verb_type = verb_type;
    }
}

class Noun extends Term {
    private String category;

    public Noun(String word_ceb, String written_form, String affixed_form, String word_en, String pos, String category) {
        super(word_ceb, written_form, affixed_form, word_en, pos);
        this.category = category;
    }
}

class Adjective extends Term {
    private String category;

    public Adjective(String word_ceb, String written_form, String affixed_form, String word_en, String pos, String category) {
        super(word_ceb, written_form, affixed_form, word_en, pos);
        this.category = category;
    }
}

class Special extends Term {
    private String alternative;

    public Special(String word_ceb, String written_form, String affixed_form, String word_en, String pos, String alternative) {
        super(word_ceb, written_form, affixed_form, word_en, pos);
        this.alternative = alternative;
    }
}
