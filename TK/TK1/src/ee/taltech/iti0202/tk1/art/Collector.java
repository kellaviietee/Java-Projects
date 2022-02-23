package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    List<Painting> paintingList = new ArrayList<>();

    /**
     * Add a painting to collectors list.
     * @param painting Painting to be added.
     * @return if the painting was added.
     */
    public boolean addPainting(Painting painting) {
        if (paintingList.contains(painting)) {
            return false;
        } else {
            paintingList.add(painting);
            return true;
        }
    }

    /**
     * Collector tries to sell a painting to another collector.
     * @param painting Painting to be sold.
     * @param fellowCollector Another collector.
     * @return if transaction was successful.
     */
    public boolean sellPainting(Painting painting, Collector fellowCollector) {
        if (paintingList.contains(painting) && !fellowCollector.equals(this)
        && fellowCollector.addPainting(painting)) {
            paintingList.remove(painting);
            return true;
        } else {
            return false;
        }
    }

    public List<Painting> getPaintings() {
        return paintingList;
    }
}
