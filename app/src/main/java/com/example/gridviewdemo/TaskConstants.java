package com.example.gridviewdemo;

public enum TaskConstants {
    LOGIN_FORM("Login Form"),
    VISITING_CARD("Visiting Card"),
    STUDENT_TABLE("Student Table"),
    SIMPLE_INTEREST("Simple Interest"),
    CALCULATOR("Calculator"),
    STUDENT_INFO("Student Information"),
    PHONE_DIALER("Phone Dialer"),
    SECRET_MESSAGE("Secret Message"),
    NEWS_PORTAL("News Portal"),
    IMAGE_GALLERY("Image Gallery");

    public final String label;

    TaskConstants(String label) {
        this.label = label;
    }
}
