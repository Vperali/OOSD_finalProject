package shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads sample products into the catalog.
 */
public class ProductLoader {

    /**
     * Loads sample products into the catalog.
     * 
     * @return A list of sample products.
     */
    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        // Add sample clothing products
        products.add(new Cloths("T-Shirt", 24.99, "Casual cotton t-shirt for everyday wear", 50));
        products.add(new Cloths("Jeans", 49.99, "Classic denim jeans for a timeless look", 30));
        products.add(new Cloths("Sneakers", 69.99, "Stylish sneakers for active lifestyles", 25));
        products.add(new Cloths("Dress", 89.99, "Chic dress for formal occasions", 15));
        products.add(new Cloths("Hoodie", 34.99, "Comfortable hoodie for cozy days", 40));
        
        // Add sample electronics products
        products.add(new Electronics("Laptop", 1299.99, "Portable computing device for work and entertainment", 10));
        products.add(new Electronics("Smartwatch", 199.99, "Wearable device for tracking fitness and notifications", 20));
        products.add(new Electronics("Wireless Headphones", 99.99, "Over-ear headphones for immersive audio experience", 15));
        products.add(new Electronics("Smartphone", 799.99, "Advanced mobile device with cutting-edge features", 10));
        products.add(new Electronics("Tablet", 399.99, "Compact tablet for browsing and multimedia", 8));

        return products;
    }
}
