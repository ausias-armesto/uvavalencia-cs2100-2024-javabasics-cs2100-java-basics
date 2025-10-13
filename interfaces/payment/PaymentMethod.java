package interfaces.payment;


// Define the PaymentProcessor interface
public interface PaymentMethod {
    public void pay(double amount);
    public String getName();
}
