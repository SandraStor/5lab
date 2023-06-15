package com.example.a5labfin;

public class Company {
    String name, address;

    public Company(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}