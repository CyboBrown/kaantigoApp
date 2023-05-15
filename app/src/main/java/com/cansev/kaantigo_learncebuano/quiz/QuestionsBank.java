package com.cansev.kaantigo_learncebuano.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    private static List<QuestionSet> caseMarkersQuestions() {
        List<QuestionSet> questionSets = new ArrayList<>();

        // Create object and pass a question with options, and answer
        QuestionSet question1 = new MultipleChoice("Translate the following sentence.","I bought a new house.", "Mipalit ko sa bag-o nga balay.", "Mopalit ko og bag-o nga balay.", "Mopalit ko sa bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "");
        QuestionSet question2 = new MultipleChoice("Choose the incorrect translation for","I am Pasan.", "Ako si Pasan.", "Si Pasan ako.", "Si ako Pasan.", "Si Pasan ko.", "Si ako Pasan.", "");
        QuestionSet question3 = new MultipleChoice("Translate the following sentence:","The person is female.", "Ang tawo babaye.", "Ang babaye tawo.", "Tawo ang babaye.", "Babaye tawo.", "Ang tawo babaye.", "");
        QuestionSet question4 = new MultipleChoice("Fill in the blanks.","_____ lalaki.", "ang", "si", "ni", "kon", "ang", "");
        QuestionSet question5 = new MultipleChoice("Fill in the blanks.","_____ Joana.", "kon", "ang", "ni", "si", "si", "");

        // Add all questions to questionsListList
        questionSets.add(question1);
        questionSets.add(question2);
        questionSets.add(question3);
        questionSets.add(question4);
        questionSets.add(question5);

        return questionSets;
    }

    private static List<QuestionSet> personalPronounsQuestions() {
        List<QuestionSet> questionSets = new ArrayList<>();

        final QuestionSet question1 = new MultipleChoice("description 1 for personal pronouns","What was the league joined by Michael Jordan?", "NFL", "MLB", "WTA", "NBA", "NBA", "");
        final QuestionSet question2 = new MultipleChoice("description 2 for personal pronouns","What was Michael Jordan's first team?", "Charlotte Hornets", "Wizards", "Chicago Bulls", "Barons", "Chicago Bulls", "");
        final QuestionSet question3 = new MultipleChoice("description 3 for personal pronouns","What is Michael Jordan's nationality?", "Spanish", "Argentine", "Puerto Rican", "American", "American", "");
        final QuestionSet question4 = new MultipleChoice("description 4 for personal pronouns","When did Michael Jordan join the NBA?", "1984", "1988", "1987", "1982", "1984", "");

        // Add all questions to questionsListList
        questionSets.add(question1);
        questionSets.add(question2);
        questionSets.add(question3);
        questionSets.add(question4);

        return questionSets;
    }

    private static List<QuestionSet> demonstrativePronounsQuestions() {
        List<QuestionSet> questionSets = new ArrayList<>();

        final QuestionSet question1 = new MultipleChoice("description 1 for demonstrative pronouns","What country did Michael Phelps swim for?", "Russia", "United States", "China", "Australia", "United States", "");
        final QuestionSet question2 = new MultipleChoice("description 2 for demonstrative pronouns","What is one of Michael Phelps' nicknames?", "The Maryland Monster", "The Maryland Menace", "The Baltimore Best", "The Baltimore Bullet", "The Baltimore Bullet", "");
        final QuestionSet question3 = new MultipleChoice("description 3 for demonstrative pronouns","On what day did Michael Phelps win his very first gold medal?", "August 14, 2000", "August 1, 2000", "August 1, 2004", "August 14, 2004", "August 14, 2004", "");
        final QuestionSet question4 = new MultipleChoice("description 4 for demonstrative pronouns","Who is Michael Phelps?", "A dancer", "A singer", "A swimmer", "A dancer", "A swimmer", "");
        final QuestionSet question5 = new MultipleChoice("description 5 for demonstrative pronouns","What country did Michael Phelps swim for?", "Russia", "United States", "China", "Australia", "United States", "");
        final QuestionSet question6 = new MultipleChoice("description 6 for demonstrative pronouns","What is one of Michael Phelps' nicknames?", "The Maryland Monster", "The Maryland Menace", "The Baltimore Best", "The Baltimore Bullet", "The Baltimore Bullet", "");
        final QuestionSet question7 = new MultipleChoice("description 7 for demonstrative pronouns","On what day did Michael Phelps win his very first gold medal?", "August 14, 2000", "August 1, 2000", "August 1, 2004", "August 14, 2004", "August 14, 2004", "");
        final QuestionSet question8 = new MultipleChoice("description 8 for demonstrative pronouns","Who is Michael Phelps?", "A dancer", "A singer", "A swimmer", "A dancer", "A swimmer", "");

        // Add all questions to questionsListList
        questionSets.add(question1);
        questionSets.add(question2);
        questionSets.add(question3);
        questionSets.add(question4);
        questionSets.add(question5);
        questionSets.add(question6);
        questionSets.add(question7);
        questionSets.add(question8);

        return questionSets;
    }

    public static List<QuestionSet> getQuestions(String selectedTopicName) {
        switch(selectedTopicName) {
            case "caseMarkers":
                return caseMarkersQuestions();
            case "personalPronouns":
                return personalPronounsQuestions();
            default:
                return demonstrativePronounsQuestions();
        }
    }
}