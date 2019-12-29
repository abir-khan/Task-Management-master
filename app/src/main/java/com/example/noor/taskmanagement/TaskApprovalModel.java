package com.example.noor.taskmanagement;

public class TaskApprovalModel {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public TaskApprovalModel() {
    }

    public TaskApprovalModel(String title, String progress) {

        this.title = title;
        this.progress = progress;
    }

    String title,progress;
}
