package hust.soict.elitech.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

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
        // goi constructor cua lop Disc
        super(title, category, director, 0, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    @Override
    public String toString() {
        return "DVD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + 
               " - " + getLength() + " mins: " + getCost() + " $";
    }
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
    //  implement the play methof
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
}