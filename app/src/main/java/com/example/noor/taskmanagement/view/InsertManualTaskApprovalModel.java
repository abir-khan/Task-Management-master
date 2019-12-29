package com.example.noor.taskmanagement.view;

import java.util.List;

public class InsertManualTaskApprovalModel {



        private String username;
        private String userId;

        private String courseID;
        private String completedTask;
        private String progressTask;
        private String deferredTask;
        private List<TaskApproval> taskApproval = null;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCourseID() {
            return courseID;
        }

        public void setCourseID(String courseID) {
            this.courseID = courseID;
        }

        public String getCompletedTask() {
            return completedTask;
        }

        public void setCompletedTask(String completedTask) {
            this.completedTask = completedTask;
        }

        public String getProgressTask() {
            return progressTask;
        }

        public void setProgressTask(String progressTask) {
            this.progressTask = progressTask;
        }

        public String getDeferredTask() {
            return deferredTask;
        }

        public void setDeferredTask(String deferredTask) {
            this.deferredTask = deferredTask;
        }

        public List<TaskApproval> getTaskApproval() {
            return taskApproval;
        }

        public void setTaskApproval(List<TaskApproval> taskApproval) {
            this.taskApproval = taskApproval;
        }

        public static class TaskApproval {

            public TaskApproval() {
            }

            private String userid;

            private String present;

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getPresent() {
                return present;
            }

            public void setPresent(String present) {
                this.present = present;
            }

            @Override
            public String toString() {
                return "TaskApproval{" +
                        "userid='" + userid + '\n' +
                        ",' present='" + present + '\n' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "InsertManualAttendanceModel{" +
                    "username='" + username + '\n' +
                    ", userId='" + userId + '\n' +
                    ", courseID='" + courseID + '\n' +
                    ", completedTask='" + completedTask + '\n' +
                    ", progressTask='" + progressTask + '\n' +
                    ", deferredTask='" + deferredTask + '\n' +
                    ", taskApproval=" + taskApproval.toString() +
                    '}';
        }


}
