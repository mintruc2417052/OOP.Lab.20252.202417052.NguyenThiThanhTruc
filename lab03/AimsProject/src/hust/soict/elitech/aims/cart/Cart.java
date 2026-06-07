package hust.soict.elitech.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.elitech.aims.media.Media;

public class Cart {
    // thay vi dung array co kich thuoc fix, ta dung arraylist de luu tru cac media trong cart
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // khong can constructor co tham so, chi can constructor mac dinh de khoi tao cart

    public Cart() {
    }

    // phuong thuc them media vao cart
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
            
            // dem sl dvd sau khi them vao cart
            if (media instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) {
                System.out.println("Number of DVDs in cart: " + countDVDs());
            }
        } else {
            System.out.println("The media is already in the cart.");
        }
    }
    // phuong thuc dem sl dvd
    private int countDVDs() {
        int count = 0;
        for (Media m : itemsOrdered) {
            if (m instanceof hust.soict.elitech.aims.media.DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }


    // phuong thuc xoa media khoi cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    //b17
    // phuong thuc sx media
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
        
    }
     // phuong thuc sx theo cost
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
        // this.print(); // co the in ra de ktra
    }

    // tinh tong chi phi
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // in thong tin cart
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
    // tim kiem sp trong cart theo id
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

    // tim kiem sp trong cart theo tittle
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found match: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
}