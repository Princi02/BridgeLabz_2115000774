package AccessModifiers;

class BankAccount{
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount should be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance()); 
    }
}


public class BankAccountManagement {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("123456789", "John Doe", 1000.00);

        // Displaying account details
        savingsAccount.displayAccountDetails();

        // Depositing money into the account
        savingsAccount.deposit(500.00);
        System.out.println("\nAfter depositing 500.00:");
        savingsAccount.displayAccountDetails();

        // Withdrawing money from the account
        savingsAccount.withdraw(300.00);
        System.out.println("\nAfter withdrawing 300.00:");
        savingsAccount.displayAccountDetails();
    }
}
