package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    private final List<Oven> ovens = new ArrayList<>();
    private final List<Orb> orbs = new ArrayList<>();

    public OrbFactory(ResourceStorage resourceStorage){

        this.resourceStorage = resourceStorage;
    }
    public void addOven(Oven oven){
        ovens.add(oven);
    }

    public List<Orb> getAndClearProducedOrbsList() {
        List<Orb> allOrbs = new ArrayList<>(orbs);
        orbs.clear();
        return allOrbs;
    }

    public List<Oven> getOvens(){
        return ovens;
    }

    public int produceOrbs() {
        List<Orb> craftedOrbs = new ArrayList<>();
        for(Oven oven:ovens){
            Optional<Orb> craftedOrb = oven.craftOrb();
            craftedOrb.ifPresent(craftedOrbs::add);
        }
        orbs.addAll(craftedOrbs);
        return craftedOrbs.size();
    }
    public int produceOrbs(int cycles){
        int orbNum = 0;
        for(int i = 0; i < cycles; i++){
            int addedOrbs = produceOrbs();
            orbNum += addedOrbs;
        }
        return orbNum;
    }
}
