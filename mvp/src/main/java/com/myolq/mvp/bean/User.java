package com.myolq.mvp.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class User {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "User{" +
                "results=" + results +
                '}';
    }

    public static class ResultsBean {
        /**
         * createdAt : 2017-02-13 09:23:18
         * email : 1234561@qq.com
         * objectId : 3173642a66
         * updatedAt : 2017-02-13 10:22:20
         * username : admin
         */

        private String createdAt;
        private String email;
        private String objectId;
        private String updatedAt;
        private String username;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "createdAt='" + createdAt + '\'' +
                    ", email='" + email + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }
    }
}
