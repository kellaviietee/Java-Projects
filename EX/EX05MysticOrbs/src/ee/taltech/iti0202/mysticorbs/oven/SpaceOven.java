package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven implements Fixable{
    private int timesFixed = 0;
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        if(timesFixed >= 5){
            return false;
        } else {
        return createdOrbsAmount >= (timesFixed + 1) * 25;
    }
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (isBroken()) {
            return getOrb();
        } else if (resourceStorage.hasEnoughResource("meteorite stone", 1)
                    && resourceStorage.hasEnoughResource("star fragment", 15)) {
                resourceStorage.takeResource("meteorite stone", 1);
                resourceStorage.takeResource("star fragment", 15);
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
        } else if (resourceStorage.hasEnoughResource("liquid silver", 40)
                || resourceStorage.hasEnoughResource("star essence", 10)) {
            if (resourceStorage.hasEnoughResource("liquid silver", 40)) {
                resourceStorage.takeResource("liquid silver", 40);
                timesFixed += 1;
            } else if (resourceStorage.hasEnoughResource("star essence", 10)) {
                resourceStorage.takeResource("star essence", 10);
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
