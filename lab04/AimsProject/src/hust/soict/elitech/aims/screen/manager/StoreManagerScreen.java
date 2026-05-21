package hust.soict.elitech.aims.screen.manager;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import hust.soict.elitech.aims.store.Store;
import hust.soict.elitech.aims.media.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    // Constructor để khởi tạo giao diện quản lý kho hàng
    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.setBackground(Color.WHITE);

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Phương thức tạo phần phía trên của giao diện, bao gồm menu và tiêu đề
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.setBackground(Color.WHITE);
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Phương thức tạo menu bar với các tùy chọn quản lý kho hàng
    JMenuBar createMenuBar() {
    JMenu menu = new JMenu("Options");

    // 1. Xử lý "View store"
    JMenuItem viewStore = new JMenuItem("View store");
    viewStore.addActionListener(e -> {
        new StoreManagerScreen(store); // Mở lại màn hình quản lý kho hàng để cập nhật hiển thị
        dispose(); // Đóng màn hình hiện tại để tránh mở nhiều cửa sổ
    });
    menu.add(viewStore);

    JMenu smUpdateStore = new JMenu("Update Store");

    // 2. Xử lý "Add Book"
    JMenuItem addBook = new JMenuItem("Add Book");
    addBook.addActionListener(e -> {
        new AddBookToStoreScreen(store); // Mở màn hình thêm Book
        dispose(); 
    });
    smUpdateStore.add(addBook);

    // 3. Xử lý "Add CD"
    JMenuItem addCD = new JMenuItem("Add CD");
    addCD.addActionListener(e -> {
        new AddCompactDiscToStoreScreen(store); // Mở màn hình thêm CD
        dispose();
    });
    smUpdateStore.add(addCD);

    // 4. Xử lý "Add DVD"
    JMenuItem addDVD = new JMenuItem("Add DVD");
    addDVD.addActionListener(e -> {
        new AddDigitalVideoDiscToStoreScreen(store); // Mở màn hình thêm DVD
        dispose();
    });
    smUpdateStore.add(addDVD);

    menu.add(smUpdateStore);

    JMenuBar menuBar = new JMenuBar();
    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    menuBar.setBackground(Color.WHITE);
    menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    menuBar.add(menu);
    return menuBar;
}

    // Phương thức tạo phần tiêu đề của giao diện
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("Segoe UI", Font.BOLD, 50));
        title.setForeground(new Color(0, 102, 204));

        header.add(Box.createRigidArea(new Dimension(20, 20)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(20, 20)));

        return header;
    }

    // Phương thức tạo phần trung tâm của giao diện, hiển thị các sản phẩm trong kho hàng
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 15, 15));
        center.setBackground(new Color(245, 245, 250));
        center.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(mediaInStore.size(), 9); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    // Phương thức main để chạy ứng dụng và tạo một số sản phẩm mẫu trong kho hàng
    public static void main(String[] args) {
         Store store = new Store();
        // Mẫu test mới đa dạng thể loại (Sci-Fi, Rock, Classic, Trinh thám...)

        // --- DIGITAL VIDEO DISC (DVD) ---
        // Constructor: (Title, Category, Cost)
        store.addMedia(new DigitalVideoDisc("Inception (2010)", "Sci-Fi", 4.5f));
        store.addMedia(new DigitalVideoDisc("The Dark Knight (2008)", "Action", 5.0f));
        store.addMedia(new DigitalVideoDisc("Spirited Away (2001)", "Animation", 3.8f));
        store.addMedia(new DigitalVideoDisc("Interstellar (2014)", "Sci-Fi", 4.9f));

        // --- COMPACT DISC (CD) ---
        // Constructor: (Title, Category, Artist, Director/Producer, Length, Cost)
        CompactDisc cd3 = new CompactDisc("Abbey Road", "Rock", "The Beatles", "George Martin", 47, 15.99f);
        store.addMedia(cd3);

        CompactDisc cd4 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", "Daft Punk", 74, 12.5f);
        store.addMedia(cd4);

        CompactDisc cd5 = new CompactDisc("21", "Pop", "Adele", "Rick Rubin", 48, 11.2f);
        store.addMedia(cd5);

        // --- BOOK ---
        // Constructor: (Title, Category, Cost)
        store.addMedia(new Book("To Kill a Mockingbird", "Classic", 6.2f));
        store.addMedia(new Book("Dune", "Sci-Fi", 7.5f));
        store.addMedia(new Book("Sherlock Holmes: A Study in Scarlet", "Mystery", 4.0f));
        store.addMedia(new Book("The Hobbit", "Fantasy", 5.8f));

        new StoreManagerScreen(store);
    }
}