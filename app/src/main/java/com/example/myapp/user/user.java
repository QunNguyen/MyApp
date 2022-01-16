package com.example.myapp.user;

import java.io.Serializable;

public class user implements Serializable {
    private String id;
    private String nameaccount;
    private String password;
    private String fullname;
    private int phonenumber;
    private static int index =0;


    public user( String nameaccount, String password, String fullname, int phonenumber) {
        this.id = String.valueOf(index++);
        this.nameaccount = nameaccount;
        this.password = password;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
    }

    public user(String nameaccount, String password) {
        this.nameaccount = nameaccount;
        this.password = password;
    }

    public Object[] objects(){
        return new Object[]{id,nameaccount,password,fullname,phonenumber};
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameaccount() {
        return nameaccount;
    }

    public void setNameaccount(String nameaccount) {
        this.nameaccount = nameaccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
