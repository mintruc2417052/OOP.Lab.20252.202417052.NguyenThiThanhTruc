package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() { return title; }
    public int getLength() { return length; }

    // Phương thức play() theo yêu cầu đề bài
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Giữ nguyên đoạn code in ra màn hình cũ của bạn
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            // Ném lỗi nếu track bị hỏng thời lượng
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    // Phương thức equals() theo yêu cầu đề bài
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra nếu cùng tham chiếu
        if (this == obj) {
            return true;
        }

        // Kiểm tra nếu obj không phải là instance của Track
        if (!(obj instanceof Track)) {
            return false;
        }

        // So sánh các thuộc tính của Track
        Track other = (Track) obj;

        // So sánh title (có thể null) và length
        boolean titleMatches = (this.title != null && this.title.equalsIgnoreCase(other.title))
                || (this.title == null && other.title == null);

        return titleMatches && (this.length == other.length);
    }
}