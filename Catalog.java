package shop;

import java.util.ArrayList;
import java.util.List;

/**
 * The Catalog class represents a catalog of products available in the online shopping system.
 * It allows for adding, retrieving, and listing products.
 */
public class Catalog {

    // List to store products in the catalog
    private List<Product> products = new ArrayList<>();

    /**
     * Adds a new product to the catalog.
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Retrieves a product from the catalog by its name.
     * @param name The name of the product to retrieve.
     * @return The product with the specified name, or null if not found.
     */
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Retrieves all products in the catalog.
     * @return A list of all products in the catalog.
     */
    public List<Product> getAllProducts() {
        return products;
    }

    /**
     * Adds multiple products to the catalog.
     * @param newProducts The list of products to add.
     */
    public void addProducts(List<Product> newProducts) {
        products.addAll(newProducts);
    }

}
