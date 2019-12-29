package com.example.noor.taskmanagement.model;

/**
 * Created by HP on 9/4/2017.
 */

public class UserRequest {

    private String activationcode;
    private String username;
    private String userID;
    private String password;
    private String courseID;
    private String homeworkID;
    private String date;
    private String studentid;
    private String level_id;
    private String playlistID;
    private String authorID;
    private String levelID;

    public String getPlayListID() {
        return playlistID;
    }

    public void setPlayListID(String playListID) {
        this.playlistID = playListID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }


    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(String homeworkID) {
        this.homeworkID = homeworkID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivationcode() {
        return activationcode;
    }

    public void setActivationcode(String activationcode) {
        this.activationcode = activationcode;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }


    @Override
    public String toString() {
        return "UserRequest{" +
                "activationcode='" + activationcode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", courseID='" + courseID + '\'' +
                ", homeworkID='" + homeworkID + '\'' +
                ", date='" + date + '\'' +
                ", studentid='" + studentid + '\'' +
                ", level_id='" + level_id + '\'' +
                '}';
    }
}
