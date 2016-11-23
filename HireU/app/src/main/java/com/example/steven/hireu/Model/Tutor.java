package com.example.steven.hireu.Model;

/**
 * Created by Steven on 11/13/2016.
 */
public class Tutor extends Person {
    private String major;

    public Tutor(String email, String name, String password, UserTypes.TypeOfUser type, String major) {
        super(email, name, password, type);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString()
    {
        return super.toString()+" "+major;
    }
}
