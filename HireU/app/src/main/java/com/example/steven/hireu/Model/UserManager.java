package com.example.steven.hireu.Model;

import java.util.Map;

/**
 * Created by Steven on 11/13/2016.
 */
public class UserManager {
    private Map<String,Tutor> tutorList;
    private Map<String,Person> employerList;
    private static UserManager SINGLETON;
    private Person currentUser;
    private int id;

    public UserTypes.TypeOfUser login(String email, String password)
    {
        return UserTypes.TypeOfUser.NOTREGISTERED;
    }

    public static UserManager getInstance()
    {
        if(SINGLETON==null)
        {
            SINGLETON = new UserManager();
        }
        return SINGLETON;
    }

    public Boolean registerTutor(Tutor tutor)
    {
        id++;
        tutor.setId(getId());
        currentUser = tutor;
        tutorList.put(tutor.getEmail(),tutor);
        return true;
    }

    private String getId()
    {
        return String.valueOf(id);
    }

    public Person getCurrentUser()
    {
        return currentUser;
    }
}
