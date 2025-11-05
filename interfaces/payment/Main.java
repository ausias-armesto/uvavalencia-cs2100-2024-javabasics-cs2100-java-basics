package interfaces.payment;

public class Main {
    public static void main(String[] args) {
        // Initialize payment service
        PaymentService paymentService = new PaymentService();

        // Register different payment methods
        paymentService.registerPaymentMethod(new CreditCardPayment("1234 5678 9012 3456", "John Doe", "12/23"));
        paymentService.registerPaymentMethod(new PayPalPayment("email@company.org"));
        paymentService.registerPaymentMethod(new CryptoPayment("1asdfasdf334asdasdf"));

        // List all available payment methods
        paymentService.listPaymentMethods();

        // Process payments using different methods
        System.out.println("\nProcessing payments...");
        paymentService.processPayment("Credit Card", 150.75);
        paymentService.processPayment("PayPal", 75.00);
        paymentService.processPayment("Crypto Wallet", 300.00);

        // Try an unsupported method
        paymentService.processPayment("Bank Transfer", 200.00); // This will print an error message
    }
}

