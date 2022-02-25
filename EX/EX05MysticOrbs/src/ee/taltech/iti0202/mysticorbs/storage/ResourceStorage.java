package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;
import java.util.Map;

public class ResourceStorage {
    private Map<String, Integer> resources = new HashMap<>();

    public boolean isEmpty() {
        return resources.isEmpty();
    }

    /**
     * Add a resource to be used to create orbs.
     * @param resource resource name.
     * @param amount how much of it will be added.
     */
    public void addResource(String resource, int amount) {
        String normResource = resource.toLowerCase().trim();
        if (resources.containsKey(normResource)) {
            Integer currentValue = resources.get(normResource);
            Integer newValue = currentValue + Integer.max(0, amount);
            resources.replace(normResource, newValue);
        } else {
            if (!normResource.equals("")) {
                resources.put(normResource, Integer.max(0, amount));
            }
        }
    }

    public int getResourceAmount(String resource) {
        String normResource = resource.toLowerCase();
        return resources.getOrDefault(normResource, 0);
    }

    public boolean hasEnoughResource(String resource, int amount) {
        String normResource = resource.toLowerCase();
        if (amount < 1) {
            return false;
        } else if (!resources.containsKey(normResource)) {
            return false;
        } else return amount <= resources.get(normResource);
    }

    public boolean takeResource(String resource, int amount) {
        if (hasEnoughResource(resource,amount)) {
            String normResource = resource.toLowerCase();
            Integer currentAmount = resources.get(normResource);
            int newAmount = currentAmount - amount;
            if (newAmount != 0) {
            resources.replace(normResource,newAmount);
            } else {
                resources.remove(normResource);
            }
            return true;
        } else {
            return false;
        }
    }
}
