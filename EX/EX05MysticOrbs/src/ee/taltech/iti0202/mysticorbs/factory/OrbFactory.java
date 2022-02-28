package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Fixable;
import ee.taltech.iti0202.mysticorbs.oven.MagicOven;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.oven.SpaceOven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    private final List<Oven> ovens = new ArrayList<>();
    private final List<Orb> orbs = new ArrayList<>();
    private final List<Oven> notFixableOvens = new ArrayList<>();

    /**
     * OrbFactory constructor.
     * @param resourceStorage Resource storage used by the factory.
     */
    public OrbFactory(ResourceStorage resourceStorage) {

        this.resourceStorage = resourceStorage;
    }

    /**
     * Add ovens to the Factory.
     * @param oven Oven to be added onto the Factory floor.
     */
    public void addOven(Oven oven) {
        ovens.add(oven);
    }

    /**
     * Returns currently produced orbs and then resets them.
     * @return Orbs that were produced.
     */
    public List<Orb> getAndClearProducedOrbsList() {
        List<Orb> allOrbs = new ArrayList<>(orbs);
        orbs.clear();
        return allOrbs;
    }

    public List<Oven> getOvens() {
        return ovens;
    }

    /**
     * Produce Orbs, if the Oven is broken try to fix it. if it is not fixable then add it to not fixable ovens list.
     * @return number of Orbs produced.
     */
    public int produceOrbs() {
        List<Orb> craftedOrbs = new ArrayList<>();
        for (Oven oven:ovens) {
            if (oven.isBroken()) {
                if (oven.getClass() == (MagicOven.class) || oven.getClass() == SpaceOven.class) {
                    try {
                        ((Fixable) oven).fix();
                    } catch (CannotFixException ex) {
                        if (ex.getReason() == CannotFixException.Reason.FIXED_MAXIMUM_TIMES) {
                            if(!notFixableOvens.contains(oven)) {
                                notFixableOvens.add(oven);
                            }
                        }
                    }
                } else if (oven.getClass() == Oven.class) {
                    if(!notFixableOvens.contains(oven)) {
                        notFixableOvens.add(oven);
                    }
                }
            }
            Optional<Orb> craftedOrb = oven.craftOrb();
            craftedOrb.ifPresent(craftedOrbs::add);
        }
        orbs.addAll(craftedOrbs);
        return craftedOrbs.size();
    }

    /**
     * Produce Orbs.
     * @param cycles How many times do the Ovens go.
     * @return number of orbs created.
     */
    public int produceOrbs(int cycles) {
        int orbNum = 0;
        for (int i = 0; i < cycles; i++) {
            int addedOrbs = produceOrbs();
            orbNum += addedOrbs;
        }
        return orbNum;
    }

    public List<Oven> getOvensThatCannotBeFixed() {
        return notFixableOvens;
    }

    /**
     * Remove Ovens that can not produce more orbs.
     */
    public void getRidOfOvensThatCannotBeFixed() {
        List<Oven> notFixableOvens = getOvensThatCannotBeFixed();
        for (Oven oven:notFixableOvens) {
            ovens.remove(oven);
        }
        notFixableOvens.clear();
    }

    /**
     * Sort the Ovens in a suitable manner.
     */
    public void optimizeOvensOrder() {
        ovens.sort(Oven::compareTo);
    }
}
