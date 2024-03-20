package shop;

/**
 * Represents an order placed by a customer.
 */
class Order {

    private Customer customer;
    private Cart cart;
    private String orderStatus;

    /**
     * Constructs an order with the specified customer and shopping cart.
     *
     * @param customer The customer who placed the order.
     * @param cart     The shopping cart containing items for the order.
     */
    public Order(Customer customer, Cart cart) {
        this.customer = customer;
        this.cart = cart;
        this.orderStatus = "Pending";
    }

    /**
     * Places the order if it's pending.
     * Otherwise, indicates that the order has already been placed.
     */
    public void placeOrder() {
        if (orderStatus.equals("Pending")) {
            // Simulate order placement logic
            Logger.log("Placing the order for Customer: " + customer.getUsername());
            Logger.log("Order Details:");
            for (Product product : cart.getItems()) {
                Logger.log(product.getName() + " - $" + product.getPrice());
            }
            Logger.log("Total Amount: $" + cart.calculateTotalAmount());

            // Implement additional order placement logic here, such as recording order
            // details, updating inventory, etc.

            // For this example, we'll keep it simple by updating the order status.
            this.orderStatus = "Placed";
            Logger.log("Order placed successfully.");
        } else {
            Logger.log("Order has already been placed.");
        }
    }

    /**
     * Returns the customer associated with the order.
     *
     * @return The customer who placed the order.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Returns the shopping cart associated with the order.
     *
     * @return The shopping cart containing items for the order.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Returns the status of the order.
     *
     * @return The status of the order (e.g., "Pending", "Placed").
     */
    public String getOrderStatus() {
        return orderStatus;
    }
}
