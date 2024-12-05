package com.diemoon.thespyamoungus.services;

import com.diemoon.thespyamoungus.models.User;
import com.diemoon.thespyamoungus.services.serviceTools.DatabaseInitialize;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private Firestore firestore;

    public User createUser(String UserLogin) {
        // Create a new user
        firestore = DatabaseInitialize.getInstance().getFirestore();
        User newUser = new User(UserLogin);

        // Save the user to Firestore
        System.out.println("User created: " + newUser);
        firestore.collection("users").document(newUser.getUserId()).set(newUser);
        return newUser;
    }

    public User getUserById(Integer userId){
        // Get a user by id
        firestore = DatabaseInitialize.getInstance().getFirestore();
        User user = null;

        try {
            user = firestore.collection("users").whereEqualTo("userId", userId).get().get().toObjects(User.class).get(0);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return user;
    }

}
