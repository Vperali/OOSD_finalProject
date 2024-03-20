package shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart that stores products.
 */
public class Cart {

    private List<Product> items = new ArrayList<>();

    /**
     * Adds a product to the shopping cart.
     * 
     * @param product The product to be added to the shopping cart.
     */
    public void addProduct(Product product) {
        items.add(product);
        Logger.log("Added product to the shopping cart: " + product.getName());
    }

    /**
     * Removes a product from the shopping cart.
     * 
     * @param product The product to be removed from the shopping cart.
     */
    public void removeProduct(Product product) {
        items.remove(product);
        Logger.log("Removed product from the shopping cart: " + product.getName());
    }

    /**
     * Clears the shopping cart by removing all items.
     */
    public void clearCart() {
        items.clear();
        Logger.log("Shopping cart cleared.");
    }

    /**
     * Retrieves the list of items in the shopping cart.
     * 
     * @return The list of items in the shopping cart.
     */
    public List<Product> getItems() {
        return items;
    }

    /**
     * Calculates the total amount of all items in the shopping cart.
     * 
     * @return The total amount of all items in the shopping cart.
     */
    public double calculateTotalAmount() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
