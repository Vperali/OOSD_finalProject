package shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OnlineShoppingGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private Customer currentUser;
	private UserAuthentication userAuthentication;
	private Cart shoppingCart;
	private Catalog catalog;

	public OnlineShoppingGUI() {
		super("Online Shopping System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		// Initialize user authentication, shopping cart, and catalog
		userAuthentication = new UserAuthentication();
		shoppingCart = new Cart();
		catalog = new Catalog();
		catalog.addProducts(ProductLoader.loadProducts());

		setupGUIComponents();

		setVisible(true);
	}

	private void setupGUIComponents() {
		JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5)); // Use GridLayout for better arrangement

		// Register button
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(e -> showRegistrationDialog());
		panel.add(registerButton);

		// Login button
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(e -> createLoginDialog());
		panel.add(loginButton);

		// Browse products button
		JButton browseProductsButton = new JButton("Browse Products");
		browseProductsButton.addActionListener(e -> createProductList());
		panel.add(browseProductsButton);

		// Add to cart button
		JButton addToCartButton = new JButton("Add to Cart");
		addToCartButton.addActionListener(e -> showAddToCartDialog());
		panel.add(addToCartButton);

		// View cart button
		JButton viewCartButton = new JButton("View Cart");
		viewCartButton.addActionListener(e -> showCart());
		panel.add(viewCartButton);

		// Place order button
		JButton placeOrderButton = new JButton("Place Order");
		placeOrderButton.addActionListener(e -> placeOrder());
		panel.add(placeOrderButton);

		// Add the panel to the frame
		add(panel);
	}

	/**
	 * Displays the registration dialog for users to input their registration
	 * details. If the user clicks OK, the entered information is retrieved and
	 * validated. If the registration is successful, the user is registered and a
	 * success message is shown. If the registration fails due to invalid input,
	 * error messages are displayed.
	 */
	private void showRegistrationDialog() {
		// Create text fields for username, password, name, and email
		JTextField usernameField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		JTextField nameField = new JTextField();
		JTextField emailField = new JTextField();

		// Create an object array to hold the components of the registration dialog
		Object[] message = { "Username:", usernameField, "Password:", passwordField, "Name:", nameField, "Email:",
				emailField };

		// Display the registration dialog and capture the user's choice
		int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);

		// If the user clicks OK, proceed with the registration process
		if (option == JOptionPane.OK_OPTION) {
			// Retrieve the entered registration information
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			String name = nameField.getText();
			String email = emailField.getText();

			// Validate the entered information
			if (!isValidUsername(username)) {
				JOptionPane.showMessageDialog(null, "Username must contain only lowercase letters.");
			} else if (!isValidPassword(password)) {
				JOptionPane.showMessageDialog(null,
						"Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
			} else if (!isValidName(name)) {
				JOptionPane.showMessageDialog(null,
						"Name must be in the format 'First Last' with the first letter of each word capitalized.");
			} else if (!isValidEmail(email)) {
				JOptionPane.showMessageDialog(null, "Email must contain the @ symbol.");
			} else {
				// If validation passes, register the user
				userAuthentication.registerUser(username, password, name, email);
				Logger.log("User registered: " + username);
				JOptionPane.showMessageDialog(null, "User registered successfully!");
			}
		}
	}

	/**
	 * Displays the login dialog for users to input their username and password. If
	 * the user clicks OK, the entered username and password are retrieved and
	 * validated. If the login is successful, the user is logged in and a success
	 * message is shown. If the login fails, an error message is displayed.
	 */
	private void createLoginDialog() {
		// Create text fields for username and password
		JTextField usernameField = new JTextField();
		JPasswordField passwordField = new JPasswordField();

		// Create an object array to hold the components of the login dialog
		Object[] message = { "Username:", usernameField, "Password:", passwordField };

		// Display the login dialog and capture the user's choice
		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

		// If the user clicks OK, proceed with the login process
		if (option == JOptionPane.OK_OPTION) {
			// Retrieve the entered username and password
			String loginUsername = usernameField.getText();
			String loginPassword = new String(passwordField.getPassword());

			// Perform login validation
			if (currentUser != null) {
				// If a user is already logged in, display a message
				JOptionPane.showMessageDialog(null, "You are already logged in.");
			} else {
				// Attempt to log in the user using the entered credentials
				currentUser = userAuthentication.login(loginUsername, loginPassword);

				// If login is successful, display a success message
				if (currentUser != null) {
					Logger.log("User logged in: " + currentUser.getUsername());
					JOptionPane.showMessageDialog(null,
							"Login successful. Welcome, " + currentUser.getUsername() + "!");
				} else {
					// If login fails, display an error message
					Logger.log("Login failed for user: " + loginUsername);
					JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
				}
			}
		}
	}

	/**
	 * Displays the list of products available in the catalog in a dialog window. If
	 * there are products available, they are shown in a scrollable list with their
	 * details. If the catalog is empty, a message indicating that there are no
	 * products is displayed.
	 */
	private void createProductList() {
		// Get the list of products from the catalog
		List<Product> productList = catalog.getAllProducts();

		// Check if the product list is not empty
		if (!productList.isEmpty()) {
			// Create a list model to store product information
			DefaultListModel<String> listModel = new DefaultListModel<>();

			// Iterate through each product in the list
			for (Product product : productList) {
				// Construct a string containing product details
				String productInfo = product.getName() + " - $" + product.getPrice() + "\n Description: "
						+ product.getDescription() + "\n Quantity in Stock: " + product.getQuantityInStock() + "\n";

				// Add the product info to the list model
				listModel.addElement(productInfo);
			}

			// Create a JList with the list model
			JList<String> productListJList = new JList<>(listModel);

			// Create a scroll pane to hold the JList
			JScrollPane scrollPane = new JScrollPane(productListJList);

			// Display the scrollable list of products in a dialog window
			JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.PLAIN_MESSAGE);
		} else {
			// If there are no products available in the catalog, display a message
			JOptionPane.showMessageDialog(null, "No products available in the catalog.", "Product List",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Displays a dialog for adding a product to the shopping cart. If the user is
	 * logged in, they can input the name of the product they want to add. If the
	 * product is found in the catalog, it is added to the shopping cart. If the
	 * user is not logged in, a message prompts them to log in to add products.
	 */
	private void showAddToCartDialog() {
		// Check if the user is logged in
		if (currentUser != null) {
			// Create a text field for entering the product name
			JTextField productNameField = new JTextField();

			// Create the message to display in the dialog
			Object[] message = { "Enter the product name to add to the cart:", productNameField };

			// Display the dialog and capture the user's choice
			int option = JOptionPane.showConfirmDialog(null, message, "Add to Cart", JOptionPane.OK_CANCEL_OPTION);

			// If the user clicks OK, proceed with adding the product to the cart
			if (option == JOptionPane.OK_OPTION) {
				// Retrieve the entered product name
				String productName = productNameField.getText();

				// Find the product in the catalog by its name
				Product selectedProduct = findProductByName(catalog.getAllProducts(), productName);

				// If the product is found, add it to the shopping cart
				if (selectedProduct != null) {
					shoppingCart.addProduct(selectedProduct);
					JOptionPane.showMessageDialog(null, "Product added to the cart.");
				} else {
					// If the product is not found, display an error message
					JOptionPane.showMessageDialog(null, "Product not found in the catalog.");
				}
			}
		} else {
			// If the user is not logged in, display a message prompting them to log in
			JOptionPane.showMessageDialog(null, "You need to log in to add products to the cart.");
		}
	}

	/**
	 * Displays a dialog for removing a product from the shopping cart. If the user
	 * is logged in, they can input the name of the product they want to remove. If
	 * the product is found in the cart, it is removed from the shopping cart. If
	 * the user is not logged in, a message prompts them to log in to remove
	 * products.
	 */
	private void removeFromCartDialog() {
		// Check if the user is logged in
		if (currentUser != null) {
			// Get the list of items in the shopping cart
			List<Product> cartItems = shoppingCart.getItems();

			// Check if the cart is not empty
			if (!cartItems.isEmpty()) {
				// Create a text field for entering the product name
				JTextField productNameField = new JTextField();

				// Create the message to display in the dialog
				Object[] message = { "Enter the product name to remove from the cart:", productNameField };

				// Display the dialog and capture the user's choice
				int option = JOptionPane.showConfirmDialog(null, message, "Remove from Cart",
						JOptionPane.OK_CANCEL_OPTION);

				// If the user clicks OK, proceed with removing the product from the cart
				if (option == JOptionPane.OK_OPTION) {
					// Retrieve the entered product name
					String productName = productNameField.getText();

					// Find the product in the cart by its name
					Product productToRemove = findProductByName(cartItems, productName);

					// If the product is found, remove it from the shopping cart
					if (productToRemove != null) {
						shoppingCart.removeProduct(productToRemove);
						JOptionPane.showMessageDialog(null, "Product removed from the cart.");
					} else {
						// If the product is not found, display an error message
						JOptionPane.showMessageDialog(null, "Product not found in the cart.");
					}
				}
			} else {
				// If the cart is empty, display a message informing the user
				JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Remove from Cart",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			// If the user is not logged in, display a message prompting them to log in
			JOptionPane.showMessageDialog(null, "You need to log in to remove products from the cart.");
		}
	}

	/**
	 * Finds a product in the given list of products by its name.
	 * 
	 * @param products    The list of products to search.
	 * @param productName The name of the product to find.
	 * @return The product if found, null otherwise.
	 */
	private Product findProductByName(List<Product> products, String productName) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(productName)) {
				return product;
			}
		}
		return null;
	}

	/**
	 * Displays the contents of the shopping cart. If the cart is not empty, it
	 * shows the list of items with their prices. If the cart is empty, it displays
	 * a message indicating that the cart is empty.
	 */
	private void showCart() {
		// Get the list of items in the shopping cart
		List<Product> cartItems = shoppingCart.getItems();

		// Check if the cart is not empty
		if (!cartItems.isEmpty()) {
			// Create a list model to store the items in the cart
			DefaultListModel<String> listModel = new DefaultListModel<>();

			// Populate the list model with item information
			for (Product item : cartItems) {
				String itemInfo = item.getName() + " - $" + item.getPrice();
				listModel.addElement(itemInfo);
			}

			// Create a JList to display the items
			JList<String> cartItemList = new JList<>(listModel);

			// Create a scroll pane to accommodate the list
			JScrollPane scrollPane = new JScrollPane(cartItemList);

			// Calculate the total price of items in the cart
			double totalPrice = calculateTotalPrice(shoppingCart);

			// Create a message with the total price
			String totalPriceMessage = "Total Price: $" + totalPrice;

			// Display the cart contents along with the total price
			JOptionPane.showMessageDialog(null, new Object[] { scrollPane, totalPriceMessage }, "Shopping Cart",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			// If the cart is empty, display a message indicating that it is empty
			JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Shopping Cart",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Places an order if the user is logged in. Calculates the total price of items
	 * in the shopping cart and attempts to process payment. If payment is
	 * successful, clears the shopping cart and logs the order. If payment fails,
	 * displays an error message. If the user is not logged in, prompts them to log
	 * in.
	 */
	private void placeOrder() {
		// Check if the user is logged in
		if (currentUser != null) {
			System.out.println("Placing an order...");

			// Calculate the total price of items in the shopping cart
			double totalPrice = calculateTotalPrice(shoppingCart);

			// Placeholder for processing payment (replace with your payment processing
			// logic)
			boolean paymentSuccess = new PaymentProcessor().processPayment(totalPrice, "Credit Card");

			// If payment is successful, clear the cart and log the order
			if (paymentSuccess) {
				shoppingCart.clearCart();
				Logger.log("Order placed for user: " + currentUser.getUsername());
				JOptionPane.showMessageDialog(null, "Order placed successfully. Payment received.");
			} else {
				// If payment fails, log the error and display an error message
				Logger.log("Payment failed for user: " + currentUser.getUsername());
				JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
			}
		} else {
			// If the user is not logged in, prompt them to log in
			JOptionPane.showMessageDialog(null, "You need to log in to place an order.");
		}
	}

	/**
	 * Calculates the total price of items in the shopping cart.
	 * 
	 * @param shoppingCart The shopping cart containing the items.
	 * @return The total price of items in the shopping cart.
	 */
	private double calculateTotalPrice(Cart shoppingCart) {
		double total = 0.0;
		for (Product product : shoppingCart.getItems()) {
			total += product.getPrice();
		}
		return total;
	}

	/**
	 * Validates a username to ensure it contains only lowercase letters.
	 * 
	 * @param username The username to validate.
	 * @return True if the username is valid, false otherwise.
	 */
	private boolean isValidUsername(String username) {
		return username.matches("^[a-z]+$");
	}

	/**
	 * Validates a password to ensure it meets certain criteria.
	 * 
	 * @param password The password to validate.
	 * @return True if the password is valid, false otherwise.
	 */
	private boolean isValidPassword(String password) {
		return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$");
	}

	/**
	 * Validates a name to ensure it is in the format 'First Last' with the first
	 * letter of each word capitalized.
	 * 
	 * @param name The name to validate.
	 * @return True if the name is valid, false otherwise.
	 */
	private boolean isValidName(String name) {
		return name.matches("^[A-Z][a-z]*\\s[A-Z][a-z]*$");
	}

	/**
	 * Validates an email address to ensure it contains the @ symbol.
	 * 
	 * @param email The email address to validate.
	 * @return True if the email address is valid, false otherwise.
	 */
	private boolean isValidEmail(String email) {
		return email.contains("@");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OnlineShoppingGUI();
			}
		});
	}
}
