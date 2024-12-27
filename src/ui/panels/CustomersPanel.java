// CustomersPanel.java
package ui.panels;

import javax.swing.*;
import java.awt.*;

public class CustomersPanel extends JPanel {
    private JTable customersTable;
    private JPanel toolbarPanel;

    public CustomersPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createToolbarPanel();
        createCustomersTable();
    }

    private void createToolbarPanel() {
        toolbarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbarPanel.setBackground(new Color(245, 245, 250));

        JButton addButton = new JButton("Add Customer");
        JButton importButton = new JButton("Import");
        JButton exportButton = new JButton("Export");
        JTextField searchField = new JTextField(20);

        toolbarPanel.add(addButton);
        toolbarPanel.add(importButton);
        toolbarPanel.add(exportButton);
        toolbarPanel.add(new JLabel("Search:"));
        toolbarPanel.add(searchField);

        add(toolbarPanel, BorderLayout.NORTH);
    }

    private void createCustomersTable() {
        String[] columns = {"ID", "Name", "Email", "Phone", "Total Orders", "Total Spent", "Actions"};
        Object[][] data = {
                {1, "John Doe", "john@example.com", "555-0123", 5, "$1,499.95", "View Edit"},
                {2, "Jane Smith", "jane@example.com", "555-0124", 3, "$899.97", "View Edit"},
                {3, "Bob Johnson", "bob@example.com", "555-0125", 1, "$299.99", "View Edit"}
        };

        customersTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(customersTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }
}