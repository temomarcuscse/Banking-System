/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

public class ChequeAccount extends Account {

    // Constructor
    public ChequeAccount(String accountNumber,
                         double balance,
                         String branch,
                         Customer owner) {

        super(accountNumber, balance, branch, owner);
    }

    // Withdrawal method
    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero.");
        }

        if (amount > getBalance()) {
            throw new IllegalArgumentException(
                    "Insufficient funds.");
        }

        deductBalance(amount);
    }
}
