package org.albertorado.apigeowork.entities;

public class Login {
    private String mail;
    private String password;

    public Login(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Login() {
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

