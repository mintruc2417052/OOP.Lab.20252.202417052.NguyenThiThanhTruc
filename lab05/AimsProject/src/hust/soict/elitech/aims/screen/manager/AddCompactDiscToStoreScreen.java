package hust.soict.elitech.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.elitech.aims.media.CompactDisc;
import hust.soict.elitech.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfArtist, tfDirector, tfLength, tfCost;

    // Constructor
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
    }

    // Override method to create the center panel with CD details input fields
    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 10, 10));

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField(); center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField(); center.add(tfCategory);

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField(); center.add(tfArtist);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField(); center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField(); center.add(tfLength);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField(); center.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String artist = tfArtist.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            store.addMedia(new CompactDisc(title, category, artist, director, length, cost));
            JOptionPane.showMessageDialog(null, "CD added successfully!");
        });
        center.add(btnAdd);

        return center;
    }
}