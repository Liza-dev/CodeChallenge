package com.example.myapplication.model;

public class CommitModel {
    private String author;
    private String message;

    public CommitModel(String author, String message) {
        this.author=author;
        this.message=message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
