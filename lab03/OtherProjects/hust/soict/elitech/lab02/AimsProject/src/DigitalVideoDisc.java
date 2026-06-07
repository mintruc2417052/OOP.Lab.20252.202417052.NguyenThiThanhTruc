public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // b16
    private static int nbDigitalVideoDiscs = 0; // bien dem tong
    private int id; // luu id cua tung dvd
    
    // phuong thuc get
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }
    
    // phuong thuc set
    public void setTitle(String title) {
        this.title = title;
    }
   
    // cac constructor

    // tat ca
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
         nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // director , category, title, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
         nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    
    // category, title, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
         nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
    
    // title
    public DigitalVideoDisc(String title) {
        this.title = title;
         nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }
}
