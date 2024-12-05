package com.diemoon.thespyamoungus.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Session {
    private Integer sessionId;
    private String sessionName;
    private String sessionPassword;
    private String sessionAdmin;
    private String sessionStatus;
    private Integer sessionMaxUsers;
    private Integer sessionCurrentUsers;
}
