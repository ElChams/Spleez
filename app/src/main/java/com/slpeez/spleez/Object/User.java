package com.slpeez.spleez.Object;

/**
 * Created by thibaut on 17/03/2016.
 */
public class User {

    private int _id;
    private String _login;
    private String _password;
    private String _firstname;
    private String _lastname;
    private int _age;

    public void setId(int id) {
        _id = id;
    }
    public int getId() {
        return _id;
    }

    public void setLogin(String login) {
        _login = login;
    }
    public String getLogin() {
        return _login;
    }

    public void getPassword(String password) {
        _password = password;
    }
    public String getPassword() {
        return _password;
    }

    public void setFirstname(String firstname) {
        _firstname = firstname;
    }
    public String getFirstname() {
        return _password;
    }

    public void setLastname(String lastname) {
        _lastname = lastname;
    }
    public String getLastname() {
        return _lastname;
    }

    public void setAge(int age) {
        _age = age;
    }
    public int getAge() {
        return _age;
    }
}
