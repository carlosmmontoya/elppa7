package com.example.elppa;

public class msnheder {
    public String id;

    public String  name;
    public String  Surname;
    public String email;
    public String hash;
    public String roll;
    public String token;
    public  String updated_at;
    public String usermail;

    public msnheder(String id, String name, String surname, String email, String hash, String roll, String token, String updated_at, String usermail) {
        this.id = id;
        this.name = name;
        Surname = surname;
        this.email = email;
        this.hash = hash;
        this.roll = roll;
        this.token = token;
        this.updated_at = updated_at;
        this.usermail = usermail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }
}
