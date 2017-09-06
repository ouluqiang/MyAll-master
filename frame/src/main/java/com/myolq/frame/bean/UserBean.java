package com.myolq.frame.bean;

/**
 * Created by root on 2017-08-24.
 */

public class UserBean extends ErrorBean{
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
    private String objectId;
    private String updatedAt;
    private String username;
    private String password;
    private String safetyIssue;
    private String safetyAnswer;
    private String sessionToken;
    private boolean mobilePhoneVerified;
    private boolean emailVerified;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserBean(String username, String password, String boy, String email, String safetyIssue, String safetyAnswer) {
        this.username = username;
        this.password = password;
        this.boy = boy;
        this.email = email;
        this.safetyIssue = safetyIssue;
        this.safetyAnswer = safetyAnswer;
    }

    public String getSafetyIssue() {
        return safetyIssue;
    }

    public void setSafetyIssue(String safetyIssue) {
        this.safetyIssue = safetyIssue;
    }

    public String getSafetyAnswer() {
        return safetyAnswer;
    }

    public void setSafetyAnswer(String safetyAnswer) {
        this.safetyAnswer = safetyAnswer;
    }

//    public UserBean(String username, String password  ) {
//        this.username = username;
//        this.password = password;
//    }

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

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public boolean isMobilePhoneVerified() {
        return mobilePhoneVerified;
    }

    public void setMobilePhoneVerified(boolean mobilePhoneVerified) {
        this.mobilePhoneVerified = mobilePhoneVerified;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "boy='" + boy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified=" + emailVerified +
                ", objectId='" + objectId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", safetyIssue='" + safetyIssue + '\'' +
                ", safetyAnswer='" + safetyAnswer + '\'' +
                '}';
    }
}
