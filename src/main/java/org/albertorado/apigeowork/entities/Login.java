package org.albertorado.apigeowork.entities;

public class Login {
    private String mail;
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

