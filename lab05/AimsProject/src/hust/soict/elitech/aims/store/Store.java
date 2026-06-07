package hust.soict.elitech.aims.store;

import java.util.ArrayList;
import hust.soict.elitech.aims.media.Media;

public class Store {
    // Sử dụng ArrayList để lưu trữ các sản phẩm trong cửa hàng
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Constructor mặc định
    public Store() {
    }

    // Thay thế addDigitalVideoDisc bằng addMedia
    public void addMedia(Media media) {
        // Kiểm tra xem sản phẩm đã tồn tại trong cửa hàng chưa trước khi thêm
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        // Nếu sản phẩm đã tồn tại, thông báo cho người dùng
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    // Thay thế removeDigitalVideoDisc bằng removeMedia
    public void removeMedia(Media media) {
        // Kiểm tra xem sản phẩm có tồn tại trong cửa hàng không trước khi xóa
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        // Nếu sản phẩm không tồn tại, thông báo cho người dùng
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }

    // Phương thức để in thông tin về cửa hàng và các sản phẩm hiện có
    public void printStore() {
        System.out.println("\n*********************** STORE ***********************");
        System.out.println("Items currently in store:");
        // Kiểm tra xem cửa hàng có sản phẩm nào không trước khi in thông tin
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        // Nếu có sản phẩm, in thông tin chi tiết của từng sản phẩm
        } else {
            int i = 1;
            for (Media media : itemsInStore) {
                System.out.println(i + ". " + media.toString());
                i++;
            }
        }
        System.out.println("*****************************************************\n");
    }

    // Phương thức để lấy danh sách các sản phẩm trong cửa hàng
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    //EX 18: Phương thức tìm kiếm sản phẩm theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            // So sánh tiêu đề của sản phẩm với tiêu đề tìm kiếm, bỏ qua sự khác biệt về chữ hoa chữ thường
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; // Trả về sản phẩm nếu tìm thấy tiêu đề phù hợp
            }
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm nào có tiêu đề phù hợp
    }
}