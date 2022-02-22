package ee.taltech.iti0202.tk0.cat;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Cat> cats = new ArrayList<>();

    /**
     * Adds a cat to his/her owner's list
     * @param cat Cat to be added
     * @return if the cat was added or not.
     */
    public boolean addCat(Cat cat) {
        if (cats.contains(cat) || cat == null) {
            return false;
        } else {
            cats.add(cat);
            return true;
        }
    }

    public List<Cat> getCats() {
        return cats;
    }

    /**
     * Try to sell a cat to another owner.
     * @param sellTo Person buying the cat.
     * @param cat Cat that is being sold.
     * @return if transaction was successful.
     */
    public boolean sellCat(Person sellTo, Cat cat) {
        if (sellTo == null || cat == null || sellTo.getCats().contains(cat) || !cats.contains(cat)) {
            return false;
        } else {
            sellTo.addCat(cat);
            cats.remove(cat);
            return true;
        }
    }
}

