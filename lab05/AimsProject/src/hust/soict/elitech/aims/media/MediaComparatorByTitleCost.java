package hust.soict.elitech.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    // So sánh theo tiêu đề (A-Z), nếu tiêu đề giống nhau thì so sánh theo giá giảm dần
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh tiêu đề không phân biệt chữ hoa chữ thường
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleDiff != 0) {
            return titleDiff;
        }
        // Nếu tiêu đề giống nhau, so sánh theo giá giảm dần
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
