package hust.soict.elitech.aims.store;

import java.util.ArrayList;
import hust.soict.elitech.aims.media.Media;

public class Store {
    // sd arraylist de luu tru cac media trong cua hang
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    // thay the addDigitalVideoDisc --> addMedia
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is already in the store.");
        }
    }

    // thay the removeDigitalVideoDisc --> removeMedia
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' was not found in the store.");
        }
    }

    // phuong thuc in ra cac media trong cua hang
    public void printStore() {
        System.out.println("\n*********************** STORE ***********************");
        System.out.println("Items currently in store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            int i = 1;
            for (Media media : itemsInStore) {
                System.out.println(i + ". " + media.toString());
                i++;
            }
        }
        System.out.println("*****************************************************\n");
    }

    // phuong thuc tra ve danh sach cac media trong cua hang
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    // b18
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            // so sanh tittle cua media vs tittle ca tim, bo qua phan biet hoa thuong
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; 
            }
        }
        return null; 
    }
}