package ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class DashboardUI extends JFrame {
    private JPanel sidebarPanel;
    private JPanel mainPanel;
    private JPanel metricsPanel;
    private JPanel chartsPanel;
    private JTable productsTable;

    public DashboardUI() {
        setTitle("Inventory Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create main container with padding
        JPanel container = new JPanel(new BorderLayout(10, 10));
        container.setBorder(new EmptyBorder(15, 15, 15, 15));
        container.setBackground(new Color(245, 245, 250));

        // Initialize components
        createSidebar();
        createMainContent();

        // Add components to container
        container.add(sidebarPanel, BorderLayout.WEST);
        container.add(mainPanel, BorderLayout.CENTER);

        add(container);

        // Add top header
        createHeader();
    }

    private void createHeader() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        // Search bar
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));

        // User profile section
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        profilePanel.setBackground(Color.WHITE);
        JLabel userLabel = new JLabel("Admin");
        profilePanel.add(userLabel);

        headerPanel.add(searchField, BorderLayout.WEST);
        headerPanel.add(profilePanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);
    }

    private void createSidebar() {
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(Color.WHITE);
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        sidebarPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(230, 230, 230)));

        // Add menu items
        String[] menuItems = {
                "Dashboard", "Inventory", "Analytics", "Sales Orders",
                "B2B ecommerce", "Products", "Customers", "Settings"
        };

        for (String item : menuItems) {
            JPanel menuItem = createMenuItem(item);
            sidebarPanel.add(menuItem);
            sidebarPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    private JPanel createMenuItem(String text) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
        item.setBackground(Color.WHITE);
        item.setMaximumSize(new Dimension(200, 40));

        JLabel label = new JLabel(text);
        label.setForeground(new Color(100, 100, 100));
        item.add(label);

        item.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                item.setBackground(new Color(245, 245, 250));
            }

            public void mouseExited(MouseEvent e) {
                item.setBackground(Color.WHITE);
            }

            public void mouseClicked(MouseEvent e) {
                // Handle menu item click
            }
        });

        return item;
    }

    private void createMainContent() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(245, 245, 250));

        // Create metrics cards
        createMetricsPanel();

        // Create charts panel
        createChartsPanel();

        // Create products table
        createProductsTable();

        // Add components to main panel
        mainPanel.add(metricsPanel, BorderLayout.NORTH);
        mainPanel.add(chartsPanel, BorderLayout.CENTER);
    }

    private void createMetricsPanel() {
        metricsPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        metricsPanel.setBackground(new Color(245, 245, 250));

        String[][] metricsData = {
                {"Gross Sales", "$22,892", "+26%"},
                {"Average Sales", "$8,283", "+23%"},
                {"New Sales", "$1,853", "+2.4%"},
                {"Gross Profits", "$5,239", "+14.4%"}
        };

        for (String[] metric : metricsData) {
            metricsPanel.add(createMetricCard(metric[0], metric[1], metric[2]));
        }
    }

    private JPanel createMetricCard(String title, String value, String growth) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(100, 100, 100));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(valueLabel.getFont().deriveFont(18f));

        JLabel growthLabel = new JLabel(growth);
        growthLabel.setForeground(new Color(75, 166, 127));

        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(valueLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(growthLabel);

        return card;
    }

    private void createChartsPanel() {
        chartsPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        chartsPanel.setBackground(new Color(245, 245, 250));

        // Add placeholder panels for charts
        JPanel revenueChart = new JPanel();
        revenueChart.setBackground(Color.WHITE);
        revenueChart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        revenueChart.add(new JLabel("Revenue vs Costs Chart"));

        JPanel unitsChart = new JPanel();
        unitsChart.setBackground(Color.WHITE);
        unitsChart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        unitsChart.add(new JLabel("Unit Sales Chart"));

        chartsPanel.add(revenueChart);
        chartsPanel.add(unitsChart);
    }

    private void createProductsTable() {
        String[] columnNames = {"Product Name", "Supplier", "Stock", "Sales", "Batch Tracked"};
        Object[][] data = {
                {"Watch Nike Series 7", "Samuel Suárez", "775", "4858", "343454"},
                {"Iphone 15", "Donald Kim", "888", "1334", "5098923"},
                {"Iphone 15 Plus", "Abdullah Khan", "466", "7127", "3245672"},
                {"Watch Nike Series 9", "Maria Moore", "722", "2126", "3256477"}
        };

        productsTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(productsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel tableTitle = new JLabel("Top Products");
        tableTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        tablePanel.add(tableTitle, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.SOUTH);
    }

}