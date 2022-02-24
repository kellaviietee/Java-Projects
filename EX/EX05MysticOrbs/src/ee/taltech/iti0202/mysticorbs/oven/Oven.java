package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class Oven implements Comparable<Oven> {

    protected final String name;
    protected final ResourceStorage resourceStorage;
    protected int createdOrbsAmount = 0;

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
        return createdOrbsAmount > 15;
    }

    public Optional<Orb> craftOrb() {
        if(isBroken()){
            return Optional.empty();
        }
        if(resourceStorage.takeResource("pearl", 1)
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
    public int compareTo(Oven o) {
        if (!this.isBroken() && o.isBroken()) {
            return 1;
        } else if (this.isBroken() && !o.isBroken()) {
            return - 1;
        } else {
            if ((this instanceof SpaceOven)  && !(o instanceof SpaceOven)) {
                return 1;
            } else if ((this instanceof MagicOven)  && (o instanceof SpaceOven)) {
                return - 1;
            } else if ((this instanceof MagicOven)  && (o != null)) {
                return 1;
            } else if (o instanceof SpaceOven || o instanceof MagicOven) {
                return - 1;
            } else {
                if((this.getClass() == MagicOven.class) && (o.getClass() == MagicOven.class))
            }
        }
    }
}
