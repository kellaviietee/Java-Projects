package ee.taltech.iti0202.socialnetwork.user;


public class User {
    String name;
    Integer age;

    public User(String name) {
        this.name = name;
        this.age = null;

    }

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
        return "User{" +
                "name='" + name + '\'' + '}';
    }
}