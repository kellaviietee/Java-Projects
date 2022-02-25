package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;

public interface Fixable {
    /**
     * Try to fix an Oven.
     * @throws CannotFixException if it cannot be fixed throw this error.
     */
    void fix() throws CannotFixException;

    /**
     * How many times has the oven been fixed.
     * @return times Oven has been fixed.
     */
    int getTimesFixed();
}
