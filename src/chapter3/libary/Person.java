package chapter3.libary;

public class Person {
    String firstName;
    String lastName;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    /**
     * Returns a string representation of a person
     *
     * @return A string representation of a person in
     * the format "<last name>, <first name>"
     */
    @Override
    public String toString() {
        // TODO: Implement
        return null;
    }

    @Override
    public boolean equals(Object o) {
        // TODO: Implement
        return false;
    }

    @Override
    public int hashCode() {
        // TODO: Implement
        return 0;
    }
}
