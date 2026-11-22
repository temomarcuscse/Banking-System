/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private String bankName;
    private String bankBranch;
    private List<Customer> customers;

    public Bank(String bankName, String bankBranch) {
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.customers = new ArrayList<>();
    }

    // Register an existing customer
    public void registerCustomer(Customer customer) {

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer cannot be null.");
        }

        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerID()
                    .equals(customer.getCustomerID())) {
                throw new IllegalArgumentException(
                        "Customer ID already exists.");
            }
        }

        customers.add(customer);
    }

    // Create and register a new customer
    public Customer registerCustomer(String customerID,
                                     String firstName,
                                     String lastName,
                                     String employerName,
                                     String employerAddress,
                                     String phoneNumber,
                                     String email) {

        Customer customer = new Customer(
                customerID, firstName, lastName,
                employerName, employerAddress,
                phoneNumber, email);

        registerCustomer(customer);

        return customer;
    }

    // Pay monthly interest to all eligible accounts
    public void payInterest() {

        for (Customer customer : customers) {

            for (Account account : customer.getAccounts()) {

                if (account instanceof InterestBearing) {
                    InterestBearing interestAccount =
                            (InterestBearing) account;

                    interestAccount.payMonthlyInterest();
                }
            }
        }
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    @Override
    public String toString() {
        return bankName + " - " + bankBranch;
    }
}
