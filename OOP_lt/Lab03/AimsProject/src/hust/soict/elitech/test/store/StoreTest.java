package hust.soict.elitech.test.store;

import hust.soict.elitech.aims.media.DigitalVideoDisc;
import hust.soict.elitech.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        System.out.println("==== TESTING ADD METHOD ====");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        System.out.println("\n==== TESTING REMOVE METHOD ====");
        store.removeMedia(dvd2); // kq mong doi --> xoa thanh cong 

        // thu xoa lai
        store.removeMedia(dvd2); // kq mong doi --> khong tim thay dia da bi xoa
        // thu xoa dia ko ton tai
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Science Fiction", 20.0f);
        store.removeMedia(dvd4); // kq mong doi --> ko tim thay
    }
}
