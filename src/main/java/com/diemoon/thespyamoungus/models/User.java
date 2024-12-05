package com.diemoon.thespyamoungus.models;

import com.diemoon.thespyamoungus.services.serviceTools.Generator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public User(String userLogin) {
        this.userId = Generator.generateUserId(userLogin);
        this.userLogin = userLogin;
        this.userNickname = "Player";
        this.userIsDead = false;
        this.userIsSpy = false;
        this.userIsVoted = false;
    }
    private String userId;
    private String userLogin;
    private String userNickname;
    private Boolean userIsSpy;
    private Boolean userIsDead;
    private Boolean userIsVoted;
}
