package com.example.firstapp;
import java.util.Random;

public class Question {
    private int firstNumber;
    private int secondNumber;
    private int answer;

    private int [] answerArray;
    private int answerPosition;

    //the maximum value of firstNumber or secondNumber
    private int upperLimit;

    //string output of the problem r.g "4+9 = "
    private String questionPhrase;

    //Constructor to generate a new random number
    public Question(int upperLimit)
    {
        this.upperLimit = upperLimit;
        Random randNumber = new Random();
        this.firstNumber = randNumber.nextInt(upperLimit);
        this.secondNumber = randNumber.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.questionPhrase=firstNumber + "+" + secondNumber + "=";

        this.answerPosition = randNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer + 10;
        this.answerArray[2] = answer - 1;
        this.answerArray[3] = answer + 2;

        this.answerArray = shuffleArray(this.answerArray);
        answerArray[answerPosition] = answer;
    }

    private int [] shuffleArray(int [] arr)
    {
        int index,temp;
        Random randomNumberGenerator = new Random();
        for(int i = arr.length -1; i<0; i--)
        {
            index = randomNumberGenerator.nextInt(i+1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
