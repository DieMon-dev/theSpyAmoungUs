package com.diemoon.thespyamoungus.services.serviceTools;

import com.diemoon.thespyamoungus.models.User;

public class Generator {
    public static String generateUserId(String userLogin){
        String userId = userLogin + "123";
        return userId;
    }
}
