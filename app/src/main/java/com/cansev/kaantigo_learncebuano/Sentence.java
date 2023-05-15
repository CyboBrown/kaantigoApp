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
                switch (doer) {
                    case "I":
                        doer_phrase = " ko";
                        break;
                    case "we (inclusive)":
                        doer_phrase = " ta";
                        break;
                    case "we (exclusive)":
                        doer_phrase = " mi";
                        break;
                    case "you (singular)":
                        doer_phrase = " ka";
                        break;
                    case "you (plural)":
                        doer_phrase = " mo";
                        break;
                    case "he, she":
                        doer_phrase = " siya";
                        break;
                    case "they":
                        doer_phrase = " sila";
                        break;
                    case "this (temporal)":
                        doer_phrase = " ron";
                        break;
                    case "this (proximal)":
                        doer_phrase = " ri";
                        break;
                    case "this (medioproximal)":
                        doer_phrase = " ni";
                        break;
                    case "this (medial)":
                        doer_phrase = " na";
                        break;
                    case "this (distal)":
                        doer_phrase = " to";
                        break;
                    default:
                        doer_phrase = " " + (isGeneralDoer ? "ang" : "si") + " " + doer;
                }
            } else {
                switch (doer) {
                    case "I":
                        doer_phrase = " nako";
                        break;
                    case "we (inclusive)":
                        doer_phrase = " nato";
                        break;
                    case "we (exclusive)":
                        doer_phrase = " namo";
                        break;
                    case "you (singular)":
                        doer_phrase = " nimo";
                        break;
                    case "you (plural)":
                        doer_phrase = " ninyo";
                        break;
                    case "he, she":
                        doer_phrase = " niya";
                        break;
                    case "they":
                        doer_phrase = " nila";
                        break;
                    case "this (temporal)":
                        doer_phrase = " aron";
                        break;
                    case "this (proximal)":
                        doer_phrase = " ari";
                        break;
                    case "this (medioproximal)":
                        doer_phrase = " ini";
                        break;
                    case "this (medial)":
                        doer_phrase = " ana";
                        break;
                    case "this (distal)":
                        doer_phrase = " adto";
                        break;
                    default:
                        doer_phrase = " " + (isGeneralDoer ? "sa" : "ni") + " " + doer;
                }
            }
        }

        String receiver_phrase;
        if(Objects.equals(receiver, " ") || Objects.equals(receiver, "")) {
            receiver_phrase = "";
        } else {
            if(Objects.equals(focus, "Patient")) {
                switch (receiver) {
                    case "I":
                        receiver_phrase = " ko";
                        break;
                    case "we (inclusive)":
                        receiver_phrase = " ta";
                        break;
                    case "we (exclusive)":
                        receiver_phrase = " mi";
                        break;
                    case "you (singular)":
                        receiver_phrase = " ka";
                        break;
                    case "you (plural)":
                        receiver_phrase = " mo";
                        break;
                    case "he, she":
                        receiver_phrase = " siya";
                        break;
                    case "they":
                        receiver_phrase = " sila";
                        break;
                    case "this (temporal)":
                        receiver_phrase = " ron";
                        break;
                    case "this (proximal)":
                        receiver_phrase = " ri";
                        break;
                    case "this (medioproximal)":
                        receiver_phrase = " ni";
                        break;
                    case "that (medial)":
                        receiver_phrase = " na";
                        break;
                    case "that (distal)":
                        receiver_phrase = " to";
                        break;
                    default:
                        receiver_phrase = " " + (isGeneralReceiver ? "ang" : "si") + " " + receiver;
                }
            } else {
                switch (receiver) {
                    case "I":
                        receiver_phrase = " nako";
                        break;
                    case "we (inclusive)":
                        receiver_phrase = " nato";
                        break;
                    case "we (exclusive)":
                        receiver_phrase = " namo";
                        break;
                    case "you (singular)":
                        receiver_phrase = " nimo";
                        break;
                    case "you (plural)":
                        receiver_phrase = " ninyo";
                        break;
                    case "he, she":
                        receiver_phrase = " niya";
                        break;
                    case "they":
                        receiver_phrase = " nila";
                        break;
                    case "this (temporal)":
                        receiver_phrase = " aron";
                        break;
                    case "this (proximal)":
                        receiver_phrase = " ari";
                        break;
                    case "this (medioproximal)":
                        receiver_phrase = " ini";
                        break;
                    case "that (medial)":
                        receiver_phrase = " ana";
                        break;
                    case "that (distal)":
                        receiver_phrase = " adto";
                        break;
                    default:
                        receiver_phrase = " " + (isGeneralReceiver ? "og" : "kang") + " " + receiver;
                }
            }
        }

        String goal_phrase;
        if(Objects.equals(goal, " ") || Objects.equals(goal, "")) {
            goal_phrase = "";
        } else {
            if(Objects.equals(focus, "Circumstantial")) {
                switch (goal) {
                    case "I":
                        goal_phrase = " ko";
                        break;
                    case "we (inclusive)":
                        goal_phrase = " ta";
                        break;
                    case "we (exclusive)":
                        goal_phrase = " mi";
                        break;
                    case "you (singular)":
                        goal_phrase = " ka";
                        break;
                    case "you (plural)":
                        goal_phrase = " mo";
                        break;
                    case "he, she":
                        goal_phrase = " siya";
                        break;
                    case "they":
                        goal_phrase = " sila";
                        break;
                    case "this (temporal)":
                        goal_phrase = " ron";
                        break;
                    case "this (proximal)":
                        goal_phrase = " ri";
                        break;
                    case "this (medioproximal)":
                        goal_phrase = " ni";
                        break;
                    case "that (medial)":
                        goal_phrase = " na";
                        break;
                    case "that (distal)":
                        goal_phrase = " to";
                        break;
                    default:
                        goal_phrase = " " + (isGeneralGoal ? "ang" : "si") + " " + goal;
                }
            } else {
                switch (receiver) {
                    case "I":
                        goal_phrase = " nako";
                        break;
                    case "we (inclusive)":
                        goal_phrase = " nato";
                        break;
                    case "we (exclusive)":
                        goal_phrase = " namo";
                        break;
                    case "you (singular)":
                        goal_phrase = " nimo";
                        break;
                    case "you (plural)":
                        goal_phrase = " ninyo";
                        break;
                    case "he, she":
                        goal_phrase = " niya";
                        break;
                    case "they":
                        goal_phrase = " nila";
                        break;
                    case "this (temporal)":
                        goal_phrase = " aron";
                        break;
                    case "this (proximal)":
                        goal_phrase = " ari";
                        break;
                    case "this (medioproximal)":
                        goal_phrase = " ini";
                        break;
                    case "that (medial)":
                        goal_phrase = " ana";
                        break;
                    case "that (distal)":
                        goal_phrase = " adto";
                        break;
                    default:
                        goal_phrase = " " + (isGeneralGoal ? "sa" : "kang") + " " + goal;
                }
            }
        }


        String instrument_phrase;
        if(Objects.equals(instrument, " ") || Objects.equals(instrument, "")) {
            instrument_phrase = "";
        } else {
            if(Objects.equals(focus, "Instrumental")) {
                switch (instrument) {
                    case "I":
                        instrument_phrase = " ko";
                        break;
                    case "we (inclusive)":
                        instrument_phrase = " ta";
                        break;
                    case "we (exclusive)":
                        instrument_phrase = " mi";
                        break;
                    case "you (singular)":
                        instrument_phrase = " ka";
                        break;
                    case "you (plural)":
                        instrument_phrase = " mo";
                        break;
                    case "he, she":
                        instrument_phrase = " siya";
                        break;
                    case "they":
                        instrument_phrase = " sila";
                        break;
                    case "this (temporal)":
                        instrument_phrase = " ron";
                        break;
                    case "this (proximal)":
                        instrument_phrase = " ri";
                        break;
                    case "this (medioproximal)":
                        instrument_phrase = " ni";
                        break;
                    case "that (medial)":
                        instrument_phrase = " na";
                        break;
                    case "that (distal)":
                        instrument_phrase = " to";
                        break;
                    default:
                        instrument_phrase = " " + (isGeneralInstrument ? "ang" : "si") + " " + instrument;
                }
            } else {
                switch (instrument) {
                    case "I":
                        instrument_phrase = " pinaagi nako";
                        break;
                    case "we (inclusive)":
                        instrument_phrase = " pinaagi nato";
                        break;
                    case "we (exclusive)":
                        instrument_phrase = " pinaagi namo";
                        break;
                    case "you (singular)":
                        instrument_phrase = " pinaagi nimo";
                        break;
                    case "you (plural)":
                        instrument_phrase = " pinaagi ninyo";
                        break;
                    case "he, she":
                        instrument_phrase = " pinaagi niya";
                        break;
                    case "they":
                        instrument_phrase = " pinaagi nila";
                        break;
                    case "this (temporal)":
                        instrument_phrase = " pinaagi aron";
                        break;
                    case "this (proximal)":
                        instrument_phrase = " pinaagi ari";
                        break;
                    case "this (medioproximal)":
                        instrument_phrase = " pinaagi ini";
                        break;
                    case "that (medial)":
                        instrument_phrase = " pinaagi ana";
                        break;
                    case "that (distal)":
                        instrument_phrase = " pinaagi adto";
                        break;
                    default:
                        instrument_phrase = " " + (isGeneralInstrument ? "pinaagi sa" : "pinaagi kang") + " " + instrument;
                }
            }
        }

        return action_phrase + doer_phrase + receiver_phrase + goal_phrase + instrument_phrase + ".";
    }
}
