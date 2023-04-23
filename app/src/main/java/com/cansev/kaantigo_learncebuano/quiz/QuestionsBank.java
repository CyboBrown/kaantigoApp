package com.cansev.kaantigo_learncebuano.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    private static List<QuestionsList> caseMarkersQuestions() {
        List<QuestionsList> questionsLists = new ArrayList<>();

        // Create object and pass a question with options, and answer
        QuestionsList question1 = new QuestionsList("description 1 for case markers","I bought a new house.", "Mipalit ko sa bag-o nga balay.", "Mopalit ko og bag-o nga balay.", "Mopalit ko sa bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "Mipalit ko og bag-o nga balay.", "");
        QuestionsList question2 = new QuestionsList("description 2 for case markers","What's Curry's college team?", "Davidson Wildcats", "Texas Longhorns", "Gonzaga Bulldogs", "Wisconsin Badgers", "Davidson Wildcats", "");
        QuestionsList question3 = new QuestionsList("description 3 for case markers","Which team picked Curry in the 2009 NBA draft?", "San Antonio Spurs", "New York Knicks", "Los Angeles Clippers", "Golden State Warriors", "Golden State Warriors", "");
        QuestionsList question4 = new QuestionsList("description 4 for case markers","What's Curry's nickname?", "Baby-faced assassin", "Baby-faced killer", "Baby-faced players", "Mr. Baby Face", "Baby-faced assassin", "");

        // Add all questions to questionsListList
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;
    }

    private static List<QuestionsList> personalPronounsQuestions() {
        List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("description 1 for personal pronouns","What was the league joined by Michael Jordan?", "NFL", "MLB", "WTA", "NBA", "NBA", "");
        final QuestionsList question2 = new QuestionsList("description 2 for personal pronouns","What was Michael Jordan's first team?", "Charlotte Hornets", "Wizards", "Chicago Bulls", "Barons", "Chicago Bulls", "");
        final QuestionsList question3 = new QuestionsList("description 3 for personal pronouns","What is Michael Jordan's nationality?", "Spanish", "Argentine", "Puerto Rican", "American", "American", "");
        final QuestionsList question4 = new QuestionsList("description 4 for personal pronouns","When did Michael Jordan join the NBA?", "1984", "1988", "1987", "1982", "1984", "");

        // Add all questions to questionsListList
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;
    }

    private static List<QuestionsList> demonstrativePronounsQuestions() {
        List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("description 1 for demonstrative pronouns","What country did Michael Phelps swim for?", "Russia", "United States", "China", "Australia", "United States", "");
        final QuestionsList question2 = new QuestionsList("description 2 for demonstrative pronouns","What is one of Michael Phelps' nicknames?", "The Maryland Monster", "The Maryland Menace", "The Baltimore Best", "The Baltimore Bullet", "The Baltimore Bullet", "");
        final QuestionsList question3 = new QuestionsList("description 3 for demonstrative pronouns","On what day did Michael Phelps win his very first gold medal?", "August 14, 2000", "August 1, 2000", "August 1, 2004", "August 14, 2004", "August 14, 2004", "");
        final QuestionsList question4 = new QuestionsList("description 4 for demonstrative pronouns","Who is Michael Phelps?", "A dancer", "A singer", "A swimmer", "A dancer", "A swimmer", "");
        final QuestionsList question5 = new QuestionsList("description 5 for demonstrative pronouns","What country did Michael Phelps swim for?", "Russia", "United States", "China", "Australia", "United States", "");
        final QuestionsList question6 = new QuestionsList("description 6 for demonstrative pronouns","What is one of Michael Phelps' nicknames?", "The Maryland Monster", "The Maryland Menace", "The Baltimore Best", "The Baltimore Bullet", "The Baltimore Bullet", "");
        final QuestionsList question7 = new QuestionsList("description 7 for demonstrative pronouns","On what day did Michael Phelps win his very first gold medal?", "August 14, 2000", "August 1, 2000", "August 1, 2004", "August 14, 2004", "August 14, 2004", "");
        final QuestionsList question8 = new QuestionsList("description 8 for demonstrative pronouns","Who is Michael Phelps?", "A dancer", "A singer", "A swimmer", "A dancer", "A swimmer", "");

        // Add all questions to questionsListList
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(String selectedTopicName) {
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