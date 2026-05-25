package com.day5.model;

public class Bug {
    private int id;
    private String title;
    private String description;
    private String status;

    public Bug() {
    }

    public Bug(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Bug(int id, String title, String description, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%d %s - %s (status: %s)", id, title, description, status);
    }
}
