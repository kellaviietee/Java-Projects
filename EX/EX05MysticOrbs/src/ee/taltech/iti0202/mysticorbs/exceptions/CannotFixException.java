package ee.taltech.iti0202.mysticorbs.exceptions;

import ee.taltech.iti0202.mysticorbs.oven.Oven;

public class CannotFixException extends Exception {

    private final Oven oven;
    private final Reason reason;

    public enum Reason {
        IS_NOT_BROKEN, FIXED_MAXIMUM_TIMES, NOT_ENOUGH_RESOURCES
    }

    /**
     * CannotFixException constructor.
     * @param oven Oven this exception is about.
     * @param reason Why this oven can not be fixed.
     */
    public CannotFixException(Oven oven, Reason reason) {
        this.oven = oven;
        this.reason = reason;
    }

    public Oven getOven() {
        return oven;
    }

    public Reason getReason() {
        return reason;
    }
}
