package hust.soict.elitech.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // B17
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor mặc định
    public Media() {
    }

    // Constructor chỉ có tiêu đề
    public Media(String title) { this.title = title; }

    // Constructor đầy đủ
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public String toString() {
        return "Media: " + title;
    }

    // Override equals để so sánh 2 Media dựa trên tiêu đề và giá tiền
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra nếu 2 object là cùng một instance
        if (obj == this) {
            return true;
        }
        // Kiểm tra nếu obj là null hoặc không phải là instance của Media
        if (!(obj instanceof Media)) {
            return false;
        }

        try {
            // Ép kiểu obj về Media để so sánh
            Media media = (Media) obj;
            // So sánh tiêu đề và giá tiền, nếu cả hai đều giống nhau thì trả về true
            return this.title.equals(media.getTitle()) && this.cost == media.getCost();
        } catch (NullPointerException e) {
            return false;
        }
    }

    // Phương thức compareTo để so sánh 2 Media dựa trên tiêu đề và giá tiền
    public int compareTo(Media other) {
        try {
            // So sánh tiêu đề trước, nếu khác nhau thì trả về kết quả so sánh tiêu đề
            int titleDiff = this.getTitle().compareTo(other.getTitle());
            if (titleDiff != 0) {
                return titleDiff;
            } else {
                // Nếu tiêu đề giống nhau, so sánh giá tiền
                return Float.compare(this.getCost(), other.getCost());
            }
        } catch (NullPointerException e) {
            return -1; // Nếu có lỗi NullPointerException, trả về -1 để cho rằng this nhỏ hơn other
        }
    }

}

