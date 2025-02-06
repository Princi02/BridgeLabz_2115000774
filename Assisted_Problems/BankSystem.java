package Assisted_Problems;

import java.util.*;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        customer.addAccount(new BankAccount(this, initialDeposit)); // Association
        System.out.println(customer.getName() + " opened an account at " + name + " with $" + initialDeposit);
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

class Customer {
    private String name;
    private List<BankAccount> accounts; // A customer can have multiple accounts

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + " at " + accounts.get(i).getBank().getName() +
                    " - Balance: $" + accounts.get(i).getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class BankAccount {
    private Bank bank;
    private double balance;

    public BankAccount(Bank bank, double initialDeposit) {
        this.bank = bank;
        this.balance = initialDeposit;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("BOB");
        Bank bank2 = new Bank("HDFC");

        Customer customer1 = new Customer("Priyanshi");
        Customer customer2 = new Customer("Alice");

        bank1.openAccount(customer1, 1000.00);
        bank2.openAccount(customer1, 2000.00);
        bank1.openAccount(customer2, 1500.00);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
