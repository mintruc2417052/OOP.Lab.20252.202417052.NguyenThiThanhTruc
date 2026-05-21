package hust.soict.elitech.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // so sanh theo title asc
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleDiff != 0) {
            return titleDiff;
        }
        // neu = so sanh theo cost desc
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
