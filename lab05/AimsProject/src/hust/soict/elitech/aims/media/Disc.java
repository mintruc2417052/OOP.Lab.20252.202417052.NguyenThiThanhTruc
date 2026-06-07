package hust.soict.elitech.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor mặc định
    public Disc() {
        super();
    }

    // Constructor có tham số
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }

    // Getter
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Setter
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
