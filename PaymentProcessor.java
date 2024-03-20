package shop;

/**
 * Handles payment processing for orders.
 */
public class PaymentProcessor {

    /**
     * Processes a payment for the specified amount using the given payment method.
     *
     * @param amount       The amount to be paid.
     * @param paymentMethod The payment method to use (e.g., Credit Card, PayPal, etc.).
     * @return true if the payment is successful, false otherwise.
     */
    public boolean processPayment(double amount, String paymentMethod) {
        // Simulate payment processing using a mock payment gateway

        // Check if the payment method is valid (e.g., Credit Card, PayPal, etc.)
        if (isValidPaymentMethod(paymentMethod)) {
            // Check if the amount is valid
            if (amount > 0) {
                // Simulate a successful payment
                System.out.println("Processing payment of $" + amount + " via " + paymentMethod);
                System.out.println("Payment successful.");
                return true;
            } else {
                System.out.println("Invalid payment amount.");
            }
        } else {
            System.out.println("Invalid payment method.");
        }
        // If payment processing fails, return false
        System.out.println("Payment processing failed.");
        return false;
    }

    /**
     * Checks if the given payment method is valid.
     *
     * @param paymentMethod The payment method to validate.
     * @return true if the payment method is valid, false otherwise.
     */
    private boolean isValidPaymentMethod(String paymentMethod) {
        // Simulate validation of payment method (e.g., check against a list of supported methods)
        // For simplicity, we'll assume all payment methods are valid except "Invalid Method".
        return !"Invalid Method".equals(paymentMethod);
    }
}
