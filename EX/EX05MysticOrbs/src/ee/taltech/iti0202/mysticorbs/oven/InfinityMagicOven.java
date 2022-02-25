package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

public class InfinityMagicOven extends MagicOven {
    /**
     * InfinityMagicOven Constructor.
     * @param name name of the Oven.
     * @param resourceStorage Storage where resources come from.
     */
    public InfinityMagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }
    @Override
    public boolean isBroken() {
        return false;
    }
}
