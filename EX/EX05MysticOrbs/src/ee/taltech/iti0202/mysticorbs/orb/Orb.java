package ee.taltech.iti0202.mysticorbs.orb;

public class Orb {
    protected final String creator;
    protected int energy = 0;

    public Orb(String creator) {
        this.creator = creator;
    }

    public void charge(String resource, int amount){
        if (!resource.equalsIgnoreCase("dust")) {
            energy += resource.trim().length() * Integer.max(0,amount);
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void removeEnergy(int amount){
        energy -= amount;
    }

    @Override
    public String toString() {
        return "Orb by " + creator;
    }
}
