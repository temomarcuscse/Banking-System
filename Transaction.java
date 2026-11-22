/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.time.LocalDateTime;

public class Transaction {
    
     // Attributes
    private LocalDateTime date;
    private String type;
    private double amount;
    private String description;
    
    // Constructor
    public Transaction(String type, double amount, String description) {

        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
    
    // Getters
    public LocalDateTime getDate() {
        return date;
    }
    
    public String getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Display transaction details
    @Override
    public String toString() {

        return date + " | " + type
                + " | BWP " + amount
                + " | " + description;
    }
}
