package shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests for the PaymentProcessor class.
 */
public class PaymentProcessorTest {

    @Test
    /**
     * Tests the processPayment method with a valid amount and payment method.
     */
    public void testProcessPaymentSuccess() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        double amount = 100.0;
        String paymentMethod = "Credit Card";
        assertTrue(paymentProcessor.processPayment(amount, paymentMethod));
    }

    @Test
    /**
     * Tests the processPayment method with an invalid negative amount.
     */
    public void testProcessPaymentInvalidAmount() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        double invalidAmount = -50.0;
        String paymentMethod = "Credit Card";
        assertFalse(paymentProcessor.processPayment(invalidAmount, paymentMethod));
    }

    @Test
    /**
     * Tests the processPayment method with an invalid payment method.
     */
    public void testProcessPaymentInvalidMethod() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        double amount = 50.0;
        String invalidMethod = "Invalid Method";
        assertFalse(paymentProcessor.processPayment(amount, invalidMethod));
    }

    // Add more tests as needed

}
