package ee.taltech.iti0202.socialnetwork.user;


public class User {
    private final String name;
    private final Integer age;

    /**
     * User Class constructor;
     * @param name users name
     */
    public User(String name) {
        this.name = name;
        this.age = null;

    }

    /**
     * Second constructor for User class;
     * @param name Users name
     * @param age Users age
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\'' + '}';
    }
}
