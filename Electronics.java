package shop;

/**
 * The Electronics class represents a concrete implementation of the Product interface for electronic products.
 */
public class Electronics implements Product {

    private String name;
    private double price;
    private String description;
    private int quantityInStock;

    /**
     * Constructs an Electronics product with the specified name, price, description, and quantity in stock.
     * @param name The name of the electronic product.
     * @param price The price of the electronic product.
     * @param description The description of the electronic product.
     * @param quantityInStock The quantity of the electronic product in stock.
     */
    public Electronics(String name, double price, String description, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    /**
     * Retrieves the name of the electronic product.
     * @return The name of the electronic product.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the electronic product.
     * @return The price of the electronic product.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the description of the electronic product.
     * @return The description of the electronic product.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the quantity of the electronic product in stock.
     * @return The quantity of the electronic product in stock.
     */
    @Override
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Provides a string representation of the Electronics instance.
     * @return A string representation of the Electronics instance.
     */
    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", description='" + getDescription() + '\'' +
                ", quantityInStock=" + getQuantityInStock() +
                '}';
    }
}
