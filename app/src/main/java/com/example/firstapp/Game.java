package com.example.firstapp;

import java.util.List;

public class Game {
    private List<Question> questions;
    private int numCorrect, numIncorrect, totalQuestions, score;
    private Question currentQuestion;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        this.numCorrect = numCorrect;
    }

    public int getNumIncorrect() {
        return numIncorrect;
    }

    public void setNumIncorrect(int numIncorrect) {
        this.numIncorrect = numIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }



    public Game()
    {
        numCorrect = 0;
        numIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new Question(10);
    }

    public void makeNewQuestion()
    {
        currentQuestion = new Question(totalQuestions*2+5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer)
    {
        boolean isCorrect;
        if(currentQuestion.getAnswer() == submittedAnswer)
        {
            numCorrect++;
            isCorrect = true;
        }
        else
        {
            numIncorrect++;
            isCorrect = false;
        }
        score = numCorrect*10 - numIncorrect*30;
        return isCorrect;
    }

}
