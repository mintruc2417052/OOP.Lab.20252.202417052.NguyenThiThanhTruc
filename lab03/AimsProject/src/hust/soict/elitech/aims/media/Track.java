package hust.soict.elitech.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    // trien khai phuong thuc play() tu interface Playable
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        boolean titleMatches = (this.title != null && this.title.equalsIgnoreCase(other.title)) 
                                || (this.title == null && other.title == null);
        
        return titleMatches && (this.length == other.length);
    }
}