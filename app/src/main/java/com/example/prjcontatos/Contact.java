package com.example.prjcontatos;

public class Contact {


    public Contact (String n, String p) {
        this.name = n;
        this.phone = p;
    }

    private String name;
    private String phone;

    public String getName(){return this.name;}
    public void setName(String n){this.name = n;}

    public String getPhone(){return this.phone;}
    public void setPhone(String p){this.phone = p;}
}
