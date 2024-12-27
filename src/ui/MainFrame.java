package ui;

import ui.panels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JPanel sidebarPanel;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    // Panel instances
    private DashboardPanel dashboardPanel;
    private InventoryPanel inventoryPanel;
    private AnalyticsPanel analyticsPanel;
    private SalesOrdersPanel salesOrdersPanel;
    private ProductsPanel productsPanel;
    private CustomersPanel customersPanel;
    private SettingsPanel settingsPanel;

    public MainFrame() {
        setTitle("B2B Management System");
        setSize( 1280,  800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize panels
        initializePanels();

        // Sidebar Menu
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout( 7,  1));
        sidebarPanel.setPreferredSize(new Dimension( 200, getHeight()));
        sidebarPanel.setBackground(Color.DARK_GRAY);

        JButton dashboardButton = createSidebarButton("Dashboard");
        JButton inventoryButton = createSidebarButton( "Inventory");
        JButton analyticsButton = createSidebarButton( "Analytics");
        JButton salesOrdersButton = createSidebarButton("Sales Orders");
        JButton productsButton = createSidebarButton("Products");
        JButton customersButton = createSidebarButton("Customers");
        JButton settingsButton = createSidebarButton("Settings");

        sidebarPanel.add(dashboardButton);
        sidebarPanel.add(inventoryButton);
        sidebarPanel.add(analyticsButton);
        sidebarPanel.add(salesOrdersButton);
        sidebarPanel.add(productsButton);
        sidebarPanel.add(customersButton);
        sidebarPanel.add(settingsButton);

        add(sidebarPanel, BorderLayout.WEST);

        // Main Content Panel
        contentPanel = new JPanel(cardLayout = new CardLayout());
        contentPanel.add(dashboardPanel, "Dashboard");
        contentPanel.add(inventoryPanel, "Inventory");
        contentPanel.add(analyticsPanel, "Analytics");
        contentPanel.add(salesOrdersPanel, "Sales Orders");
        contentPanel.add(productsPanel, "Products");
        contentPanel.add(customersPanel, "Customers");
        contentPanel.add(settingsPanel, "Settings");

        add(contentPanel, BorderLayout.CENTER);
    }

    private void initializePanels() {
        dashboardPanel = new DashboardPanel();
        inventoryPanel = new InventoryPanel();
        analyticsPanel = new AnalyticsPanel();
        salesOrdersPanel = new SalesOrdersPanel();
        productsPanel = new ProductsPanel();
        customersPanel = new CustomersPanel();
        settingsPanel = new SettingsPanel();
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(this::handleNavigation);
        return button;
    }

    private void handleNavigation(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        cardLayout.show(contentPanel, command);
    }
}