package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven implements Fixable{
    private int timesFixed = 0;
    private static final int LIQUID_SILVER_FIX = 40;
    private static final int STAR_ESSENCE_FIX = 10;
    private static final int STAR_FRAGMENT_CREATE = 15;
    private static final int RESOURCES_NEEDED = 25;
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        if(timesFixed >= 5){
            return false;
        } else {
        return createdOrbsAmount >= (timesFixed + 1) * RESOURCES_NEEDED;
    }
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (isBroken()) {
            return getOrb();
        } else if (resourceStorage.hasEnoughResource("meteorite stone", 1)
                    && resourceStorage.hasEnoughResource("star fragment", STAR_FRAGMENT_CREATE)) {
                resourceStorage.takeResource("meteorite stone", 1);
                resourceStorage.takeResource("star fragment", STAR_FRAGMENT_CREATE);
                Orb craftedOrb = new SpaceOrb(name);
                createdOrbsAmount += 1;
                return Optional.of(craftedOrb);
            } else {
            return getOrb();
        }
        }

    private Optional<Orb> getOrb() {
        if (resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            Orb craftedOrb = new Orb(name);
            craftedOrb.charge("pearl", 1);
            craftedOrb.charge("silver", 1);
            createdOrbsAmount += 1;
            return Optional.of(craftedOrb);
        }
        return Optional.empty();
    }

    @Override
    public void fix() throws CannotFixException {
        if (!isBroken()) {
            throw new CannotFixException(this, CannotFixException.Reason.IS_NOT_BROKEN);
        } else if (resourceStorage.hasEnoughResource("liquid silver", LIQUID_SILVER_FIX)
                || resourceStorage.hasEnoughResource("star essence", STAR_ESSENCE_FIX)) {
            if (resourceStorage.hasEnoughResource("liquid silver", LIQUID_SILVER_FIX)) {
                resourceStorage.takeResource("liquid silver", LIQUID_SILVER_FIX);
                timesFixed += 1;
            } else if (resourceStorage.hasEnoughResource("star essence", STAR_ESSENCE_FIX)) {
                resourceStorage.takeResource("star essence", STAR_ESSENCE_FIX);
                timesFixed += 1;
            }
        } else {
            throw new CannotFixException(this, CannotFixException.Reason.NOT_ENOUGH_RESOURCES);
        }
    }
    @Override
    public int getTimesFixed() {
        return timesFixed;
    }
}
