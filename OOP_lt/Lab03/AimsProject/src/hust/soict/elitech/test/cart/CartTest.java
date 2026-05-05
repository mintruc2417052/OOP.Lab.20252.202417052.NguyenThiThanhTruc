package hust.soict.elitech.test.cart;

import hust.soict.elitech.aims.cart.Cart;
import hust.soict.elitech.aims.media.DigitalVideoDisc;
public class CartTest {
    public static void main(String[] args) {
        // tao 1 cart moi
        Cart cart = new Cart();

        // tao 3 dia dvd moi va them vao cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // in ra thong tin cac dvd trong cart
        cart.print();

        
        // test co ton tai hay khong
        System.out.println("\nTesting Search By ID:");
        cart.searchById(2); 
        cart.searchById(998); 

        // test tim kiem theo ten
        System.out.println("\nTesting Search By Title:");
        cart.searchByTitle("Lion"); 
        cart.searchByTitle("Aladin"); 
        cart.searchByTitle("Avatar"); 
    }
}