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
        return createdOrbsAmount > (timesFixed + 1) * 25;
    }
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (isBroken()) {
            return Optional.empty();
        }
        else if (resourceStorage.takeResource("meteorite stone", 1)
                && resourceStorage.takeResource("star fragment", 15)) {
            Orb craftedOrb = new SpaceOrb(name);
            return Optional.of(craftedOrb);
        } else if (resourceStorage.takeResource("pearl", 1)
                && resourceStorage.takeResource("silver", 1)) {
            Orb craftedOrb = new Orb(name);
            craftedOrb.charge("pearl",1);
            craftedOrb.charge("silver",1);
            return Optional.of(craftedOrb);
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void fix() throws CannotFixException {
        if (!isBroken()) {
            throw new CannotFixException(this, CannotFixException.Reason.IS_NOT_BROKEN);
        } else if (!resourceStorage.takeResource("liquid silver", 40)
                && !resourceStorage.takeResource("star essence", 10)) {
            throw new CannotFixException(this, CannotFixException.Reason.NOT_ENOUGH_RESOURCES);
        } else {
            if (resourceStorage.takeResource("liquid silver", 40)) {
                timesFixed += 1;
            } else if (resourceStorage.takeResource("star essence", 10)) {
                timesFixed += 1;
            }
        }
    }
    @Override
    public int getTimesFixed() {
        return timesFixed;
    }
}
