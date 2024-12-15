package com.example.demo.model;

public class Task {
    private int id;
    private String title;
    private boolean complete;

    public Task(int id, String title, boolean complete) {
        this.id = id;
        this.title = title;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
