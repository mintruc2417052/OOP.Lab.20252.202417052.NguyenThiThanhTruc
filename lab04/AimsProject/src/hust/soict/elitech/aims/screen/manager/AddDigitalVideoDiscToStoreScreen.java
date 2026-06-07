package hust.soict.elitech.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;

    // Constructor
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
    }

    // Create the center panel with input fields for DVD details
    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 10, 10));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField(); center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField(); center.add(tfCategory);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField(); center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField(); center.add(tfLength);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField(); center.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = tfLength.getText().isEmpty() ? 0 : Integer.parseInt(tfLength.getText());
                float cost = tfCost.getText().isEmpty() ? 0.0f : Float.parseFloat(tfCost.getText());
                
                store.addMedia(new DigitalVideoDisc(category, title, director, length, cost));
                JOptionPane.showMessageDialog(null, "DVD added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Length and Cost must be valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        center.add(btnAdd);

        return center;
    }
}