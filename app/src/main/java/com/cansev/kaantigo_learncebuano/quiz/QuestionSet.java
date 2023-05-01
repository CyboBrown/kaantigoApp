package com.cansev.kaantigo_learncebuano.quiz;

abstract class QuestionSet {
    private String description, question, answer;

    public QuestionSet(String description, String question, String answer) {
        this.description = description;
        this.question = question;
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

class MultipleChoice extends QuestionSet {
    private String option1, option2, option3, option4, userSelectedAnswer;

    public MultipleChoice(String description, String question, String option1, String option2, String option3, String option4, String answer, String userSelectedAnswer) {
        super(description, question, answer);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}

class Identification extends QuestionSet {
    public Identification(String description, String question, String answer) {
        super(description, question, answer);
    }
}
