package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;

public class Action {

    private Location goTo;
    private List<String> deposit = new ArrayList<>();
    private List<String> take = new ArrayList<>();

    public Action(Location goTo) {
        this.goTo = goTo;
    }
    public void addDeposit(String packetName) {
        deposit.add(packetName);
    }

    public void addTake(String packetName) {
    take.add(packetName);
    }


    @Override
    public String toString() {
        return goTo + " to Take " + take + " to deposit " + deposit;
    }

    public Location getGoTo() {
        return goTo;
    }
}
