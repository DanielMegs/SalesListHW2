package daniel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

    /**
     * Launch the application.
     * @author danny
     */
public class SalesList {

    private JFrame frame;
    private JTextField itemInput;
    private JTextField costInput;
    private JTextField quantityInput;
    private SalesSlip salesSlip;
    

	/**
	 * Initializes and displays the main application window.
	 * 
	 * @param args command line arguments
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SalesList window = new SalesList();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SalesList() {
        salesSlip = new SalesSlip();
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel title = new JLabel("Sales List");
        title.setBounds(225, 11, 111, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 25));
        frame.getContentPane().add(title);
        
        JLabel itemLabel = new JLabel("Item:");
        itemLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        itemLabel.setBounds(71, 100, 43, 22);
        frame.getContentPane().add(itemLabel);
        
        JLabel costLabel = new JLabel("Cost: $");
        costLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        costLabel.setBounds(71, 160, 57, 22);
        frame.getContentPane().add(costLabel);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        quantityLabel.setBounds(71, 231, 73, 22);
        frame.getContentPane().add(quantityLabel);
        
        JButton btnNewButton = new JButton("Add item to the Sales List");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(175, 284, 235, 31);
        frame.getContentPane().add(btnNewButton);
        
        itemInput = new JTextField();
        itemInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        itemInput.setBounds(165, 94, 269, 30);
        frame.getContentPane().add(itemInput);
        itemInput.setColumns(10);
        
        costInput = new JTextField();
        costInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        costInput.setBounds(165, 154, 269, 30);
        frame.getContentPane().add(costInput);
        costInput.setColumns(10);
        
        quantityInput = new JTextField();
        quantityInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        quantityInput.setBounds(165, 225, 269, 30);
        frame.getContentPane().add(quantityInput);
        quantityInput.setColumns(10);
        
        JTextArea salesListDisplay = new JTextArea();
        salesListDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
        salesListDisplay.setBounds(71, 337, 461, 243);
        frame.getContentPane().add(salesListDisplay);
        
        JLabel totalSalesLabel = new JLabel("Total Sales:");
        totalSalesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        totalSalesLabel.setBounds(71, 609, 92, 22);
        frame.getContentPane().add(totalSalesLabel);
        
        JTextArea totalSalesOutput = new JTextArea();
        totalSalesOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        totalSalesOutput.setBounds(175, 603, 259, 30);
        frame.getContentPane().add(totalSalesOutput);
        
        // Setting up button action
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch input values
                String itemName = itemInput.getText();
                double itemCost = Double.parseDouble(costInput.getText());
                int itemQuantity = Integer.parseInt(quantityInput.getText());
                
                // Create new SalesItem and add to SalesSlip
                SalesItem newItem = new SalesItem(itemName, itemCost, itemQuantity);
                salesSlip.addItem(newItem);
                
                // Update the display
                salesListDisplay.setText(salesSlip.toString());
                totalSalesOutput.setText(String.format("$%.2f", salesSlip.getTotalSales()));
            }
        });
    }
}