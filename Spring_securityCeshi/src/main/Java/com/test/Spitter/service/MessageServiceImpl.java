package com.test.Spitter.service;

public class MessageServiceImpl   implements  MessageService{
    public String adminMessage() {
        return "admin message";
    }

    public String adminDate() {
        return "admin " + System.currentTimeMillis();
    }
    public String userMessage() {
        return "user message";
    }

    public String userDate() {
        return "user " + System.currentTimeMillis();
    }
}