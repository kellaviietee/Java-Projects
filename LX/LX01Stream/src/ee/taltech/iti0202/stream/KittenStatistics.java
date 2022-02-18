package ee.taltech.iti0202.stream;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class KittenStatistics {

    private List<Kitten> kittens;

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }

    /**
     * Find arithmetic age of all the kittens.
     * @return Average age.
     */
    public OptionalDouble findKittensAverageAge() {
        if (kittens.size() == 0) {
            return OptionalDouble.empty();
        } else {
            return kittens.stream()
                    .map(Kitten::getAge).toList()
                    .stream()
                    .mapToInt(Integer::intValue).average();
        }

    }

    /**
     * Find oldest kitten.
     * @return oldest kitten.
     */
    public Optional<Kitten> findOldestKitten() {
        if (kittens.size() == 0) {
            return Optional.empty();
        } else {
            return kittens.stream().max(Comparator.comparing(Kitten::getAge));
        }
    }

    /**
     * Find youngest kittens.
     * @return youngest kittens.
     */
    public List<Kitten> findYoungestKittens() {
        Integer youngestAge = kittens.stream()
                .mapToInt(Kitten::getAge)
                .min()
                .getAsInt();
        return kittens.stream()
                .filter(kitten -> kitten.getAge() == youngestAge)
                .collect(Collectors.toList());
    }

    /**
     * Find kittens by gender.
     * @param gender Gender of requested kitten.
     * @return All kittens with the requested gender.
     */
    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream()
                .filter(kitten -> kitten.getGender() == gender)
                .collect(Collectors.toList());
    }

    /**
     * Find kittens within appropriate ages.
     * @param minAge Minimum age of the kitten.
     * @param maxAge Maximum age of the kitten.
     * @return List of all the kittens between min and max ages.
     */
    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream()
                .filter(kitten -> kitten.getAge() >= minAge)
                .filter(kitten -> kitten.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    /**
     * Find the first kitten with specified name.
     * @param givenName Kittens name.
     * @return First kitten with that name.
     */
    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return kittens.stream()
                .filter(kitten -> kitten.getName().equalsIgnoreCase(givenName))
                .findFirst();

    }

    /**
     * Sort kittens by age, with younger ones first.
     * @return list of sorted kittens.
     */
    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream()
                .sorted(Comparator.comparing(Kitten::getAge))
                .collect(Collectors.toList());

    }

    /**
     * Sort kittens by age, with older ones being first.
     * @return list of sorted kittens.
     */
    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream()
                .sorted(Comparator.comparing(Kitten::getAge).reversed())
                .collect(Collectors.toList());
    }

}
