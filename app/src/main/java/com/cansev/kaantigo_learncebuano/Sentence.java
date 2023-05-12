package com.cansev.kaantigo_learncebuano;

import androidx.annotation.NonNull;

public class Sentence {
    private String sentence;
    private String verb;
    String action;
    String focus;
    String aspect;
    String doer;
    String receiver;
    String goal;
    String instrument;

    public Sentence(String action, String focus, String aspect, String doer, String receiver, String goal, String instrument) {
        this.action = action;
        this.focus = focus;
        this.aspect = aspect;
        this.doer = doer;
        this.receiver = receiver;
        this.goal = goal;
        this.instrument = instrument;

    }

    @NonNull
    @Override
    public String toString() {
        return "";
    }
}
