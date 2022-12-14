package ee.taltech.iti0202.tk0.cat;

import java.util.Objects;

public class Cat {

    private String name;
    private int age;
    private String color;

    /**
     * Cat constructor.
     * @param name Cat's name.
     * @param age Cat's age.
     * @param color Cat's color.
     */
    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * Simpler constructor for a Cat.
     * @param name Cat's name.
     */
    public Cat(String name) {
        this.name = name;
        this.age = 0;
        this.color = "none";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (!Objects.equals(color, "none")) {
            return color + " " + name + " (" + age + ")";
        } else {
            return name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && name.equals(cat.name) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color);
    }
}

