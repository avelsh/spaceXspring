package com.example.spacexspring;

import java.util.List;

/**
 * We need this class in order to beautifully display a question
 * and an answer to a question in the browser together.
 */
public class Dates {
    //Attributes
    private String question;
    private List<String> answer;

    //Constructor
    public Dates(String question, List<String> answer) {
        this.question = question;
        this.answer = answer;
    }

    //Setters and Getters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    //To String

    @Override
    public String toString() {
        return "Dates{" +
                "Question: '" + question + '\n' +
                ", The answer to the question='" + answer + '\n' +
                '}';
    }
}
