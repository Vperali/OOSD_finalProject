package shop;

/**
 * The ClothingProduct class represents a concrete implementation of the Product interface for clothing products.
 */
public class Cloths implements Product {

    private String name;
    private double price;
    private String description;
    private int quantityInStock;

    /**
     * Constructs a ClothingProduct with the specified name, price, description, and quantity in stock.
     * @param name The name of the clothing product.
     * @param price The price of the clothing product.
     * @param description The description of the clothing product.
     * @param quantityInStock The quantity of the clothing product in stock.
     */
    public Cloths(String name, double price, String description, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Retrieves the name of the clothing product.
     * @return The name of the clothing product.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the clothing product.
     * @return The price of the clothing product.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the description of the clothing product.
     * @return The description of the clothing product.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the quantity of the clothing product in stock.
     * @return The quantity of the clothing product in stock.
     */
    @Override
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Provides a string representation of the ClothingProduct instance.
     * @return A string representation of the ClothingProduct instance.
     */
    @Override
    public String toString() {
        return "ClothingProduct{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", description='" + getDescription() + '\'' +
                ", quantityInStock=" + getQuantityInStock() +
                '}';
    }
}
