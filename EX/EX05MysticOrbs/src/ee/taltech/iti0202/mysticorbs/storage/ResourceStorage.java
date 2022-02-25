package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;
import java.util.Map;

public class ResourceStorage {
    private Map<String, Integer> resources = new HashMap<>();

    public boolean isEmpty() {
        return resources.isEmpty();
    }

    public void addResource(String resource, int amount) {
        String norm_resource = resource.toLowerCase().trim();
        if (resources.containsKey(norm_resource)) {
            Integer currentValue = resources.get(norm_resource);
            Integer newValue = currentValue + Integer.max(0, amount);
            resources.replace(norm_resource, newValue);
        } else {
            if(!norm_resource.equals("")) {
                resources.put(norm_resource, Integer.max(0, amount));
            }
        }
    }

    public int getResourceAmount(String resource) {
        String norm_resource = resource.toLowerCase();
        return resources.getOrDefault(norm_resource, 0);
    }

    public boolean hasEnoughResource(String resource, int amount) {
        String norm_resource = resource.toLowerCase();
        if (amount < 1) {
            return false;
        } else if (!resources.containsKey(norm_resource)) {
            return false;
        } else return amount <= resources.get(norm_resource);
    }

    public boolean takeResource(String resource, int amount) {
        if (hasEnoughResource(resource,amount)) {
            String norm_resource = resource.toLowerCase();
            Integer currentAmount = resources.get(norm_resource);
            int newAmount = currentAmount - amount;
            if (newAmount != 0){
            resources.replace(norm_resource,newAmount);
            } else {
                resources.remove(norm_resource);
            }
            return true;
        }
        else {
            return false;
        }

    }
}
