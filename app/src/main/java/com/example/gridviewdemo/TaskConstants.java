package com.example.gridviewdemo;

public enum TaskConstants {
    LOGIN_FORM("Login Form"),
    VISITING_CARD("Visiting Card"),
    STUDENT_TABLE("Student Table"),
    SIMPLE_INTEREST("Simple Interest"),
    PHONE_DIALER("Phone Dialer"),
    SECRET_MESSAGE("Secret Message");

    public final String label;

    TaskConstants(String label) {
        this.label = label;
    }
}
