package com.toast.administrator.hello.data.db.model;

public class User {
    String name;
    String password;

    public User(String name, String pwd) {
        this.name = name;
        password = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
