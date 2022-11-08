package com.example.prjcontatos;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contact {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Contact (String n, String p, String d) {
        this.name = n;
        this.phone = p;
        this.birthday = LocalDate.parse(d, dateTimeFormatter);
    }

    private String name;
    private String phone;
    private LocalDate birthday;

    public String getName(){return this.name;}
    public void setName(String n){this.name = n;}

    public String getPhone(){return this.phone;}
    public void setPhone(String p){this.phone = p;}

    private LocalDate getBirthDay(){ return this.birthday; }

}
