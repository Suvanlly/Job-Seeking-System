package com.jssgui.gui;

public class UserInstance {
    private User user;
    private static final UserInstance instance = new UserInstance();

    private UserInstance(){}

    public static UserInstance getInstance(){
        return instance;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User u){
        this.user = u;
    }
}
