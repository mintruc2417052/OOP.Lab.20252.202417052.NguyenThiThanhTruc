package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    // Constructor
     public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Getters and Setters
    public List<String> getAuthors() {
        return authors;
    }

    // Methods to add and remove authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    // Method to remove an author from the list
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }
    @Override
    public String toString() {
        return "Book: " + getTitle() + " [This is a Book object]";
    }
}