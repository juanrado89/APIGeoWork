package org.albertorado.apigeowork.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class Login {
    @Size(min = 5, max = 255)
    @Email
    private String mail;
    @Size(min = 15, max = 50)
    private String password;
    private int id;
    public Login(int id,String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public Login() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

