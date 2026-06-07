package hust.soict.elitech.aims.media;

import hust.soict.elitech.aims.exception.PlayerException;

// Lớp DigitalVideoDisc kế thừa từ lớp Disc và triển khai giao diện Playable
public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    // Các constructor khác nhau để tạo đối tượng DigitalVideoDisc
    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        // Gọi constructor của lớp Disc
        super(title, category, director, 0, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, String director, int length, float cost) {
        // Gọi constructor của lớp Disc
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // Triển khai phương thức toString() để hiển thị thông tin của DVD
    @Override
    public String toString() {
        return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() +
                " - " + getLength() + " mins: " + getCost() + " $";
    }
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
    // Triển khai phương thức play() từ giao diện Playable
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Nếu thời lượng > 0, hiển thị thông tin và tiếp tục chơi DVD
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            // Nếu thời lượng <= 0, hiển thị lỗi và ném ngoại lệ PlayerException
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

}