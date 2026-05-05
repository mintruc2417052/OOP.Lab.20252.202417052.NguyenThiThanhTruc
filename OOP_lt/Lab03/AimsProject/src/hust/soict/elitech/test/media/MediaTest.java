package hust.soict.elitech.test.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.elitech.aims.media.*; // import tat ca cac lop media tu package media
// b16
public class MediaTest {
    public static void main(String[] args) {
        // tao danh sach media
        List<Media> mediae = new ArrayList<Media>();

        // tao doi tuong
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Justin Bieber", "Director X", 45, 18.95f);
        Media dvd = new DigitalVideoDisc("Inception", "Sci-Fi", 20.0f);
        Media book = new Book("Java Programming", "Education", 10.0f);

        // them vao danh sach
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // duyet + in
        System.out.println("\n--- Testing Polymorphism with toString() ---");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
