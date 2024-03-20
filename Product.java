package shop;

/**
 * Represents the general structure of a product.
 */
public interface Product {

    /**
     * Gets the name of the product.
     * 
     * @return The name of the product.
     */
    String getName();

    /**
     * Gets the price of the product.
     * 
     * @return The price of the product.
     */
    double getPrice();

    /**
     * Gets the description of the product.
     * 
     * @return The description of the product.
     */
    String getDescription();

    /**
     * Gets the quantity of the product in stock.
     * 
     * @return The quantity of the product in stock.
     */
    int getQuantityInStock();
}
