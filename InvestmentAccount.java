/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

public class InvestmentAccount extends Account implements InterestBearing {

    private static final double INTEREST_RATE = 0.05;
    private static final double MINIMUM_DEPOSIT = 500.00;

    public InvestmentAccount(String accountNumber, double balance,
                             String branch, Customer owner) {
        super(accountNumber, balance, branch, owner);

        if (balance < MINIMUM_DEPOSIT) {
            throw new IllegalArgumentException(
                "Investment accounts require a minimum opening deposit of BWP 500.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be greater than zero.");
        }

        if (amount > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        deductBalance(amount);
    }

    @Override
    public void payMonthlyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        addInterest(interest);
    }
}
