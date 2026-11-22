/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer {

    private String customerID;
    private String firstName;
    private String lastName;
    private String employerName;
    private String employerAddress;
    private String phoneNumber;
    private String email;

    private List<Account> accounts;

    public Customer(String customerID, String firstName, String lastName,
                    String employerName, String employerAddress,
                    String phoneNumber, String email) {

        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employerName = employerName;
        this.employerAddress = employerAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.accounts = new ArrayList<>();
    }

    public boolean isEmployed() {
        return employerName != null && !employerName.isBlank()
                && employerAddress != null && !employerAddress.isBlank();
    }

    public void openAccount(Account account) {

        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        if (account.getOwner() != this) {
            throw new IllegalArgumentException(
                    "This account does not belong to this customer.");
        }

        if (account instanceof ChequeAccount && !isEmployed()) {
            throw new IllegalArgumentException(
                    "Only employed customers can open cheque accounts.");
        }

        for (Account existingAccount : accounts) {
            if (existingAccount.getAccountNumber()
                    .equals(account.getAccountNumber())) {
                throw new IllegalArgumentException(
                        "Account number already exists for this customer.");
            }
        }

        accounts.add(account);
    }

    public void depositFunds(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdrawFunds(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    private Account findAccount(String accountNumber) {

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        throw new IllegalArgumentException(
                "Account not found: " + accountNumber);
    }

    public List<Transaction> viewTransactionalHistory() {

        List<Transaction> history = new ArrayList<>();

        for (Account account : accounts) {
            history.addAll(account.getTransactions());
        }

        history.sort(Comparator.comparing(Transaction::getDate));

        return history;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public String toString() {
        return customerID + " - " + firstName + " " + lastName;
    }
}
