package exceptions.bank;

public class BankAccount {
    private double balance;
    private double dailyLimit = 500.0; // Daily limit for withdrawals
    private double totalWithdrawnToday = 0.0;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }

        if ((totalWithdrawnToday + amount) > dailyLimit) {
            throw new TransactionLimitExceededException("Daily transaction limit exceeded.");
        }

        balance -= amount;
        totalWithdrawnToday += amount;
        System.out.println("Withdrew: $" + amount);
        //throw new Error("This is a Uncaught Error");
    }

    public double getBalance() {
        return balance;
    }
}

