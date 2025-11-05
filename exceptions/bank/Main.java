package exceptions.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        try {
            System.out.println("Initial Balance: $" + account.getBalance());
            account.deposit(200);
            System.out.println("Balance after deposit: $" + account.getBalance());
            
            // Withdraw multiple times to approach the limit
            account.withdraw(300); // First withdrawal within limit
            System.out.println("Balance after first withdrawal: $" + account.getBalance());
            
            account.withdraw(150); // Second withdrawal, close to the limit
            System.out.println("Balance after second withdrawal: $" + account.getBalance());
            
            // This withdrawal should exceed the daily limit and throw an unchecked exception
            account.withdraw(100); 
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (TransactionLimitExceededException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }

        System.out.println("Final Balance: $" + account.getBalance());
    }
}
