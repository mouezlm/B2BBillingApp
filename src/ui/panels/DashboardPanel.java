package ui.panels;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private JPanel metricsPanel;
    private JPanel chartsPanel;
    private JPanel productsPanel;

    public DashboardPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createMetricsPanel();
        createChartsPanel();
        createProductsPanel();

        add(metricsPanel, BorderLayout.NORTH);
        add(chartsPanel, BorderLayout.CENTER);
        add(productsPanel, BorderLayout.SOUTH);
    }

    private void createMetricsPanel() {
        metricsPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        metricsPanel.setBackground(new Color(245, 245, 250));

        metricsPanel.add(createMetricCard("Gross Sales", "$22,892", "+26%"));
        metricsPanel.add(createMetricCard("Average Sales", "$8,283", "+23%"));
        metricsPanel.add(createMetricCard("New Sales", "$1,853", "+2.4%"));
        metricsPanel.add(createMetricCard("Gross Profits", "$5,239", "+14.4%"));
    }

    private JPanel createMetricCard(String title, String value, String growth) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel(title);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(valueLabel.getFont().deriveFont(18f));
        JLabel growthLabel = new JLabel(growth);

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

        // Revenue vs Costs Chart
        JPanel revenueChart = new JPanel();
        revenueChart.setBackground(Color.WHITE);
        revenueChart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        revenueChart.add(new JLabel("Revenue vs Costs Chart"));

        // Units Sold Chart
        JPanel unitsChart = new JPanel();
        unitsChart.setBackground(Color.WHITE);
        unitsChart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        unitsChart.add(new JLabel("Units Sold Chart"));

        chartsPanel.add(revenueChart);
        chartsPanel.add(unitsChart);
    }

    private void createProductsPanel() {
        productsPanel = new JPanel(new BorderLayout());
        productsPanel.setBackground(Color.WHITE);
        productsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        String[] columns = {"Product Name", "Supplier", "Stock", "Sales", "Batch Tracked"};
        Object[][] data = {
                {"Watch Nike Series 7", "Samuel Suárez", 775, 4858, 343454},
                {"Iphone 15", "Donald Kim", 888, 1334, 5098923},
                {"Iphone 15 Plus", "Abdullah Khan", 466, 7127, 3245672},
                {"Watch Nike Series 9", "Maria Moore", 722, 2126, 3256477}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel titleLabel = new JLabel("Top Products");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        productsPanel.add(titleLabel, BorderLayout.NORTH);
        productsPanel.add(scrollPane, BorderLayout.CENTER);
    }
}