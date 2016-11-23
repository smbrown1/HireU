package com.example.steven.hireu.Model;

/**
 * Created by Steven on 11/13/2016.
 */
public class Person {
    protected String email;
    protected String name;
    protected String password;
    protected String id;
    protected UserTypes.TypeOfUser type;

    public Person(String email, String name, String password, UserTypes.TypeOfUser type) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString()
    {
        return name;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserTypes.TypeOfUser getType() {
        return type;
    }

    public void setType(UserTypes.TypeOfUser type) {
        this.type = type;
    }
}
