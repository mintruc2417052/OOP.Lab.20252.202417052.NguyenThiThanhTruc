package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Danh sách tác giả của cuốn sách
    private List<String> authors = new ArrayList<String>();

    // Constructor để khởi tạo đối tượng Book
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Phương thức để lấy danh sách tác giả
    public List<String> getAuthors() {
        return authors;
    }

    // Phương thức để thêm tác giả vào danh sách
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // Phương thức để xóa tác giả khỏi danh sách
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }

    // Phương thức toString để hiển thị thông tin của cuốn sách
    @Override
    public String toString() {
        return "Book: " + getTitle() + " [This is a Book object]";
    }
}