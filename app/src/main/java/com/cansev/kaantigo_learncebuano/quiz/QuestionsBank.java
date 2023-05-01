package com.cansev.kaantigo_learncebuano.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    private static List<QuestionSet> caseMarkersQuestions() {
        List<QuestionSet> questionSets = new ArrayList<>();

        // Create object and pass a question with options, and answer
        QuestionSet question1 = new MultipleChoice("description 1 for case markers","I bought a new house.", "Mipalit ko sa bag-o nga balay.", "Mopalit ko og bag-o nga balay.", "Mopalit ko sa bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "");
        QuestionSet question2 = new MultipleChoice("description 2 for case markers","What's Curry's college team?", "Davidson Wildcats", "Texas Longhorns", "Gonzaga Bulldogs", "Wisconsin Badgers", "Davidson Wildcats", "");
        QuestionSet question3 = new MultipleChoice("description 3 for case markers","Which team picked Curry in the 2009 NBA draft?", "San Antonio Spurs", "New York Knicks", "Los Angeles Clippers", "Golden State Warriors", "Golden State Warriors", "");
        QuestionSet question4 = new MultipleChoice("description 4 for case markers","What's Curry's nickname?", "Baby-faced assassin", "Baby-faced killer", "Baby-faced players", "Mr. Baby Face", "Baby-faced assassin", "");

        // Add all questions to questionsListList
        questionSets.add(question1);
        questionSets.add(question2);
        questionSets.add(question3);
        questionSets.add(question4);

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