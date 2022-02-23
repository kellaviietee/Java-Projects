package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven{
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return createdOrbsAmount > 25;
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
}
