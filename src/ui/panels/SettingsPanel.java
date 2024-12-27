// SettingsPanel.java
package ui.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private JTabbedPane tabbedPane;

    public SettingsPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 245, 250));

        createTabbedPane();
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("General", createGeneralSettingsPanel());
        tabbedPane.addTab("Users", createUsersPanel());
        tabbedPane.addTab("Notifications", createNotificationsPanel());
        tabbedPane.addTab("Backup", createBackupPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createGeneralSettingsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Company Information
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Company Name:"), gbc);
        gbc.gridx = 1;
        panel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Currency:"), gbc);
        gbc.gridx = 1;
        panel.add(new JComboBox<>(new String[]{"USD", "EUR", "GBP"}), gbc);

        return panel;
    }

    private JPanel createUsersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);

        // Users table
        String[] columns = {"Username", "Role", "Email", "Status", "Last Login", "Actions"};
        Object[][] data = {
                {"admin", "Administrator", "admin@example.com", "Active", "2024-03-20", "Edit Delete"},
                {"user1", "User", "user1@example.com", "Active", "2024-03-19", "Edit Delete"}
        };

        JTable usersTable = new JTable(data, columns);
        panel.add(new JScrollPane(usersTable), BorderLayout.CENTER);

        return panel;
    }

// Continuing the SettingsPanel.java implementation...

    private JPanel createNotificationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Email Notifications Section
        JPanel emailSection = new JPanel(new GridBagLayout());
        emailSection.setBackground(Color.WHITE);
        emailSection.setBorder(BorderFactory.createTitledBorder("Email Notifications"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JCheckBox orderCheckbox = new JCheckBox("New Order Notifications");
        JCheckBox inventoryCheckbox = new JCheckBox("Low Inventory Alerts");
        JCheckBox customerCheckbox = new JCheckBox("New Customer Registration");
        JCheckBox reportCheckbox = new JCheckBox("Daily Report Summary");

        emailSection.add(orderCheckbox, gbc);
        gbc.gridy++;
        emailSection.add(inventoryCheckbox, gbc);
        gbc.gridy++;
        emailSection.add(customerCheckbox, gbc);
        gbc.gridy++;
        emailSection.add(reportCheckbox, gbc);

        // SMTP Settings Section
        JPanel smtpSection = new JPanel(new GridBagLayout());
        smtpSection.setBackground(Color.WHITE);
        smtpSection.setBorder(BorderFactory.createTitledBorder("SMTP Settings"));

        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // SMTP Server
        gbc.gridx = 0; gbc.gridy = 0;
        smtpSection.add(new JLabel("SMTP Server:"), gbc);
        gbc.gridx = 1;
        smtpSection.add(new JTextField(20), gbc);

        // Port
        gbc.gridx = 0; gbc.gridy = 1;
        smtpSection.add(new JLabel("Port:"), gbc);
        gbc.gridx = 1;
        smtpSection.add(new JTextField(5), gbc);

        // Username
        gbc.gridx = 0; gbc.gridy = 2;
        smtpSection.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        smtpSection.add(new JTextField(20), gbc);

        // Password
        gbc.gridx = 0; gbc.gridy = 3;
        smtpSection.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        smtpSection.add(new JPasswordField(20), gbc);

        // Add sections to main panel
        panel.add(emailSection);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(smtpSection);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private JPanel createBackupPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Automatic Backup Settings
        JPanel autoBackupPanel = new JPanel(new GridBagLayout());
        autoBackupPanel.setBackground(Color.WHITE);
        autoBackupPanel.setBorder(BorderFactory.createTitledBorder("Automatic Backup Settings"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Enable automatic backup
        gbc.gridx = 0; gbc.gridy = 0;
        JCheckBox enableBackup = new JCheckBox("Enable Automatic Backup");
        autoBackupPanel.add(enableBackup, gbc);

        // Backup frequency
        gbc.gridx = 0; gbc.gridy = 1;
        autoBackupPanel.add(new JLabel("Backup Frequency:"), gbc);
        gbc.gridx = 1;
        String[] frequencies = {"Daily", "Weekly", "Monthly"};
        autoBackupPanel.add(new JComboBox<>(frequencies), gbc);

        // Backup location
        gbc.gridx = 0; gbc.gridy = 2;
        autoBackupPanel.add(new JLabel("Backup Location:"), gbc);
        gbc.gridx = 1;
        JPanel locationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        locationPanel.setBackground(Color.WHITE);
        JTextField locationField = new JTextField(20);
        JButton browseButton = new JButton("Browse");
        locationPanel.add(locationField);
        locationPanel.add(browseButton);
        autoBackupPanel.add(locationPanel, gbc);

        // Manual Backup Section
        JPanel manualBackupPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        manualBackupPanel.setBackground(Color.WHITE);
        manualBackupPanel.setBorder(BorderFactory.createTitledBorder("Manual Backup"));

        JButton backupNowButton = new JButton("Backup Now");
        JButton restoreButton = new JButton("Restore from Backup");

        manualBackupPanel.add(backupNowButton);
        manualBackupPanel.add(restoreButton);

        // Backup History Section
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setBackground(Color.WHITE);
        historyPanel.setBorder(BorderFactory.createTitledBorder("Backup History"));

        String[] columns = {"Date", "Size", "Status", "Actions"};
        Object[][] data = {
                {"2024-03-20 10:00", "256 MB", "Success", "Download Delete"},
                {"2024-03-19 10:00", "255 MB", "Success", "Download Delete"},
                {"2024-03-18 10:00", "254 MB", "Success", "Download Delete"}
        };

        JTable historyTable = new JTable(data, columns);
        historyPanel.add(new JScrollPane(historyTable), BorderLayout.CENTER);

        // Add all sections to main panel
        panel.add(autoBackupPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(manualBackupPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(historyPanel);

        return panel;
    }
}

