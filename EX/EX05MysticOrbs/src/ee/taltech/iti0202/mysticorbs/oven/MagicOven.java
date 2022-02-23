package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven implements Fixable {
    private int timesFixed = 0;

    public MagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return createdOrbsAmount > 5;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (isBroken()) {
            return Optional.empty();
        } else if (createdOrbsAmount % 2 == 0) {
            if (resourceStorage.takeResource("gold", 1)
                    && resourceStorage.takeResource("dust", 3)) {
                Orb craftedOrb = new Orb(name);
                craftedOrb.charge("gold",1);
                craftedOrb.charge("dust",3);
                return Optional.of(craftedOrb);
            } else {
                return Optional.empty();
            }
        } else {
            if (resourceStorage.takeResource("gold", 1)
                    && resourceStorage.takeResource("dust", 3)) {
                Orb craftedOrb = new MagicOrb(name);
                craftedOrb.charge("gold",1);
                craftedOrb.charge("dust",3);
                return Optional.of(craftedOrb);
            } else {
                return Optional.empty();
            }
        }
    }

    @Override
    public void fix() throws CannotFixException {
        if (timesFixed >= 10) {
            throw new CannotFixException(this, CannotFixException.Reason.FIXED_MAXIMUM_TIMES);
        }else if (!isBroken()) {
            throw new CannotFixException(this, CannotFixException.Reason.IS_NOT_BROKEN);
        } else if (!resourceStorage.takeResource("clay",(timesFixed + 1) * 25)
            || !resourceStorage.takeResource("freezing powder",(timesFixed + 1) * 100)){
        throw new CannotFixException(this, CannotFixException.Reason.NOT_ENOUGH_RESOURCES);
        } else{
            createdOrbsAmount = 0;
            timesFixed += 1;
        }
    }

    @Override
    public int getTimesFixed() {
        return timesFixed;
    }
}