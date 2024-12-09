package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {

        Account sharedAccount = new Account(1500);

        System.out.println("Initial Account Balance: " + sharedAccount.getBalance());


        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(sharedAccount, false, 500.00));
        transactions.add(new Transaction(sharedAccount, true, 200.00));
        transactions.add(new Transaction(sharedAccount, false, 1000.00));
        transactions.add(new Transaction(sharedAccount, true, 100.00));
        transactions.add(new Transaction(sharedAccount, false, 40.00));


        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (Transaction t : transactions) {
            executorService.execute(t);
        }

        executorService.shutdown();


        while (!executorService.isTerminated()) {
        }


        System.out.printf("Final Account Balance: %.2f%n", sharedAccount.getBalance());
    }
}


