package org.albertorado.apigeowork.dtos;

public class LoginDto {
    private String mail;
    private String password;

    public LoginDto() {
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
