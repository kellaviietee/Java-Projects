package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private final Location goTo;
    private List<String> deposit = new ArrayList<>();
    private List<String> take = new ArrayList<>();

    public Action(Location goTo) {

        this.goTo = goTo;
    }

    public List<String> getDeposit() {
        return deposit;
    }

    public List<String> getTake() {
        return take;
    }


    public Location getGoTo() {
        return goTo;
    }

    public void addDeposit(String packetName) {
        deposit.add(packetName);
    }
    public void addTake(String packetName) {
        take.add(packetName);
    }
}

