package ui.panels;

import javax.swing.*;
import java.awt.*;

public class ProductsPanel extends JPanel {
    private JTable productsTable;
    private JPanel actionsPanel;

    public ProductsPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createActionsPanel();
        createProductsTable();
    }

    private void createActionsPanel() {
        actionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actionsPanel.setBackground(new Color(245, 245, 250));

        JButton addButton = new JButton("Add Product");
        JButton importButton = new JButton("Import");
        JButton exportButton = new JButton("Export");
        JTextField searchField = new JTextField(20);

        actionsPanel.add(addButton);
        actionsPanel.add(importButton);
        actionsPanel.add(exportButton);
        actionsPanel.add(new JLabel("Search:"));
        actionsPanel.add(searchField);

        add(actionsPanel, BorderLayout.NORTH);
    }

    private void createProductsTable() {
        String[] columns = {"ID", "Product Name", "Category", "Price", "Stock", "Status", "Actions"};
        Object[][] data = {
                {1, "Watch Nike Series 7", "Electronics", "$299.99", 775, "Active", "Edit Delete"},
                {2, "Iphone 15", "Electronics", "$999.99", 888, "Active", "Edit Delete"},
                {3, "Iphone 15 Plus", "Electronics", "$1099.99", 466, "Active", "Edit Delete"}
        };

        productsTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(productsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }
}