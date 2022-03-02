
package ee.taltech.iti0202.shelter.animal;
public abstract class Animal {
    public enum Type {
        HIROLA, TARANTULA, WOMBAT
    }
    private String color;

    /**
     * Animal constructor
     * @param color animal color.
     */
    public Animal(String color) {
        this.color = color;
    }

    /**
     * Get animals color
     * @return Animals color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the animals color.
     * @param color Animals new color.
     */
    public void setColor(String color) {
        this.color = color;
    }
}
