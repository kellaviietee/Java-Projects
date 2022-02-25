package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class Oven implements Comparable<Oven> {

    protected final String name;
    protected final ResourceStorage resourceStorage;
    protected int createdOrbsAmount = 0;
    private static final int MAXIMUM_ORBS = 15;

    /**
     * Oven constructor.
     * @param name Name of the oven.
     * @param resourceStorage Resource storage.
     */
    public Oven(String name, ResourceStorage resourceStorage) {

        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public String getName() {
        return name;
    }

    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    public int getCreatedOrbsAmount() {
        return createdOrbsAmount;
    }

    public boolean isBroken() {
        return createdOrbsAmount >= MAXIMUM_ORBS;
    }

    /**
     * Craft an Orb if possible.
     * @return Orb if possible or an empty optional.
     */
    public Optional<Orb> craftOrb() {
        if (isBroken()) {
            return Optional.empty();
        }
        if (resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            Orb craftedOrb = new Orb(name);
            craftedOrb.charge("pearl", 1);
            craftedOrb.charge("silver", 1);
            createdOrbsAmount += 1;
            return Optional.of(craftedOrb);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public int compareTo(Oven o) {
        if (!this.isBroken() && o.isBroken()) {
            return 1;
        } else if (this.isBroken() && !o.isBroken()) {
            return -1;
        } else if (this.isBroken() == o.isBroken()) {
            if (this.getClass() == SpaceOven.class && o.getClass() != SpaceOven.class) {
                return 1;
            } else if (this.getClass() == MagicOven.class && o.getClass() == SpaceOven.class) {
                return -1;
            } else if (this.getClass() == MagicOven.class && o.getClass() == Oven.class) {
                return 1;
            } else if (this.getClass() == Oven.class && o.getClass() != Oven.class) {
                return -1;
            } else if (this instanceof MagicOven && o instanceof MagicOven) {
                    if (this.createdOrbsAmount % 2 == 1 && o.createdOrbsAmount % 2 == 0) {
                        return 1;
                    } else if (this.createdOrbsAmount % 2 == 0 && o.createdOrbsAmount % 2 == 1) {
                        return -1;
                    } else if (this.createdOrbsAmount == o.createdOrbsAmount) {
                        if (this.getClass() == MagicOven.class && o.getClass() == InfinityMagicOven.class) {
                            return -1;
                        } else if (this.getClass() == InfinityMagicOven.class && o.getClass() == MagicOven.class) {
                            return 1;
                    }
                }
            } else if (this.createdOrbsAmount < o.createdOrbsAmount) {
                return 1;
            } else if (this.createdOrbsAmount > o.createdOrbsAmount) {
                return -1;
            }
        }
        return this.name.compareTo(o.name);
    }
}
