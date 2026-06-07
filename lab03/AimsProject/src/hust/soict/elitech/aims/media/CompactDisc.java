package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>(); // khoi tao trachk list rong
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
        }
    }

    // tong do dai cd
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    // trien khai phuong thuc play() cua cd
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by artist: " + this.artist);
        System.out.println("Total length: " + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD: " + getTitle() + " [This is a CD object]";
    }
}