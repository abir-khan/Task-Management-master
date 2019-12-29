package com.example.noor.taskmanagement.responseModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 9/3/2017.
 */

public class KraResponseModel {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("KraID")
    @Expose
    private Integer kraID;
    @SerializedName("KpiID")
    @Expose
    private Integer kpiID;
    @SerializedName("TaskTitle")
    @Expose
    private String taskTitle;
    @SerializedName("N1ApprovalStatus")
    @Expose
    private Object n1ApprovalStatus;
    @SerializedName("TargetScore")
    @Expose
    private Integer targetScore;
    @SerializedName("ObtainedScore")
    @Expose
    private Integer obtainedScore;
    @SerializedName("TaskType")
    @Expose
    private Integer taskType;
    @SerializedName("Project")
    @Expose
    private Integer project;
    @SerializedName("Priority")
    @Expose
    private Integer priority;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("CompletePer")
    @Expose
    private String completePer;
    @SerializedName("EstimationHour")
    @Expose
    private Integer estimationHour;
    @SerializedName("ActualHour")
    @Expose
    private Integer actualHour;
    @SerializedName("AssignedTo")
    @Expose
    private String assignedTo;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("DueDate")
    @Expose
    private String dueDate;
    @SerializedName("CompletedDate")
    @Expose
    private String completedDate;
    @SerializedName("AssignedBy")
    @Expose
    private String assignedBy;
    @SerializedName("EntryDate")
    @Expose
    private String entryDate;
    @SerializedName("EditDate")
    @Expose
    private String editDate;
    @SerializedName("EditBy")
    @Expose
    private String editBy;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getKraID() {
        return kraID;
    }

    public void setKraID(Integer kraID) {
        this.kraID = kraID;
    }

    public Integer getKpiID() {
        return kpiID;
    }

    public void setKpiID(Integer kpiID) {
        this.kpiID = kpiID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Object getN1ApprovalStatus() {
        return n1ApprovalStatus;
    }

    public void setN1ApprovalStatus(Object n1ApprovalStatus) {
        this.n1ApprovalStatus = n1ApprovalStatus;
    }

    public Integer getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(Integer targetScore) {
        this.targetScore = targetScore;
    }

    public Integer getObtainedScore() {
        return obtainedScore;
    }

    public void setObtainedScore(Integer obtainedScore) {
        this.obtainedScore = obtainedScore;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompletePer() {
        return completePer;
    }

    public void setCompletePer(String completePer) {
        this.completePer = completePer;
    }

    public Integer getEstimationHour() {
        return estimationHour;
    }

    public void setEstimationHour(Integer estimationHour) {
        this.estimationHour = estimationHour;
    }

    public Integer getActualHour() {
        return actualHour;
    }

    public void setActualHour(Integer actualHour) {
        this.actualHour = actualHour;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }

}

