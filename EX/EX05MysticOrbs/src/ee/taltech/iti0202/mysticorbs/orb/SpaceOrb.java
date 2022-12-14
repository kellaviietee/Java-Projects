package ee.taltech.iti0202.mysticorbs.orb;

public class SpaceOrb extends Orb {
    /**
     * Spaceorb constructor.
     * @param creator Name of the oven this SpaceOrb came out of.
     */
    public SpaceOrb(String creator) {
        super(creator);
        this.energy = 100;
    }
    @Override
    public void charge(String resource, int amount) {
    }

    @Override
    public String toString() {
        return "SpaceOrb by " + creator;
    }

    /**
     * Absorb energy of another Orb if the other orb has less energy.
     * @param orb The other orb to be compared to.
     * @return if the absorption was successful.
     */
    public boolean absorb(Orb orb) {
        if (energy > orb.getEnergy()) {
            energy += orb.getEnergy();
            orb.removeEnergy(orb.getEnergy());
            return true;
        } else {
            return false;
        }
    }
}
