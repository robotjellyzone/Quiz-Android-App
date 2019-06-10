package com.example.android.quizapp;

public class storageofquestions {
    private String usernames [] = {
            "XYZ", "ABC", "CAT", "WXY"
    };
    private String passwords [] = {
            "XYZ", "ABC", "CAT", "WXY"
    };
    public String getString(int a){
        return usernames[a];
    }
    public String getPassword(int a){
        return passwords[a];
    }
}