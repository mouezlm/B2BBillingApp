// SalesOrdersPanel.java
package ui.panels;

import javax.swing.*;
import java.awt.*;

public class SalesOrdersPanel extends JPanel {
    private JTable ordersTable;
    private JPanel filtersPanel;

    public SalesOrdersPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createFiltersPanel();
        createOrdersTable();
    }

    private void createFiltersPanel() {
        filtersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtersPanel.setBackground(new Color(245, 245, 250));

        String[] statuses = {"All Status", "Pending", "Processing", "Shipped", "Delivered"};
        JComboBox<String> statusFilter = new JComboBox<>(statuses);

        JTextField dateFromField = new JTextField(10);
        JTextField dateToField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        JButton exportButton = new JButton("Export");

        filtersPanel.add(new JLabel("Status:"));
        filtersPanel.add(statusFilter);
        filtersPanel.add(new JLabel("Date From:"));
        filtersPanel.add(dateFromField);
        filtersPanel.add(new JLabel("Date To:"));
        filtersPanel.add(dateToField);
        filtersPanel.add(searchButton);
        filtersPanel.add(exportButton);

        add(filtersPanel, BorderLayout.NORTH);
    }

    private void createOrdersTable() {
        String[] columns = {"Order ID", "Customer", "Date", "Status", "Items", "Total", "Actions"};
        Object[][] data = {
                {"ORD-001", "John Doe", "2024-03-20", "Delivered", 3, "$899.97", "View"},
                {"ORD-002", "Jane Smith", "2024-03-20", "Processing", 2, "$1999.98", "View"},
                {"ORD-003", "Bob Johnson", "2024-03-19", "Pending", 1, "$299.99", "View"}
        };

        ordersTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }
}