package com.example.noor.taskmanagement;

public class TaskModel {
    @Override
    public String toString() {
        return "TaskModel{" +
                "taskTitle='" + taskTitle + '\'' +
                ", targetScore='" + targetScore + '\'' +
                ", kRA=" + kRA +
                ", kPI=" + kPI +
                ", priority=" + priority +
                ", status=" + status +
                ", taskType=" + taskType +
                ", project=" + project +
                ", startDate='" + startDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", estimatedHour=" + estimatedHour +
                ", completion=" + completion +
                '}';
    }

    public TaskModel() {
    }

    public TaskModel(String taskTitle, String priority, String status, String startDate, String dueDate, String estimatedHour) {
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.status = status;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.estimatedHour = estimatedHour;
    }


    public String getTaskTitle() {

        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(String targetScore) {
        this.targetScore = targetScore;
    }

    public int getkRA() {
        return kRA;
    }

    public void setkRA(int kRA) {
        this.kRA = kRA;
    }

    public int getkPI() {
        return kPI;
    }

    public void setkPI(int kPI) {
        this.kPI = kPI;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEstimatedHour() {
        return estimatedHour;
    }

    public void setEstimatedHour(String estimatedHour) {
        this.estimatedHour = estimatedHour;
    }

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    String taskTitle,priority,status;
    String targetScore;

    public int getEsthour() {
        return esthour;
    }

    public void setEsthour(int esthour) {
        this.esthour = esthour;
    }

    public TaskModel(String taskTitle, String priority, String status, int esthour, String startDate, String dueDate) {
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.status = status;
        this.esthour = esthour;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    int esthour;
    int kRA, kPI;
    int taskType, project;
    String estimatedHour,startDate, dueDate;
    int completion;
}
