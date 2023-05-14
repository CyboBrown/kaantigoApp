package com.cansev.kaantigo_learncebuano;

import androidx.annotation.NonNull;

import com.cansev.kaantigo_learncebuano.database.Verb;

import java.util.Objects;

public class Sentence {
    Verb verb;
    String focus;
    String aspect;
    String doer;
    String receiver;
    String goal;
    String instrument;
    boolean isGeneralDoer;
    boolean isGeneralReceiver;
    boolean isGeneralGoal;
    boolean isGeneralInstrument;

    public Sentence(Verb verb, String focus, String aspect, String doer, String receiver, String goal, String instrument, boolean isGeneralDoer, boolean isGeneralReceiver, boolean isGeneralGoal, boolean isGeneralInstrument) {
        this.verb = verb;
        this.focus = focus;
        this.aspect = aspect;
        this.doer = doer;
        this.receiver = receiver;
        this.goal = goal;
        this.instrument = instrument;
        this.isGeneralDoer = isGeneralDoer;
        this.isGeneralReceiver = isGeneralReceiver;
        this.isGeneralGoal = isGeneralGoal;
        this.isGeneralInstrument = isGeneralInstrument;
    }

    @NonNull
    @Override
    public String toString() {
        String action_phrase = verb.getAffixedVerb(focus, aspect);
        if(action_phrase.charAt(0) == '-') {
            action_phrase = action_phrase.substring(1);
        }
        action_phrase = Character.toUpperCase(action_phrase.charAt(0)) + action_phrase.substring(1);

        String doer_phrase;
        if(Objects.equals(doer, " ") || Objects.equals(doer, "")) {
            doer_phrase = "";
        } else {
            if(Objects.equals(focus, "Agent")) {
                doer_phrase = " " + (isGeneralDoer ? "ang" : "si") + " " + doer;
            } else {
                doer_phrase = " " + (isGeneralDoer ? "sa" : "ni") + " " + doer;
            }
        }


        String receiver_phrase;
        if(Objects.equals(receiver, " ") || Objects.equals(receiver, "")) {
            receiver_phrase = "";
        } else {
            if(Objects.equals(focus, "Patient")) {
                receiver_phrase = " " + (isGeneralReceiver ? "ang" : "si") + " " + receiver;
            } else {
                receiver_phrase = " " + (isGeneralReceiver ? "og" : "kang") + " " + receiver;
            }
        }


        String goal_phrase;
        if(Objects.equals(goal, " ") || Objects.equals(goal, "")) {
            goal_phrase = "";
        } else {
            if(Objects.equals(focus, "Circumstantial")) {
                goal_phrase = " " + (isGeneralGoal ? "ang" : "si") + " " + goal;
            } else {
                goal_phrase = " " + (isGeneralGoal ? "sa" : "kang") + " " + goal;
            }
        }


        String instrument_phrase;
        if(Objects.equals(instrument, " ") || Objects.equals(instrument, "")) {
            instrument_phrase = "";
        } else {
            if(Objects.equals(focus, "Instrumental")) {
                instrument_phrase = " " + (isGeneralInstrument ? "ang" : "si") + " " + instrument;
            } else {
                instrument_phrase = " " + (isGeneralInstrument ? "pinaagi sa" : "pinaagi kang") + " " + instrument;
            }
        }

        return action_phrase + doer_phrase + receiver_phrase + goal_phrase + instrument_phrase + ".";
    }
}
