package com.challangeAlkemy.dto;

import com.challangeAlkemy.entities.User;

public class UserDto {
    
    private String username;
    private String password;


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

    public User getUserFromDto(){
        User user = new User();
        user.setNombre(username);
        user.setPassword(password);
        return user;
    }
    
}