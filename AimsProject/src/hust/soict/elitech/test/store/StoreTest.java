package hust.soict.elitech.test.store;

import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        // Tạo một số đĩa DVD để thử nghiệm
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Thử nghiệm thêm và xóa đĩa DVD trong cửa hàng
        System.out.println("==== TESTING ADD METHOD ====");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Thử thêm một đĩa đã tồn tại
        System.out.println("\n==== TESTING REMOVE METHOD ====");
        store.removeMedia(dvd2); // Kết quả mong đợi: Xóa thành công Star Wars

        // Thử xóa một đĩa đã bị xóa trước đó
        store.removeMedia(dvd2); // Kết quả mong đợi: Thông báo không tìm thấy đĩa

        // Thử xóa một đĩa không tồn tại trong cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Science Fiction", 20.0f);
        store.removeMedia(dvd4); // Kết quả mong đợi: Thông báo không tìm thấy đĩa
    }
}
