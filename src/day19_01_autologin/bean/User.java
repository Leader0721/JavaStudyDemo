package day19_01_autologin.bean;

import java.io.Serializable;

/**
 *

    create database day19;
 use day19;
 create table user(
    username varchar(100) primary key,
    password varchar(100) not null,
    nickname varchar(100) not null);






 * Created by 83731 on 2017/11/05.
 */
public class User implements Serializable {
    private String username;
    private String password;
    private String nickname;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
