package shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The CatalogTest class contains test cases for the Catalog class.
 */
public class CatalogTest {

    /**
     * Test for adding a product to the catalog.
     */
    @Test
    public void testAddProduct() {
        // Arrange
        Catalog catalog = new Catalog();
        Product laptop = new Electronics("Lappy", 1100.0, "High-End laptop", 10);

        // Act
        catalog.addProduct(laptop);

        // Assert
        assertEquals(1, catalog.getAllProducts().size());
        assertEquals(laptop, catalog.getProductByName("Lappy"));
    }

    /**
     * Test for adding multiple products to the catalog.
     */
    @Test
    public void testAddProducts() {
        // Arrange
        Catalog catalog = new Catalog();
        List<Product> newProducts = new ArrayList<>();
        Product shirt = new Cloths("Shirt", 30.0, "Nylon T-shirt", 50);
        newProducts.add(shirt);

        // Act
        catalog.addProducts(newProducts);

        // Assert
        assertEquals(1, catalog.getAllProducts().size());
        assertEquals(shirt, catalog.getProductByName("Shirt"));
    }

    /**
     * Test for retrieving a product by its name from the catalog.
     */
    @Test
    public void testGetProductByName() {
        // Arrange
        Catalog catalog = new Catalog();
        Product laptop = new Electronics("Laptop", 1200.0, "High-performance laptop", 10);
        catalog.addProduct(laptop);

        // Assert
        assertEquals(laptop, catalog.getProductByName("Laptop"));
        assertNull(catalog.getProductByName("NonexistentProduct"));
    }

    // Add more tests as needed

}
