package com.diemoon.thespyamoungus.services;

import com.diemoon.thespyamoungus.models.Session;
import com.diemoon.thespyamoungus.services.serviceTools.DatabaseInitialize;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SessionService {
    private Firestore firestore;
    public void createSession(){
        // Create a new session
        firestore = DatabaseInitialize.getInstance().getFirestore();
        Session newSession = new Session();

//      Fill up the session data
        newSession.setSessionName("sessionName");
        newSession.setSessionId(123456);
        newSession.setSessionStatus("active");
        newSession.setSessionMaxUsers(5);
        newSession.setSessionCurrentUsers(0);

//      Save the session to Firestore
        System.out.println("Session created: " + newSession);
        firestore.collection("sessions").document().set(newSession);
    }

    public List<Session> getAllSessions(){
        // Get all sessions
        firestore = DatabaseInitialize.getInstance().getFirestore();
        List<Session> sessions = null;

        try {
            sessions = firestore.collection("sessions").get().get().toObjects(Session.class);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public Session getSessionById(Integer sessionId){
        // Get a session by id
        firestore = DatabaseInitialize.getInstance().getFirestore();
        Session session = null;

        try {
            session = firestore.collection("sessions").whereEqualTo("sessionId", sessionId).get().get().toObjects(Session.class).get(0);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return session;
    }

    public void deleteSession(Integer sessionId){
        // Delete a session by id
        firestore = DatabaseInitialize.getInstance().getFirestore();
        Session session = null;

        try {
            session = firestore.collection("sessions").whereEqualTo("sessionId", sessionId).get().get().toObjects(Session.class).get(0);
            firestore.collection("sessions").document(session.getSessionId().toString()).delete();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
