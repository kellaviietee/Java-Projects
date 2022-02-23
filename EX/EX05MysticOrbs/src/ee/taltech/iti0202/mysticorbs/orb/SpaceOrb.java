package ee.taltech.iti0202.mysticorbs.orb;

public class SpaceOrb extends Orb{
    public SpaceOrb(String creator) {
        super(creator);
        this.energy = 100;
    }
    @Override
    public void charge(String resource, int amount){
    }

    @Override
    public String toString() {
        return " SpaceOrb by " + creator;
    }

    public boolean absorb(Orb orb){
        if(energy > orb.getEnergy()){
            energy += orb.getEnergy();
            orb.removeEnergy(orb.getEnergy());
            return true;
        }
        else {
            return false;
        }
    }
}
