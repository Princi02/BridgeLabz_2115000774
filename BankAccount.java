public class BankAccount{

    static String bankName = "Bank Of Baroda";
    static int totalAccounts = 0;
    final String accountNumber;
    String accountHolderName;

    public BankAccount(String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
    }

    public void displayDetails(){
        if(this instanceof BankAccount){
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Priyanshi", "123456");

        account1.displayDetails();
        BankAccount.getTotalAccounts();
        
    }

}