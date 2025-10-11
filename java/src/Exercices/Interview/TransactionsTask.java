package Exercices.Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    private String fromAccount;
    private String toAccount;
    private String currency;
    private double amount;

    public Transaction(String fromAccount, String toAccount, String currency, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.currency = currency;
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Transaction{%s -> %s: %.2f %s}", 
                           fromAccount, toAccount, amount, currency);
    }

}

//	•	Method 1: Map<String, Double> getTotalAmountPerCurrency(List<Transaction> transactions)
//	•	Returns the total amount for each currency.
//  •	Method 2: Map<String, Map<String, Double>> getTotalSentPerAccount(List<Transaction> transactions)
//	•	Returns a map of accounts → map of currencies → total amount sent.
//	•	Example: { "Alice": { "USD": 120.0, "EUR": 50.0 }, "Bob": { "USD": 30.0 } }

class TransactionAggregator {
    public static Map<String, Double> getTotalAmountPerCurrency(List<Transaction> transactions) {
        return transactions.stream()
                .reduce(new HashMap<String, Double>(),
                        (Map<String, Double> acc, Transaction t) -> {
                    acc.merge(t.getCurrency(), t.getAmount(), Double::sum);
                    return acc;
                },
                (Map<String, Double> map1, Map<String, Double> map2) -> {
                    map2.forEach((key, value) -> map1.merge(key, value, Double::sum));
                    return map1;
                });
    }

    public static  Map<String, Map<String, Double>> getTotalSentPerAccount(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getFromAccount,
                        Collectors.groupingBy(
                                Transaction::getCurrency,
                                Collectors.summingDouble(Transaction::getAmount)
                        )
                ));
    }
}

public class TransactionsTask {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            // Alice's transactions
            new Transaction("Alice", "Bob", "USD", 100.0),
            new Transaction("Alice", "Charlie", "USD", 20.0),
            new Transaction("Alice", "David", "EUR", 50.0),
            
            // Bob's transactions  
            new Transaction("Bob", "Alice", "USD", 30.0),
            new Transaction("Bob", "Charlie", "GBP", 75.0),
            
            // Charlie's transactions
            new Transaction("Charlie", "David", "EUR", 25.0),
            new Transaction("Charlie", "Alice", "USD", 15.0),
            
            // David's transactions
            new Transaction("David", "Bob", "GBP", 40.0),
            new Transaction("David", "Alice", "EUR", 60.0),
            
            // Additional edge case scenarios
            new Transaction("Eve", "Frank", "JPY", 1000.0),
            new Transaction("Frank", "Eve", "JPY", 500.0)
        );

        System.out.println("Sample Transactions:");
        transactions.forEach(System.out::println);
        
        System.out.println("\n--- Ready for implementation ---");
        System.out.println("Expected results:");
        System.out.println("Total per currency: {USD=165.0, EUR=135.0, GBP=115.0, JPY=1500.0}");
        System.out.println("Total sent per account:");
        System.out.println("Alice: {USD=120.0, EUR=50.0}");
        System.out.println("Bob: {USD=30.0, GBP=75.0}");
        System.out.println("Charlie: {EUR=25.0, USD=15.0}");
        System.out.println("David: {GBP=40.0, EUR=60.0}");
        System.out.println("Eve: {JPY=1000.0}");
        System.out.println("Frank: {JPY=500.0}");

        System.out.println(TransactionAggregator.getTotalAmountPerCurrency(transactions));
        System.out.println(TransactionAggregator.getTotalSentPerAccount(transactions));

    }
}
