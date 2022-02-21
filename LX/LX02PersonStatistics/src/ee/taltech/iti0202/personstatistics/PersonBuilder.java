package ee.taltech.iti0202.personstatistics;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double heightInMeters;
    private String occupation;
    private String nationality;

    public PersonBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }
    public PersonBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public PersonBuilder withAge(String age){
        this.age = Integer.parseInt(age);
        return this;
    }
    public PersonBuilder withGender(String gender){
        this.gender = Gender.valueOf(gender);
        return this;
    }
    public PersonBuilder withHeightInMeters(String heightInMeters){
        this.heightInMeters = Double.parseDouble(heightInMeters);
        return this;
    }
    public PersonBuilder occupation(String occupation){
        this.occupation = occupation;
        return this;
    }
    public PersonBuilder nationality(String nationality){
        this.nationality = nationality;
        return this;
    }
    public Person build(){
        return new Person(firstName,lastName,age,gender,heightInMeters,occupation,nationality);
    }
}
