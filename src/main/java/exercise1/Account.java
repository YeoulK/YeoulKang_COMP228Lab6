package exercise1;


public class Account {
    private double balance;


    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }


    public synchronized void deposit(double amount) {
        if (amount > 0) {
            double newBalance = balance + amount;
            System.out.printf("%s depositing %.2f. New balance: %.2f%n",
                    Thread.currentThread().getName(), amount, newBalance);
            balance = newBalance;
        }
    }


    public synchronized void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                double newBalance = balance - amount;
                System.out.printf("%s withdrawing %.2f. New balance: %.2f%n",
                        Thread.currentThread().getName(), amount, newBalance);
                balance = newBalance;
            } else {
                System.out.printf("%s attempted to withdraw %.2f but only %.2f is available.%n",
                        Thread.currentThread().getName(), amount, balance);
            }
        }
    }


    public synchronized double getBalance() {
        return balance;
    }
}