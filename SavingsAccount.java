/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

public class SavingsAccount extends Account implements InterestBearing {

    private static final double INTEREST_RATE = 0.0005;

    public SavingsAccount(String accountNumber, double balance,
                          String branch, Customer owner) {
        super(accountNumber, balance, branch, owner);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException(
            "Withdrawals are not allowed on savings accounts.");
    }

    @Override
    public void payMonthlyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        addInterest(interest);
    }
}
