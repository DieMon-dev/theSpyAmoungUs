package com.diemoon.thespyamoungus.controllers;

import com.diemoon.thespyamoungus.models.Session;
import com.diemoon.thespyamoungus.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/create")
    public void createSession() {
        sessionService.createSession();
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Integer id) {
        return sessionService.getSessionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSession(@PathVariable Integer id) {
        sessionService.deleteSession(id);
    }

}
