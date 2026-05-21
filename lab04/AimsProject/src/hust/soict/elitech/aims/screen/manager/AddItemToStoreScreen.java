package hust.soict.elitech.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import hust.soict.elitech.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    // Constructor nhận Store và tiêu đề để tái sử dụng
    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(title);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Phần North dùng chung cho tất cả
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS - Add Item");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        north.add(header);
        
        return north;
    }

    // Tạo menu bar với tùy chọn "View store"
    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            // Khi chọn "View store", mở màn hình StoreManager với store hiện tại
            new StoreManagerScreen(store);  
            dispose(); // Đóng màn hình hiện tại
        });
        menu.add(viewStore);
        menuBar.add(menu);
        return menuBar;
    }

    // Phần Center sẽ được các lớp con triển khai riêng
    abstract JPanel createCenter();
}