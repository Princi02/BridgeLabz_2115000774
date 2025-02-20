import java.util.*;

public class BankingSystem {
    static class Account {
        String accountNumber;
        double balance;
        public Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
        public String toString() {
            return "AccountNumber: " + accountNumber + ", Balance: " + balance;
        }
    }

    public static void main(String[] args) {
        Map<String, Double> accounts = new HashMap<>();
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        Queue<String> withdrawalQueue = new LinkedList<>();

        accounts.put("A001", 5000.0);
        accounts.put("A002", 1500.0);
        accounts.put("A003", 2500.0);

        for (Map.Entry<String, Double> entry : accounts.entrySet())
            sortedAccounts.put(entry.getValue(), entry.getKey());

        withdrawalQueue.add("A001");
        withdrawalQueue.add("A002");

        System.out.println("Accounts:");
        accounts.forEach((k, v) -> System.out.println(k + " -> " + v));
        System.out.println("\nSorted Accounts:");
        sortedAccounts.forEach((k, v) -> System.out.println(v + " -> " + k));
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for Account: " + acc);
        }
    }
}
