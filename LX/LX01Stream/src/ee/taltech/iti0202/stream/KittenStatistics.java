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

    public OptionalDouble findKittensAverageAge() {
        if (kittens.size() == 0){return OptionalDouble.empty();}
        else{
            return kittens.stream()
                    .map(Kitten::getAge).toList()
                    .stream()
                    .mapToInt(Integer::intValue).average();
        }

    }

    public Optional<Kitten> findOldestKitten() {
        if(kittens.size() ==0){return Optional.empty();}
        else{
            return kittens.stream().max(Comparator.comparing(Kitten::getAge));
        }
    }

    public List<Kitten> findYoungestKittens() {
        Integer youngestAge = kittens.stream()
                .mapToInt(Kitten::getAge)
                .min()
                .getAsInt();
        return kittens.stream()
                .filter(kitten -> kitten.getAge() == youngestAge)
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensAccordingToGender(Kitten.Gender gender) {
        return kittens.stream()
                .filter(kitten -> kitten.getGender() == gender)
                .collect(Collectors.toList());
    }

    public List<Kitten> findKittensBetweenAges(int minAge, int maxAge) {
        return kittens.stream()
                .filter(kitten -> kitten.getAge() >= minAge)
                .filter(kitten -> kitten.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public Optional<Kitten> findFirstKittenWithGivenName(String givenName) {
        return kittens.stream()
                .filter(kitten -> kitten.getName().equals(givenName))
                .findFirst();

    }

    public List<Kitten> kittensSortedByAgeYoungerFirst() {
        return kittens.stream()
                .sorted(Comparator.comparing(Kitten::getAge))
                .collect(Collectors.toList());

    }

    public List<Kitten> kittensSortedByAgeOlderFirst() {
        return kittens.stream()
                .sorted(Comparator.comparing(Kitten::getAge).reversed())
                .collect(Collectors.toList());
    }
    
}