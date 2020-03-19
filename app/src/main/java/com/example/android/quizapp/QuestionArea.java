package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;

public class QuestionArea {
    private String questions[] = {
            "Which city to host India’s first-ever nationwide food archaeology conference “ArchaeoBroma”?",
            "What is the India’s rank in the 2018 World Press Freedom Index (WPFI)?",
            "Who has won the 2018 presidential election in Paraguay?",
            "Dudhsagar Waterfalls is located in which state?",
            "Who has become the first woman lawyer to be directly promoted as a judge of the Supreme Court (SC)?"
    };

    private String Choices [] [ ] = {
            { "Mumbai" ,"New Delhi" ,"Indore" ,"Surat"} ,
            {"136th" , "138th" , "135th" , "137th"},
            {"Juan Afara", " Horacio Cartes" ," Mario Abdo Benítez" , "Efrain Alegre"},
            {"Maharashtra" , " Karnataka " , " Haryana" , "Goa"},
            {"Ranjana Prakash Desai" , "Ruma Pal" , "Indu Malhotra" , "Gyan Sudha Misra"},
    };
    private String answers [] = {"Mumbai", "138th", "Mario Abdo Benítez","Goa", "Indu Malhotra" };

    public String  getQuestions(int a) {

        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice1 = Choices[a][0];
        return choice1;
    }

    public String getchoice2(int a){
        String choice2 = Choices[a][1];
        return choice2;
    }

    public String getchoice3(int a){
        String choice3 = Choices[a][2];
        return choice3;
    }
    public String getchoice4(int a){
        String choice4 = Choices[a][3];
        return choice4;
    }

    public String getCorrectAnswer(int a){
        String answer = answers[a];
        return answer;
    }

}