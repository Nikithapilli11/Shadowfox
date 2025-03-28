import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementSystem {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, quantityField, priceField;

    public InventoryManagementSystem() {
        frame = new JFrame("Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        tableModel = new DefaultTableModel(new String[]{"Item Name", "Quantity", "Price"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new GridLayout(2, 3));
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(nameField);
        inputPanel.add(quantityField);
        inputPanel.add(priceField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Item");
        JButton updateButton = new JButton("Update Item");
        JButton deleteButton = new JButton("Delete Item");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        addButton.addActionListener(e -> addItem());
        updateButton.addActionListener(e -> updateItem());
        deleteButton.addActionListener(e -> deleteItem());

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addItem() {
        String name = nameField.getText();
        String quantity = quantityField.getText();
        String price = priceField.getText();
        tableModel.addRow(new Object[]{name, quantity, price});
        clearFields();
    }

    private void updateItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.setValueAt(nameField.getText(), selectedRow, 0);
            tableModel.setValueAt(quantityField.getText(), selectedRow, 1);
            tableModel.setValueAt(priceField.getText(), selectedRow, 2);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Please select an item to update.");
        }
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select an item to delete.");
        }
    }

    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryManagementSystem::new);
    }
}
