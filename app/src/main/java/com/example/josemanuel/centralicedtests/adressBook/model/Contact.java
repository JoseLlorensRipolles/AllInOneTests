package com.example.josemanuel.centralicedtests.adressBook.model;

/**
 * Created by JoseManuel on 14/06/2016.
 */
public class Contact {
    private String name;
    private int phone;

    public Contact(String name ,int phone ) {
        this.phone = phone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String toString(){
        return name + ": " +phone;
    }


}
