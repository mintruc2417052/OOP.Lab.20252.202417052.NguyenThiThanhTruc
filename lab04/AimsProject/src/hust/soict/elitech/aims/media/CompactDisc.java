package hust.soict.elitech.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // constructor
    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>(); // khoi tao trachk list rong
    }

    // getter cho artist
    public String getArtist() {
        return artist;
    }

    // thêm track vào cd, kiểm tra nếu track đã tồn tại thì không thêm và thông báo
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        }
    }

    // xóa track khỏi cd, kiểm tra nếu track không tồn tại thì thông báo
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
        }
    }

    // tính tổng độ dài của cd bằng cách cộng độ dài của tất cả các track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    // triển khai phương thức play() của cd, in thông tin cd và phát từng track
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