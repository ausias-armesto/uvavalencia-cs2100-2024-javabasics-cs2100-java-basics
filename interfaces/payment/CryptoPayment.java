package interfaces.payment;

// Implementing the PaymentProcessor interface for cryptocurrency payments
class CryptoPayment implements PaymentMethod {
    private String walletAddress;

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    // Constructor
    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Crypto Wallet.");
    }

    @Override
    public String getName() {
        return "Crypto Wallet";
    }
}
