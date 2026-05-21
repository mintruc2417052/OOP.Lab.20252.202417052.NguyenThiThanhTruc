package hust.soict.elitech.aims;

import java.util.Scanner;
import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.*;
import hust.soict.elitech.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // khoi tao du lieu mau
        initData();

        // vong lap
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Thanks for using AIMS. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // menu hien thi
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

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

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

    // chuc nang 1: xem cua hang
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

    // chuc nang 2: xem chi tiet sp
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

    // them sp vao gio
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

    // chuc nang play media
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

    // chuc nang 3: xem gio hang
    public static void viewCart() {
        cart.print();
        int choice;
        while (true) {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: // filter
                System.out.println("Filtering options: ");
                System.out.println("1. Filter by ID");
                System.out.println("2. Filter by Title");
                System.out.print("Your choice: ");
                int filterChoice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                if (filterChoice == 1) {
                    System.out.print("Please enter the ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    cart.searchById(id); // goi ham searchById
                } else if (filterChoice == 2) {
                    System.out.print("Please enter the Title: ");
                    String title = scanner.nextLine();
                    cart.searchByTitle(title); // goi ham searchByTitle
                } else {
                    System.out.println("Invalid option!");
                }
                break;
                case 2: // sort
                    System.out.println("1. By Title, 2. By Cost");
                    int s = scanner.nextInt();
                    if (s==1) cart.sortByTitle(); else cart.sortByCost();
                    cart.print();
                    break;
                case 3: // remove
                    System.out.print("Title to remove: ");
                    Media m = store.searchByTitle(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4: playMedia(); break;
                case 5: 
                    System.out.println("An order has been created! Cart is now empty.");
                    cart = new Cart(); // reset cart sau khi dat hang
                    return; 
                default: System.out.println("Invalid choice.");
            }
        }
    }

    // chuc nang 4: cap nhat cua hang
    public static void updateStore() {
    System.out.println("\nUpdate Store Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Add a Media to store");
    System.out.println("2. Remove a Media from store");
    System.out.println("0. Back");
    System.out.print("Please choose: ");
    
    int updateChoice = scanner.nextInt();
    scanner.nextLine(); // clear buffer

    if (updateChoice == 1) {
        // logic them media
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

        if (type == 1) { // them dvd
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        } 
        else if (type == 2) { // them cd
            System.out.print("Enter Artist: ");
            String artist = scanner.nextLine();
            System.out.print("Enter Director: ");
            String director = scanner.nextLine();
            System.out.print("Enter Length: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            // khong co thong tin ve track nen ta se bo qua, chi them cd voi thong tin co san
            store.addMedia(new CompactDisc(title, category, artist, director, length, cost));
        } 
        else if (type == 3) { //them book
            store.addMedia(new Book(title, category, cost));
            System.out.println("Note: Authors can be added later via Book class methods.");
        }
    } 
    else if (updateChoice == 2) {
        // xoa media
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

    private static void initData() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book("Java Programming", "Education", 45.0f));
    }
}