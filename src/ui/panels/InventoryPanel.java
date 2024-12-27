package ui.panels;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    private JTable inventoryTable;
    private JPanel controlsPanel;

    public InventoryPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createControlsPanel();
        createInventoryTable();
    }

    private void createControlsPanel() {
        controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlsPanel.setBackground(new Color(245, 245, 250));

        JButton addButton = new JButton("Add Item");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");
        JTextField searchField = new JTextField(20);
        searchField.setPreferredSize(new Dimension(200, 30));

        controlsPanel.add(addButton);
        controlsPanel.add(deleteButton);
        controlsPanel.add(refreshButton);
        controlsPanel.add(new JLabel("Search: "));
        controlsPanel.add(searchField);

        add(controlsPanel, BorderLayout.NORTH);
    }

    private void createInventoryTable() {
        String[] columns = {"ID", "Product Name", "Category", "Stock", "Unit Price", "Supplier", "Last Updated"};
        Object[][] data = {
                {1, "Watch Nike Series 7", "Electronics", 775, "$299.99", "Samuel Suárez", "2024-03-20"},
                {2, "Iphone 15", "Electronics", 888, "$999.99", "Donald Kim", "2024-03-20"},
                {3, "Iphone 15 Plus", "Electronics", 466, "$1099.99", "Abdullah Khan", "2024-03-20"}
        };

        inventoryTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }
}
