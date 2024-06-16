package com.hmovie.vn.dto.response;

public class UserCreatedDateResponse {
    private String userCreatedDate;

    public UserCreatedDateResponse(String userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }

    public String getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(String userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }
}
