package com.example.a5labfin;

import java.util.ArrayList;

public class Courier {
    private String name;
    private String bankAccount;
    private ArrayList<Order> orders;

    public Courier(String name, String bankAccount){
        this.name = name;
        this.bankAccount = bankAccount;
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public ArrayList<Order>getOrders(){return orders;}

}
