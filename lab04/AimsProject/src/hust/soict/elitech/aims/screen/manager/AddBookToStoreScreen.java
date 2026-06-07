package hust.soict.elitech.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.elitech.aims.media.Book;
import hust.soict.elitech.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;

    // Constructor
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    // Tạo giao diện trung tâm để nhập thông tin sách
    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));
        
        center.add(new JLabel("Title:"));
        tfTitle = new JTextField(); center.add(tfTitle);      
        center.add(new JLabel("Category:"));
        tfCategory = new JTextField(); center.add(tfCategory);   
        center.add(new JLabel("Cost:"));
        tfCost = new JTextField(); center.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            store.addMedia(new Book(title, category, cost));
            JOptionPane.showMessageDialog(null, "Book added successfully!");
        });
        center.add(btnAdd);

        return center;
    }
}