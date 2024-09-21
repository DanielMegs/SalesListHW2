package daniel;

public class SalesItem {
	private String name;
	private double price;
	private int quantity;

	// Constructor
	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getter and Setter Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Method to calculate total price for the item
	public double getTotalPrice() {
		return price * quantity;
	}

	// toString method to display the item details
	public String toString() {
		return name + " $" + String.format("%.2f", price) + " " + quantity;
	}
}