package com.myolq.user.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 2017-08-24.
 */

public class UserBean {
    /**
     * createdAt : 2017-09-01 11:27:33
     * email : 632521056@qq.com
     * emailVerified : true
     * objectId : 27828dadff
     * updatedAt : 2017-09-01 11:28:04
     * username : 3265824
     */

    private String boy;
    private String createdAt;
    private String email;
//    private boolean emailVerified;
    private String objectId;
    private String updatedAt;
    private String username;
    private String password;


    public UserBean(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

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

//    public boolean isEmailVerified() {
//        return emailVerified;
//    }
//
//    public void setEmailVerified(boolean emailVerified) {
//        this.emailVerified = emailVerified;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "boy='" + boy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", email='" + email + '\'' +
//                ", emailVerified=" + emailVerified +
                ", objectId='" + objectId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
