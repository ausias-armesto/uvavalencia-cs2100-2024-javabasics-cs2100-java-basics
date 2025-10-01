package interfaces.payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<String, PaymentMethod> paymentMethods;

    public PaymentService() {
        this.paymentMethods = new HashMap<>();
    }

    public void registerPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getName(), paymentMethod);
    }

    public void processPayment(String methodName, double amount) {
        if (paymentMethods.containsKey(methodName)) {
            paymentMethods.get(methodName).pay(amount);
        } else {
            System.err.println("[ERROR] Payment method " + methodName + " not found.");
        }
    }

    public void listPaymentMethods() {
        System.out.println("Available Payment Methods:");
        paymentMethods.values().forEach(pm -> System.out.println(" - " + pm.getName()));
    }
}
