package hust.soict.elitech.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // so sanh theo gia desc
        int costDiff = Float.compare(m2.getCost(), m1.getCost());
        if (costDiff != 0) {
            return costDiff;
        }
        // neu = thi so sanh theo title
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}