package shop;

/**
 * Represents a customer of the online shop.
 */
public class Customer {

    private String username;
    private String password;
    private String fullName;
    private String emailAddress;

    /**
     * Constructs a customer with the specified username, password, name, and email.
     *
     * @param username    The username of the customer.
     * @param password    The password of the customer.
     * @param fullName    The full name of the customer.
     * @param emailAddress The email address of the customer.
     */
    public Customer(String username, String password, String fullName, String emailAddress) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    /**
     * Returns the username of the customer.
     *
     * @return The username of the customer.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the customer.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the customer.
     *
     * @return The password of the customer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the customer.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the full name of the customer.
     *
     * @return The full name of the customer.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the customer.
     *
     * @param fullName The full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param emailAddress The email address to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
