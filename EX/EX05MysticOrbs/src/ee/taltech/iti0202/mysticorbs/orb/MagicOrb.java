package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb{

    public MagicOrb(String creator) {
        super(creator);
    }
    @Override
    public void charge(String resource, int amount){
        if (!resource.equalsIgnoreCase("dust")) {
            energy += resource.length() * amount;
        }
    }

    @Override
    public String toString() {
        return "MagicOrb by " + creator;
    }
}
