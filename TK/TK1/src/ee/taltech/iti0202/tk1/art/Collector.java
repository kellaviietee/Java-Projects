package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    List<Painting> paintingList = new ArrayList<>();

    public boolean addPainting(Painting painting){
        if (paintingList.contains(painting)) {
            return false;
        }
        else{
            paintingList.add(painting);
            return true;
        }
    }
    public boolean sellPainting(Painting painting, Collector fellowCollector){
        if(paintingList.contains(painting) && !fellowCollector.equals(this)
        && fellowCollector.addPainting(painting)){
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
