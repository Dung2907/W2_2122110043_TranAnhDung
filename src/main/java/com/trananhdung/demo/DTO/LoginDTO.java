package com.trananhdung.demo.DTO;


public class LoginDTO {
    private String email;
    private String passwordHash;
    

    public LoginDTO(){
        
    }
    // Getters
    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}