package daniel;

import java.util.ArrayList;

public class SalesSlip {
    private ArrayList<SalesItem> items;

    // Constructor
    public SalesSlip() {
        items = new ArrayList<>();
    }

    // Method to add an item to the sales list
    public void addItem(SalesItem item) {
        items.add(item);
    }

    // Method to compute the total sales
    public double getTotalSales() {
        double total = 0;
        for (SalesItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // toString method to display the list of sales items
    public String toString() {
        StringBuilder salesList = new StringBuilder();
        for (SalesItem item : items) {
            salesList.append(item.toString()).append("\n");
        }
        return salesList.toString();
    }
}