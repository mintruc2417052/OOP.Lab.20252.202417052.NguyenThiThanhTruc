package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

// CompactDisc kế thừa từ Disc và triển khai giao diện Playable
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor của CompactDisc, gọi constructor của Disc để khởi tạo các thuộc tính chung
    public CompactDisc(String title, String category, String artist, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>(); // Đảm bảo khởi tạo part này!
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Phương thức để thêm một track vào CD, kiểm tra trùng lặp trước khi thêm
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        }
    }

    // Phương thức để xóa một track khỏi CD, kiểm tra tồn tại trước khi xóa
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " does not exist in the CD.");
        }
    }

    // Triển khai hàm getLength() cho CD, tổng thời lượng là tổng thời lượng của tất cả các track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Triển khai phương thức play() cho CD, phát từng track một, nếu có lỗi sẽ ném PlayerException
    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            // Lặp qua tất cả các bài hát (Track) trong CD để phát
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch(PlayerException e) {
                    throw e; // Ném lỗi ra ngoài nếu bài hát này bị hỏng
                }
            }
        } else {
            // Ném lỗi nếu bản thân tổng thời lượng của đĩa CD <= 0
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    // Override phương thức toString() để trả về thông tin của CD
    @Override
    public String toString() {
        return "CD: " + getTitle() + " [This is a CD object]";
    }
}