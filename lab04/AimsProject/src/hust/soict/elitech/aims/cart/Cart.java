package hust.soict.elitech.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.elitech.aims.media.Media;

public class Cart {
    // Sử dụng ArrayList để lưu trữ các Media trong giỏ hàng
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Constructor mặc định

    public Cart() {
    }

    // Phương thức thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
            // Kiểm tra nếu media là một DVD, in ra số lượng DVD hiện có trong giỏ hàng
            if (media instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) {
                System.out.println("Number of DVDs in cart: " + countDVDs()); // Gọi hàm phụ để đếm số lượng DVD
            }
        } else {
            System.out.println("The media is already in the cart."); // Thông báo nếu media đã tồn tại trong giỏ hàng
        }
    }
    // Hàm phụ để đếm số lượng DVD trong giỏ hàng
    private int countDVDs() {
        int count = 0;
        for (Media m : itemsOrdered) {
            if (m instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) { // Kiểm tra nếu media là một DVD
                count++;
            }
        }
        return count;
    }

    // Phương thức xóa Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        // Kiểm tra nếu media tồn tại trong giỏ hàng trước khi xóa
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media); 
            System.out.println("The media has been removed from the cart."); 
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    //EX 17

    // phương thức sắp xếp giỏ hàng theo tiêu đề (Title)
    public void sortByTitle() {
        // Sử dụng Collections.sort() với Comparator để sắp xếp theo tiêu đề, nếu tiêu đề giống nhau thì sắp xếp theo giá
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
        
    }
     // phương thức sắp xếp giỏ hàng theo giá (Cost)
    public void sortByCost() {
        // Sử dụng Collections.sort() với Comparator để sắp xếp theo giá, nếu giá giống nhau thì sắp xếp theo tiêu đề
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
        // this.print();
    }

    // Phương thức tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        // Duyệt qua tất cả các Media trong giỏ hàng và cộng dồn chi phí
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Phương thức in thông tin giỏ hàng ra
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm sản phẩm trong giỏ hàng theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    // Tìm kiếm sản phẩm trong giỏ hàng theo Title (sử dụng contains để tìm kiếm tương đối)
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            // Sử dụng contains để tìm kiếm tương đối, không phân biệt chữ hoa chữ thường
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        // Nếu không tìm thấy bất kỳ media nào có tiêu đề chứa chuỗi tìm kiếm, in ra thông báo
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
}