package fruitshop2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Manager {

    ArrayList<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ShoppingCart> orders = new Hashtable<>();
    Validate validate = new Validate();
    int fruitIdCounter = 1;

    public boolean checkIdExist(ArrayList<Customer> customers, String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void createFruit() {
        String fruitId = String.valueOf(fruitIdCounter++);
        String fruitName = validate.inputString("Enter Fruit Name: ");
        double price = validate.inputDouble("Enter Price: ", 0.01, Double.MAX_VALUE);
        int quantity = validate.inputInt("Enter Quantity: ", 1, Integer.MAX_VALUE);
        String origin = validate.inputString("Enter Origin: ");

        Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        fruits.add(newFruit);

        System.out.println("Fruit created successfully.");
    }

    public void viewOrders() {
        // Implement logic to view orders
        if (orders.isEmpty()) {
            System.err.println("No orders have been placed.");
            return;
        }

        // Iterate through orders and display order details
        for (String customerName : orders.keySet()) {
            System.out.println("Customer: " + customerName);
            ShoppingCart cart = orders.get(customerName);
            System.out.printf("%-8s| %-9s| $%-6s| $%-6s%n", "Product", "Quantity", "Price", "Amount");

            for (Fruit fruit : cart.getItems()) {
                System.out.printf("%-8s| %-9d| $%-6.2f| $%-6.2f%n",
                        fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getTotalPrice());
            }

            System.out.println("Total: $" + cart.getTotalPrice());
        }
    }

    public void shopping() {
        List<Fruit> orderedItems = new ArrayList<>(); // Store all ordered items
        //boolean continueOrdering = true;

        while (true) {
            System.out.println("List of Fruits:");
            System.out.printf("%-4s | %-12s | %-7s | %-5s%n", " Item", "Fruit Name", "Origin", "Price");

            for (Fruit fruit : fruits) {
                System.out.printf("%-4s | %-12s | %-7s | $%-5.2f%n", fruit.getFruitId(), fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }

            int selectedItem = validate.inputInt("Select a fruit (Enter Item): ", 1, fruits.size());
            Fruit selectedFruit = fruits.get(selectedItem - 1); // Adjust for 0-based index

            System.out.println("You selected: " + selectedFruit.getFruitName()); // Display the selected fruit
            int quantity = validate.inputInt("Please input quantity: ", 1, Integer.MAX_VALUE);

            if (quantity > selectedFruit.getQuantity()) {
                System.err.println("Not enough quantity in stock. Please try a lower quantity.");
                continue;
            }

            selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
            orderedItems.add(new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));

            // Ask if the customer wants to continue ordering
            //continueOrdering = validate.checkInputYN("Do you want to continue ordering (Y/N)?");
            if (!validate.checkInputYN("Do you want to continue")) {
                break;
            }
        }

        String customerName = validate.inputString("Input your name: ");
        ShoppingCart cart = new ShoppingCart();
        cart.setItems(orderedItems);
        orders.put(customerName, cart);

        System.out.println("Total: $" + cart.getTotalPrice());
        System.out.println("Order processed successfully.");
    }

}
