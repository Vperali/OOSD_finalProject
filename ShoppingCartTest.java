package shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testCalculateTotalAmount() {
        // Load sample products
        List<Product> products = ProductLoader.loadProducts();

        // Create a shopping cart
        Cart cart = new Cart();

        // Add some products to the cart
        cart.addProduct(products.get(0)); // Laptop
        cart.addProduct(products.get(1)); // Smartwatch
        cart.addProduct(products.get(5)); // T-Shirt
        cart.addProduct(products.get(8)); // Dress

        // Calculate the expected total amount
        double expectedTotalAmount = products.get(0).getPrice() + products.get(1).getPrice()
                + products.get(5).getPrice() + products.get(8).getPrice();

        // Check if the total amount matches the expected value (with a small delta for precision issues)
        assertEquals(expectedTotalAmount, cart.calculateTotalAmount(), 0.01);
    }

    @Test
    public void testAddProduct() {
        // Load sample products
        List<Product> products = ProductLoader.loadProducts();

        // Create a shopping cart
        Cart cart = new Cart();

        // Add a product to the cart
        cart.addProduct(products.get(2)); // Headphones

        // Check if the cart contains the added product
        assertEquals(1, cart.getItems().size());
        assertEquals(products.get(2), cart.getItems().get(0));
    }

    @Test
    public void testRemoveProduct() {
        // Load sample products
        List<Product> products = ProductLoader.loadProducts();

        // Create a shopping cart
        Cart cart = new Cart();

        // Add a product to the cart
        Product product = products.get(3); // Smartphone
        cart.addProduct(product);

        // Remove the product from the cart
        cart.removeProduct(product);

        // Check if the cart is empty after removing the product
        assertEquals(0, cart.getItems().size());
    }

    // Add more test cases as needed

}
