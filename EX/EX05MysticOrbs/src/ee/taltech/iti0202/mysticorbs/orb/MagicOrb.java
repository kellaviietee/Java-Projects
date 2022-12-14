package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb {
    /**
     * MagicOrb constructor.
     * @param creator Oven's name that this orb came out of.
     */
    public MagicOrb(String creator) {
        super(creator);
    }
    @Override
    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust")) {
            energy += resource.trim().length() * 2 * Integer.max(0, amount);
        }
    }

    @Override
    public String toString() {
        return "MagicOrb by " + creator;
    }
}
