package hust.soict.elitech.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    
    public Disc() {
        super();
    }
     public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // goi constructor cua lop cha media
        this.director = director;
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // setter 
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
