/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account {

    // Attributes
    private String accountNumber;
    private double balance;
    private String branch;
    private Customer owner;

    private List<Transaction> transactions;

    // Constructor
    public Account(String accountNumber, double balance,
                   String branch, Customer owner) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Account number is required.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative.");
        }

        if (branch == null || branch.isBlank()) {
            throw new IllegalArgumentException(
                    "Branch is required.");
        }

        if (owner == null) {
            throw new IllegalArgumentException(
                    "An account must have an owner.");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.owner = owner;

        this.transactions = new ArrayList<>();

        // Record initial deposit
        if (balance > 0) {
            transactions.add(new Transaction(
                    "OPENING DEPOSIT",
                    balance,
                    "Initial account deposit"
            ));
        }
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero.");
        }

        balance += amount;

        transactions.add(new Transaction(
                "DEPOSIT",
                amount,
                "Money deposited"
        ));
    }

    // Abstract withdrawal method
    public abstract void withdraw(double amount);

    // Add interest to account balance
    protected void addInterest(double amount) {

        if (amount > 0) {
            balance += amount;

            transactions.add(new Transaction(
                    "INTEREST",
                    amount,
                    "Monthly interest paid"
            ));
        }
    }

    // Deduct money from account balance
    protected void deductBalance(double amount) {

        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException(
                    "Invalid withdrawal amount.");
        }

        balance -= amount;

        transactions.add(new Transaction(
                "WITHDRAWAL",
                amount,
                "Money withdrawn"
        ));
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public Customer getOwner() {
        return owner;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
