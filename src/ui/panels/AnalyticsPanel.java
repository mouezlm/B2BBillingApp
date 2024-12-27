// AnalyticsPanel.java
package ui.panels;

import javax.swing.*;
import java.awt.*;

public class AnalyticsPanel extends JPanel {
    private JPanel metricsPanel;
    private JPanel chartsPanel;

    public AnalyticsPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createMetricsPanel();
        createChartsPanel();
    }

    private void createMetricsPanel() {
        metricsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        metricsPanel.setBackground(new Color(245, 245, 250));

        addMetricCard("Total Revenue", "$128,459", "+15% vs last month");
        addMetricCard("Average Order Value", "$543", "+5% vs last month");
        addMetricCard("Total Orders", "236", "+8% vs last month");
        addMetricCard("Customer Retention", "85%", "+2% vs last month");

        add(metricsPanel, BorderLayout.NORTH);
    }

    private void addMetricCard(String title, String value, String comparison) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel(title);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(valueLabel.getFont().deriveFont(18f));
        JLabel comparisonLabel = new JLabel(comparison);

        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(valueLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(comparisonLabel);

        metricsPanel.add(card);
    }

    private void createChartsPanel() {
        chartsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        chartsPanel.setBackground(new Color(245, 245, 250));

        // Placeholder panels for charts
        addChartPanel("Revenue Trends");
        addChartPanel("Order Distribution");
        addChartPanel("Top Products");
        addChartPanel("Customer Demographics");

        add(chartsPanel, BorderLayout.CENTER);
    }

    private void addChartPanel(String title) {
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel(title);
        chartPanel.add(titleLabel, BorderLayout.NORTH);
        chartPanel.add(new JLabel("Chart Placeholder"), BorderLayout.CENTER);

        chartsPanel.add(chartPanel);
    }
}
