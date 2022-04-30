package com.ruixiang.moudle;

/**
 * @Classname: UserInfo
 * @Description: 用户信息的获取
 * @Data： 2022/1/26 12:36
 * @Created by ruixiang
 */
public class UserInfo {
    public String userId;
    public String nickname;
    public String description;
    public String statusCode;
    public String msg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
