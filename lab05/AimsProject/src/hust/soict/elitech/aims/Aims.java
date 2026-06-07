package hust.soict.elitech.aims;

import java.util.Scanner;
import hust.soict.elitech.aims.media.*;
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu cho Store
        initData();

        // Vòng lặp chính để hiển thị menu và xử lý lựa chọn của người dùng
        int choice;
        while (true) {
            showMenu(); // Hiển thị menu chính
            choice = scanner.nextInt(); // Đọc lựa chọn của người dùng
            scanner.nextLine(); // Clear buffer

            // Xử lý lựa chọn của người dùng
            switch (choice) {
                case 1:
                    viewStore(); // Chức năng 1: Xem cửa hàng
                    break;
                case 2:
                    updateStore(); // Chức năng 2: Cập nhật cửa hàng
                    break;
                case 3:
                    viewCart(); // Chức năng 3: Xem giỏ hàng
                    break;
                case 0:
                    System.out.println("Thanks for using AIMS. Goodbye!"); // Chức năng 0: Thoát chương trình
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again."); // Xử lý lựa chọn không hợp lệ
            }
        }
    }

    // Menu hiển thị chính
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Menu hiển thị khi xem cửa hàng
    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // Menu hiển thị khi xem chi tiết media
    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }
    
    // Menu hiển thị khi xem giỏ hàng
    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // Logic cho các chức năng sẽ được triển khai ở đây

    // Chức năng xem cửa hàng
    public static void viewStore() {
        store.printStore(); 
        int choice;
        while (true) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: seeMediaDetails(); break;
                case 2: addMediaToCart(); break;
                case 3: playMedia(); break;
                case 4: viewCart(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Chức năng xem chi tiết media
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title); 
        
        if (media != null) {
            System.out.println(media.toString());
            int choice;
            while (true) {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) break;
                if (choice == 1) cart.addMedia(media);
                else if (choice == 2) {
                    if (media instanceof Playable) ((Playable) media).play();
                    else System.out.println("This media cannot be played!");
                }
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    // Chức năng thêm vào giỏ hàng
    public static void addMediaToCart() {
        System.out.print("Enter the title to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    // Chức năng Play
    public static void playMedia() {
        System.out.print("Enter the title to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Cannot play this media!");
        }
    }

    // Chức năng xem giỏ hàng
    public static void viewCart() {
        cart.print();
        int choice;
        while (true) {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: // Filter
                System.out.println("Filtering options: ");
                System.out.println("1. Filter by ID");
                System.out.println("2. Filter by Title");
                System.out.print("Your choice: ");
                int filterChoice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (filterChoice == 1) {
                    System.out.print("Please enter the ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    cart.searchById(id); // Gọi hàm searchById đã có trong Cart của bạn
                } else if (filterChoice == 2) {
                    System.out.print("Please enter the Title: ");
                    String title = scanner.nextLine();
                    cart.searchByTitle(title); // Gọi hàm searchByTitle đã có trong Cart của bạn
                } else {
                    System.out.println("Invalid option!");
                }
                break;
                case 2: // Sort 
                    System.out.println("1. By Title, 2. By Cost");
                    int s = scanner.nextInt();
                    if (s==1) cart.sortByTitle(); else cart.sortByCost();
                    cart.print();
                    break;
                case 3: // Remove
                    System.out.print("Title to remove: ");
                    Media m = store.searchByTitle(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4: playMedia(); break;
                case 5: 
                    System.out.println("An order has been created! Cart is now empty.");
                    cart = new Cart(); // Reset cart sau khi đặt hàng
                    return; 
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // Chức năng cập nhật cửa hàng (thêm/xóa media)
    public static void updateStore() {
    System.out.println("\nUpdate Store Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Add a Media to store");
    System.out.println("2. Remove a Media from store");
    System.out.println("0. Back");
    System.out.print("Please choose: ");
    
    int updateChoice = scanner.nextInt();
    scanner.nextLine(); // Clear buffer

    if (updateChoice == 1) {
        // logic thêm media mới vào store
        System.out.println("Choose media type: 1. DVD, 2. CD, 3. Book");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        if (type == 1) { // them DVD
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        } 
        else if (type == 2) { // them CD
            System.out.print("Enter Artist: ");
            String artist = scanner.nextLine();
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            // Lưu ý: CD có thể có nhiều track, nhưng để đơn giản chúng ta sẽ không thêm track ngay lúc này. Bạn có thể mở rộng sau.
            store.addMedia(new CompactDisc(title, category, artist, director, length, cost));
        } 
        else if (type == 3) { // them Book
            store.addMedia(new Book(title, category, cost));
            System.out.println("Note: Authors can be added later via Book class methods.");
        }
    } 
    else if (updateChoice == 2) {
        // logic xóa media
        System.out.print("Enter the title of the media you want to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found in store!");
        }
    }
}
    // Hàm khởi tạo dữ liệu mẫu cho Store
    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f)); // Thêm một DVD vào Store
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f)); // Thêm một DVD khác vào Store
        store.addMedia(new Book("Java Programming", "Education", 45.0f)); // Thêm một Book vào Store
    }
}