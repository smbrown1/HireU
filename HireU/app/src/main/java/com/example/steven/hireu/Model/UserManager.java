package com.example.steven.hireu.Model;

import java.util.HashMap;
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

    private UserManager()
    {
        tutorList = new HashMap<>();
        employerList = new HashMap<>();
        fixedUsers();
        fixedEmployers();
    }

    public void setCurrentUser(Person currentUser) {
        this.currentUser = currentUser;
    }

    public Map<String, Tutor> getTutorList() {

        return tutorList;
    }

    private void fixedUsers()
    {
        tutorList.put("stevenbrown@byu.net",new Tutor("StevenBrown@byu.net","Steven Brown","password",UserTypes.TypeOfUser.TUTOR,"Computer Science"));
        tutorList.put("person1@byu.net",new Tutor("person1@byu.net","person1","password",UserTypes.TypeOfUser.TUTOR,"Computer Science"));
        tutorList.put("person2@byu.net",new Tutor("person2@byu.net","person2","password",UserTypes.TypeOfUser.TUTOR,"Computer Science"));
        tutorList.put("person3@byu.net",new Tutor("person3@byu.net","person3","password",UserTypes.TypeOfUser.TUTOR,"Computer Science"));

    }

    private void fixedEmployers()
    {
        employerList.put("employer@gmail.com",new Person("employer@gmail.com","I am the Employer","password",UserTypes.TypeOfUser.PERSON));
    }

    public UserTypes.TypeOfUser login(String email, String password)
    {
        if(tutorList.get(email)!=null)
        {
            Tutor t = tutorList.get(email);
            if(t.getPassword().contains(password))
            {
                currentUser=t;
                return UserTypes.TypeOfUser.TUTOR;
            }
        }
        else if(employerList.get(email)!=null)
        {
            Person t = employerList.get(email);
            if(t.getPassword().contains(password))
            {
                currentUser=t;
                return UserTypes.TypeOfUser.PERSON;
            }
        }
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
