package app;

import ui.MainFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set System Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
            // Center the window on screen
            frame.setLocationRelativeTo(null);
        });
    }
}