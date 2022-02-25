package ee.taltech.iti0202.mysticorbs.orb;

public class Orb {
    protected final String creator;
    protected int energy = 0;

    /**
     * Orb constructor
     * @param creator Oven name that created this Orb.
     */
    public Orb(String creator) {
        this.creator = creator;
    }

    /**
     * Charge the Orb with energy.
     * @param resource Resource to be used to charge the orb.
     * @param amount How much of the resource was used.
     */
    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust")) {
            energy += resource.trim().length() * Integer.max(0, amount);
        }
    }

    public int getEnergy() {
        return energy;
    }

    /**
     * Remove energy from the Orb.
     * @param amount energy amount to be removed.
     */
    public void removeEnergy(int amount) {
        energy -= amount;
    }

    @Override
    public String toString() {
        return "Orb by " + creator;
    }
}
