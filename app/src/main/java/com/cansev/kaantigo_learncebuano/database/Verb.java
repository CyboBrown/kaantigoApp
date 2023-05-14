package com.cansev.kaantigo_learncebuano.database;

import java.util.Objects;

public class Verb extends Term {

    public Verb(String word_ceb, String written_form, String affixed_form, String word_en, String category) {
        super(word_ceb, written_form, affixed_form, word_en, "verb", category);
    }

    public Verb(String written_form, String affixed_form, String category) {
        super(" ", written_form, affixed_form, " ", "verb", category);
    }

    public String getAffixedVerb(String focus, String aspect) {
        String afxform;
        if (Objects.equals(getAffixed_form(), "*")) {
            afxform = getWritten_form();
        } else {
            afxform = getAffixed_form();
        }
        switch (focus) {
            case "Agent":
                switch (aspect) {
                    case "Actual":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "na" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "n" + getWritten_form().substring(1);
                        } else {
                            return "mi" + getWritten_form();
                        }
                    case "Contingent":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ma" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "m" + getWritten_form().substring(1);
                        } else {
                            return "mo" + getWritten_form();
                        }
                    case "Imperative":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ka" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return getWritten_form();
                        } else {
                            return getWritten_form();
                        }
                }
                break;
            case "Patient":
                switch (aspect) {
                    case "Actual":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "gika" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "gi" + getWritten_form();
                        } else {
                            return "gi" + getWritten_form();
                        }
                    case "Contingent":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ka" + afxform + "on";
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return afxform + "on";
                        } else {
                            return afxform + "on";
                        }
                    case "Imperative":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ka" + afxform + "a";
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return afxform + "a";
                        } else {
                            return afxform + "a";
                        }
                }
                break;
            case "Circumstantial":
                switch (aspect) {
                    case "Actual":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "gika" + afxform + "an";
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "gi" + afxform + "an";
                        } else {
                            return "gi" + afxform + "an";
                        }
                    case "Contingent":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ka" + afxform + "an";
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return afxform + "an";
                        } else {
                            return afxform + "an";
                        }
                    case "Imperative":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ka" + afxform + "i";
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return afxform + "i";
                        } else {
                            return afxform + "i";
                        }
                }
                break;
            case "Instrumental":
                switch (aspect) {
                    case "Actual":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "gika" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "gi" + getWritten_form();
                        } else {
                            return "gi" + getWritten_form();
                        }
                    case "Contingent":
                    case "Imperative":
                        if (Objects.equals(getCategory(), "stative")) {
                            return "ika" + getWritten_form();
                        } else if (Objects.equals(getCategory(), "distributive")) {
                            return "i" + getWritten_form();
                        } else {
                            return "i" + getWritten_form();
                        }
                }
                break;
        }
        return null;
    }
}
